function checkForm(form)
  {
    if(form.username.value == "") {
      alert("Error: Username cannot be blank!");
      form.username.focus();
      return false;
    }

    if(form.password.value == "") {
    window.alert("Error: Please check that you've entered  your password!");
     form.password.focus();
     return false;
   }

  }
