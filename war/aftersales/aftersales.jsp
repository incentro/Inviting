   <% String eventID = request.getParameter("eventID");
    response.setHeader("Access-Control-Allow-Origin","*");
    %>
   
    <!DOCTYPE html>

    <%@page import="model.*"%>
    <%@page import="java.util.*"%>
    <%@page import="domein.*"%>
    <%@include file="../includes/login_check.jsp" %>
    

<html>
    <head>
        <title>Incentro Event Inviting System</title>
        <%@include file="../includes/head.html" %>
        <link rel="stylesheet" type="text/css" href="../assets/css/inviteSystem.css" />
    </head>

<body>

     <div class="fixed right">
			<div class="select_header">Naam</div>
			<div class="select_header">Email</div>
			<div class="select_header">Functie</div>
			<div class="select_header">Bedrijf</div>
			<div class="select_header">Telefoon</div>
			<div class="select_header">Mobiel</div>
			<div class="select_header">Contactpersoon</div>
     </div>
    <div class="wrapper">
<div class="header">
        <a href="/InviteSystem/eOverzicht.jsp" id="logo" ><img src="../assets/img/logo.png" /></a>
  		</div>
        <h3>Contactenlijst - uitnodigen</h3>
        <div class="search-form">
            <a href="../eOverzicht.jsp"><input type="submit" value="Terug"  class="button-menu" /></a>
			
            <div class="search-live">
                <input type="text" class="search-input" name="id" placeholder="Search"></input>
            </div>

            <div class="checkbox">
                <input name="eventID" id="eventID" value="<%out.print(eventID);%>" type="hidden" />
            </div>		
        </div>
	                 
        <table class="table sortable" >
         <caption><h1>Uitgenodigd</h1> </caption>   
            <thead>
             <tr>
                <th>Naam</th>
                <th>Email</th>
                <th>Bedrijf</th>
                <th>Functie</th>
                <th>Contactpersoon</th>
                <th>Status</th>
             </tr> 
            </thead>
            <tbody class="invited">
            <!-- ajax include -->
           	</tbody> 
            </table>        
    </div>
    
    <script src="../assets/js/jquery.1.8.0.min.js"></script>    
    <script src="../assets/js/aftersales.js"></script>
	<script src="../assets/js/sorttable.min.js"></script>
</body>
</html>