package br.com.fiap.sistema.drones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DroneInfo {

	@Id
	private String id;
	private String latitude;
	private String longitude;
	private String temperatura;
	private String umidade;
	private String email;
	private Boolean habilitaLocalizacao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Drone (id: " + id + ", latitude: " + latitude + ", longitude: " + longitude + ", temperatura: "
				+ temperatura + ", umidade: " + umidade + ", email: " + email + ")";
	}

	public Boolean getHabilitaLocalizacao() {
		return habilitaLocalizacao;
	}

	public void setHabilitaLocalizacao(Boolean habilitaLocalizacao) {
		this.habilitaLocalizacao = habilitaLocalizacao;
	}
}
