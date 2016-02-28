<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>PortfolioHomePage</title>
<s:head />
</head>

<body>
<h4>Welcome to the Struts 2 Portfolio!</h4>

<hr>
<h5>Account Management</h5>

<ul>
	<li><a href="<s:url action='LoginForm'/>">Login to an Existing
	Account</a></li>
	<li><a href="<s:url action='Registration'/>">Create an Account</a></li>
</ul>
<hr>
<h5>Browse an Artist's Portfolios ( Demo of select component. )</h5>

<s:form action="SelectPortfolio">
	<s:select name="username" list='users' listKey="username"
		listValue="username" label="Select an artist" />
	<s:submit value="Browse" />
</s:form>

<hr>
<h5>View a Portfolio ( Demo of doubleselect component. )</h5>

<s:form action="ViewPortfolio">
	<s:doubleselect name="username" list='users' listKey="username"
		listValue="username" doubleName="portfolioName"
		doubleList="portfolios" doubleListKey="value.name"
		doubleListValue="value.name" label="Select an artist and portfolio" />
	<s:submit value="View" />
</s:form>

</body>

</html>
