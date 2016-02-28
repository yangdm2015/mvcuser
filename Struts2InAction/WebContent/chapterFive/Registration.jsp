<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Portfolio Registration</title>
	</head>

	<body>
		<h4>Complete and submit the form to create your own portfolio.</h4> 
		<s:form action="Register">
    	  <s:textfield name="user.username" label="Username"/>
    	  <s:password name="user.password" label="Password"/>
    	  <s:textfield name="user.portfolioName" label="Enter a name for your portfolio"/>  	
    	  <s:textfield name="user.age" label="Enter your age, with double precision!"/>  	
    	  <s:textfield name="user.birthday" label="Enter your birthday. (mm/dd/yy)"/>  	
     	<s:submit/>
		</s:form>	
	  
		
	</body>
	
</html>
