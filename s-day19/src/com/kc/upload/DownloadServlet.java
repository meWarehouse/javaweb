package com.kc.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/downloadServletq")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FileDAO fileDAO = new FileDAO();

	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileId = request.getParameter("fileId");

		int id = 0;

		id = Integer.parseInt(fileId);

		TFile tFile = fileDAO.getTFile(id);

		//-----------------------------------------中文乱码
		//获取用户浏览器
		String agent = request.getHeader("User-Agent");
		
		//编码后的文件名
		String fileNameEncoder = "";
		
		if(agent.contains("MSIE")) {
			// ie 浏览器
			fileNameEncoder = URLEncoder.encode(tFile.getFileName(),"UTF-8");
			fileNameEncoder = fileNameEncoder.replace("+"," ");
		}else if(agent.contains("Firefox")){
			//火狐
			BASE64Encoder base64Encoder = new BASE64Encoder();
			fileNameEncoder = "=?utf-8?B?"+base64Encoder.encode(tFile.getFileName().getBytes("UTF-8")) + "?=";
		}else {
			fileNameEncoder = URLEncoder.encode(tFile.getFileName(),"UTF-8");
		}
		
		//设置文件 MIME 类型
		response.setContentType(request.getServletContext().getMimeType(tFile.getFileName()));
		
		//-----------------------------------------中文乱码
		
		
		// 设置响应头 attachement 表示让浏览器将响应的内容当做一个文件来下载，而不是直接解析响应内容
		response.setHeader("content-Disposition", "attachement;filename" + fileNameEncoder);

		InputStream is = null;
		OutputStream os = null;

		try {
			// 获取文件输入流
			is = new FileInputStream(new File(tFile.getFilePath()));

			// 获取响应输出流
			os = response.getOutputStream();

			// 从输入流中拷贝数据到输出流中
			IOUtils.copy(is, os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
