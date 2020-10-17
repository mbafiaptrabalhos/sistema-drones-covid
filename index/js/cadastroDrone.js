document.getElementById("sliderTemperatura").oninput = function () {
  document.getElementById("valueTemperatura").innerHTML = this.value;
}

document.getElementById("sliderUmidade").oninput = function () {
  document.getElementById("valueUmidade").innerHTML = this.value;
}

enviaDadosDrone = function () {

  var idDrone = document.getElementById("idDrone").value;
  var latitude = document.getElementById("latitude").value;
  var longitude = document.getElementById("longitude").value;
  var temperatura = document.getElementById("sliderTemperatura").value;
  var umidade = document.getElementById("sliderUmidade").value;
  var email = document.getElementById("email").value;
  var habilitaLocalizacao = document.getElementById("habilitaLocalizacao").checked;

  var http = new XMLHttpRequest();

  //URL DO MICROSERVICE PRODUTOR
  var url = 'http://localhost:8080/api/producer/create';

  http.open('POST', url, true);
  http.setRequestHeader('Content-type', 'application/json');

  var drone = {
    "id": idDrone,
    "latitude": latitude,
    "longitude": longitude,
    "temperatura": temperatura,
    "umidade": umidade,
    "email": email,
    "habilitaLocalizacao": habilitaLocalizacao
  }

  var params = JSON.stringify(drone);

  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
      console.log(http.responseText);
    }
  }
  http.send(params);


  setTimeout(function () {
    enviaDadosDrone()
  }, 10000);

}