<%@include file="/includes/login_check.jsp"%>
<%@page import="model.*"%>
<%@page import="domein.*"%>
<% 
String eventID 			= request.getParameter("eventID");
int mailID 				= Integer.parseInt(request.getParameter("mailID"));

String naam				= "mail ";
String onderwerp 		= request.getParameter("onderwerp");
String wat				= request.getParameter("exist");
Boolean active 			= Boolean.valueOf(request.getParameter("exist"));  
boolean exist 			= active.booleanValue();  
String aanhef			= request.getParameter("aanhef");
String link				= request.getParameter("link");
String image_header		= request.getParameter("image_header");
String image_subheader	= request.getParameter("image_subheader");
String image			= request.getParameter("image");
String header1			= request.getParameter("header1");
String header2			= request.getParameter("header2");
String content1			= request.getParameter("content1");
String content2			= request.getParameter("content2");

	//update query

MailIO mIo			= new MailIO();
if(!exist){
mIo.addMailData(eventID, naam, aanhef, onderwerp, link, image_header, image_subheader, image, content1, header1, header2, content2);
}else {
	mIo.updateMailData(mailID, eventID, naam, aanhef, onderwerp, link, image_header, image_subheader, image, content1, header1, header2, content2);
}


%>