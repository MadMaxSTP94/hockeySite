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
	<style><%@include file="players.css"%></style>

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

	<!--Таблица команд-->
	<div class="team-standings">

		<!--<h1 class="team-standings-title">STANDINGS 22-2023</h1>-->
		<div class="filters">
			<h3 class="filter-title">Filters</h3>
			<div class="filter-list">
				<div class="filter-list-el">
					<label for="" class="filter-header-label">Season</label>
					<select name="season" id="1">
						<option value="" class="season-option">2022 - 2023</option>
						<option value="" class="season-option">2021 - 2022</option>
						<option value="" class="season-option">2020 - 2021</option>
						<option value="" class="season-option">2019 - 2020</option>
					</select>

				</div>
				<div class="filter-list-el">
					<label for="" class="filter-header-label">Stats</label>
					<select name="season" id="2">
						<option value="" class="season-option">Standings</option>
						<option value="" class="season-option">Power play</option>
						<option value="" class="season-option">Penalty kill</option>
						<option value="" class="season-option">Attendance</option>
					</select>
				</div>

				<div class="filter-list-el">
					<label for="" class="filter-header-label">Team</label>
					<select name="season" id="">
						<option value="" class="season-option">All</option>
						<option value="" class="season-option">Assat</option>
						<option value="" class="season-option">HIFK</option>
						<option value="" class="season-option">LUKKO</option>
					</select>
				</div>
				<div class="filter-list-el"></div>
			</div>
		</div>

		<div class="teams-position">
			<table class="teams">
				<tr class="stat header">
					<td class="teams-table-column  points">NAME</td>
					<td class="teams-table-column">TEAM</td>
					<td class="teams-table-column">PLACE OF BIRTH</td>
					<td class="teams-table-column">NATIONALITY</td>
					<td class="teams-table-column">AGE</td>
					<td class="teams-table-column">HEIGHT</td>
					<td class="teams-table-column">WEIGHT</td>

					<td class="teams-table-column">SHOOTS</td>

				</tr>
				<%= request.getAttribute("playerRows")%>
			</table>

		</div>

	</div>
</div>



</div>

<div class="footer">
	<div class="footer-main-container">dfdsbdfbdfbdfb</div>
	<div class="footer-secondary-container">gbfgbfgbfgbfgb</div>
</div>

</body>
</html>