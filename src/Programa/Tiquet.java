package Programa;

import Moviles.Movil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;

// TODO impresión del ticket

public class Tiquet implements Serializable {
    private final Map<Movil, Integer> listaMovilesCarrito;
    private int costeCompra;
    
    public Tiquet(){
        this.listaMovilesCarrito = new LinkedHashMap<>();
    }
    
    public Map<Movil, Integer> getCarritoMoviles() {
        List<Movil> salida = new ArrayList<>();
        salida.addAll(listaMovilesCarrito.keySet());
        return listaMovilesCarrito;
    }
    
    public void anyadeATiquet(Movil movil) {
        Integer productoYaAnyadido = listaMovilesCarrito.putIfAbsent(movil, 1);
        if (productoYaAnyadido != null) {
            int cantPrevia = listaMovilesCarrito.get(movil);
            listaMovilesCarrito.put(movil, cantPrevia + 1);
        }
        actualizaCosteCompra(movil);
    }
    
    private void actualizaCosteCompra(Movil movil) {
         costeCompra += movil.getPrecioEuros();
    }
    
    public void quitaDelCarrito(Movil movil) {
        int cantidadCarro = listaMovilesCarrito.get(movil);
        costeCompra = costeCompra - movil.getPrecioEuros() * cantidadCarro;
        if (cantidadCarro - 1 == 0) {
            listaMovilesCarrito.remove(movil);
            Log.log(Level.INFO, movil.getMarca() + " " + movil.getModelo() + " eliminado del carrito.");
        } else {
            listaMovilesCarrito.put(movil, cantidadCarro - 1);
        }
    }
    
    public String costeTotalCompra() {
        int costeTotal = 0;
        for (Map.Entry<Movil, Integer> entry : listaMovilesCarrito.entrySet()) {
            costeTotal += entry.getKey().getPrecioEuros()*entry.getValue();
        }
        return costeTotal + "€";
    }
}
