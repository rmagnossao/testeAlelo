package br.com.alelo.api.main.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alelo.api.main.entity.PersonResponse;

@Service
public class ApiService {

	private RestTemplate restTemplate;

	public PersonResponse getPerson(Integer id) {
		ResponseEntity<PersonResponse> resp = restTemplate.getForEntity("http://localhost:8080/api/retornaPerson/" + id,
				PersonResponse.class);
		return resp.getStatusCode() == HttpStatus.OK ? (PersonResponse) resp.getBody() : null;
	}

}
