package src.strategy;
import src.factoryMethod.Carrito;
import src.factoryMethod.Juguete;
import src.factoryMethod.Peluche;
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
            System.out.println(" ||Lista de juguetes|| ");
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
        System.out.println("Se ha clonado correctamente el juguete");


        //        int i = 1;
//        for (Juguete juguete : Menu.getInstance().juguetes){
//            juguete.setId(i++);
        //       }
        for (int i = 0; i < Menu.getInstance().juguetes.size(); i++){
            if (juguetes.get(i) instanceof Carrito) {
                Carrito coche = (Carrito) juguetes.get(i);
                coche.setId(i);
            } else {
                Peluche muñeco = (Peluche) juguetes.get(i);
                muñeco.setId(i);

            }
        }
        Menu.getInstance().juguetes.addAll(new LinkedHashSet<>(juguetes));
    }
    @Override
    public int getOpcion() {
        return 2;
    }
}
