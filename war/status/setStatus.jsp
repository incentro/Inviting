<%@page import="model.*" %>
<%@page import="domein.*"%>
<%@include file="/includes/login_check.jsp"%>
			
		<%
		OpmerkingIO oIo = new OpmerkingIO();
	  	String datum = oIo.getDate();
	
	  	String opmerking = request.getParameter("opmerking");
	  	String eventID = request.getParameter("eventID");
	  	String gebruikerID = (String)request.getSession().getAttribute("userMail");
	  	String contact	= request.getParameter("genodigdeID");

	  	oIo.insertOpmerking(contact, datum, opmerking, gebruikerID, eventID);
	  	%>
	  	<tr>
					<td><%out.print(gebruikerID);%></td>
					<td><%out.print(datum); %></td>
					<td><%out.print(opmerking); %></td>
			</tr>
	  	