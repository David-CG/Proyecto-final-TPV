package Programa;

import Moviles.Movil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Tiquet implements Serializable {
    private final Map<Movil, Integer> listaMovilesCarrito;
    private int costeCompra;
    private final LocalDateTime fechaHoraTiquet;
    
    public Tiquet(){
        this.listaMovilesCarrito = new LinkedHashMap<>();
        this.fechaHoraTiquet = LocalDateTime.now();
    }
    
    public Map<Movil, Integer> getCarritoMoviles() {
        List<Movil> salida = new ArrayList<>();
        salida.addAll(listaMovilesCarrito.keySet());
        return listaMovilesCarrito;
    }
    
    public String getCosteCompra() {
        return costeCompra + "€";
    }
    
    public String getFechaHoraTiquet() {
        String dia = fechaHoraTiquet.getDayOfMonth() + " - " + fechaHoraTiquet.getMonthValue() + " - " + fechaHoraTiquet.getYear();
        String hora = fechaHoraTiquet.getHour() + ":" + fechaHoraTiquet.getMinute();
        return "El dia " + dia + " a las " + hora + " se ha creado su recibo.";
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
        } else {
            listaMovilesCarrito.put(movil, cantidadCarro - 1);
        }
    }
    
    public String costeTotalCompra() {
        int costeTotal = 0;
        for (Map.Entry<Movil, Integer> t : listaMovilesCarrito.entrySet()) {
            costeTotal += t.getKey().getPrecioEuros()*t.getValue();
        }
        return costeTotal + "€";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiquet tiquet = (Tiquet) o;
        return costeCompra == tiquet.costeCompra &&
                Objects.equals(listaMovilesCarrito, tiquet.listaMovilesCarrito) &&
                Objects.equals(fechaHoraTiquet, tiquet.fechaHoraTiquet);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(listaMovilesCarrito, costeCompra, fechaHoraTiquet);
    }
}
