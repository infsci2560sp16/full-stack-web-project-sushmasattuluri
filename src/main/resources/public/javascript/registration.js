function register(){
  alert("XXXXXXXsuccessfully accepted");
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var confpassword = $("#confpassword").val();
	var email = $("#email").val();
	$.post("/register",{"firstname":firstname,"lastname":lastname,"username":username,"password":password,"confpassword":confirmPassword,"email":email},function(data){
	alert("successfully accepted");
	window.location.href="/myIndex?username="+JSON.parse(data).username;
  });
}
