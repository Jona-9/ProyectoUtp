package Operaciones;

import ConversionDatos.Pais;
import ConversionDatos.TransformandoDatos;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RealizarOperaciones {
    Scanner scanner = new Scanner(System.in);
    Double Dolar;
    Double PesoArgentino;
    Double RealBrasilero;
    Double SolPeruano;
    Double PesoColombiano;
    Double PesoChileno;

    public RealizarOperaciones(TransformandoDatos transformandoDatos) {
        this.Dolar = Double.valueOf(transformandoDatos.USD());
        this.PesoArgentino = Double.valueOf(transformandoDatos.ARS());
        this.RealBrasilero = Double.valueOf(transformandoDatos.BRL());
        this.SolPeruano = Double.valueOf(transformandoDatos.PEN());
        this.PesoColombiano = Double.valueOf(transformandoDatos.COP());
        this.PesoChileno = Double.valueOf(transformandoDatos.CLP());
    }

    public NumberFormat entregarFormato(String codigoDeLaMoneda) {
        Currency moneda = Currency.getInstance(codigoDeLaMoneda);
        return NumberFormat.getCurrencyInstance();
    }
    public int validarOpcionPais() {
        int opcion = 0;
        do {
            try {
                opcion = this.scanner.nextInt();
                // Si hay tiempo, creamos una excepción para este caso.
                if (opcion < 1 || opcion > 6) {System.out.println("Error: Introduzca un número en un rango del 1 al 6");}
            }   catch (InputMismatchException e) {System.out.println("Error: Introduzca un valor válido ");}

        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

    public double solicitarCantidad() {
        this.scanner.nextLine();
        System.out.println("Ingrese la cantidad de dinero a convertir:");
        return this.scanner.nextDouble();
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
                    case 7 -> transformar = cantidad * (SolPeruano / PesoColombiano);
                    case 8 -> transformar = cantidad * (SolPeruano / PesoChileno);
                    case 9 -> transformar = cantidad * (PesoChileno / SolPeruano);
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
                    case 9 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    case 10 -> transformar = cantidad * (PesoChileno / PesoArgentino);
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
                    case 9 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    case 10 -> transformar = cantidad * (PesoChileno / PesoArgentino);
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
                    case 9 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    case 10 -> transformar = cantidad * (PesoChileno / PesoArgentino);
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
                    case 9 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    case 10 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    default -> transformar = -1.0;
                }
            }
            case USA -> {
                switch (opcion) {
                    case 1 -> transformar = cantidad * (SolPeruano / Dolar);
                    case 2 -> transformar = cantidad * (Dolar / SolPeruano);
                    case 3 -> transformar = cantidad * (SolPeruano / PesoArgentino);
                    case 4 -> transformar = cantidad * (PesoArgentino / SolPeruano);
                    case 5 -> transformar = cantidad * (SolPeruano / RealBrasilero);
                    case 6 -> transformar = cantidad * (RealBrasilero / SolPeruano);
                    case 7 -> transformar = cantidad * (SolPeruano / PesoChileno);
                    case 8 -> transformar = cantidad * (PesoChileno / SolPeruano);
                    case 9 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    case 10 -> transformar = cantidad * (PesoChileno / PesoArgentino);
                    default -> transformar = -1.0;
                }
            }
            default -> System.out.println("Pais no disponible");
        }
        return transformar;
    }
}
