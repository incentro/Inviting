<%@include file="/includes/login_check.jsp"%>
<%@page import="model.*" %>
<%@page import="domein.*" %>
<!DOCTYPE html>
<html>

<head>
<title>Incentro Event Inviting System</title>
<%@include file="/includes/head.html" %>
<link rel="stylesheet" type="text/css" href="../assets/css/inviteSystem.css" />
</head>

<body>

	<div class="wrapper">
		<div class="header">
			<a href="../eOverzicht.jsp" class="logo"><img src="../assets/img/logo.png" /></a>
		</div>
			<h3>Evenement aanmaken</h3>
			
		<%@include file="/includes/menu_back.html" %>
		
			
		<form class='opstelForm' action="../EventToevoegen.do" method="get" >
			 <div class="child bottom noheight">     			

				 
				<label>Contactpersoon</label> 
					<select name="contactpersoon">
					<% 
					GebruikersIO gIo = new GebruikersIO();
						for(Gebruiker g : gIo.listGebruikers()){
					%>
						<option value="<%out.print(g.getVoornaam() +" "+g.getAchternaam()); %>"><%out.print(g.getVoornaam() +" "+g.getAchternaam()); %></option>
						<%} %>
					</select> <br /><br /> 
					<label>Titel event</label> <input type="text" id="naam" name="naam" placeholder="Titel evenement" required />
				<br />			
					<label>Subtitel</label> <input type="text" id="subTitel" name="subTitel" placeholder="Subtitel" required />
				<br />			
					<label>Datum</label> <input type="date" name="datum" id="datum" placeholder="datum" required />
				<br />			
					<label>Organisator</label> <input type="text" name="organisator" id="organisator" placeholder="organisator" required />
				<br />
				
				<label for="locatie">Locatie</label> 
					<select name="locatie">
<%
					LocatieIO lIo = new LocatieIO();
						for(Locatie l : lIo.listLocaties()){
					%>
						<option value="<%out.print(l.getLocatieID());%>"><%out.print(l.getAdres()+", "+l.getPlaats()); %></option>
						<%} %>
					</select> 
			</div>

			<input type="submit" name="voegToe" value="Voeg toe" id="form_submit1" />
		
		</form>		
	</div>
</body>

</html>