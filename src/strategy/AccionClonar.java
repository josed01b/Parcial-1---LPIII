package src.strategy;

public class AccionClonar  implements Accion{


    public void aplicar(){
        System.out.println("Clonando....");
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}
