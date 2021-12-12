package com.digitalinnovationone.heroesapi2;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import com.digitalinnovationone.heroesapi2.repository.HeroesRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovationone.heroesapi2.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class Heroesapi2ApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;

	@Test
	public void getOneHeroById() {
		// Verifica se retorna status 200-ok ao insira um ID de um registro existente no banco
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "2")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getAllHeroes() {
		// Verifica se retorna status 200-ok ao requisitar todos os registros no banco
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL)
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneHeronotFound() {
		// Verificar se retorna status 404-NOTFOUND ao requisitar um ID inexistente no banco
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "19")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteHero() {
		// Verifica se retorna status 404-NOTFOUND ao deletar um ID existente,
		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "5")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}

}

