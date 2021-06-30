package Moviles;

import java.io.Serializable;

public enum Marcas implements Serializable {
    
    XIAOMI("Xiaomi"),
    REDMI("Redmi"),
    POCO("POCO"),
    TODOS("Todos");
    
    private String marca;
    
    Marcas(String marcas) {
        this.marca = marcas;
    }
    
    public String getMarca(){
        return marca;
    }
    
}
