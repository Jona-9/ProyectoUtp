package Operaciones;

import ConsolaUI.Mensajes;
import ConversionDatos.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

public class SistemaConv {
    private Scanner scanner;
    private Gson gson;
    private RespuestaAPI conversor;
    private RealizarOperaciones realizarOperaciones;
    private Pais paisElegido;
    private String monedaClave;
    private Mensajes escribirConsola;

    public void ejecutar() {
        try {
            inicializar();
            seleccionarPais();
            configMoneda();
            obtenerDatosAPI();
            // Metodos faltantes:
            // Bienvenida al programa luego de los ajustes de usuario
            // Metodo que use el atributo "realizarOperaciones" para mostrar resultados
        } catch (Exception e) {
            System.out.println("Error: Ha ocurrido un error no identificado");
        }
    }

    public void inicializar() {
        this.scanner = new Scanner(System.in);
        this.gson = new GsonBuilder().create();
        this.conversor = new RespuestaAPI();
        this.escribirConsola = new Mensajes();
    }

    public void seleccionarPais() {
        escribirConsola.paisesLista();
        int eleccion = validarOpcionPais();
        colocarPais(eleccion);
    }

    public void configMoneda() {
        this.monedaClave = paisElegido.getMonedaCodigo();
    }

    public TransformandoDatos obtenerDatosAPI() throws IOException, InterruptedException {
        TransformandoDatos datos = null;
        try {
            String json = this.conversor.convercion(this.monedaClave);
            ApiResponse respuesta = this.gson.fromJson(json, ApiResponse.class);
            datos = respuesta.conversion_rates();
        } catch (Exception e) {
            System.out.println("Error en la obtención de datos: " + e.getMessage());
        }
        return datos;
    }

    public void iniciarOperaciones() {



    }

