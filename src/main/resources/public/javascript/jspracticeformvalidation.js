function formvalidate() {
// Make quick references to our fields.
var username = document.getElementById("username");
var password = document.getElementById("password");
var confpassword = document.getElementById("confpassword");
var firstname = document.getElementById("firstname");
var lastname = document.getElementById("lastname");
var email = document.getElementById("email");
var address = document.getElementById("address");
var phone = document.getElementById("phone");
var status = document.getElementById("status");
var occupation = document.getElementById("occupation");
var income = document.getElementById("income");
var estassets = document.getElementById("estassets");

// Check each input in the order that it appears in the form.
if (lengthDefine(username, 6, 8)) {
if (matchingpassword(password,confpassword,"Error: Please check that you've entered and confirmed your password!") {
if (inputalphabet1(firstname, "* For your name please use alphabets only *")) {
if (inputalphabet2(lastname, "* For your name please use alphabets only *")) {
if (emailValidation(email, "* Please enter a valid email address *")) {
if (textAlphanumeric(address, "* For Address please use numbers and letters *")) {
if (textNumeric1(phone, "* Please enter a valid phone number *")) {
if (inputalphabet3(status, "* For your status please use alphabets only *")) {
if (inputalphabet4(occupation, "* For your status please use alphabets only *")) {
if (textNumeric2(income, "* Please enter numeric values *")) {
if (textNumeric3(estassets, "* Please enter numeric values *")) {
return true;
}
}
}
}
}
}
}
}
}
}

return false;
}

}
// Function that checks whether input text is numeric or not.
function textNumeric3(inputtext, alertMsg) {
var numericExpression = /^[0-9]+$/;
if (inputtext.value.match(numericExpression)) {
return true;
} else {
document.getElementById("estassets").innerText = alertMsg; // This segment displays the validation rule for zip.
inputtext.focus();
return false;
}
}
// Function that checks whether input text is numeric or not.
function textNumeric2(inputtext, alertMsg) {
var numericExpression = /^[0-9]+$/;
if (inputtext.value.match(numericExpression)) {
return true;
} else {
document.getElementById("income").innerText = alertMsg; // This segment displays the validation rule for zip.
inputtext.focus();
return false;
}
}
// Function that checks whether input text is an alphabetic character or not.
function inputalphabet4(inputtext, alertMsg) {
var alphaExp = /^[a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById("occupation").innerText = alertMsg; // This segment displays the validation rule for name.
//alert(alertMsg);
inputtext.focus();
return false;
}
}
// Function that checks whether input text is an alphabetic character or not.
function inputalphabet3(inputtext, alertMsg) {
var alphaExp = /^[a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById("status").innerText = alertMsg; // This segment displays the validation rule for name.
//alert(alertMsg);
inputtext.focus();
return false;
}
}

// Function that checks whether input text is numeric or not.
function textNumeric1(inputtext, alertMsg) {
var numericExpression = /^[0-9]+$/;
if (inputtext.value.match(numericExpression)) {
return true;
} else {
document.getElementById("phone").innerText = alertMsg; // This segment displays the validation rule for zip.
inputtext.focus();
return false;
}
}

// Function that checks whether input text includes alphabetic and numeric characters.
function textAlphanumeric(inputtext, alertMsg) {
var alphaExp = /^[0-9a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById("address").innerText = alertMsg; // This segment displays the validation rule for address.
inputtext.focus();
return false;
}
}


// Function that checks whether an user entered valid email address or not and displays alert message on wrong email address format.
function emailValidation(inputtext, alertMsg) {
var emailExp = /^[w-.+]+@[a-zA-Z0-9.-]+.[a-zA-z0-9]{2,4}$/;
if (inputtext.value.match(emailExp)) {
return true;
} else {
document.getElementById("email").innerText = alertMsg; // This segment displays the validation rule for email.
inputtext.focus();
return false;
}
}
// Function that checks whether input text is an alphabetic character or not.
function inputalphabet1(inputtext, alertMsg) {
var alphaExp = /^[a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById("firstname").innerText = alertMsg; // This segment displays the validation rule for name.
//alert(alertMsg);
inputtext.focus();
return false;
}
}
// Function that checks whether input text is an alphabetic character or not.
function inputalphabet2(inputtext, alertMsg) {
var alphaExp = /^[a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById("lastname").innerText = alertMsg; // This segment displays the validation rule for name.
//alert(alertMsg);
inputtext.focus();
return false;
}
}

function  matchingpassword(inputtext,inputtext2,alertMsg) {
if(inputtext.value == inputtext2.value){
  return true;
} else {
  document.getElementById("confpassword").innerText = alertMsg; // This segment displays the validation rule for email.
  inputtext2.focus();
  return false;
 }
 }
 // Function that checks whether the input characters are restricted according to defined by user.
 function lengthDefine(inputtext, min, max) {
 var uInput = inputtext.value;
 if (uInput.length >= min && uInput.length <= max) {
 return true;
 } else {
 document.getElementById("username").innerText = "* Please enter between " + min + " and " + max + " characters *"; // This segment displays the validation rule for username
 inputtext.focus();
 return false;
 }
 }
