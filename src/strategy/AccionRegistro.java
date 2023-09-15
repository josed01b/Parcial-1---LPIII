package src.strategy;

import src.singleton.Menu;
import src.factoryMethod.Juguete;

public class AccionRegistro implements Accion{

    @Override
    public void aplicar() {
        if(getOpcion() == 4 && Menu.getInstance().juguetes.isEmpty()){
            System.out.println("No hay juguetes por mostrar");
        } else {
            System.out.println(" ||Lista juguetes existententes|| ");
            for (Juguete toy : Menu.getInstance().juguetes){
                System.out.println( toy.toString());
            }
        }

    }

    @Override
    public int getOpcion() {
        return 4;
    }
}
