window.onload = init;

function submitTest(){
  alert("Submit test....!");
		return true;
}

  $function() {
       $("#submit").click(function(){
         alert("Welcome! You have registered successfully.. not really!");
              var username = $("#username").val();
              var password = $("#password").val();
              var obj = JSON.stringify({"username":username,"password":password});

              $.ajax({
             		url : "/api/register",
             		type : "POST",
                contentType:'application/json',
             		dataType: "json",
             		data : obj,
            		success : function(data) {
                  alert("Welcome! You have registered successfully!");
                  window.location.href='/index.html'
                  console.log(data);
                }
          	});
            return false;
        });
  });
