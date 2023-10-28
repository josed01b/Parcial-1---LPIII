package src.factoryMethod;
import src.singleton.Menu;

import java.util.*;

public class CreadorCarrito implements CreadorJuguete {
    private static Scanner teclado = new Scanner(System.in);
    private int id, nroPuerta;
    private String color, marca;

    @Override
    public Juguete crear() {
        id = Menu.getInstance().juguetes.size();

        System.out.println("Ingrese el color del carro");
        color = teclado.nextLine();

        System.out.println("Ingrese la marca del carro");
        marca = teclado.nextLine();

        System.out.println("Ingrese el numero de las puertas del carro");
        nroPuerta = teclado.nextInt();

        Carrito car = Carrito.builder()
                .id(id)
                .color(color)
                .marca(marca)
                .nroPuertas(nroPuerta)
                .build();

        Menu.getInstance().juguetes.add(car);
        return new Carrito(id, color, marca, nroPuerta);
    }
}
