package sku.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.mvc.dto.Animals;
import sku.mvc.service.AnimalsService;
import sku.mvc.service.AnimalsServiceImpl;



public class AnimalsController implements Controller {
	private AnimalsService animalService = new AnimalsServiceImpl() ;

	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  전체검색하기 
	 * */
	
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception{
      String searchText = request.getParameter("searchText");
		System.out.println("searchText = " + searchText);
		
		Animals animal = animalService.selectBy(searchText);
		request.setAttribute("animal", animal);
	    
		return new ModelAndView("animalsearch/search.jsp");
	}
	
}
	

	















