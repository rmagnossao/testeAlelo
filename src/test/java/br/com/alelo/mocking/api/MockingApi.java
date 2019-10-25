package br.com.alelo.mocking.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.alelo.api.main.entity.PersonResponse;
import br.com.alelo.api.main.service.ApiService;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class MockingApi {

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	private ApiService apiService = new ApiService();

	@SuppressWarnings("deprecation")
	@Test
	public void returnExternalApi() {
		PersonResponse personResponse = new PersonResponse(5, "teste");
		Mockito.when(restTemplate.getForEntity("http://localhost:8080/api/retornaPerson/5", PersonResponse.class))
				.thenReturn(new ResponseEntity<PersonResponse>(personResponse, HttpStatus.OK));

		PersonResponse personResp = apiService.getPerson(5);
		Assert.assertEquals(personResponse, personResp);
	}

}
