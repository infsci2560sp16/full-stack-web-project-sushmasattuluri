window.onload = init;

$(function(){
        $("#submit").click(function(){

        var username = $("#username").val();
				var password = $("#password").val();
        // var email = $("#email").val();
        // var fname = $("#fname").val();
        // var lname =$("#lname").val();
				// var gender =$('input:radio[name="gender"]:checked').val();
				// var language =$("#language").val();
				// var planguage =$("#planguage").val();
				// var topic =$("#topic").val();

        var obj = JSON.stringify({"username":username,"password":password
																	// "email":email,"fname":fname,"lname":lname,
																	// "gender":gender,"language":language,"planguage":planguage,"topic":topic
                                });
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
