package com.codeoftheweb.salvo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) throws Throwable{
		SpringApplication.run(SalvoApplication.class, args);
		System.out.println("Salute James");
	}
	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepo,
									  GameRepository gameRepo,
									  GamePlayerRepository gamePlayerRepo,
									  ShipRepository shipRepo,
									  SalvoRepository salvoRepo,
									  ScoreRepository scoreRepo) {
		return (args) -> {


			Date date = new Date();
			Game game1 = new Game(date, false);
			Game game2 = new Game(date, false);
			Game game3 = new Game(date, false);
			Game game4 = new Game(date, false);

			game2.setDate(game2.calculateDate(3600));
			game3.setDate(game3.calculateDate(7200));

			gameRepo.save(game1);
			gameRepo.save(game2);
			gameRepo.save(game3);
			gameRepo.save(game4);

			//create some players
			Player player1 = new Player("Richard Hatch", "pilot");
			Player player2 = new Player("Bruce Lee", "kungfu");
			Player player3 = new Player("Bruce Wayne", "batman");
			Player player4 = new Player("Peter Parker", "spiderman");

			playerRepo.save(player1);
			playerRepo.save(player2);
			playerRepo.save(player3);
			playerRepo.save(player4);

			GamePlayer gamePlayer1 = new GamePlayer(player1, game1, date);
			GamePlayer gamePlayer2 = new GamePlayer(player2, game1, date);
			GamePlayer gamePlayer3 = new GamePlayer(player1, game2, date);
			GamePlayer gamePlayer4 = new GamePlayer(player2, game2, date);
			GamePlayer gamePlayer5 = new GamePlayer(player2, game3, date);
			GamePlayer gamePlayer6 = new GamePlayer(player4, game3, date);
			GamePlayer gamePlayer7 = new GamePlayer(player2, game4, date);
			GamePlayer gamePlayer8 = new GamePlayer(player1, game4, date);


			gamePlayerRepo.save(gamePlayer1);
			gamePlayerRepo.save(gamePlayer2);
			gamePlayerRepo.save(gamePlayer3);
			gamePlayerRepo.save(gamePlayer4);
			gamePlayerRepo.save(gamePlayer5);
			gamePlayerRepo.save(gamePlayer6);
			gamePlayerRepo.save(gamePlayer7);
			gamePlayerRepo.save(gamePlayer8);



			List<String> locations1 = Arrays.asList("H2", "H3", "H4","H5");
			List<String> locations2 = Arrays.asList("E1", "F1", "G1");
			List<String> locations3 = Arrays.asList("B4", "B5");
			List<String> locations4 = Arrays.asList("B5", "C5", "D5");
			List<String> locations5 = Arrays.asList("F1", "F2");
			List<String> locations6 = Arrays.asList("B5", "C5", "D5","E5");
			List<String> locations7 = Arrays.asList("C6", "C7");
			List<String> locations8 = Arrays.asList("A2", "A3", "A4");
			List<String> locations9 = Arrays.asList("G6", "H6");
			List<String> locations10 = Arrays.asList("B5", "C5", "D5","E5");
			List<String> locations11 = Arrays.asList("C6", "C7");
			List<String> locations12 = Arrays.asList("A2", "A3", "A4");
			List<String> locations13 = Arrays.asList("G6", "H6");
			List<String> locations14 = Arrays.asList("B5", "C5", "D5");
			List<String> locations15 = Arrays.asList("C6", "C7");
			List<String> locations16 = Arrays.asList("A2", "A3", "A4");
//			List<String> locations17 = Arrays.asList("G6", "H6");
//			List<String> locations18 = Arrays.asList("B5", "C5", "D5");
//			List<String> locations19 = Arrays.asList("C6", "C7");
//			List<String> locations20 = Arrays.asList("A2", "A3", "A4");
//			List<String> locations21 = Arrays.asList("G6", "H6");
//			List<String> locations22 = Arrays.asList("B5", "C5", "D5");
//			List<String> locations23 = Arrays.asList("C6", "C7");
//			List<String> locations24 = Arrays.asList("B5", "C5", "D5");
//			List<String> locations25 = Arrays.asList("C6", "C7");
//			List<String> locations26 = Arrays.asList("A2", "A3", "A4");
//			List<String> locations27 = Arrays.asList("G6", "H6");


			Ship ship1 = new Ship("galactica", locations1, gamePlayer1);
			Ship ship2 = new Ship("pegasus", locations2, gamePlayer1);
			Ship ship3 = new Ship("viper", locations3, gamePlayer1);
			Ship ship4 = new Ship("pegasus", locations4, gamePlayer2);
			Ship ship5 = new Ship("raptor", locations5, gamePlayer2);
			Ship ship6 = new Ship("baseStar", locations6, gamePlayer3);
			Ship ship7 = new Ship("viper", locations7, gamePlayer3);
			Ship ship8 = new Ship("pegasus", locations8, gamePlayer4);
			Ship ship9 = new Ship("raptor", locations9, gamePlayer4);
			Ship ship10 = new Ship("galactica", locations10, gamePlayer5);
			Ship ship11 = new Ship("viper", locations11, gamePlayer5);
			Ship ship12 = new Ship("pegasus", locations12, gamePlayer6);
			Ship ship13 = new Ship("raptor", locations13, gamePlayer6);
			Ship ship14 = new Ship("pegasus", locations14, gamePlayer7);
			Ship ship15 = new Ship("viper", locations15, gamePlayer7);
			Ship ship16 = new Ship("pegasus", locations16, gamePlayer8);


			shipRepo.save(ship1);
			shipRepo.save(ship2);
			shipRepo.save(ship3);
			shipRepo.save(ship4);
			shipRepo.save(ship5);
			shipRepo.save(ship6);
			shipRepo.save(ship7);
			shipRepo.save(ship8);
			shipRepo.save(ship9);
			shipRepo.save(ship10);
			shipRepo.save(ship11);
			shipRepo.save(ship12);
			shipRepo.save(ship13);
			shipRepo.save(ship14);
			shipRepo.save(ship15);
			shipRepo.save(ship16);

			List<String> salvoLocations1 = Arrays.asList("B5", "C5", "");
			List<String> salvoLocations2 = Arrays.asList("B4", "B5", "B6");
			List<String> salvoLocations3 = Arrays.asList("", "D5", "");
			List<String> salvoLocations4 = Arrays.asList("E1", "H3", "A2");
			List<String> salvoLocations5 = Arrays.asList("A2", "A4", "G6");
			List<String> salvoLocations6 = Arrays.asList("B5", "D5", "C7");
			List<String> salvoLocations7 = Arrays.asList("A3", "H6", "");
			List<String> salvoLocations8 = Arrays.asList("C5", "C6", "");
			List<String> salvoLocations9 = Arrays.asList("G6", "H6", "A4");
			List<String> salvoLocations10 = Arrays.asList("H1", "H2", "H3");
			List<String> salvoLocations11 = Arrays.asList("A2", "A3", "D8");
			List<String> salvoLocations12 = Arrays.asList("E1", "F2", "G3");
			List<String> salvoLocations13 = Arrays.asList("A3", "A4", "F7");
			List<String> salvoLocations14 = Arrays.asList("B5", "C6", "H1");
			List<String> salvoLocations15 = Arrays.asList("A2", "G6", "H6");
			List<String> salvoLocations16 = Arrays.asList("C5", "C7", "D5");


			Salvo salvo1 = new Salvo(1, salvoLocations1, gamePlayer1);
			Salvo salvo2 = new Salvo(1, salvoLocations2, gamePlayer2);
			Salvo salvo3 = new Salvo(2, salvoLocations3, gamePlayer1);
			Salvo salvo4 = new Salvo(2, salvoLocations4, gamePlayer2);
			Salvo salvo5 = new Salvo(1, salvoLocations5, gamePlayer3);
			Salvo salvo6 = new Salvo(1, salvoLocations6, gamePlayer4);
			Salvo salvo7 = new Salvo(2, salvoLocations7, gamePlayer3);
			Salvo salvo8 = new Salvo(2, salvoLocations8, gamePlayer4);
			Salvo salvo9 = new Salvo(1, salvoLocations9, gamePlayer5);
			Salvo salvo10 = new Salvo(1, salvoLocations10, gamePlayer6);
			Salvo salvo11 = new Salvo(2, salvoLocations11, gamePlayer5);
			Salvo salvo12 = new Salvo(2, salvoLocations12, gamePlayer6);
			Salvo salvo13 = new Salvo(1, salvoLocations13, gamePlayer7);
			Salvo salvo14 = new Salvo(1, salvoLocations14, gamePlayer8);
			Salvo salvo15 = new Salvo(2, salvoLocations15, gamePlayer7);
			Salvo salvo16 = new Salvo(2, salvoLocations16, gamePlayer8);


			salvoRepo.save(salvo1);
			salvoRepo.save(salvo2);
			salvoRepo.save(salvo3);
			salvoRepo.save(salvo4);
			salvoRepo.save(salvo5);
			salvoRepo.save(salvo6);
			salvoRepo.save(salvo7);
			salvoRepo.save(salvo8);
			salvoRepo.save(salvo9);
			salvoRepo.save(salvo10);
			salvoRepo.save(salvo11);
			salvoRepo.save(salvo12);
			salvoRepo.save(salvo13);
			salvoRepo.save(salvo14);
			salvoRepo.save(salvo15);
			salvoRepo.save(salvo16);

			Score score1 = new Score(game1, player1, 1.0);
			Score score2 = new Score(game1, player2, 0.0);
			Score score3 = new Score(game2, player1, 0.5);
			Score score4 = new Score(game2, player2, 0.5);
			Score score5 = new Score(game3, player2, 1.0);
			Score score6 = new Score(game3, player4, 0.0);
			Score score7 = new Score(game4, player2, 0.5);
			Score score8 = new Score(game4, player1, 0.5);

			scoreRepo.save(score1);
			scoreRepo.save(score2);
			scoreRepo.save(score3);
			scoreRepo.save(score4);
			scoreRepo.save(score5);
			scoreRepo.save(score6);
			scoreRepo.save(score7);
			scoreRepo.save(score8);



		};
	}
}
@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	PlayerRepository playerRepo;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inputName-> {
			Player player = playerRepo.findByUserName(inputName);
			if (player != null) {
				return new User(player.getUserName(), player.getPassWord(),
						AuthorityUtils.createAuthorityList("USER"));
			} else {
				throw new UsernameNotFoundException("Unknown user: " + inputName);
			}
		});
	}
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/web/game.html").hasAuthority("USER")
				.and()
				.formLogin()
				.usernameParameter("name")
				.passwordParameter("pwd")
				.loginPage("/api/login");

		http.logout().logoutUrl("/api/logout");

		// turn off checking for CSRF tokens
		http.csrf().disable();

		// if user is not authenticated, just send an authentication failure response
		http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

		// if login is successful, just clear the flags asking for authentication
		http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

		// if login fails, just send an authentication failure response
		http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

		// if logout is successful, just send a success response
		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
	}

	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

		}

	}

}



































