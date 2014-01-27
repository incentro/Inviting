<%@include file="/includes/login_check.jsp"%>
<%@page import="model.*"%>
<%@page import="domein.*"%>
<%
String eventID 		=request.getParameter("eventID");
String mailID 			= request.getParameter("mailID");

MailISendO mio= new MailISendO();
mio.constructor(eventID, mailID, false,"");
%>
