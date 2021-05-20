public class telefonoMovil {
    private final String marca;
    private final String modelo;
    private final String color;
    private int almacenamiento;
    private final int ram;
    private int precioEuros;

    public telefonoMovil(String marca, String modelo, String color, int almacenamiento, int ram, String imei, int precioEuros) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.precioEuros = precioEuros;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public int getRam() {
        return ram;
    }

    public int getPrecioEuros() {
        return precioEuros;
    }

    public void setPrecioEuros(int precioEuros) {
        this.precioEuros = precioEuros;
    }

    public String infoMovil(){
        return marca+" "+modelo+" con "+almacenamiento+"GB de almacenamiento y "+ram+"GB de memoria RAM y cuesta "+precioEuros+"€";
    }
}
