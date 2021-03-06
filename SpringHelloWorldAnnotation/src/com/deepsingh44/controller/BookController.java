package com.deepsingh44.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.deepsingh44.dao.BookDao;
import com.deepsingh44.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookDao bookDao;

	@PostMapping("/add")
	public String addBook(@RequestParam("imagefile") MultipartFile file,Book book,HttpSession session) throws IOException {
		System.out.println(file.getSize());
		System.out.println(book);
		//file upload here
		String rootlocation=session.getServletContext().getRealPath("/");
		System.out.println(rootlocation);
		File folder=new File(rootlocation,"bookimages");
		if(!folder.exists())folder.mkdir();
		File myFile=File.createTempFile("book", ".jpg",folder);
		System.out.println(myFile.getAbsolutePath());
		file.transferTo(myFile);
		
		String filename=myFile.getName();
		System.out.println(filename);
		//then add data into database
		book.setImage(filename);
		
		int i=bookDao.insert(book);
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView listBookPage() {
		ModelAndView model=new ModelAndView();
		model.addObject("books", bookDao.getAllBooks());
		model.setViewName("booklist");
		return model;
	}


}
