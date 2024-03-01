package sku.mvc.service;

import java.sql.SQLException;

import sku.mvc.dao.UserDAO;
import sku.mvc.dao.UserDAOImpl;
import sku.mvc.dto.UserDTO;
import sku.mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {
    private UserDAO dao = new UserDAOImpl();
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
       UserDTO dbDTO =  dao.loginCheck(userDTO);
       if(dbDTO==null) {
    	   throw new AuthenticationException("정보를 다시 확인해주세요.");
       }

		return dbDTO;
	}
	
	public int signUp(UserDTO userDTO) throws SQLException, AuthenticationException {
	       int result =  dao.signUp(userDTO);
	       if(result == 0) {
	    	   throw new AuthenticationException("회원가입에 실패하였습니다.");
	       }

			return result;
		}
}
