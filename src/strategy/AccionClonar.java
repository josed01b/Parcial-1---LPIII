package src.strategy;
import src.factoryMethod.Carrito;
import src.factoryMethod.Juguete;
import src.singleton.Menu;

import java.util.*;
public class AccionClonar  implements Accion{
    private static Scanner tcl = new Scanner(System.in);
    private int idc;
    private int vc;


    public void aplicar(){

        if (getOpcion() == 2 && Menu.getInstance().juguetes.isEmpty() ){
            System.out.println("ATENCION !! no existen juguetes para clonar");
        } else {
            System.out.println(" ||Lista de juguetes|| ");
            for (int i = 0; i < Menu.getInstance().juguetes.size(); i++){
                System.out.println(Menu.getInstance().juguetes.get(i).toString());
            }

            System.out.println("Ingresa el Id del juguete que deseas clonar");
            idc = tcl.nextInt();

            System.out.println("Ingrese las veces que desea clonar el juguete");
            vc = tcl.nextInt();

            if ( idc < 0 || idc > Menu.getInstance().juguetes.size() ){
                System.out.println("Este juguete no existen para clonar");

            }

            Juguete toy = Menu.getInstance().juguetes.get(idc);
            for (int i = 0; i < vc; i++ ){
                Menu.getInstance().juguetes.add(toy.clone(Menu.getInstance().juguetes.size()));
            }
        }
        System.out.println("Se ha clonado correctamente el juguete");
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}
