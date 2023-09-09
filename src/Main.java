package src;

import src.factoryMethod.Juguete;
import src.strategy.Accion;
import src.strategy.AccionHandler;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class Main {
    private static Scanner tcl = new Scanner(System.in);
    private static List<Juguete> juguetes = new ArrayList<>();
    private AccionHandler accionHandler = new AccionHandler();
    private static final int opc_sal = 5;

    public static void main(String[] args) {

            int option = 0;
            Map<Integer, Accion> strategy = AccionHandler.getStrategy();

                do {
                    option = tcl.nextInt();
                    tcl.nextLine();
                    Accion accion = strategy.get(option);
                    if (option == opc_sal) {
                        continue;
                    }
                    if (accion == null) {
                        System.out.printf("Esta opcion no existe\n");
                    } else {
                        accion.aplicar();
                    }
                } while (option != opc_sal);
                System.out.printf("Salida existosa");

                }
    }
