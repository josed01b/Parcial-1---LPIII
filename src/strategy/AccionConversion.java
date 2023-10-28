package src.strategy;

import src.factoryMethod.Juguete;
import src.singleton.Menu;

import java.sql.SQLOutput;
import java.util.stream.Collectors;

public class AccionConversion implements Accion {
    public void aplicar() {
        if (Menu.getInstance().juguetes.isEmpty()) {
            System.out.println("No hay ningun juegute");
        } else {
            Menu.getInstance().juguetes.stream()
                    .collect(Collectors.toMap(Juguete::getId, juguete -> juguete))
                    .forEach((id, juguete) -> System.out.printf("Key->%s%n ", id + "\nValue-> " + juguete));
        }
    }
    public int getOpcion() {return 7;}
}
