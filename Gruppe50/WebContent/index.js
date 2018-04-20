$(document).ready(function() {
    
	//alert("Javascript ready");
	
	$("#btn").click(function() {
		
		//Prevent form from reseting on incorrect login credentials
		//event.preventDefault();

		var data = $("#loginForm").serializeObject();
		
		alert("Name: " + data.username + " Password: " + data.password);
			
		$.ajax({
			url: "rest/test/login",
			data: JSON.stringify(data),
			contentType: "application/json",
			method: 'POST',
			success: function(resp){
				alert(resp);
			},
			error: function(resp){
				alert("Fejl: " + resp);
			}
		})
	});
	
});