package br.com.fiap.kafkaproducer.business;

import br.com.fiap.kafkaproducer.model.DroneInfo;

public class ValidaDadosDrone {

    private static String[] tiposLimpeza = {
            "Nebulização de Ambientes",
            "Descontaminação de Superfícies de Contato",
            "Descontaminação de Veículos"
    };

    public static DroneInfo validate(DroneInfo drone) {
        DroneInfo droneInfo = drone;
        switch (drone.getTipoLimpeza()) {
            case "1":
                droneInfo.setTipoLimpeza(tiposLimpeza[0]);
                break;

            case "2":
                droneInfo.setTipoLimpeza(tiposLimpeza[1]);
                break;

            case "3":
                droneInfo.setTipoLimpeza(tiposLimpeza[2]);
                break;
        }
        return droneInfo;
    }
}
