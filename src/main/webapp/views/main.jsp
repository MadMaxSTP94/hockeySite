<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.hockeyhigh.model.media.*" %>
<%@ page import="com.hockeyhigh.dto.*" %>
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
	<div class="team hifk"><img src="/main/team-logos/hifk.png" alt="hifk" class="hifk"></div>
	<div class="team hpk"><img src="/main/team-logos/hpk.png" alt="hpk" class="hifk"></div>
	<div class="team ilves"><img src="/main/team-logos/ilves.png" alt="ilves" class="hifk"></div>
	<div class="team jukurit"><img src="/main/team-logos/jukurit.png" alt="jukurit" class="hifk"></div>
	<div class="team jyp"><img src="/main/team-logos/jyp.png" alt="jyp" class="jyp"></div>
	<div class="team kalpa"><img src="/main/team-logos/kalpa.png" alt="kalpa" class="kalpa"></div>
	<div class="team kookoo"><img src="/main/team-logos/kookoo.png" alt="kookoo" class="kookoo"></div>
	<div class="team karpat"><img src="/main/team-logos/karpat.png" alt="karpat" class="hifk"></div>
	<div class="team lukko"><img src="/main/team-logos/lukko.png" alt="lukko" class="hifk lukko"></div>
	<div class="team pelicans"><img src="/main/team-logos/pelicans.png" alt="pelicans" class="hifk"></div>
	<div class="team saipa"><img src="/main/team-logos/saipa.png" alt="saipa" class="hifk"></div>
	<div class="team sport"><img src="/main/team-logos/sport.png" alt="sport" class="hifk"></div>
	<div class="team tappara"><img src="/main/team-logos/tappara.png" alt="tappara" class="hifk"></div>
	<div class="team tps"><img src="/main/team-logos/tps.png" alt="tps" class="hifk"></div>
	<div class="team assat"><img src="/main/team-logos/assat.png" alt="assat" class="hifk"></div>

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
				<div class="game">
					<div class="date">Today</div>
					<div class="status">2nd</div>
					<div class="game-score">
						<div class="game-team">
							<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
							<p class="team-name">Assat</p>
						</div>
						<div class="score">
							<p class="total-score">4 - 1</p>
						</div>
						<div class="game-team">
							<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
							<p class="team-name">Assat</p>
						</div>
					</div>
				</div>
				<div class="game">
					<div class="date">Today</div>
					<div class="status">2nd</div>
					<div class="game-score">
						<div class="game-team">
							<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
							<p class="team-name">Assat</p>
						</div>
						<div class="score">
							<p class="total-score">4 - 1</p>
						</div>
						<div class="game-team">
							<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
							<p class="team-name">Assat</p>
						</div>
					</div>
				</div>
				<div class="game">
					<div class="date">Today</div>
					<div class="status">2nd</div>
					<div class="game-score">
						<div class="game-team">
							<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
							<p class="team-name">Assat</p>
						</div>
						<div class="score">
							<p class="total-score">4 - 1</p>
						</div>
						<div class="game-team">
							<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
							<p class="team-name">Assat</p>
						</div>
					</div>

				</div>

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

			<div class="teams-position">
				<table class="teams">
					<tr class="stat">
						<td class="teams-table-column"></td>
						<td class="teams-table-column">Team</td>
						<td class="teams-table-column">GP</td>
						<td class="teams-table-column">W</td>
						<td class="teams-table-column">T</td>
						<td class="teams-table-column">L</td>
						<td class="teams-table-column">OTW</td>
						<td class="teams-table-column">P</td>
					</tr>
					<tr class="stat" id="nech">
						<td class="teams-table-column">1</td>
						<td class="teams-table-column">
							<div>
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<p class="team-name">Assat</p>
							</div>

						</td>
						<td class="teams-table-column">44</td>
						<td class="teams-table-column">29</td>
						<td class="teams-table-column">13</td>
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">0</td>
						<td class="teams-table-column">78</td>
					</tr>
					<tr class="stat">
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">
							<div>
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<p class="team-name">Pelicans</p>
							</div>
						</td>
						<td class="teams-table-column">44</td>
						<td class="teams-table-column">29</td>
						<td class="teams-table-column">13</td>
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">0</td>
						<td class="teams-table-column">78</td>
					</tr>
					<tr class="stat" id="nech">
						<td class="teams-table-column">3</td>
						<td class="teams-table-column">
							<div>
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<p class="team-name">Arizona Coyotes</p>
							</div>
						</td>
						<td class="teams-table-column">44</td>
						<td class="teams-table-column">29</td>
						<td class="teams-table-column">13</td>
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">0</td>
						<td class="teams-table-column">78</td>
					</tr>
				</table>

			</div>

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
			<a href="" class="anchor">
				<div class="news-div-top">
					<p class="news-header">NEWS</p>
					<p class="news-highlight">Some text</p>
					<p class="news-date">04.04.2023</p>
				</div>
			</a>



			<!--Second block-->
			<div class="div-news-other">
				<div class="news-div-top-right">
					<a href="" class="anchor">
						<p class="news-header">NEWS</p>
						<p class="news-highlight">Some text</p>
						<p class="news-date">04.04.2023</p>
					</a>
				</div>

				<div class="news-other">
					<div class="news-div">
						<a href="" class="anchor">
							<p class="news-header">NEWS</p>
							<p class="news-highlight">Some text</p>
							<p class="news-date">04.04.2023</p>
						</a>
					</div>
					<div class="news-div">
						<a href="" class="anchor">
							<p class="news-header">NEWS</p>
							<p class="news-highlight">Some text</p>
							<p class="news-date">04.04.2023</p>
						</a>
					</div>
				</div>

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
				<div class="videos-list">
					<div class="video">
						<a href="https://google.com" class="anchor">
							<img src="../images/2.jpg" alt="" class="video-img">
							<span class="video-description">Video description Ullmark made incredible save</span>
						</a>
						<span  class="video-date">04.04.2023</span>
					</div>
					<div class="video">
						<a href="" class="anchor">
							<% Media media = (Media)request.getAttribute("media"); %>
							<img src="<%="views/" + media.getUrl()%>" alt="" class="video-img">
							<span class="video-description"><%= media.getHeader() %></span>
						</a>
						<span  class="video-date">04.04.2023</span>
					</div>
					<div class="video">
						<a href="" class="anchor">
							<img src="../images/1.jpg" alt="" class="video-img">
							<span class="video-description">Video description</span>
						</a>
						<span  class="video-date">04.04.2023</span>
					</div>
					<div class="video">
						<a href="" class="anchor">
							<img src="../images/2.jpg" alt="" class="video-img">
							<span class="video-description">Video description</span>
						</a>
						<span  class="video-date">04.04.2023</span>
					</div>
				</div>

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
			<div class="players-stats-container">

				<div class="players-stats">
					<p class="points-title">Points</p>

					<div class="tournament-selection">
						<button class="tournament">PLAYOFFS</button>
						<button class="tournament">REGULAR SEASON</button>
					</div>

					<div class="stat-selection">
						<button class="stat-selection-el">ALL</button>
						<button class="stat-selection-el">DEFENSMAN</button>
						<button class="stat-selection-el">ROOKIES</button>
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
							<div id="testId" class="top-player-list-el">
								<img src=<%="views/" + media.getUrl()%> alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points"><%= media.getUrl() %></span>
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

				<!--Separation-->

				<div class="goalies-stats">
					<p class="other-stats">Goalies</p>

					<div class="tournament-selection">
						<button class="tournament">PLAYOFFS</button>
						<button class="tournament">REGULAR SEASON</button>
					</div>

					<div class="stat-selection">
						<button class="stat-selection-el">GAA</button>
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
					<div class="news-list">
						<div class="news">
							<a href="https://google.com" class="anchor">
								<img src="../images/3.jpg" alt="" class="video-img">
								<span class="news-description">Video description Ullmark made incredible save</span>
							</a>
							<span  class="news-date">04.04.2023</span>
						</div>
						<div class="news">
							<a href="" class="anchor">
								<img src="../images/7.jpg" alt="" class="video-img">
								<span class="news-description">News description</span>
							</a>
							<span  class="news-date">04.04.2023</span>
						</div>
						<div class="news">
							<a href="" class="anchor">

								<img src="../images/9.png" alt="" class="video-img">
								<span class="news-description">News description</span>
							</a>
							<span  class="news-date">04.04.2023</span>
						</div>
						<div class="news">
							<a href="" class="anchor">
								<img src="../images/8.jpg" alt="" class="video-img">
								<span class="news-description" >News description</span>
							</a>
							<span  class="news-date">04.04.2023</span>
						</div>
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
<script src="component/jquery/jquery.js" type="text/javascript"></script>
<script src="component/jquery/jquery.min.js" type="text/javascript"></script>
</body>
</html>