package br.com.fiap.kafkaproducer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DroneInfo", description = "Descreve um modelo da mensagem enviada pelos Drones")
public class DroneInfo {

    @ApiModelProperty(value = "identificador do Drone", dataType = "Integer")
    private Long id;
    @ApiModelProperty(value = "A  latitude é a distância ao Equador medida ao longo do meridiano de Greenwich.", dataType = "String")
    private String latitude;
    @ApiModelProperty(value = "A longitude é a distância ao meridiano de Greenwich medida ao longo do Equador.", dataType = "String")
    private String longitude;
    @ApiModelProperty(value = "temperatura medida da região onde o drone está sobrevoando", dataType = "String")
    private String temperatura;
    @ApiModelProperty(value = "umidade do ar da região onde o drone está sobrevoando", dataType = "String")
    private String umidade;
    @ApiModelProperty(value = "E-mail para contato", dataType = "String")
    private String email;
    @ApiModelProperty(value = "Valor TRUE habilita rastrear no mapa a localização FALSE desabilita", dataType = "String")
    private Boolean habilitaLocalizacao;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getHabilitaLocalizacao() {
        return habilitaLocalizacao;
    }

    public void setHabilitaLocalizacao(Boolean habilitaLocalizacao) {
        this.habilitaLocalizacao = habilitaLocalizacao;
    }
}
