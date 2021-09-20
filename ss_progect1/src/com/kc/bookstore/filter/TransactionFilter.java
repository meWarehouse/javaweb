package com.kc.bookstore.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.bookstore.db.JdbcUtils;
import com.kc.bookstore.web.ConnectionContext;

/**
 * Servlet Filter implementation class TransactionFilter
 */
@WebFilter("/*")
public class TransactionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransactionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Connection connection = null;
		
		try {
			
			//1.获取连接
			connection = JdbcUtils.getConnection();
			
			//2.开启事务
			connection.setAutoCommit(false);
			
			//3.利用 ThreadLocal 将连接与当前线程绑定
			ConnectionContext.getInstance().bind(connection);
			
			//4.将请求转发给目标
			chain.doFilter(request, response);
			
			//5.提交事务
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//回滚事物
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			
			resp.sendRedirect(req.getContextPath()+"/error-1.jsp");
			
			
		}finally {
			//7.解除绑定
			ConnectionContext.getInstance().remove();
			
			//7.关闭资源
			JdbcUtils.release(connection);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
