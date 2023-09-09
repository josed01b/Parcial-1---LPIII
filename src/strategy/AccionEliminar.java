package src.strategy;

public class AccionEliminar implements Accion{


    @Override
    public void aplicar() {System.out.println("Eliminando....");
    }

    @Override
    public int getOpcion() {
        return 3;
    }
}
