$( document ).ready(function() {
    
		alert("hej");
                       
    var imgPath = "/Gruppe50/GRAFIK";
		var counter = 0;
		var gameover = false;
   
    $("#galge").attr("src", imgPath + "/galge.png");
   
   //e.preventDefault();
   
    $.ajax({
    
      type     :  "POST",
      url      :  "galgeleg",
      dataType :  "application/json",
      //data     :  "",
      success  :  function(result) {
        //$("#word").text(result.word);
        $("#word").text("success");
      },
      error    :  function(xhr) {
        alert('an error occured ' + xhr.status + ' status text ' + xhr.statusText + ' ' + xhr.responseText);
      }
    });
   
});

//apache-tomcat-9.0.6/bin/startup.sh
//apace-tomcat-9.0.6/bin/shutdown.sh