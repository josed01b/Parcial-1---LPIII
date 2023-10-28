package src.strategy;
import src.factoryMethod.Juguete;
import src.singleton.Menu;
import java.util.*;
public class AccionClonar  implements Accion{
    private static Scanner teclado = new Scanner(System.in);
    private int idclonar;
    private int nroveces;
    public void aplicar(){
        int bandera = 1;
        List<Juguete> juguetes = new ArrayList<>(Menu.getInstance().juguetes);

        if ( Menu.getInstance().juguetes.isEmpty() ){
            System.out.println("ATENCION !! no existen juguetes para clonar");
        } else {
            System.out.println(" || Lista de juguetes || ");
            Menu.getInstance().juguetes.forEach(System.out::println);

            do {
                try {
                    System.out.println("Ingresa el Id del juguete que deseas clonar");
                    idclonar = teclado.nextInt();

                    System.out.println("Ingrese las veces que desea clonar el juguete");
                    nroveces = teclado.nextInt();

                    if ( idclonar <= 0 || idclonar > Menu.getInstance().juguetes.size() ){
                        System.out.println("Este juguete no existen para clonar");

                    }
                    bandera = 0;
                } catch (InputMismatchException ex){
                    System.out.println(" ERROR !! Solo se permite digitar numeros");
                    teclado.nextLine();
                }
            } while (bandera == 1);

            Juguete toy = juguetes.get(idclonar - 1);
            for (int i = 0; i < nroveces; i++ ){
                Menu.getInstance().juguetes.add(toy.clone(Menu.getInstance().juguetes.size()));
            }
        }

        for (int i = 0; i < juguetes.size(); i++) {
            Juguete juguete = juguetes.get(i);
            juguete.setId(i);
        }
        System.out.println("Se ha clonado correctamente el juguete ");
    }
    @Override
    public int getOpcion() {
        return 2;
    }
}
