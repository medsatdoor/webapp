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

<style type="text/css">
table {
	border-radius: 10px color: #333;
	font-family: Helvetica, Arial, sans-serif;
	width: 70%;
	border-collapse: collapse;
	border-spacing: 0;
}

td,th {
	border: 1px solid transparent; /* No more visible border */
	height: 30px;
	transition: all 0.3s; /* Simple transition for hover effect */
}

th {
	font-weight: bold;
	background: #666;
	color: #FFF;
}

td {
	background: #FAFAFA;
	text-align: left;
}

/* Cells in even rows (2,4,6...) are one color */
tr:nth-child(even) td {
	background: #F1F1F1;
}

/* Cells in odd rows (1,3,5...) are another (excludes header cells) */
tr:nth-child(odd) td {
	background: #FEFEFE;
}
/* Hover cell effect! */
</style>
</head>


<body>

	<center>
		<jsp:useBean id="servicePathsObject" class="com.ecomm.ws.servicelines.ServicePathsImpl" />

		<h1>Server Started</h1>
		<br>
		<table>
			<th>TASK</th>
			<th>HTTP</th>
			<th>URI</th>
			<%
				String PROTOCOL = servicePathsObject.PROTOCOL;
				String HOST = servicePathsObject.HOST;
				String PORT = servicePathsObject.PORT;
				String APPLICATION_CONTEXT = servicePathsObject.APPLICATION_CONTEXT;
				String SERVICE_BASE_URL = servicePathsObject.SERVICE_BASE_URL;	
				String _SERVICE_BASE_URI = null;
				
				java.lang.reflect.Field[] fields = servicePathsObject.getClass().getFields();
				for(java.lang.reflect.Field field : fields){
					// set system and application properties
					String property = field.getName().trim();
					if(property.equals("PROTOCOL") || property.equals("HOST") || property.equals("PORT") 
							|| property.equals("APPLICATION_CONTEXT") || property.equals("SERVICE_BASE_URL")){
						continue;
					}
					if(property.contains("_SERVICE_BASE_URI")){
						_SERVICE_BASE_URI = (String)field.get(servicePathsObject);
						continue;
					}
					
					// set URI for service property
					String value = (String)field.get(servicePathsObject);
					String ABS_URI = PROTOCOL + "://" + HOST + ":" + PORT + APPLICATION_CONTEXT 
							+ SERVICE_BASE_URL + _SERVICE_BASE_URI + value;
					
					// check task name
					String task = property.charAt(0) + property.substring(1).toLowerCase().replaceAll("_", " ");
					
					// check http method type		
					String httpMethod = null;
					if(property.contains("LIST")){
						httpMethod = "GET";		
					}
					if(property.contains("ADD")){
						httpMethod = "POST";		
					}	
					if(property.contains("UPDATE")){
						httpMethod = "PUT";		
					}
					if(property.contains("DELETE")){
						httpMethod = "DELETE";		
					}
					
			%>
				<tr>
					<td style="text-indent: 8%; width: 30%"><%= task %></td>
					<td style="text-align: center;"><%= httpMethod %></td>
					<td style="text-indent: 5%"><%= ABS_URI %></td>
				</tr>
			<%	
				}		
			%>	
		</table>
	</center>
</body>
</html>