function frmvalidate(form) {
    var err=new String();
    //Do validation,building error string as we go
    err+=frmnonblank("username","Username");
    err+=frmnonblank("password","Password");
    //err+=frmnonblank("firstname","First Name");
    //err+=frmnonblank("lastname","Last name");
  //  err+=frmnonblank("phone","Phone no");


    if(document.all || document.getElementById) {
      if(err.length !=0){
        errid=document.getElementById("errtext");
        errid.innerHTML =err;
        return(false);
      } else{
        validateid =document.getElementById("validateId");
        validateid.value="true";
      }
    }
    return (true);
}

function frmnonblank(el,name) {
  var err = new String();
  if(document.all || document.getElementById) {
    elid=document.getElementById(el);
    if(elid.value == " ") {
      err = "The '" + name +" 'field cannot be blank<br/>";
      }
  }
   return err;
}
