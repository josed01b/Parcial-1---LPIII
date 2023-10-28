package src.strategy;

import src.singleton.Menu;
import src.factoryMethod.Juguete;

public class AccionRegistro implements Accion{
    @Override
    public void aplicar() {
        if(Menu.getInstance().juguetes.isEmpty()){
            System.out.println("No hay juguetes por mostrar");
        } else {
            System.out.println(" ||Lista juguetes existententes|| ");
            for (Juguete juguete : Menu.getInstance().juguetes) {
                System.out.print(juguete.toString());
                System.out.println();
            }
        }
    }
    @Override
    public int getOpcion() {
        return 4;
    }
}
