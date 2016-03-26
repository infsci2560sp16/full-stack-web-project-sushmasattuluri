<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">

  <title>Welcome Page</title>
  <link rel="stylesheet" type="text/css" href="stylesheets/stylesheet_4.css">
</head>

<body>
  <header>
    <h1><img src="logo.jpg" alt="HTML5 Icon">Vista</h1>
  </header>

  <nav>
    <ul>

      <li><a href="">About Us</a></li>
      <li><a href="page5_standard.html">Details about Stocks and Bonds</a></li>
      <li><a href="page4_contactus.html">Contact Us</a></li>
      <li><input type="button" onclick="location.href='index.html';" value="Log Out" />	</li>

      </ul>
  </nav>





      <div class="data_from_server">
    <h2> Pricing <h2><br>
      ${message}

    <#list users as user>

                      <#if user  == "John Doe" >
          <p>Investment less than  $10,000 :</p><br>
          Annual fee = 0.35%
      <#else>
    <p>  Investment greater than  $10,000 :</p><br>
     Annual fee = 0.15%
      </#if>
                        </#list>

    </div>


  <footer>
  Copyright © vistainvestments.com
  </footer>


</body>
</html>
