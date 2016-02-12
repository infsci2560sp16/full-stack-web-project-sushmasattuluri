
function loadDoc() {

  var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
     if (xhttp.readyState == 4 && xhttp.status == 200) {
       document.getElementById("demo").innerHTML = xhttp.responseText;
     }
   };
  xhttp.open("GET", "C:\Users\sushma\Documents\safety_net.txt", true);
  xhttp.send();
}
