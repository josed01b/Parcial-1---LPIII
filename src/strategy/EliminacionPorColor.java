package src.strategy;
import src.factoryMethod.Carrito;
import src.factoryMethod.Juguete;
import src.factoryMethod.Peluche;
import src.singleton.Menu;
import java.util.*;
import java.util.stream.IntStream;
public class EliminacionPorColor implements Accion{
    private static final Scanner teclado = new Scanner(System.in);
    public void aplicar(){
        int bandera = 1;
        int idcolor = 0;

        List<Juguete> juguetes = new ArrayList<>(Menu.getInstance().juguetes);
        Set<String> colors = new HashSet<>();
        Map<Integer, String> color = new HashMap<>();

        Menu.getInstance().juguetes
                .forEach(juguete -> {
                    colors.add(juguete.getColor());
                });

        colors.forEach(coloor -> color.put(color.size(), coloor));
        System.out.println("|| Lista Colores || ");
        color.forEach((id, Color) -> System.out.println(" ID-> " + id + " || " + " COLOR-> " + Color));

        do {
            try {
                System.out.println("Digite el id del color que desea eliminar");
                idcolor = teclado.nextInt();
                bandera = 0;

            } catch (InputMismatchException ex) {
                System.out.println("ERROR! Solo se permite ingresar numeros");
                teclado.nextLine();
            }
        } while (bandera == 1);

        String Scolor = color.get(idcolor);

        if (Menu.getInstance().juguetes.isEmpty()){
            System.out.println("No existen juguetes");

        } else {
            for(Juguete toy : juguetes){
                if (Scolor.equals(toy.getColor())){
                    Menu.getInstance().juguetes.remove(toy);
                    System.out.println("¡Juguete eliminado!");
                }
            }

            int i = 0;
            for (Juguete juguete : Menu.getInstance().juguetes) {
                juguete.setId(i++);
            }
//            IntStream.range(0, juguetes.size())
//                    .forEach(i -> {
//                        Juguete juguete = juguetes.get(i);
//                        if (juguete instanceof Carrito) {
//                            ((Carrito) juguete).setId(i);
//                        } else if (juguete instanceof Peluche) {
//                            ((Peluche) juguete).setId(i);
//                        }
//                    });
//
//            Menu.getInstance().juguetes.addAll(new LinkedHashSet<>());
        }
        }
   public int getOpcion(){
        return 8;
   }
}
