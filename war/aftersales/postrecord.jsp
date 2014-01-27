<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="domein.*"%>
<%@include file="../includes/login_check.jsp" %>

<%
String entityId  = request.getParameter("entityId");
String title  = request.getParameter("NoteTitle");
String content  = request.getParameter("NoteContent");

ZohoAPI zoho = new ZohoAPI();

String xml = zoho.insertNote(entityId, title, content);

%>