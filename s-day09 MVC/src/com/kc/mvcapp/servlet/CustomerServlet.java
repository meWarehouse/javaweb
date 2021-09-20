package com.kc.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.mvcapp.dao.CriteriaCustomer;
import com.kc.mvcapp.dao.CustomerDAO;
import com.kc.mvcapp.dao.factory.CustomerDAOFactory;
import com.kc.mvcapp.dao.imp.CustomerDAOJdbcImpl;
import com.kc.mvcapp.dao.imp.CustomerDAOXMLImpl;
import com.kc.mvcapp.domain.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
//	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
//	private CustomerDAO customerDAO = new CustomerDAOXMLImpl();
	
	// 面向接口编程
	private CustomerDAO customerDAO = CustomerDAOFactory.getInstance().getCustomerDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String method = request.getParameter("method");
//
//		switch (method) {
//		case "add":
//			add(request,response);
//			break;
//		case "query":
//			query(request,response);
//			break;
//		case "delete":
//			delete(request,response);
//			break;
//
//		}
//
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取ServletPath：/addCustomer.do 或 /delete.do
		String servletPath = req.getServletPath();
		
		// 去除 / 和  .do 得到类似于 addCustomer 或  delete
		String methodName= servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length()-3);
		
//		System.out.println("servletPath:"+ methodName);
		
		
		try {
			
			//利用反射获取 methodName 对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			//利用反射调用对应的方法
			method.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			//可以给出一些响应
			resp.sendRedirect("error.jsp");
			
		}
		
		
		
	}
	

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String forwardPath = "/error.jsp";
			
		//1.获取请求参数 id
		String idStr = request.getParameter("id");
		System.out.println("------------:"+idStr);
		//2. 调用CustomerDAO 的 customerDAO.get(id) 获取和 id 对应的customer对象
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if(customer != null) {
				forwardPath = "/updatecustomer.jsp";
				//3. 将customer 放入request中
				request.setAttribute("customer", customer);
			}
		} catch (NumberFormatException e) {
			
		}
		
		//4. 响应updatecustomer.jsp 页面：转发
		request.getRequestDispatcher(forwardPath).forward(request, response);	
		
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取表单  id(隐藏域) name address phone oldName(隐藏域)
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String oldName = request.getParameter("oldName");
		
		System.out.println("name:" + name);
		System.out.println("oldName:" + oldName);
		
		//2.检验name是否已经被占用  比较 name 与 oldName 的值是否相同  好处 避免数据库查询 效率更高
		if(!(oldName.equals(name))) { //不建议 name.equals(oldName) 新提交的name可能为空
			//2.1.若不相同，则调用 customerDAO 的 getCountWithName(String name) 获取name 在数据库中是否存在
			long count = customerDAO.getCountWidthName(name);
			//2.2.若返回值大于 0 则响应 updatecustomer,jsp 页面 ： 通过 请求转发的方式响应 
			if(count > 0) {
				//2.2.1 在updatecustomer.jsp 页面显示一个错误信息：用户名 name 已被占用，请重新选择！
				//在request 中放入一个属性 message ：用户名  name 已被占用，请重新选择！
				//在页面上通过 request.getAttribute("message") 的方式来显示
				request.setAttribute("message", "用户名 "+name+"已被占用，请重新选择！");
				
				//2.2.2 newcustomer.jsp 的表单值回显
				//address phone 显示提交表单的新值，而 name 显示 oldName 
				
				
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				
				return;
				
			}
			
		}
		
		//3.若验证通过	将接收的参数封装为一个 Customer的对象 
		Customer customer = new Customer(Integer.parseInt(id),name, address, phone);
		
		//4.调用customerDAO 的 update() 方法
		customerDAO.update(customer);
		
		//5.重定向到 query.jsp 的页面 
		response.sendRedirect("query.do");
		
		
		
		
	}
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		System.out.println("delete参数  ----");
		
		String idStr = request.getParameter("id");
		int id = 0;
		
		//try ... catch 的作用：防止 idStr 不能转为 int 类型
		// 若不能转则 id = 0,无法进行任何的删除操作
		try {
			
			id = Integer.parseInt(idStr);
			
			customerDAO.delete(id);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 response.sendRedirect("query.do");
		
		
		
	}
	

	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		
		//1. 调用 CustomerDAO 的getAll() 得到Customer 的集合
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);	
		
		//2. 将Customer 的集合放入 request中
		request.setAttribute("customers", customers);
		
		//3. 转发页面到index.jsp 不能使用重定向
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//1.获取表单中的 name address phone 
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//2.检查 name 是否已经被占用
		
		//2.1.调用CustomerDAO的getCountWidthName方法获取name在数据库中是否存在
		Long count = customerDAO.getCountWidthName(name);
//		System.out.println("count:"+count);
		//2.2.若返回值大于0 则响应 necustomer.jsp 页面：
		//通过请求转发的方式来响应 newcuatomer.jsp 
		if(count > 0) {
			
			//2.2.1. 要求newcustomer.jsp 的页面显示一个错误信息 ： 用户名 name 已经被占用 ，请重新选择
			// 在页面上通过request.getAttribute("message")的方式来显示
			request.setAttribute("message", " 用户名 "+ name +"已经被占用 ，请重新选择");
			
			//2.2.2. newcustomer.jsp 的表单值可以回显
			// 通过 value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") 方式回显
			//2.2.3 结束方法：return
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);;
			return;
		}
	
		
		//3.将接收的参数封装为一个 Customer的对象 
		Customer customer = new Customer(name, address, phone);
		
		//4.调用customerDAO 的save方法
		customerDAO.save(customer);
		
		//5.重定向到success.jsp的页面 	使用重定向可以解决表单重复提交的问题
		response.sendRedirect("success.jsp");
			
		
		
	}

}
