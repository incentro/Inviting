<%@page import="java.sql.*"%>
<%@page import="model.*"%>
<%@page import="domein.*"%>
<%@include file="../includes/login_check.jsp" %>

<%
NewEventIO event = new NewEventIO();

String gebruiker 	= request.getParameter("v1");
String titel 				= request.getParameter("v2");
String subtitel 		= request.getParameter("v3");
String datum 		= request.getParameter("v4");
String organisator = request.getParameter("v5");
String adres			=	request.getParameter("v6");


EventStore e = new EventStore(gebruiker, titel, subtitel, datum, organisator, adres);

String succes = event.addEvent(e);

out.println(succes);
%>


