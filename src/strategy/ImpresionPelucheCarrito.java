package src.strategy;

import src.factoryMethod.Carrito;
import src.factoryMethod.Juguete;
import src.factoryMethod.Peluche;
import src.singleton.Menu;

import java.util.*;

public class ImpresionPelucheCarrito {

    Scanner teclado = new Scanner(System.in);
    private int opcion;

    public void Aplicar(){
        try {
            System.out.println("¿Qué juguete desea imprimir?\n" + "1-Carrito\n" + "2-Peluche\n");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                Menu.getInstance().juguetes.stream()
                        .filter(juguete -> juguete instanceof Carrito)
                        .sorted(Comparator.comparing(juguete -> juguete.getId(),Comparator.reverseOrder()))
                        .forEach(System.out::println);

            } else if (opcion == 2) {
               Menu.getInstance().juguetes.stream()
                        .filter(juguete -> juguete instanceof Peluche)
                        .sorted(Comparator.comparing(juguete -> juguete.getId(), Comparator.reverseOrder()))
                        .forEach(System.out::println);
            }

        } catch (InputMismatchException ex) {
            System.out.println("ERROR !! Solo se permite digitar numeros");
            teclado.nextLine();
        }
    }
}
