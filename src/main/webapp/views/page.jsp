<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hockeyhigh.model.entity.media.*" %>
<html>
<head>
	<link rel="stylesheet" href="page.css">
</head>
<body>
<div class="medium-news-div">

	<% Media media = (Media)request.getAttribute("media"); %>
	<img src="<%="views/" + media.getUrl()%>" alt="" class="news-image">

	<div class="article">
		<div class="header-date">
			<p class="news-header">NEWS</p>
			<p class="date">04.04.2023</p>
			<p><%= "/webapp/views/" + media.getUrl() %></p>

		</div>

		<div class="article">
			<h1 class="articl-header">Malik traded to Assat</h1>
			<blockquote>
				KooKoo has signed a one-year contract extension with Nick Malik. The upcoming season for the goalkeeper will be the third in a row in Kouvola.
				In his second league season, 20-year-old Nick Malik Played 24 regular season games between the posts at Kookoo with an interception percentage of 89.14% and three playoffs games with an interception percentage of 93.75%. In the regular season, the Czech's goals against average was 2.74 and in the playoffs 1.92. Malik has played a total of 58 regular season games in two seasons with a 90.97% interception rate and 17 playoffs with a 92.78% interception rate. Malik will form the goalkeeping duo in Kouvola together with Oskari Setänen.
				The phrase "The Curse of the second season"fits nicely with Malik's last season. However, Nick has proven his skills on several occasions and we believe he will come back with his best game in Coconut, " said Kookoo sports director Jarno Kultanen in a club press release.
				Assemble player contracts for the 2023-2024 season (situation 7.4.2023):
				<br><br>
				Goalkeepers: #31 Nick Malik, #32 Oskari Setänen<br>
				Defenders: #4 Väinö Liikonen, #17 Ari Gröndahl<br>
				Attackers: #20 Samuel Valkeejärvi, #91 Linus Andersson<br>
			</blockquote>
		</div>
	</div>
</div>
</body>
</html>
