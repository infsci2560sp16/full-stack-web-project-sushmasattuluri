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
<p> Pricing :The more you invest ,the less you pay for fees.</p>

  <ul>
     <#list messages as message>



  <#if message  <= 10,000 >
     0 -  ${message} Annual fee = 0.35%
  <#else>
  more than ${message}  Annual fee = 0.15%
  </#if>
  </#list>
</ul>
</p>
</div>

  <p>Select your first goal to begin</p>

  <div class="dropdown">
  <button type="button" class="dropbtn">Safety Net</button>
  <div  class="dropdown-content">
    <p class="p1">Grow your savings to cover 3 to 6 months of unplanned expenses in a conservatively invested portfolio.40%stocks and 60%bonds</p>
    <img src="test4.jpg" alt="HTML5 Icon" style="width:auto;height:350px;">
    <a href="">Select this goal -----     Safety Net    </a>

    </div>
  </div>

  <div class="dropdown">
  <button type="button" class="dropbtn">Retirement</button>
  <div  class="dropdown-content">
    <p class="p2">Invest long-term with a target of $1,827,000 for an annual retirement income of $89,037. This can be a regular investment account, or an IRA account.90%stocks and 10%bonds</p>
    <img src="test5.jpg" alt="HTML5 Icon" style="width:auto;height:350px;">
    <a href="">Select this goal</a>
      </div>
    </div>

      <div class="dropdown">
     <button type="button" class="dropbtn">General Investment</button>
     <div  class="dropdown-content">
       <p class="p3">Grow and preserve capital over time. This is an excellent goal type for unknown future needs or money you plan to pass to future generations.80%stocks and 20%bonds</p>
       <img src="test6.jpg" alt="HTML5 Icon"  style="width:auto;height:350px;">
       <a href="">Select this goal</a>
        </div>
      </div>


  <footer>
  Copyright © vistainvestments.com
  </footer>


</body>
</html>
