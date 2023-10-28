package src.strategy;

import src.factoryMethod.Carrito;
import src.factoryMethod.Juguete;
import src.factoryMethod.Peluche;
import src.singleton.Menu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EliminacionPorColor implements Accion{
    private static final Scanner teclado = new Scanner(System.in);
    private int bandera = 1;
    private int idcolor;
    private String Eliminado;
    public void aplicar(){
        List<Juguete> juguetes = new ArrayList<>(Menu.getInstance().juguetes);

        Map<Integer, String> color = Menu.getInstance().juguetes.stream()
                .collect(Collectors.toMap(Juguete::getId, Juguete::getColor));

        color.forEach((id, Color) -> System.out.println("id : " + id + "|" + "Color : " + Color));

        do {
            try {
                System.out.println("Digite el id del color que desea eliminar");
                idcolor = teclado.nextInt();
                bandera = 0;

            } catch (InputMismatchException ex) {
                System.out.println("ERROR! Solo se permite ingresar numeros");
                bandera = 1;
            }
        } while (bandera == 1);

        for (int i = 0; i < Menu.getInstance().juguetes.size(); i++){
            if (juguetes.get(i) instanceof Carrito){
                Carrito coche = (Carrito) juguetes.get(i);
                coche.setId(i);
            } else {
                Peluche muñeco = (Peluche) juguetes.get(i);
                muñeco.setId(i);

            }
        }
        Menu.getInstance().juguetes.addAll(new LinkedHashSet<>(juguetes));
        }

   public int getOpcion(){
        return 8;
   }
}
