package com.kc.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kc.bookstore.domain.Account;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.domain.ShoppingCart;
import com.kc.bookstore.domain.ShoppingCartItem;
import com.kc.bookstore.domain.User;
import com.kc.bookstore.service.AccountService;
import com.kc.bookstore.service.BookService;
import com.kc.bookstore.service.UserService;
import com.kc.bookstore.web.BookStoreWebUtils;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;


@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	private BookService bookService = new BookService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = request.getParameter("method");
		System.out.println("----:"+methodName);
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			method.setAccessible(true);
			
			method.invoke(this, request,response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
		
	}
	
	private UserService userService = new UserService();
	
	protected void cash(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//简单验证：验证表单域的值是否符合基本规范：是否为空，是否可以转为 int 类型，是否是一个 Email，不需要进行数据库或调用任何方法的业务方法
		
		String username = request.getParameter("username");
		String accountid = request.getParameter("accountid");
		
		//简单验证
		StringBuffer errors = validateFormField(username, accountid);
		
		//验证表单是否通过
		if(errors.toString().equals("")) {
			errors = validateFormField(username, accountid);
			
			//复杂验证
			//验证用户名与账户是否匹配
			if(errors.toString().equals("")) {
				errors = validateUser(username, accountid);
				
				//库存是否充足
				if(errors.toString().equals("")) {
					errors = validateBookStore(request);
					
					//余额是否够
					if(errors.toString().equals("")) {
						errors = validateBalance(request,accountid);
					}
				}
			}
			
		}
		
		if(!errors.toString().equals("")) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("WEB-INF/pages/cash.jsp").forward(request, response);
			return;
		}	
		
		//验证通过执行具体的逻辑操作
		bookService.cash(BookStoreWebUtils.getShoppingCart(request),username,accountid);
		
		response.sendRedirect(request.getContextPath()+"/success.jsp");
		
	}
	
	private AccountService accountService = new AccountService();
	
	//验证余额是否充足
	public StringBuffer validateBalance(HttpServletRequest request,String accountid) {
		StringBuffer errors = new StringBuffer();
		
		ShoppingCart cart = BookStoreWebUtils.getShoppingCart(request);
		
		Account account = accountService.getAccount(Integer.parseInt(accountid));
		
		if(cart.getTotalMoney() > account.getBalance()) {
			errors.append("余额不足");
		}
		
		return errors;
		
	}
	
	//验证库存是否充足
	public StringBuffer validateBookStore(HttpServletRequest request) {
		
		StringBuffer errors = new StringBuffer();
		
		ShoppingCart cart = BookStoreWebUtils.getShoppingCart(request);
		
		for(ShoppingCartItem sci : cart.getItems()) {
			int quantity = sci.getQuantity();
			//int storeNumber = sci.getBook().getStoreNumber(); 为什么不用这个
			int storeNumber = bookService.getBook(sci.getBook().getId()).getStoreNumber();
			
			if(quantity > storeNumber) {
				errors.append(sci.getBook().getTitle()+"库存不足<br>");
			}
			
		}
		
		return errors;
		
	}
	
	//验证用户名和账号是否匹配
	public StringBuffer validateUser(String username,String accountid) {
		
		boolean flag = false;
		User user = userService.getUserByUserName(username);
		if(user != null) {
			int accountId2 = user.getAccountId();
			if(accountid.trim().equals(""+accountId2)) {
				flag = true;
			}
		}
		StringBuffer errors2 = new StringBuffer();
		if(!flag) {
			errors2.append("用户名和账号不匹配");
		}
		
		return errors2;
		
	}
	
	//验证表单基本信息
	public StringBuffer validateFormField(String username,String accountid) {
		
		StringBuffer errors = new StringBuffer();
		
		if(username == null || username.trim().equals("")) {
			errors.append("用户名不能为空");
		}
		
		if(accountid == null || accountid.trim().equals("")) {
			errors.append("<br>账号不能为空");
		}
		return errors;
	}
	
	
	protected void updateItemQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//4.在 updateItemQuantity 方法中获取 quantity，id 再获取购物车对象，调用 servlet 的方法做修改
		String idStr = request.getParameter("id");
		String quantityStr = request.getParameter("quantity");
		
		ShoppingCart sc = BookStoreWebUtils.getShoppingCart(request);
		
		int id = -1;
		int quantity = -1;
		
		try {
			//当 id 异常时  quantity 也就没有意义 所以将 id 与 quantity 放在一起
			id = Integer.parseInt(idStr);
			quantity = Integer.parseInt(quantityStr);
		} catch (NumberFormatException e) {}
		
		if(id > 0 && quantity > 0) {
			
			bookService.updateItemQuantity(sc,id,quantity);
		}
		
		//5.传回 json 数据：bookNumber:xxx 和 totalMony
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("bookNumber", sc.getBookNumber());
		result.put("totalMony", sc.getTotalMoney());
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(result);
		response.setContentType("text/javascript");
		response.getWriter().print(jsonStr);
		
	}
	
	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShoppingCart sc = BookStoreWebUtils.getShoppingCart(request);
		
		bookService.clearShoppingCart(sc);
		
		request.getRequestDispatcher("/WEB-INF/pages/emptycart.jsp").forward(request, response);
		
	}
	
	protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = request.getParameter("id");
		
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {}
		
		ShoppingCart sc = BookStoreWebUtils.getShoppingCart(request);
		
		bookService.removeItemFromShoppingCart(sc,id);
		
		if(sc.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/pages/emptycart.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
		
		
	}
	/*
	 * protected void toCartPage(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * 		request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request,response); 
	 * } 
	 * 
	 * protected void cash(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * 		request.getRequestDispatcher("/WEB-INF/pages/cash.jsp").forward(request,response); 
	 * }
	 */

	
	protected void forwardPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		request.getRequestDispatcher("/WEB-INF/pages/"+page+".jsp").forward(request, response);
		
	}
	
	protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1.获取商品 id 
		String idStr = request.getParameter("id");
		int id = -1;
		
		boolean flag = false;
		
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {}
		
		if(id > 0) {
			// 2.获取购物车对象
			//ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart"); //错误
			
			ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(request);
			
			// 3.调用 BookServlet 的  addToCart() 方法将商品放入购物车中
			flag = bookService.addToCart(id,shoppingCart);
			
			
		}
		
		if(flag) {
			
			// 4.直接调用 getBooks() 方法
			getBooks(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/error-1.jsp");
		
	}
	
	protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = request.getParameter("id");
		
		System.out.println("--id:"+idStr);
		
		int id = -1;
		Book book = null;
		
		try {
			id = Integer.parseInt(idStr);
			
		} catch (NumberFormatException e) {}
		
		
		if(id > 0) { book = bookService.getBook(id);}
		
		if(book == null) {
			response.sendRedirect(request.getContextPath()+"/error-1.jsp");
			return;
		}
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request, response);
		
	}
	
	
	protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pageNoStr = request.getParameter("pageNo");
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");
		
		//如果出现异常让参数为一下值
		int pageNo = 1; 
		int minPrice = 0;
		int maxPrice = Integer.MAX_VALUE;
		
		//分开写 防止前面的出异常后面的无法赋值
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {}
		
		try {
			minPrice = Integer.parseInt(minPriceStr);
		} catch (NumberFormatException e) {}
		
		try {
			maxPrice = Integer.parseInt(maxPriceStr);
		} catch (NumberFormatException e) {}
		
		System.out.println("-----------------------------------------");
		System.out.println("pageno:"+pageNo);
		System.out.println("minprice:"+minPrice);
		System.out.println("maxprice:"+maxPrice);
		
		
		CriteriaBook criteriaBook = new CriteriaBook(minPrice, maxPrice, pageNo);
		
		Page<Book> page = bookService.getPage(criteriaBook);
		
		request.setAttribute("bookPage",page);
		
		request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);
		
		
		
	}

}
