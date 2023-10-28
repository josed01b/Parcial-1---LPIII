package src.strategy;
import src.factoryMethod.Carrito;
import src.factoryMethod.Juguete;
import src.factoryMethod.Peluche;
import src.singleton.Menu;

import java.util.*;
public class AccionEliminar implements Accion{
    Scanner teclado = new Scanner(System.in);
    private int ideliminar, bandera = 1;
    @Override
    public void aplicar() {
        List<Juguete> juguetes = new ArrayList<>(Menu.getInstance().juguetes);

        do {
            try {
                if( Menu.getInstance().juguetes.isEmpty()){
                    System.out.println("No existe ningun juguete a elminar");
                } else{
                    System.out.println(" ||Lista de juguetes|| ");
                    Menu.getInstance().juguetes.forEach(System.out::println);

                    System.out.println("Ingrese el Id del juguete que desea eliminar");
                    ideliminar = teclado.nextInt();
                }
                bandera = 0;

            } catch (InputMismatchException ex) {
                System.out.println("ERROR !! Solo se permite digitar numeros");
                bandera = 1;
            }
        } while (bandera == 1);

        if (ideliminar >= 1 && ideliminar < Menu.getInstance().juguetes.size()) {
            Menu.getInstance().juguetes.remove(ideliminar );
            System.out.println("Se ha eliminado el juguete");
        }else{
            System.out.println("El juguete no existe en la lista");
        }


        for (int i = 0; i < Menu.getInstance().juguetes.size(); i++){  //reajustar id
            juguetes.get(i).setId(i);
        }

    }
    @Override
    public int getOpcion() {
        return 3;
    }
}
