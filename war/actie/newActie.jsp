<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="domein.*"%>
<%@include file="../includes/login_check.jsp" %>
<%		
	String eventID 	= request.getParameter("eventID");
	String user 	= request.getParameter("user_id");
	String date 	= request.getParameter("date");
	String text 	= request.getParameter("text");
	String actor 	= request.getParameter("actor");
	String contact 	= request.getParameter("contact");
		 
	ActieIO aio = new ActieIO();
	aio.setActie(eventID, user, date, text, actor, contact);
			
%>
