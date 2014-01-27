<%@include file="/includes/login_check.jsp"%>
<%@page import="model.*"%>
<%@page import="domein.*"%>
<!DOCTYPE html>
<html>

<head>
<title>Incentro Event Inviting System</title>
<%@include file="/includes/head.html"%>
<link rel="stylesheet" type="text/css" href="../assets/css/inviteSystem.css" />
</head>
<body>
<div class="wrapper">
<div class="header">
			<a href="../eOverzicht.jsp" class="logo"><img src="../assets/img/logo.png" alt="" /></a>
		</div>
		<%@include file="../includes/menu_back.html" %>
<!-- multistep form -->
<form id="msform">
	<!-- fieldset --> 

	<fieldset class="show">
		<h2 class="fs-title">Locatie toevoegen</h2>
		<h3 class="fs-subtitle">Voeg hier een nieuwe locatie toe</h3>
		<input type="text" name="locatie_adres" placeholder="straat" style="width:75%;" title="voer de straatnaam in"  /><input type="text" name="locatie_nr" placeholder="nr" style="width:25%;" title="voer het huisnummer in" />
		<input type="text" name="locatie_plaats" placeholder="plaats" />
		<input type="text" name="locatie_postcode" placeholder="Postcode" maxlength="4" style="width:35%;" /><input type="text" name="locatie_postcode_nr" placeholder="nr" maxlength="2" style="width:20%;" />
		<input type="text" name="locatie_tel" placeholder="telefoonnr" />
		<input type="text" name="locatie_website" placeholder="website" /> 
		
		<input type="button" name="submit" class="submit action-button" id="locatie" value="Submit" />
	</fieldset>
	<!--  ************************************************************************************** -->
</form>
</div>
<!-- jQuery -->
<script src="../assets/js/jquery.1.8.0.min.js" type="text/javascript"></script>
<script src="../assets/js/tooltip.js" type="text/javascript"></script>
<script src="../assets/js/newEvent.js" type="text/javascript"></script>
</body>
</html>