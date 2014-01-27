$(window).load(function() {
	locatie();
	gebruiker();
	$("#gebruiker").click( function(){
		var field = $(this).parent() ;
		if(validate(field)) {
			 var email 				= $( "input[name='user_email']" ).val();
			 var voornaam 		= $( "input[name='user_voornaam']" ).val();
			 var achternaam 	= $( "input[name='user_achternaam']" ).val();
			 var tel					=	$( "input[name='user_tel']" ).val();
			 var bedrijf				=	$( "input[name='user_bedrijf']" ).val();
			 var pass					=	$( "input[name='user_pass']" ).val();
			 var cpass				=	$( "input[name='user_cpass']" ).val();
			 var button			= "#next1";
			 if(pass === cpass){
				 insert("addGebruiker.jsp",email, voornaam, achternaam, tel, pass, bedrijf, button);
			 } else {
				 error("wachtwoorden zijn niet gelijk");
			 }	
		} else{
			error("niet alle velden ingevuld");
		}
	} );
	$(".table").on("click", "#gebruikerDelete", function() {
		event.preventDefault();
		var email = $(this).attr("value");
		$.post('deleteUser.jsp', {
			email : email
		}, function(data) {
			alert("gebruiker met emailadres: "+email+" verwijderd");
			debugger;
			$(this).parent().remove();
			debugger;
		});
	});

	$("#locatie").click(function(){
		var field = $(this).parent() ;
		if(validate(field)) {
			 var adres 			= $( "input[name='locatie_adres']" ).val() + " " + $( "input[name='locatie_nr']" ).val();
			 var plaats 			= $( "input[name='locatie_plaats']" ).val();
			 var postcode 	= $( "input[name='locatie_postcode']" ).val() + $( "input[name='locatie_postcode_nr']" ).val();
			 var tel		 		= $( "input[name='locatie_tel']" ).val();
			 var website		=	$( "input[name='locatie_website']" ).val();
			 var button			=	"#next2";

				 insert("addLocatie.jsp",adres, plaats, postcode, website, tel, "", button);
		} else{
			error("niet alle velden ingevuld");
		}
	} );
	

	$("#evenement").click( function(){
		var field = $(this).parent() ;
		if(validate(field)) {
			 var gebruiker 	= $( "select[name='event_gebruiker']" ).val();
			 var titel 				= $( "input[name='event_titel']" ).val();
			 var subtitel 		= $( "input[name='event_subtitel']" ).val();
			 var datum			=	$( "input[name='event_datum']" ).val();
			 var organisator=	$( "input[name='event_organisator']" ).val();
			 var adres			=	$( "select[name='event_adres']" ).val();
			 var button		=	"home";
				 insert("addEvent.jsp",gebruiker, titel, subtitel, datum, organisator, adres, button);

		} else{
			error("niet alle velden ingevuld");
		}
	});
	
	function locatie() {
		$.post('locaties.jsp', {
		}, function(data) {
			$(".event_adres").html(data);
		});
	}
	
	function gebruiker() {
		$.post('gebruikers.jsp', {
		}, function(data) {
			$(".event_gebruiker").html(data);
		});
	}
	
	

	// general functions
	function validate(fieldset){
		var bool = true;
		$(fieldset).find("input, select").each(function() {
			   if($(this).val() === "")	 {
				   bool = false;
			   }   			 
		});
		return bool;
	}

	function insert(url, v1,v2, v3, v4, v5, v6, button){
		$.post(url, {
			v1 : v1,
			v2 : v2,
			v3 : v3,
			v4: v4,
			v5: v5,
			v6: v6
		}, function(data) {
			succes(data, button);
			 locatie();
			 gebruiker();
			 if(button == "home") {
				 setTimeout(function(){ window.location = "../eOverzicht.jsp"; }, 3400);
			 }
		});
	}
	
	function error(text){
		$('.fs-subtitle').text(text).css('color', 'red');
	}
	
	function succes(text, button){
		$('.fs-subtitle').text(text).css('color', 'green');
	};
	
});


