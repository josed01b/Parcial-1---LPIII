package src.strategy;
import src.factoryMethod.Juguete;
import src.singleton.Menu;

import java.util.*;
public class AccionEliminar implements Accion{
    Scanner teclado = new Scanner(System.in);
    private int ideliminar;
    @Override
    public void aplicar() {
        List<Juguete> juguetes = new ArrayList<>();
            try {
                if( Menu.getInstance().juguetes.isEmpty()){
                    System.out.println("No existe ningun juguete a elminar");
                } else{
                    System.out.println(" ||Lista de juguetes|| ");
                    for (int i = 0; i < Menu.getInstance().juguetes.size(); i++){
                        System.out.println(Menu.getInstance().juguetes.get(i).toString());

                    }

                    System.out.println("Ingrese el Id del juguete que desea eliminar");
                    ideliminar = teclado.nextInt();
                }

            } catch (InputMismatchException ex) {
                System.out.println("ERROR !! Solo se permite digitar numeros");
                teclado.nextLine();
            }

        if (ideliminar >= 0 && ideliminar < Menu.getInstance().juguetes.size()) {
            Menu.getInstance().juguetes.remove(ideliminar);
            System.out.println("Se ha eliminado el juguete");
        }else{
            System.out.println("El juguete1 no existe en la lista");
        }


        for (int i = 0; i < Menu.getInstance().juguetes.size(); i++){
            Menu.getInstance().juguetes.get(i).setId(i);
        }

    }

    @Override
    public int getOpcion() {
        return 3;
    }
}
