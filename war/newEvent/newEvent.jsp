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
	<!-- fieldsets --> 
	<!--  ************************************************************************************** -->
	<fieldset>
		<h2 class="fs-title">gebruiker toevoegen</h2>
		<h3 class="fs-subtitle">Voeg een nieuwe gebruiker toe die toegang krijgt tot dit systeem</h3>
		<input type="text" name="user_email" placeholder="Email" title="Voer hier het incentro email account in van de gebruiker" />
		<input type="text" name="user_voornaam" placeholder="voornaam" title="Voer de voornaam van de gebruiker in" />
		<input type="text" name="user_achternaam" placeholder=achternaam title="voer de achternaam in" />
		<input type="text" name="user_tel" placeholder="telefoonnummer" title="voer een telefoonnummer in" />
		<input type="text" name="user_bedrijf" placeholder="bedrijf" title="geef aan voor welk bedrijf het contactpersoon werkt" />
		<input type="password" name="user_pass" placeholder="Password" title="geef het wachtwoord waarmee de gebruiker kan inloggen" />
		<input type="password" name="user_cpass" placeholder="Confirm Password" title="voer nog een keer het wachtwoord in" />
		<input type="button" name="user_submit" class="submit action-button" id="gebruiker" value="Submit" />
		<input type="button" name="user_next" class="next action-button" id="next1" value="Terug" />
	</fieldset>
	<!--  ************************************************************************************** -->
	<fieldset>
		<h2 class="fs-title">Nieuw evenement</h2>
		<h3 class="fs-subtitle">Voeg een nieuw evenement toe</h3>
		<select name="event_gebruiker" class="event_gebruiker" title="Geef het contactpersoon op van dit evenement. Of maak een nieuw contactpersoon aan.">
			<!--  dynamic input from ajax -->
		</select>
		<input type="button" name="previous" class="previous action-button" value="Nieuwe gebruiker" />
		<input type="text" name="event_titel" placeholder="Titel evenement"  title="Voer hier de titel van het evenement in"/>
		<input type="text" name="event_subtitel" placeholder="Subtitel" title="Voeg een korte beschrijving toe van het evenement" />
		<input type="date" name="event_datum" placeholder="datum" title="selecteer de datum wanneer het evenement word gehouden" />
		<input type="text" name="event_organisator" placeholder="organisator" title="voeg de organisator van het evenement toe" />
		<select name="event_adres" class="event_adres" title="Geef aan waar het evenement gehouden word. Of maak een nieuwe locatie aan">
			<!--  dynamic input from ajax -->
		</select>
		<input type="button" name="next" class="next action-button" id="next2"  value="nieuwe locatie" />
		<input type="button" name="submit" class="submit action-button" id="evenement" value="Submit" />
	</fieldset>
	<!--  ************************************************************************************** -->
	<fieldset>
		<h2 class="fs-title">Locatie toevoegen</h2>
		<h3 class="fs-subtitle">Voeg hier een nieuwe locatie toe voor het evenement</h3>
		<input type="text" name="locatie_adres" placeholder="straat" style="width:75%;" title="voer de straatnaam in"  /><input type="text" name="locatie_nr" placeholder="nr" style="width:25%;" title="voer het huisnummer in" />
		<input type="text" name="locatie_plaats" placeholder="plaats" />
		<input type="text" name="locatie_postcode" placeholder="Postcode" maxlength="4" style="width:35%;" /><input type="text" name="locatie_postcode_nr" placeholder="nr" maxlength="2" style="width:20%;" />
		<input type="text" name="locatie_tel" placeholder="telefoonnr" />
		<input type="text" name="locatie_website" placeholder="website" />
		<input type="button" name="previous" class="previous action-button" value="Terug" />
		
		<input type="button" name="submit" class="submit action-button" id="locatie" value="Submit" />
	</fieldset>
	<!--  ************************************************************************************** -->
</form>
</div>
<!-- jQuery -->
<script src="../assets/js/jquery.1.8.0.min.js" type="text/javascript"></script>
<script src="../assets/js/tooltip.js" type="text/javascript"></script>
<!-- jQuery easing plugin -->
<script src="http://thecodeplayer.com/uploads/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="../assets/js/formSlider.js" type="text/javascript"></script>
<script src="../assets/js/newEvent.js" type="text/javascript"></script>
</body>
</html>