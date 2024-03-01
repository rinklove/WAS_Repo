package com.kh.app.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileServlet
 */
@MultipartConfig(
			maxFileSize = 1024 * 1024/*1MB*/ * 10
			, maxRequestSize = 1024 * 1024 * 50
		)
@WebServlet("/file/upload")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 이름 출력
		System.out.println("uploadFile = " + request.getPart("uploadFile").getSubmittedFileName());
		
		//읽기 준비
		InputStream in = request.getPart("uploadFile").getInputStream();
		
		//내보내기 준비
		String path = request.getServletContext().getRealPath(File.separator + "resources"+File.separator+"upload"+File.separator+"img");
		String fileName = File.separator + UUID.randomUUID() + "___" + request.getPart("uploadFile").getSubmittedFileName();
		File target = new File(path + fileName);
		FileOutputStream out =new  FileOutputStream(target);
		
//		int data = 0;
//		while((data = in.read()) != -1) {
//			out.write(data);
//		}
		
		byte[] arr = new byte[1024];
		int size = 0;
		while((size = in.read(arr)) != -1) {
			out.write(arr, 0, size);
		}
		
		//자원 반납
		in.close();
		out.close();
	}

}
