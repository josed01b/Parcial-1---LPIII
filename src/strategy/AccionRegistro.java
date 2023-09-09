package src.strategy;
public class AccionRegistro implements Accion{

    @Override
    public void aplicar() {
        System.out.println("Registrando...");
    }

    @Override
    public int getOpcion() {
        return 4;
    }
}
