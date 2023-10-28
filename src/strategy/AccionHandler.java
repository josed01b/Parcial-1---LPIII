package src.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AccionHandler {

    private static final List<Accion> opciones =
            List.of(new AccionCrear(),
                    new AccionClonar(),
                    new AccionEliminar(),
                    new AccionRegistro(),
                    new CarritoMayorNumeroPuerta(),
                    new ImpresionPelucheCarrito(),
                    new AccionConversion(),
                    new EliminacionPorColor());
    public static Map<Integer, Accion> getStrategy(){
        Map<Integer, Accion> strategy = new HashMap<>();
        for (Accion accion : opciones){
            strategy.put(accion.getOpcion(), accion);
        }
        return strategy;
    }
}
