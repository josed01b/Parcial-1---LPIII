package src.strategy;

import src.factoryMethod.Carrito;
import src.factoryMethod.Juguete;
import src.singleton.Menu;

import java.util.*;

public class CarritoMayorNumeroPuerta implements Accion{

    public void aplicar(){

        if(Menu.getInstance().juguetes.isEmpty()){
            System.out.println("No hay jueguetes");
        } else {
             Menu.getInstance().juguetes.stream()
                    .filter( juguete -> juguete instanceof Carrito)
                    .max(Comparator.comparing(juguete -> ((Carrito) juguete).getNroPuertas()))
                     .ifPresentOrElse(juguete ->  System.out.println("El carrito con mas puertas es: " + juguete),
                             () -> System.out.println("No hay carrito con mas puertas"));
        }
    }

    public int getOpcion(){return 6;}
}
