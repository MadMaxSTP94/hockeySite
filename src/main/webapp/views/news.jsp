<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.hockeyhigh.model.media.*" %>
<%@ page import="com.hockeyhigh.*" %>
<%@ page import="com.hockeyhigh.util.*" %>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="main.css"/>
	<link rel="stylesheet" href="news.css"/>
	<link rel="shortcut icon" href="vaasan-sport-sm.png"/>
	<title>Liiga</title>
	<style><%@include file="main.css"%></style>
	<style><%@include file="news.css"%></style>

</head>
<body>
<div class="parade-container">
	<!--Команды-->
	<div class="team hifk"><img src="team-logos/hifk.png" alt="hifk" class="hifk"></div>
	<div class="team hpk"><img src="team-logos/hpk.png" alt="hpk" class="hifk"></div>
	<div class="team ilves"><img src="team-logos/ilves.png" alt="ilves" class="hifk"></div>
	<div class="team jukurit"><img src="team-logos/jukurit.png" alt="jukurit" class="hifk"></div>
	<div class="team jyp"><img src="team-logos/jyp.png" alt="jyp" class="jyp"></div>
	<div class="team kalpa"><img src="team-logos/kalpa.png" alt="kalpa" class="kalpa"></div>
	<div class="team kookoo"><img src="team-logos/kookoo.png" alt="kookoo" class="kookoo"></div>
	<div class="team karpat"><img src="team-logos/karpat.png" alt="karpat" class="hifk"></div>
	<div class="team lukko"><img src="team-logos/lukko.png" alt="lukko" class="hifk lukko"></div>
	<div class="team pelicans"><img src="team-logos/pelicans.png" alt="pelicans" class="hifk"></div>
	<div class="team saipa"><img src="team-logos/saipa.png" alt="saipa" class="hifk"></div>
	<div class="team sport"><img src="team-logos/sport.png" alt="sport" class="hifk"></div>
	<div class="team tappara"><img src="team-logos/tappara.png" alt="tappara" class="hifk"></div>
	<div class="team tps"><img src="team-logos/tps.png" alt="tps" class="hifk"></div>
	<div class="team assat"><img src="team-logos/assat.png" alt="assat" class="hifk"></div>

	<!--JSP here-->
</div>

<header>
	<div class="main-menu-container">
		<div class="main-menu-item logo">
			<a href="" class="anchor">
				<img src="https://liiga.fi/static/media/logo_liiga_small.85530e4269a1040069b7.webp" alt="">
			</a>
		</div>
		<div class="main-menu-item">News</div>
		<div class="main-menu-item">Stats</div>
		<div class="main-menu-item">Players</div>
		<div class="main-menu-item">Teams</div>
		<div class="main-menu-item">Games</div>
	</div>
</header>


<!--Central columns-->
<div class="medium-two-column-container">
	<!--Left Column-->
	<div class="medium-left-column">
		<div class="games-schedule">
			<div class="games-schedule-group">
				<div class="schedule-arrow">
					<button class="left button">&#60</button>
				</div>
				<p class="label">Games</p>
				<div class="schedule-arrow">
					<button class="right button">></button>
				</div>
			</div>

			<!--Здесь будут игры-->

			<div class="games-list">
				<%= request.getAttribute("team_schedule") %>
				<div>
					<a href="" class="anchor">
						<p class="teams-schedule">view full schedule</p>
					</a>
				</div>

			</div>
			<!--Конец играм(((-->
		</div>

		<!--Таблица команд-->
		<div class="team-standings">
			<h1 class="team-standings-title">STANDINGS 22-2023</h1>
			<%=request.getAttribute("team_table")%>
			<div class="full-teams-stats-link">
				<a href="" class="anchor">
					<p>SEE STANDINGS WITH MORE DETAILS</p>
				</a>
			</div>
			<!--Teams-->
		</div>

	</div>
	<!--End of the left column-->

	<!--Right column-->
	<div class="medium-right-column">

		<div class="medium-news-div">
			<%= request.getAttribute("newsTop")%>
			<!--Second block-->
			<div class="div-news-other">
				<%= request.getAttribute("newsRight")%>
				<%= request.getAttribute("newsOther")%>
			</div>
			<!--Second block ended-->
		</div>

		<!--Players Stats Block-->
		<div class="div-players-stats">

			<!--News-->
			<div class="main-news-block">
				<div class="main-news">


					<div class="search-container">
						<div class="search">
							<div class="search-logo">
								<img src="../images/search.png" alt="search" class="search-logo">
							</div>
							<input type="text" class="search-input" placeholder="Find" maxlength="20">
						</div>
						<div class="filter">
							<label for="" class="filter-label">News</label>
							<select name="" id="" class="select">
								<option value="">News</option>
								<option value="">Videos</option>
							</select>
						</div>



					</div>
					<div class="news-info">
						<div class="news-title-el">
							<p class="news-title">LATEST</p>
						</div>
					</div>
					<%= request.getAttribute("mediaRow")%>

					<div class="more-block">
						<p class="more">LOAD MORE</p>
					</div>

				</div>
			</div>
			<!--News-->

		</div>
	</div>
	<!--Medium right column-->

</div>

<div class="footer">
	<div class="footer-main-container">dfdsbdfbdfbdfb</div>
	<div class="footer-secondary-container">gbfgbfgbfgbfgb</div>
</div>

<script>
	function targetClick () {
        const elems = document.querySelector('#testId');
        console.log(elems);
	}
	targetClick()
	</script>
</body>
</html>