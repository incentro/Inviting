<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%@page import="model.*"%>
<%@page import="domein.*"%>
<%@ page import = "java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<%@include file="includes/login_check.jsp" %>
<html>
<head>
<title>Incentro Event Inviting System</title>
<%@include file="includes/head.html" %>
<link rel="stylesheet" type="text/css" href="assets/css/inviteSystem.css" />
</head>

<body>

	<div class="wrapper">
		<%@include file="includes/header.html" %>
		

		<h3>
			Change Key 

		</h3>
	 <%@include file="includes/menu_back.html" %>
		
 <form id="msform" method="post" class="small" action="changeKey.do">
	<!-- fieldset --> 

	<fieldset class="show">
		<h2 class="fs-title">API key</h2>
		<h3 class="fs-subtitle">Verander hier de API key van Zoho</h3>
		
		 		 <input type="text" name='key' placeholder="Key" />
                <input type="submit"  class="submit action-button" value="Submit" /> 

	</fieldset>
	<!--  ************************************************************************************** -->
</form>

 <form id="msform" class="small" method="post" action="cyncContacts.do">
	<!-- fieldset --> 

	<fieldset class="show">
		<h2 class="fs-title">Contacten</h2>
		<h3 class="fs-subtitle">Verwijder alle contacten en importeer deze opnieuw vanuit Zoho, Dit kan enkele minuten duren</h3>

                <input type="submit"  class="submit action-button" value="Submit" /> 

	</fieldset>
	<!--  ************************************************************************************** -->
</form>

        <%@include file="includes/footer.html" %>
	</div>
</body>

</html>