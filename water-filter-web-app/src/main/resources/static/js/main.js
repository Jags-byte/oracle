$(document).ready(function () {
	console.log("Inside Document Ready");

    $("#ticketForm").submit(function (event) {
    	console.log("Inside Ticket Form Submit");
    	
    	event.preventDefault();
        createTicket();
    });

});

//Creates a new Ticket
function createTicket() {
   	console.log("Inside Create Ticket");
    $("#createTicketBtn").prop("disabled", true);
    $("#successAlert").addClass("d-none");
    $("#failureAlert").addClass("d-none");
    
	var formData = {
      ticketDescription: $("#ticketDescription").val(),
      customerId: $("#customerId").val(),
      agentName: $("#agentName").val()
    };
    
    var ticketSericeUri = $("#ticketServiceUri").val() + "/tickets";
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: ticketSericeUri,
        data: JSON.stringify(formData),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("Create Successful: ", data);
    		$("#createTicketBtn").prop("disabled", false);
    		$("#ticketDescription").val("");
      		$("#customerId").val("");
      		$("#agentName").val("");
      		$("#successAlert").removeClass("d-none");
	    },
        error: function (e) {
			console.log("Create Failed! ", e);
    		$("#createTicketBtn").prop("disabled", false);
      		$("#failureAlert").removeClass("d-none");

        }
    });
}

//Deletes a ticket
function deleteTicket(btn) {
   	console.log("Inside Delete Ticket");
   	var ticketId = $(btn).siblings('input').val();
   	console.log("ticketId: " + ticketId);
    $(btn).hide();
    $("#successAlert").addClass("d-none");
    $("#failureAlert").addClass("d-none");
    
    var ticketSericeUri = $("#ticketServiceUri").val() + "/tickets/" + ticketId;
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: ticketSericeUri,
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("Delete Successful: ", data);
    		$(btn).closest("tr").remove();
      		$("#successAlert").removeClass("d-none");
	    },
        error: function (e) {
			console.log("Delete Failed! ", e);
    		$(btn).show();
    		$("#failureAlert").removeClass("d-none");

        }
    });
}
