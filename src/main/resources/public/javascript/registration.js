function register(){
  alert("XXXXXXXsuccessfully accepted");
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var confpassword = $("#confpassword").val();
	var email = $("#email").val();
  alert("XXXXXXXsuccessfully accepted"+ firstname + "  " + lastname+ "  " + username+ "  " + password + "  "+ email);
	//$.post("/register",{"firstname":firstname,"lastname":lastname,"username":username,"password":password,"confpassword":confirmPassword,"email":email},function(data){

  var obj = JSON.stringify("firstname":firstname,"lastname":lastname,"username":username,"password":password,"confpassword":confirmPassword,"email":email);

  $.ajax({
                   contentType:'application/json',
                   url: "/register",
                   type: "POST",
                   datatype: "json",
                   data: obj,
                   success: function(data) {
                       alert("Welcome! You have registered successfully!");
                       //window.location.href='/index.html';
 											console.log(data);
                   }
               });
}
