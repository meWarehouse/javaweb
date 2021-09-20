package com.kc.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileDAO fileDAO = new FileDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("UploadServlet  正在进行文件上传.....");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		// 检查是否为上传文件请求 通过检查请求数据表单类型是否为 multipart/form-data 来判断是不是文件上传请求
		if (!ServletFileUpload.isMultipartContent(request)) {

			out.print("错误，不是文件上传请求---");
			return;
		}

		// 文件上传工厂类 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 设置内存临界值-如果超出将产生临时文件存储于临时文件目录
		factory.setSizeThreshold(1024);// 3M

		// 设置临时存储文件目录
		factory.setRepository(new File("D:/Java_work/java-sen/servlet+jsp/s-day19/temp/upload/"));

		// 创建一个 ServletFileUpload 对象，用于解析文件上传请求
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置单个文件最大值
		upload.setFileSizeMax(1024 * 1024 * 50);// 5M

		// 设置单个请求中文件的最大值
		upload.setSizeMax(1024 * 1024 * 100);// 10M

		upload.setHeaderEncoding("UTF-8");

		String realPath = request.getServletContext().getRealPath("/");
		System.out.println("部署路径：" + realPath);

		// 解析文件上传请求

		try {
			// 每个 FileItem 代表表单中的一项
			List<FileItem> parseRequest = upload.parseRequest(request);
			// 迭代表单中的数据项
			for (FileItem item : parseRequest) {
				// 如果数据项是一个普通的数据项
				if (item.isFormField()) {
					// getFieldName 得到 input 的 name，getString 得到 input 的 值
					System.out.println(item.getFieldName() + ":" + item.getString("UTF-8"));
				} else {
					// 获取文件名
					String fileName = item.getName();
					// 拼凑文件路径
					// File.pathSeparator 文件分隔符
					String filePath = realPath + "upload1" + File.separator + fileName;
					System.out.println("文件路径：" + filePath);
					File storeFile = new File(filePath);
					// 将文家数据项的数据写入 storeFile 中
					item.write(storeFile);

					TFile tfile = new TFile();
					tfile.setFilePath(filePath);
					tfile.setFileName(fileName);
					// 写入数据库
					fileDAO.insertData(tfile);

					out.print("文件上传成功！！！");

				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
