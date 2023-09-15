package src.singleton;

import src.factoryMethod.Juguete;
import src.strategy.Accion;
import src.strategy.AccionHandler;

import java.util.*;

public class Menu {
    private static final Scanner tcl = new Scanner(System.in);

    private Menu(){
    }

    private static Menu getInstance;
    public List<Juguete> juguetes = new ArrayList<>();
    private final AccionHandler accionHandler = new AccionHandler();
    private static final int opc_sal = 5;

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
                        opc_sal + "-Salir\n");
                option = tcl.nextInt();
                tcl.nextLine();
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
                tcl.nextLine();

            }


        } while (option != opc_sal);
        System.out.println("Salida existosa");
    }

}
