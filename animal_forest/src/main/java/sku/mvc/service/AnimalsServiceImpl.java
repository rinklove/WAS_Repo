package sku.mvc.service;

import java.sql.SQLException;

import sku.mvc.dao.AnimalDAO;
import sku.mvc.dao.AnimalDAOImpl;
import sku.mvc.dto.Animals;

public class AnimalsServiceImpl implements AnimalsService {
	private AnimalDAO dao = new AnimalDAOImpl();
	
	@Override
	public Animals selectBy(String name) throws SQLException {
		Animals animal =dao.selectBy(name);
		if(animal==null)throw new SQLException(name+"에 해당하는 정보가 없습니다.");
		return animal;
	}
	
}
		
	
	













