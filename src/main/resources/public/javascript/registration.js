window.onload = init;

function submitTest(){
  alert("Submit test....!");
		return true;
}


$(function(){
        $("#submit").click(function(){

        var username = $("#username").val();
				var password = $("#password").val();

        var obj = JSON.stringify({"username":username,"password":password	});
              $.ajax({
                  contentType:'application/json',
                  url: '/api/register',
                  type: "POST",
                  datatype: "json",
                  data: obj,
                  success: function(data) {
                      alert("Welcome! You have registered successfully!");
                      window.location.href='/index.html';
											console.log(data);
                  }
              });
                    return false;
          });
   });
