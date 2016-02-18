function employeeValidation()
{
  var username = document.getElementById("username").value;
  var password = document.getElementById("password").value;
  var confpassword = document.getElementById("confpassword").value;
	var firstname= document.getElementById("firstname").value;
	var lastname= document.getElementById("lastname").value;
	var email= document.getElementById("email").value;
	var address= document.getElementById("address").value;
  var phone = document.getElementById("phone").value;
  var status = document.getElementById("status").value;
  var occupation = document.getElementById"'occupation").value;
  var income = document.getElementById("income").value;
  var estassets = document.getElementById("estassets").value;

	var emailreg= /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,6}$/;
	var alphareg=/^[A-Za-z]+$/;
	var alphanum= /^[0-9a-zA-Z]+$/;



	if(firstname!="" && lastname!="" && address!="" && city!="" && state!=""&& country!="" && zipcode!="" && employeeid!=""  && email!="")
	{
		if(email.match(emailreg))
		{
			if(firstname.match(alphareg))
			{
				if(address.match(alphanum))
				{
	              if(password.match(confpassword))
				  {
					  if(password.length>=6 && password.length<=20)
					  {
						alert("data suceessfully validated");
			            return true;
					  }
					  else
					  {
						alert("password must contain 6 to 20 character");
                       return false;
					  }
				  }
				  else
				  {
					alert("password cannot be matched");
					return false;
				  }

				}
				else
				{
				alert("enter a valid address");
				return false;
				}

			}
			else{
				alert("enter a valid first name");
				return false;
			}
		}

		else{
			alert("enter a valid email");
			return false;
		}
	}
	else{
		alert("all fields are required");
		return false;
	}

}
