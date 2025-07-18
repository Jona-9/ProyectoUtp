package Operaciones;

import ConversionDatos.Pais;
import ConversionDatos.TransformandoDatos;

public class RealizarOperaciones  {
    public String moneda;
    Double Dolar;
    Double PesoArgentino;
    Double RealBrasilero;
    Double SolPeruano;
    Double PesoColombiano;
    Double PesoChileno;
    String json;

    public RealizarOperaciones(TransformandoDatos transformandoDatos) {
        this.Dolar = Double.valueOf(transformandoDatos.USD());
        this.PesoArgentino = Double.valueOf(transformandoDatos.ARS());
        this.RealBrasilero = Double.valueOf(transformandoDatos.BRL());
        this.SolPeruano = Double.valueOf(transformandoDatos.PEN());
        this.PesoColombiano = Double.valueOf(transformandoDatos.COP());
        this.PesoChileno = Double.valueOf(transformandoDatos.CLP());
    }

    public double hacerConversion(Pais paisElegido, int opcion, double cantidad) {
        Double transformar = 0.0;

        switch (paisElegido) {
            case PERU -> {
                switch (opcion) {
                    case 1 -> transformar = cantidad * (SolPeruano / Dolar);
                    case 2 -> transformar = cantidad * (Dolar / SolPeruano);
                    case 3 -> transformar = cantidad * (SolPeruano / PesoArgentino);
                    case 4 -> transformar = cantidad * (PesoArgentino / SolPeruano);
                    case 5 -> transformar = cantidad * (SolPeruano / RealBrasilero);
                    case 6 -> transformar = cantidad * (RealBrasilero / SolPeruano);
                    case 7 -> transformar = cantidad * (SolPeruano / PesoChileno);
                    case 8 -> transformar = cantidad * (PesoChileno / SolPeruano);
                    default -> transformar = -1.0;
                }
            }
            case ARGENTINA -> {
                switch (opcion) {
                    case 1 -> transformar = cantidad * (PesoArgentino / Dolar);
                    case 2 -> transformar = cantidad * (Dolar / PesoArgentino);
                    case 3 -> transformar = cantidad * (PesoArgentino / SolPeruano);
                    case 4 -> transformar = cantidad * (SolPeruano / PesoArgentino);
                    case 5 -> transformar = cantidad * (PesoArgentino / RealBrasilero);
                    case 6 -> transformar = cantidad * (RealBrasilero / PesoArgentino);
                    case 7 -> transformar = cantidad * (PesoArgentino / PesoChileno);
                    case 8 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    default -> transformar = -1.0;
                }
            }
            case BRASIL -> {
                switch (opcion) {
                    case 1 -> transformar = cantidad * (SolPeruano / Dolar);
                    case 2 -> transformar = cantidad * (Dolar / SolPeruano);
                    case 3 -> transformar = cantidad * (SolPeruano / PesoArgentino);
                    case 4 -> transformar = cantidad * (PesoArgentino / SolPeruano);
                    case 5 -> transformar = cantidad * (SolPeruano / RealBrasilero);
                    case 6 -> transformar = cantidad * (RealBrasilero / SolPeruano);
                    case 7 -> transformar = cantidad * (SolPeruano / PesoChileno);
                    case 8 -> transformar = cantidad * (PesoChileno / SolPeruano);
                    default -> transformar = -1.0;
                }
            }
            case COLOMBIA -> {
                switch (opcion) {
                    case 1 -> transformar = cantidad * (SolPeruano / Dolar);
                    case 2 -> transformar = cantidad * (Dolar / SolPeruano);
                    case 3 -> transformar = cantidad * (SolPeruano / PesoArgentino);
                    case 4 -> transformar = cantidad * (PesoArgentino / SolPeruano);
                    case 5 -> transformar = cantidad * (SolPeruano / RealBrasilero);
                    case 6 -> transformar = cantidad * (RealBrasilero / SolPeruano);
                    case 7 -> transformar = cantidad * (SolPeruano / PesoChileno);
                    case 8 -> transformar = cantidad * (PesoChileno / SolPeruano);
                    default -> transformar = -1.0;
                }
            }
            case CHILE -> {
                switch (opcion) {
                    case 1 -> transformar = cantidad * (SolPeruano / Dolar);
                    case 2 -> transformar = cantidad * (Dolar / SolPeruano);
                    case 3 -> transformar = cantidad * (SolPeruano / PesoArgentino);
                    case 4 -> transformar = cantidad * (PesoArgentino / SolPeruano);
                    case 5 -> transformar = cantidad * (SolPeruano / RealBrasilero);
                    case 6 -> transformar = cantidad * (RealBrasilero / SolPeruano);
                    case 7 -> transformar = cantidad * (SolPeruano / PesoChileno);
                    case 8 -> transformar = cantidad * (PesoChileno / SolPeruano);
                    default -> transformar = -1.0;
                }
            }
            default -> System.out.println("Pais no disponible");
        }
        return transformar;
    }
}