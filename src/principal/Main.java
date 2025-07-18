package principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ConversionDatos.ApiResponse;
import ConversionDatos.RespuestaAPI;
import Operaciones.RealizarOperaciones;
import ConversionDatos.TransformandoDatos;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lec = new Scanner(System.in);
        Gson gson = new GsonBuilder().create();
        RespuestaAPI conversor = new RespuestaAPI();
        String json = conversor.convercion("USD");
        ApiResponse respuesta = gson.fromJson(json, ApiResponse.class);
        TransformandoDatos datos = respuesta.conversion_rates();
        RealizarOperaciones realizar = new RealizarOperaciones(datos);
        String mensaje = """
                *----Bienvenido al conversor de monedas UTP----*
                1) Dólar --> Sol Peruano
                2) Sol Peruano --> Dólar
                3) Dólar --> Peso Argentino
                4) Peso Argentino --> Dólar
                5) Dólar --> Real Brasileño
                6) Real Brasileño --> Dólar
                7) Dólar --> Peso Colombiano
                8) Peso Colombiano --> Dólar
                9) Salir
                ----* Elija una opción válida *----
                """;
        int numero = 0;
        double cantidad = 0.0;
        do {
            do {
                System.out.print(mensaje);
                numero = lec.nextInt();
                if (numero < 0 || numero > 9) {
                    System.out.println("Error ingrese el número dentro del rango correcto");
                }
            } while (numero < 0 || numero > 9);
            if (numero == 9) {
                break;
            }
            System.out.println("Ingrese la cantidad que va a convertir");
            cantidad = lec.nextDouble();
            String mostrar = switch (numero) {
                case 1 ->
                        String.format("Su cantidad ingresada en $%.2f es %.2f Soles ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 2 ->
                        String.format("Su cantidad ingresada en S/%.2f es %.2f Dólares ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 3 ->
                        String.format("Su cantidad ingresada en $%.2f es %.2f Pesos Argentinos ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 4 ->
                        String.format("Su cantidad ingresada en ARS %.2f es %.2f Dólares ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 5 ->
                        String.format("Su cantidad ingresada en  $%.2f es %.2f Real brasileño ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 6 ->
                        String.format("Su cantidad ingresada en  BRL %.2f es %.2f Dólares ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 7 ->
                        String.format("Su cantidad ingresada en   $%.2f es %.2f Peso Colombiano ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 8 ->
                        String.format("Su cantidad ingresada en   Col %.2f es %.2f Dólares ", cantidad, realizar.hacerConversion(numero, cantidad));
                case 9 ->
                        String.format("Saliendo del programa");
                default ->
                        String.format("--Finalizando el programa--");

            };
            System.out.println(mostrar);
        } while (numero != 9);
        System.out.println("--Saliendo - del  - programa--");
    }
}