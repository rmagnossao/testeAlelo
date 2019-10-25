package br.com.alelo.api.main.entity;

public class PersonResponse {

	private Integer id;
	private String name;

	public PersonResponse() {

	}

	public PersonResponse(Integer id, String name) {
		this.id = id;
		this.name = name;

	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;

	}


}
