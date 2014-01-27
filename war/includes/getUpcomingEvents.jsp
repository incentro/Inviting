	<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="domein.*"%>
<%@include file="../includes/login_check.jsp" %>
<%		
		
				EvenementenIO eIo = new EvenementenIO();
				ActieIO aio				= new ActieIO();
				
				for (Evenement e : eIo.listUpcomingEvents()) {

		%><tr>
			
					<td><a href="eDetails.jsp?eventID=<%out.print(e.getEventID());%>"><%=e.getNaam() %></a></td>	
					<td>
						<%
							out.print(e.getContactPersoon());
						%>
					</td>
					<td>
						<%=  e.getDatum()	%>
					</td>
					<td><a href="uitnodigingen/uUitnodigen.jsp?eventID=<%out.print(e.getEventID()); %>">Uitnodigen</a></td>
					<td><a href="status/status.jsp?eventID=<%out.print(e.getEventID()); %>">Status</a></td>
					<td><a href="actiepage.jsp?eventID=<%=e.getEventID() %>">Todo
					<%if(aio.checkActies(e.getEventID())) {
						out.println("<span style='color:red'>!</span>");
					}
					%>	
					</a></td>
			</tr>
			<%
				}
					
			%>