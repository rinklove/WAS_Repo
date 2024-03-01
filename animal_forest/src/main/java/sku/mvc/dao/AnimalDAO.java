package sku.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import sku.mvc.dto.Animals;
import sku.mvc.dto.Electronics;
import sku.mvc.dto.Reply;


public interface AnimalDAO {
	
	Animals selectBy(String name) throws SQLException;
	  

}









