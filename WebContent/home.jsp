<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,logic.buyticket.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <!-- info about content, e.g.: content type, keywords, charset or description -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- linked CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <link href="css/style.css" rel="stylesheet" type="text/css">
<title>Home</title>
</head>
<body class = "defaultBackgorund">
<div class="container">

 <div class="splitBanner left">
  <div class="centered">
  
  <!-- Logo -->
  <div class = "logoPosition">
  <img class = "logoImg" src="img/concertIcon.png" height = 106.8 width = 106.8>
  <div class = "row">
  <p class = "logoText">LIVE<mark style = "background-color: rgba(0,0,0,0); color: #6A4C93">the</mark>MUSIC</p>
  </div>
  </div>
  
    <ul>
    <li><form action="home.jsp" method="GET"><input type="submit" class = "selected" value="Home"></form></li>
    <li><form action="news.jsp" method="GET"><input type="submit" class = "notSelected" value="News"></form></li>
    <li><form action="favorites.jsp" method="GET"><input type="submit" class = "notSelected" value="Favorites"></form></li>
    <li><form action="friends.jsp" method="GET"><input type="submit" class = "notSelected" value="Friends"></form></li>
    <li><form action="aroundyou.jsp" method="GET"><input type="submit" class = "notSelected" value="Around you"></form></li>
    <li><form action="myevents.jsp" method="GET"><input type="submit" class = "notSelected" value="My Events"></form></li>
    </ul>
  </div>
</div>

<div class="splitBackground right">
  <div class="centered">
  <% String username = session.getAttribute("username").toString(); %>
    <h2>Welcome <%=username%></h2>
    <% 
    ArrayList<MusicEventBean> musicEvents = BuyTicketBoundary.getFollowed(username);
    %>
    <h3 class = "h3">Suggested Events</h3>
    <ul>
    <%
    for(int i = 0; i < musicEvents.size(); i++){
    	%><li class = "sideList">
    	<div class="card text-center" style="width: 18rem;">
    	<!-- Mettere immagine che cambia a seconda del path fornito e che usa immagine di default se path di default -->
  	<img class="card-img-top cardImg" src="img/concert.jpg" height = 215 width = 155>
  	<div class="card-body">
    <h5 class="card-title"><%= musicEvents.get(i).getName() %></h5>
    <h6 class="card-title"><%= musicEvents.get(i).getArtistId() %></h6>
  </div>
</div>
</li>
    		<%
    }
    %>
    </ul>
    <h3 class = "h3">Suggested Artists</h3>
  </div>
</div> 

</div>
</body>
</html>