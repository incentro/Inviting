console.log = function() {
	console.log("a");
};


$(window).load(function() {
	var eventID = $(".checkbox  #eventID").val();

	// Ophalen uitgenodigde klanten
	$.post('invited.jsp', {
		beforeSend:load('.invited'), //Show spinner
        complete: unload('.invited'), 
		eventID : eventID,
	}, function(data) {
		$('.invited').html(data);
	});
	$('.invited').on('click', '.sendxml', function(e) {
		e.preventDefault();
		debugger;
		var id = $(this).parent().parent().find('.entityId').attr('value');
		var title = $(this).parent().find('.NoteTitle').val();
		var content = $(this).parent().find('.NoteContent').val();
		debugger;
		ajaxhandler(id, title, content, this);		
	});
	
	function ajaxhandler(id, title, content, e){
		$.post('postrecord.jsp', {
			beforeSend:load('.sendxml'), //Show spinner
	        complete: unload('.sendxml'), 
	        entityId : id,
	        NoteTitle: title,
	        NoteContent:content
	        
		}, function(data) {
			alert("opmerking toegevoegd");
			$(e).parent().toggle('slow');
		});
	}

	//vul de sidebar met data.
	$('.invited').on('mouseover', '.hover', function() {
		var id = $(this).attr('value');
		moreData(id);
	});
	
	$('.invited').on('click', '.hover', function() {
		$(this).next().toggle();
	});

	// Zoek functie
	$(".search-input").keyup(function() {
		var filter = $(this).val(), count = 0;

		$(".invited .hover").each(function() {
			if ($(this).text().search(new RegExp(filter, "i")) < 0) {
				$(this).fadeOut();
			} else {
				$(this).show();
				count++;
			}
		});
	});
	// alle checkboxes aanvinken
	$(".selectInvited").click(function() { checkAll('.invited tr td .check', this);});
	
	function checkAll(div, e){
		$(div).attr('checked', e.checked);
	}

	function moreData(id) {
		$.post('getContact.jsp', {
			beforeSend:load('.right'), //Show spinner
	        complete: unload('.right'), 
			id : id,
		}, function(data) {
			$('.right').html(data);
		});
	}
});

function load(div){
	$(div).append("<img class='loader' src='../assets/img/ajax-loader.gif'/>");
}
function unload(div){
	$(div+ " loader").remove();
}