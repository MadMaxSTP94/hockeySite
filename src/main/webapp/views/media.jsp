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
	<link rel="stylesheet" href="media.css"/>
	<link rel="shortcut icon" href="vaasan-sport-sm.png"/>
	<title>Liiga</title>
	<style><%@include file="main.css"%></style>
	<style><%@include file="media.css"%></style>

</head>
<body>
<div class="parade-container">
	<!--Команды-->
	<div class="team hifk"><a href="/team?id=15"><img src="team-logos/hifk.png" alt="hifk" class="hifk"></a></div>
	<div class="team hpk"><a href="/team?id=16"><img src="team-logos/hpk.png" alt="hpk" class="hifk"></a></div>
	<div class="team ilves"><a href="/team?id=14"><img src="team-logos/ilves.png" alt="ilves" class="hifk"></a></div>
	<div class="team jukurit"><a href="/team?id=17"><img src="team-logos/jukurit.png" alt="jukurit" class="hifk"></a></div>
	<div class="team jyp"><a href="/team?id=18"><img src="team-logos/jyp.png" alt="jyp" class="jyp"></a></div>
	<div class="team kalpa"><a href="/team?id=20"><img src="team-logos/kalpa.png" alt="kalpa" class="kalpa"></a></div>
	<div class="team kookoo"><a href="/team?id=21"><img src="team-logos/kookoo.png" alt="kookoo" class="kookoo"></a></div>
	<div class="team karpat"><a href="/team?id=22"><img src="team-logos/karpat.png" alt="karpat" class="hifk"></a></div>
	<div class="team lukko"><a href="/team?id=23"><img src="team-logos/lukko.png" alt="lukko" class="hifk lukko"></a></div>
	<div class="team pelicans"><a href="/team?id=12"><img src="team-logos/pelicans.png" alt="pelicans" class="hifk"></a></div>
	<div class="team saipa"><a href="/team?id=24"><img src="team-logos/saipa.png" alt="saipa" class="hifk"></a></div>
	<div class="team sport"><a href="/team?id=25"><img src="team-logos/sport.png" alt="sport" class="hifk"></a></div>
	<div class="team tappara"><a href="/team?id=5"><img src="team-logos/tappara.png" alt="tappara" class="hifk"></a></div>
	<div class="team tps"><a href="/team?id=26"><img src="team-logos/tps.png" alt="tps" class="hifk"></a></div>
	<div class="team assat"><a href="/team?id=27"><img src="team-logos/assat.png" alt="assat" class="hifk"></a></div>

	<!--JSP here-->
</div>

<header>
	<div class="main-menu-container">
		<div class="main-menu-item">
			<a href="/main" class="anchor">
				<img src="https://liiga.fi/static/media/logo_liiga_small.85530e4269a1040069b7.webp" alt="">
			</a>
		</div>
		<div class="main-menu-item"><a class="anchor" href="/news"><p>News</p></a></div>
		<div class="main-menu-item"><a class="anchor" href="/stats"><p>Stats</p></a></div>
		<div class="main-menu-item"><a class="anchor" href="/players"><p>Players</p></a></div>
		<div class="main-menu-item"><a class="anchor" href="/teams"><p>Teams</p></a></div>
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
					<button class="button" id="left">&#60</button>
				</div>
				<p class="label">Games</p>
				<div class="schedule-arrow">
					<button class="button" id="right">></button>
				</div>
			</div>

			<!--Здесь будут игры-->

			<div class="schedule">
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
				<a href="/teams" class="anchor">
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


			<%= request.getAttribute("mediaBlock")%>


		</div>
	</div>
	<!--Medium right column-->

</div>

<div class="footer">
	<div class="footer-main-container">dfdsbdfbdfbdfb</div>
	<div class="footer-secondary-container">gbfgbfgbfgbfgb</div>
</div>


<script>


	function setSlider() {
		var slides = document.querySelectorAll('.games-list');
		var currentSlide = 0;
		var slideInterval = setInterval(nextSlide, 5000);

		var prevButton = document.querySelector('#left');
		var nextButton = document.querySelector('#right');

		function nextSlide() {
			if(currentSlide != slides.length - 1) {
				slides[currentSlide].classList.add('hidden');
                currentSlide = (currentSlide + 1) % slides.length;
                slides[currentSlide].classList.remove('hidden');
			}
		}

		function prevSlide() {
			if(currentSlide > 0) {
				slides[currentSlide].classList.add('hidden');
                currentSlide = (currentSlide - 1 + slides.length) % slides.length;
                slides[currentSlide].classList.remove('hidden');
			}
		}

		prevButton.addEventListener('click', function() {
            clearInterval(slideInterval);
            prevSlide();
            slideInterval = setInterval(nextSlide, 5000);
		});

		nextButton.addEventListener('click', function() {
            clearInterval(slideInterval);
            nextSlide();
            slideInterval = setInterval(nextSlide, 5000);
		});
	}

	setSlider();

</script>
</body>
</html>