var teste_drone = [{
    id: "1",
    latitude: "-23.594928",
    longitude: "-46.687030",
    temperatura: "27",
    umidade: "55",
    email: "agronegocio@controlador.com"
},
{
    id: "2",
    latitude: "-23.592490",
    longitude: "-46.681022",
    temperatura: "26",
    umidade: "57",
    email: "WHOOOOPS@controlador.com"
}]

var mymap = L.map('mapid').setView([teste_drone[0].latitude, teste_drone[0].longitude], 14);



L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
}).addTo(mymap);


mapMarkers = [];


obtemDadosDrone = function () {
    var http = new XMLHttpRequest();

    //URL DO MICROSERVICE CONSUMIDOR B
    var url = 'http://localhost:8081/api/drones';

    http.open('GET', url, true);

    http.onreadystatechange = function () {
        if (http.readyState == 4 && http.status == 200) {
            drones = JSON.parse(http.responseText);

            dronesMostrar = drones;
            dronesApagar = drones;

            mapMarkers.forEach(element => {
                mymap.removeLayer(element);
            });
            
            dronesMostrar = dronesMostrar.filter(d => d.habilitaLocalizacao === true);


            for (var i = 0; i < dronesMostrar.length; i++) {
                var id = dronesMostrar[i].id;
                var latitude = dronesMostrar[i].latitude;
                var longitude = dronesMostrar[i].longitude;
                var temperatura = dronesMostrar[i].temperatura;
                var umidade = dronesMostrar[i].umidade;
                var email = dronesMostrar[i].email;

                // Adiciona marcador
                var marker = L.marker([latitude, longitude]).addTo(mymap);
                mapMarkers.push(marker);

                // Adiciona Popup
                marker.bindPopup(`
                Id: ${id} </br>
                Latitude: ${latitude}
                Longitude: ${longitude}
                Temperatura: ${temperatura}
                Umidade: ${umidade} </br>
                Email: ${email}
                        `).openPopup();

            }
        }
    }
    http.send();

    setTimeout(function () {
        obtemDadosDrone()
    }, 8000);

}

obtemDadosDrone();







