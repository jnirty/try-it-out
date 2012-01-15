<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int number = 0;

if(request.getParameter("number").matches("[\\d]+")) { 
	number = Integer.parseInt(request.getParameter("number"));
	out.println("Square root of " + number + " is " + Math.sqrt(number));
} else {
	out.println("Enter a number!");
}
%>