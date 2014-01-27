<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="domein.*"%>
<%@include file="../includes/login_check.jsp" %>
<%      
        String eventID  = request.getParameter("eventID");
            BezoekerIO bIo = new BezoekerIO();
            ArrayList<ContactZoho> gList = bIo.naamBezoekers(eventID);
        for(ContactZoho g : gList) {
        %>		
           <tr class="hover" value="<%=g.getId()%>">
              <td><%=g.getVoornaam() + " "+ g.getAchternaam()%></td>
			 <td class="email"><%=g.getMail() %></td>
			 <td><%=g.getBedrijf() %></td>
			  <td><%=g.getFunctie() %></td>
			 <td><%=g.getContactpersoon()%></td>
			  <%
                            String status1 = g.getStatus();
                                    if (status1.equals("1")) {  status1 = "<td class='green'>Geaccepteerd</td>";
                                    } else if (status1.equals("2")) {status1 = "<td class='red'>Afgewezen</td>";
                                    } else {status1 = "<td>Afwachtend</td>";
                                    }
                                    out.print(status1);
                        %>
           </tr>    
                   
         <tr class='hiderow' style="display:none">
				<td><input type="hidden" name ="entityId" class="entityId" value="<%=g.getId()%>">Opmerking toevoegen:</td>
				<td><input type="text" name ="Note Title" class="NoteTitle" placeholder='Titel'><br />
           		<textarea name="Note Content" class="NoteContent" placeholder="plaats hier de opmerking"></textarea>
           		<input type="submit" value="Voeg toe" name="submit" class='sendxml' ></td>
           		<td></td><td></td><td></td>
           		<td><select name="status">
                            <option value="0">Status aanpassen</option>
                            <option value="1">Geaccepteerd</option>
                            <option value="2">Afgewezen</option>
                            <option value="3">Afwachtend</option>
                        </select></td>
           </tr>
           
       
        <%
        }
        %>
