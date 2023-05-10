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
			<%= request.getAttribute("newsTop")%>
			<!--Second block-->
			<div class="div-news-other">
				<%= request.getAttribute("newsRight")%>
				<%= request.getAttribute("newsOther")%>
			</div>
			<!--Second block ended-->
		</div>
		<!--Videos Block-->
		<div class="main-videos-block">
			<div class="main-videos">
				<div class="videos-info">
					<div class="video-title-el">
						<p class="videos-title">VIDEOS</p>
					</div>
					<div class="video-title-el">
						<p class="more-videos-link">View more videos</p>
					</div>
				</div>
				<%= request.getAttribute("mediaRow")%>
			</div>
		</div>
		<!--Videos-->

		<!--Players Stats Block-->
		<div class="div-players-stats">
			<div class="players-stats-info">
				<div class="players-stats-el">
					<p class="stats-title">PLAYERS STATS</p>
				</div>
				<div class="players-stats-el">
					<p class="more-stats-link">View all TOP-10 statistics</p>
				</div>
			</div>

			<!--Players Stats Container-->
			<div class="players-stats-container"  >

				<div class="players-stats">
					<p class="points-title">Points</p>

					<div class="tournament-selection">
						<button class="tournament">REGULAR SEASON</button>
					</div>

					<div class="stat-selection">
						<button class="stat-selection-el" id="buttonP">ALL</button>
						<button class="stat-selection-el">DEFENSMAN</button>
						<button class="stat-selection-el">ROOKIES</button>
					</div>

					<%= request.getAttribute("top_stats")%>

				</div>

				<!--Separation-->

				<div class="goalies-stats">

					<p class="other-stats">Goalies</p>

					<div class="tournament-selection">
						<button class="tournament" onload="active">REGULAR SEASON</button>
					</div>

					<div class="stat-selection">
						<button class="stat-selection-el" id="buttonG">GAA</button>
						<button class="stat-selection-el">SAVES%</button>
						<button class="stat-selection-el">SHUTOUTS</button>
					</div>

					<div class="top-player-container">
						<div class="top-player-el">
							<img src="../images/joly.png" alt="" class="player-photo">
							<div class="player-info">
								<div class="player-info-el">
									<img src="../images/vaasan-sport-sm.png" style ="height:30px; width:40px;" alt="">
									<p class="player-number">#20</p>
								</div>
								<div class="player-info-el">
									<p class="player-name"></p>
								</div>
								<div class="player-info-el"></div>

							</div>
							<div class="player-stats">
								<p class="points-label">Points</p>
								<p class="points-total">5+2=7</p>
							</div>
						</div>
						<div class="top-player-list">
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
						</div>

					</div>

				</div>


			</div>
			<!--Players Stats Block-->
			<!--News-->
			<div class="main-news-block">
				<div class="main-news">
					<div class="news-info">
						<div class="news-title-el">
							<p class="news-title">NEWS</p>
						</div>
						<div class="news-title-el">
							<p class="more-news-link">Read-more</p>
						</div>
					</div>
					<%= request.getAttribute("articleRow")%>
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


	function setButtonsActive() {
		const buttonP = document.getElementById('buttonP');
		const buttonG = document.getElementById('buttonG');
		buttonP.classList.add('active');
		buttonG.classList.add('active');
	}

	function setButtonEvents() {
		const buttons = document.querySelectorAll('.stat-selection-el');
		const buttonsP = Object.values(buttons).slice(0,3);
		const buttonsG = Object.values(buttons).slice(3);
		setEventListeners(buttonsP);
		setEventListeners(buttonsG);
	}

	function setEventListeners(buttons) {
		console.log(buttons);
		buttons[0].addEventListener('click', function() {
			this.classList.add('active');
			buttons[1].classList.remove('active');
			buttons[2].classList.remove('active');
		});
		buttons[1].addEventListener('click', function() {
			this.classList.add('active');
			buttons[0].classList.remove('active');
			buttons[2].classList.remove('active');
		});
		buttons[2].addEventListener('click', function() {
			this.classList.add('active');
			buttons[0].classList.remove('active');
			buttons[1].classList.remove('active');
		});
	}

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

	setButtonsActive();
	setButtonEvents();
	setSlider();

</script>
</body>
</html>