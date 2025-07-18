package ConversionDatos;

public enum Pais {
    PERU("Perú", "PEN"),
    USA("Estados Unidos", "USD"),
    ARGENTINA("Argentina", "ARS"),
    BRASIL("Brasil", "BRL"),
    COLOMBIA("Colombia", "COP"),
    CHILE("Chile", "CLP");

    private final String nombre;
    private final String monedaCodigo;

    Pais(String nombre, String monedaCodigo) {
        this.nombre = nombre;
        this.monedaCodigo = monedaCodigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getMonedaCodigo() {
        return  this.monedaCodigo;
    }
}
