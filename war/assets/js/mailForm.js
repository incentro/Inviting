
//$(window).load(function() {
/*	var count = 0;
	
	//If pressed at addBlock add a block and check the count status
	$( ".addBlock" ).click(function(event) {
		event.preventDefault();
		count = count +1;
		extraBlock();
		checkAdd();
	});
	
	//If pressed at dynamic item remove
	$('.dynamic').on('click tap', '.remove', function() {
		removeitem(this);
	});
	*/
	//Add an extra block to element dynamic
/*	function extraBlock() {
		$(".dynamic").append(	"<div class='row textblock'>" +
								"<label>Header</label>" +
								"<input type='text' class='mail_content'/>" +
								"<label>Content</label>" +
								"<textarea class='mail_content'></textarea><img src='../assets/img/remove-button.png' class='remove'>" +
								"</div>");
	}
	
	//Check the count status and remove the closest row
	function removeitem(handler) {
		count = count -1;
		checkAdd();
		$(handler).closest('.row').remove();
		
	}*/

	// check the count status and remove or show
/*	function checkAdd() {
		if(count >= 2){
			$(".addBlock").hide();
		}
		else {
			$(".addBlock").show();
		}	
	}
});*/
// opslaan van de mail

// handle form data
$(window).load(function() {
	//var eventID = $('.eventID').val();

	/*$( "#opslaan" ).click(function(event) {
		load('.loader');
		event.preventDefault();
			$.post('mail_save_data.jsp', 
					$( "form" ).serialize()
			,function(data) {
				unload('.loader');
				alert("Gegevens zijn opgeslagen");
				window.location = '../mailen.jsp?eventID='+eventID;
			});
			  
	});*/
	
	$('#verstuurTest').click(function(){
		event.preventDefault();
		var eventID = $('.eventID').val();
		var mailID = $('.mailID').val();
		var receiver = $('.receiver').val();
		$.post('sendSingleMail.jsp', {
			beforeSend:load('.lader'), //Show spinner
			eventID : eventID,
			mailID : mailID,
			receiver : receiver
		}, function(data) {
			alert(data + receiver);
			unload('.lader');
		});
	});	
	
	function load(div){
		$(div).append("<img class='loader' src='../assets/img/ajax-loader.gif'/>");
	}
	function unload(div){
		$(div + " .loader").remove();
	}
});


