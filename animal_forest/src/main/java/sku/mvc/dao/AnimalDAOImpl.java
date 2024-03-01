package sku.mvc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import sku.mvc.dto.Animals;
import sku.mvc.dto.Electronics;
import sku.mvc.dto.Reply;
import sku.mvc.paging.PageCnt;
import sku.mvc.util.DbUtil;

public  class AnimalDAOImpl implements AnimalDAO {
    private Properties proFile  = new Properties();
	
    /**
     * dbQuery.properties로딩해서 Properties객체에 저장!!!
     * */
	public AnimalDAOImpl() {
		try {
			//proFile.load(new FileInputStream("src/~~~"));
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버에서 실행될때 classes폴더의 위치를 동적으로 가져와서 경로를 설정해야한다.
			
			proFile.load( getClass().getClassLoader().getResourceAsStream("dbQuery.properties") );
			String value = proFile.getProperty("ani.select");
			System.out.println("value = " + value);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Animals selectBy(String name) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Animals animal=null;
		String sql = proFile.getProperty("ani.selectBy");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				animal = new Animals(rs.getString(1), rs.getString(2), rs.getString(3),
						               rs.getString(4), rs.getString(5));
			
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return animal;
	}
	
	

}


