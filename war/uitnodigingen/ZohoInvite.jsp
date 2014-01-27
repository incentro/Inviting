<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="domein.*"%>
<%

String eventID  = request.getParameter("eventID");

ZohoAPI zc = new ZohoAPI();
UitnodigingIO UIo   = new UitnodigingIO();

ArrayList<ContactZoho> aContacts = new ArrayList<ContactZoho>() ;

aContacts = zc.koppelContacten(eventID);

for(ContactZoho l :  aContacts){
	UIo.genodigdenToevoegen(l.getId(), eventID);
}
%> 