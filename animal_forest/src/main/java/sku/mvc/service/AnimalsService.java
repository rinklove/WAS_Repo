package sku.mvc.service;

import java.sql.SQLException;
import java.util.List;

import sku.mvc.dto.Animals;
import sku.mvc.dto.Electronics;

public interface AnimalsService{
	

Animals selectBy(String name) throws SQLException;
	  
}
