<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="test.JDBCTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer result = null;
    	try {
    		Connection con = new JDBCTemplate().getConnection();
    		String query = "select 1 from dual";
    		PreparedStatement pstmt =  con.prepareStatement(query);
    		ResultSet rs = pstmt.executeQuery();
    		if(rs.next()) 
    	 	result = rs.getInt("1");
    		JDBCTemplate.close(con);
    		JDBCTemplate.close(pstmt);
    		JDBCTemplate.close(rs);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>minus</title>
</head>
<body>
	<h1>결과: <%out.println(result); %></h1>
</body>
</html>