$(document).ready(function () {
	console.log("Inside Document Ready Agent");
    fetchTickets();

});

//Retrieves all tickets for an Agent
function fetchTickets() {
   	console.log("Inside fetchTickets");
    var agentName = $("#loggedInAgentName").val();;
   	console.log("agentName: " + agentName);
    
    var ticketSericeUri = $("#ticketServiceUri").val() + "/tickets/agents/" + agentName;
    
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: ticketSericeUri,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (mydata) {
            try{
	            console.log("Fetch Successful: ", mydata);
	            mydata.forEach( ticket => {
	            
	            	var d = new Date("" + ticket.createdDate); 
	            	let createdDate = d.toLocaleString();
	            	let tr = `<tr >
						<td>${ticket.ticketId}</td>
						<td>${ticket.ticketDescription}</td>
						<td>${ticket.customer.name}</td>
						<td>${createdDate}</td>
						<td class="tistat">${ticket.ticketStatus}</td>`;
					
					if (ticket.ticketStatus == 'ASSIGNED') {
						tr = tr +
							`<td><a href="#" onclick="updateTicketStatus(this)">Complete</a>
							<input type="hidden" value="${ticket.ticketId}"/>
							</td>
						</tr>`;
					} else {
						tr = tr + `<td></td></tr>`
					}
					 
		      		$('#ticketDetailsTableBody').append(tr);
				});
				$("#loadingSpinner").remove();
	      		$("#ticketDetailsTable").removeClass("d-none");
	      	} catch(e) {
				console.log("Fetch Failed! ", e);
	      		$("#loadingSpinner").remove();
	      		$("#noResultAlert").removeClass("d-none");
			}
	    },
        error: function (e) {
			console.log("Fetch Failed! ", e);
      		$("#loadingSpinner").remove();
      		$("#noResultAlert").removeClass("d-none");
        }
    });
}

//Updates Ticket Status
function updateTicketStatus(btn) {
   	console.log("Inside Update Ticket Status");
   	var ticketId = $(btn).siblings('input').val();
   	console.log("ticketId: " + ticketId);
    $(btn).hide();
    $("#successAlert").addClass("d-none");
    $("#failureAlert").addClass("d-none");
    
    
	var formData = {
      ticketId: ticketId,
      ticketStatus: 'COMPLETED'
    };
    
    var ticketSericeUri = $("#ticketServiceUri").val() + "/tickets/status";
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: ticketSericeUri,
        data: JSON.stringify(formData),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("Update Successful: ", data);
    		console.log("###" + $(btn).closest("tr").find(".tistat"));
    		console.log("###" + $(btn).closest("tr").find(".tistat").text());
    		console.log("###" + $(btn).closest("tr").find(".tistat").html());
    		$(btn).closest("tr").find(".tistat").html("COMPLETED");
    		$(btn).remove();
    		
      		$("#successAlert").removeClass("d-none");
	    },
        error: function (e) {
			console.log("Update Failed! ", e);
    		$(btn).show();
    		$("#failureAlert").removeClass("d-none");

        }
    });
}
