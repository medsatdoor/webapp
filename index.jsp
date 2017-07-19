<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index.jsp</title>
</head>
<body>
	<h2>Server has been started</h2>
	<%
		String servicePropertyFilePath = "G:\\bkp\\webapp\\cxf\\src\\main\\java\\service-lines.properties";
		BufferedReader reader = new BufferedReader(new FileReader(new File(servicePropertyFilePath)));
		String line = "";
		while((line=reader.readLine())!=null){
			out.println(line);		
		}
	%>
</body>
</html>