package src.strategy;
import src.factoryMethod.CreadorCarrito;
import src.factoryMethod.CreadorPeluche;

import java.util.*;

public class AccionCrear implements Accion {
    private final CreadorCarrito creadorcarritos = new CreadorCarrito();
    private final CreadorPeluche creadorpeluches = new CreadorPeluche();
    Scanner teclado = new Scanner(System.in);
    private int opc;

    @Override
    public void aplicar() {

            try {
                System.out.println("Selecciona que juguete deseas crear\n" +
                        "1- Carrito\n" +
                        "2- Peluche\n");
                opc = teclado.nextInt();

                if ( opc <= 0 || opc >= 3){
                    System.out.println("ERROR !! Opcion invalida");
                }
                if (opc == 1){
                    creadorcarritos.crear();
                    System.out.println(" Carrito creado !!");

                }else if (opc == 2){
                    creadorpeluches.crear();
                    System.out.println(" Peluche creado !!");

                }
            } catch (InputMismatchException ex) {

                System.out.println("ERROR !! Solo se permite digitar numeros");
                teclado.nextLine();
            }
    }

    public int getOpcion(){
        return 1;
    }
}
