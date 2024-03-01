 package sku.mvc.service;

import java.sql.SQLException;

import sku.mvc.dto.UserDTO;
import sku.mvc.exception.AuthenticationException;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
   
   public int signUp(UserDTO userDTO) throws SQLException, AuthenticationException;
}