    public int validarOpcionConversion() {
        escribirConsola.mostrarBienvenida(this.paisElegido);
        int opcionConversion = 0;
        do {
            escribirConsola.generarMenuPais(this.paisElegido);
            opcionConversion = this.scanner.nextInt();
            if (opcionConversion < 1 || opcionConversion > 9) {System.out.println("Error: Ingrese el número en el rango indicado");}
            else if (opcionConversion == 9)                   {break;}
        } while (opcionConversion < 1 || opcionConversion > 9);

            return opcionConversion;
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



    private void colocarPais(int eleccion) {
        this.paisElegido = switch (eleccion) {
            case 1 -> Pais.USA;
            case 2 -> Pais.PERU;
            case 3 -> Pais.ARGENTINA;
            case 4 -> Pais.BRASIL;
            case 5 -> Pais.COLOMBIA;
            case 6 -> Pais.CHILE;
            default -> Pais.USA;
        };
    }
    public void formatoConversion() {
        Double cantidadDinero = solicitarCantidad();
        int opcionConversion = validarOpcionConversion();

        Map<Integer, MonedaSimbolo> elecciones = new HashMap<>();
        switch (this.paisElegido) {
            case PERU -> {
                elecciones.put(1, new MonedaSimbolo(Pais.PERU, Pais.USA));
                elecciones.put(2, new MonedaSimbolo(Pais.USA, Pais.PERU));
                elecciones.put(3, new MonedaSimbolo(Pais.PERU, Pais.ARGENTINA));
                elecciones.put(4, new MonedaSimbolo(Pais.ARGENTINA, Pais.PERU));
                elecciones.put(5, new MonedaSimbolo(Pais.PERU, Pais.BRASIL));
                elecciones.put(6, new MonedaSimbolo(Pais.BRASIL, Pais.PERU));
                elecciones.put(7, new MonedaSimbolo(Pais.PERU, Pais.COLOMBIA));
                elecciones.put(8, new MonedaSimbolo(Pais.COLOMBIA, Pais.PERU));
                elecciones.put(9, new MonedaSimbolo(Pais.PERU, Pais.CHILE));
                elecciones.put(10, new MonedaSimbolo(Pais.CHILE, Pais.PERU));
            }
            case ARGENTINA -> {
                elecciones.put(1, new MonedaSimbolo(Pais.ARGENTINA, Pais.USA));
                elecciones.put(2, new MonedaSimbolo(Pais.USA, Pais.ARGENTINA));
                elecciones.put(3, new MonedaSimbolo(Pais.ARGENTINA, Pais.PERU));
                elecciones.put(4, new MonedaSimbolo(Pais.PERU, Pais.ARGENTINA));
                elecciones.put(5, new MonedaSimbolo(Pais.ARGENTINA, Pais.BRASIL));
                elecciones.put(6, new MonedaSimbolo(Pais.BRASIL, Pais.ARGENTINA));
                elecciones.put(7, new MonedaSimbolo(Pais.ARGENTINA, Pais.COLOMBIA));
                elecciones.put(8, new MonedaSimbolo(Pais.COLOMBIA, Pais.ARGENTINA));
                elecciones.put(9, new MonedaSimbolo(Pais.ARGENTINA, Pais.CHILE));
                elecciones.put(10, new MonedaSimbolo(Pais.CHILE, Pais.ARGENTINA));
            }
            case BRASIL -> {
                elecciones.put(1, new MonedaSimbolo(Pais.BRASIL, Pais.USA));
                elecciones.put(2, new MonedaSimbolo(Pais.USA, Pais.BRASIL));
                elecciones.put(3, new MonedaSimbolo(Pais.BRASIL, Pais.ARGENTINA));
                elecciones.put(4, new MonedaSimbolo(Pais.ARGENTINA, Pais.BRASIL));
                elecciones.put(5, new MonedaSimbolo(Pais.BRASIL, Pais.PERU));
                elecciones.put(6, new MonedaSimbolo(Pais.PERU, Pais.BRASIL));
                elecciones.put(7, new MonedaSimbolo(Pais.BRASIL, Pais.COLOMBIA));
                elecciones.put(8, new MonedaSimbolo(Pais.COLOMBIA, Pais.BRASIL));
                elecciones.put(9, new MonedaSimbolo(Pais.BRASIL, Pais.CHILE));
                elecciones.put(10, new MonedaSimbolo(Pais.CHILE, Pais.BRASIL));
            }
            case COLOMBIA -> {
                elecciones.put(1, new MonedaSimbolo(Pais.COLOMBIA, Pais.USA));
                elecciones.put(2, new MonedaSimbolo(Pais.USA, Pais.COLOMBIA));
                elecciones.put(3, new MonedaSimbolo(Pais.COLOMBIA, Pais.ARGENTINA));
                elecciones.put(4, new MonedaSimbolo(Pais.ARGENTINA, Pais.COLOMBIA));
                elecciones.put(5, new MonedaSimbolo(Pais.COLOMBIA, Pais.BRASIL));
                elecciones.put(6, new MonedaSimbolo(Pais.BRASIL, Pais.COLOMBIA));
                elecciones.put(7, new MonedaSimbolo(Pais.COLOMBIA, Pais.PERU));
                elecciones.put(8, new MonedaSimbolo(Pais.PERU, Pais.COLOMBIA));
                elecciones.put(9, new MonedaSimbolo(Pais.COLOMBIA, Pais.CHILE));
                elecciones.put(10, new MonedaSimbolo(Pais.CHILE, Pais.COLOMBIA));
            }
            case CHILE -> {
                elecciones.put(1, new MonedaSimbolo(Pais.CHILE, Pais.USA));
                elecciones.put(2, new MonedaSimbolo(Pais.USA, Pais.CHILE));
                elecciones.put(3, new MonedaSimbolo(Pais.CHILE, Pais.PERU));
                elecciones.put(4, new MonedaSimbolo(Pais.PERU, Pais.CHILE));
                elecciones.put(5, new MonedaSimbolo(Pais.CHILE, Pais.BRASIL));
                elecciones.put(6, new MonedaSimbolo(Pais.BRASIL, Pais.CHILE));
                elecciones.put(7, new MonedaSimbolo(Pais.CHILE, Pais.COLOMBIA));
                elecciones.put(8, new MonedaSimbolo(Pais.COLOMBIA, Pais.CHILE));
                elecciones.put(9, new MonedaSimbolo(Pais.CHILE, Pais.PERU));
                elecciones.put(10, new MonedaSimbolo(Pais.PERU, Pais.CHILE));
            }
            case USA -> {
                elecciones.put(1, new MonedaSimbolo(Pais.USA, Pais.PERU));
                elecciones.put(2, new MonedaSimbolo(Pais.PERU, Pais.USA));
                elecciones.put(3, new MonedaSimbolo(Pais.USA, Pais.ARGENTINA));
                elecciones.put(4, new MonedaSimbolo(Pais.ARGENTINA, Pais.USA));
                elecciones.put(5, new MonedaSimbolo(Pais.USA, Pais.BRASIL));
                elecciones.put(6, new MonedaSimbolo(Pais.BRASIL, Pais.USA));
                elecciones.put(7, new MonedaSimbolo(Pais.USA, Pais.COLOMBIA));
                elecciones.put(8, new MonedaSimbolo(Pais.COLOMBIA, Pais.PERU));
                elecciones.put(9, new MonedaSimbolo(Pais.PERU, Pais.CHILE));
                elecciones.put(10, new MonedaSimbolo(Pais.CHILE, Pais.PERU));
            }
        }
        MonedaSimbolo convertir = elecciones.get(opcionConversion);
        Pais emisor = convertir.origen();
        Pais receptor = convertir.destino();
        String monedaEmisora = emisor.getMonedaCodigo();
        String monedaReceptora = receptor.getMonedaCodigo();

        NumberFormat emisoraFormato = this.realizarOperaciones.entregarFormato(monedaEmisora);
        NumberFormat receptoraFormato = this.realizarOperaciones.entregarFormato(monedaReceptora);

        System.out.println("Su cantidad ingresada en " + emisoraFormato.format(cantidadDinero) + " es " + receptoraFormato.format(this.realizarOperaciones.hacerConversion(this.paisElegido, opcionConversion, cantidadDinero)));
    }
}