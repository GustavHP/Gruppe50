$( document ).ready(function() {
    
	alert("Javascript file loaded...");
	
	data = $("#dataToSend").val();
	
	
	$("#Btn").click(function() {
		$.ajax({
		      type     :  "POST",
		      url      :  "rest/test/ct",
		      data	   :  data,
		      dataType :  "application/json",
		      success  :  function(data) {
		    	  alert("Din token: " + data);
		      },
		      error    :  function(xhr) {
		        alert('an error occured: ' + xhr.status + ' status text: ' + xhr.statusText + ' responseText: ' + xhr.responseText);
		      }
		    });
	});
   
});