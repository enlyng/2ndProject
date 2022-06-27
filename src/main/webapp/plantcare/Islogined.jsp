<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
if (session.getAttribute("UserEmail") == null) {
	/*
	자바스크립트를 사용하기 위한 유틸리티 클래스를 통해 경고창을 띄우고
	location.href로 페이지를 이동한다.
	*/
	JSFunction.alertLocation("로그인 후 이용해주십시오.", "../plantcare/login.do", out); //이 코드가 실행될 수 있도록
	
	
	return; //jspService()라는 함수를 종료시켜야 한다.
}
%>