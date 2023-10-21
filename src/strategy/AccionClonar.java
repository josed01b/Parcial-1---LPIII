package src.strategy;
import src.factoryMethod.Juguete;
import src.singleton.Menu;

import java.util.*;
public class AccionClonar  implements Accion{
    private static Scanner teclado = new Scanner(System.in);
    private int idclonar;
    private int nroveces;


    public void aplicar(){


        if ( Menu.getInstance().juguetes.isEmpty() ){
            System.out.println("ATENCION !! no existen juguetes para clonar");
        } else {
            System.out.println(" ||Lista de juguetes|| ");
            for (int i = 0; i < Menu.getInstance().juguetes.size(); i++){
                System.out.println(Menu.getInstance().juguetes.get(i).toString());
            }

            System.out.println("Ingresa el Id del juguete que deseas clonar");
            idclonar = teclado.nextInt();

            System.out.println("Ingrese las veces que desea clonar el juguete");
            nroveces = teclado.nextInt();

            if ( idclonar < 0 || idclonar > Menu.getInstance().juguetes.size() ){
                System.out.println("Este juguete no existen para clonar");

            }

            Juguete toy = Menu.getInstance().juguetes.get(idclonar);
            for (int i = 0; i < nroveces; i++ ){
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
