package src.singleton;

import src.factoryMethod.Juguete;
import src.strategy.Accion;
import src.strategy.AccionHandler;

import java.util.*;

public class Menu {
    private static final Scanner teclado = new Scanner(System.in);

    private Menu(){
    }

    private static Menu getInstance;
    public Set<Juguete> juguetes = new LinkedHashSet<>();
    private static final int opc_sal = 9;
    public static Menu getInstance(){
        if (getInstance == null){
            getInstance = new Menu();
        }
        return getInstance;
    }
    public void menu(){
        int option = 0;
        Map<Integer, Accion> strategy = AccionHandler.getStrategy();

        do {
            try {
                System.out.println("---MENU---\n" +
                        "1-Crear\n" +
                        "2-Clonar\n" +
                        "3-Eliminar\n" +
                        "4-Registrar\n" +
                        "5-Impresión Peluches o Carritos\n" +
                        "6-Impresión del carrito con mayor numero de puertas" +
                        "7-" +
                        "8-Eliminación juguetes por color" +
                        opc_sal + "-Salir\n");
                option = teclado.nextInt();
                teclado.nextLine();
                Accion accion = strategy.get(option);
                if (option == opc_sal) {
                    continue;
                }
                if (accion == null) {
                    System.out.println("ERROR !! Esta opcion no existe.\n");
                } else {
                    accion.aplicar();
                }
            } catch (InputMismatchException ex){
                System.out.println(" ERROR !! Solo se permite digitar numeros");
                teclado.nextLine();

            }


        } while (option != opc_sal);
        System.out.println("Salida existosa");
    }

}
