package Operaciones;

import ConversionDatos.ApiResponse;
import ConversionDatos.Pais;
import ConversionDatos.RespuestaAPI;
import ConversionDatos.TransformandoDatos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaConv {
    private Scanner scanner;
    private Gson gson;
    private RespuestaAPI conversor;
    private RealizarOperaciones realizarOperaciones;
    private Pais paisElegido;
    private String monedaClave;

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
    }

    public void seleccionarPais() {
        listadoDePaises();
        int eleccion = validarOpcionPais();
        colocarPais(eleccion);
        System.out.println("El país elegido es: " + this.paisElegido.getNombre());
    }

    public void configMoneda() {
        this.monedaClave = paisElegido.getMonedaCodigo();
        System.out.println(this.monedaClave);
    }

    public void obtenerDatosAPI() throws IOException, InterruptedException {
        try {
            String json = this.conversor.convercion(this.monedaClave);
            ApiResponse respuesta = this.gson.fromJson(json, ApiResponse.class);
            TransformandoDatos datos = respuesta.conversion_rates();
            this.realizarOperaciones = new RealizarOperaciones(datos);

        } catch (Exception e) {
            System.out.println("Error en la obtención de datos: " + e.getMessage());
        }
    }

    public void iniciarOperaciones() {
        double cantidadDinero = solicitarCantidad();
        int opcionConversion = validarOpcionConversion();


    }

    

    public int validarOpcionConversion() {
        mostrarBienvenida();
        int opcionConversion = 0;
        do {
            generarMenuPais(this.paisElegido);
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

    public void listadoDePaises() {
        String menuPaises = """
                ═══════════════════════════════════════
                🌍 SELECCIONE SU PAÍS DE ORIGEN
                ═══════════════════════════════════════
                1) Estados Unidos (USD)
                2) Perú (PEN)
                3) Argentina (ARS)
                4) Brasil (BRL)
                5) Colombia (COP)
                6) Chile (CLP)
                ═══════════════════════════════════════
                Seleccione una opción (1-6):\s""";
        System.out.print(menuPaises);
    }
    private void mostrarBienvenida() {
        System.out.println("----Bienvenido al conversor de monedas UTP----");
        System.out.println("País: " + this.paisElegido.getNombre());
        System.out.println("Moneda base: " + this.monedaClave);
        System.out.println("═══════════════════════════════════════");
    }
    private void generarMenuPais(Pais pais) {
        String menuPais = switch (pais) {
            case PERU -> """
            ═══════════════════════════════════════
              CONVERSOR DE MONEDAS - PERÚ
            ═══════════════════════════════════════
            1) Sol Peruano --> Dólar (USD)
            2) Dólar --> Sol Peruano (PEN)
            3) Sol Peruano --> Peso Argentino (ARS)
            4) Peso Argentino --> Sol Peruano (PEN)
            5) Sol Peruano --> Real Brasileño (BRL)
            6) Real Brasileño --> Sol Peruano (PEN)
            7) Sol Peruano --> Peso Colombiano (COP)
            8) Peso Colombiano --> Sol Peruano (PEN)
            9) Salir
            ═══════════════════════════════════════
            Seleccione una opción:""";
            case ARGENTINA -> """
            ═══════════════════════════════════════
              CONVERSOR DE MONEDAS - ARGENTINA
            ═══════════════════════════════════════
            1) Peso Argentino --> Dólar (USD)
            2) Dólar --> Peso Argentino (ARS)
            3) Peso Argentino --> Sol Peruano (PEN)
            4) Sol Peruano --> Peso Argentino (ARS)
            5) Peso Argentino --> Real Brasileño (BRL)
            6) Real Brasileño --> Peso Argentino (ARS)
            7) Peso Argentino --> Peso Colombiano (COP)
            8) Peso Colombiano --> Peso Argentino (ARS)
            9) Salir
            ═══════════════════════════════════════
            Seleccione una opción:""";
            case BRASIL -> """
            ═══════════════════════════════════════
              CONVERSOR DE MONEDAS - BRASIL
            ═══════════════════════════════════════
            1) Real Brasileño --> Dólar (USD)
            2) Dólar --> Real Brasileño (BRL)
            3) Real Brasileño --> Sol Peruano (PEN)
            4) Sol Peruano --> Real Brasileño (BRL)
            5) Real Brasileño --> Peso Argentino (ARS)
            6) Peso Argentino --> Real Brasileño (BRL)
            7) Real Brasileño --> Peso Colombiano (COP)
            8) Peso Colombiano --> Real Brasileño (BRL)
            9) Salir
            ═══════════════════════════════════════
            Seleccione una opción:""";
            case COLOMBIA -> """
            ═══════════════════════════════════════
              CONVERSOR DE MONEDAS - COLOMBIA
            ═══════════════════════════════════════
            1) Peso Colombiano --> Dólar (USD)
            2) Dólar --> Peso Colombiano (COP)
            3) Peso Colombiano --> Sol Peruano (PEN)
            4) Sol Peruano --> Peso Colombiano (COP)
            5) Peso Colombiano --> Peso Argentino (ARS)
            6) Peso Argentino --> Peso Colombiano (COP)
            7) Peso Colombiano --> Real Brasileño (BRL)
            8) Real Brasileño --> Peso Colombiano (COP)
            9) Salir
            ═══════════════════════════════════════
            Seleccione una opción:""";
            case CHILE -> """
            ═══════════════════════════════════════
               CONVERSOR DE MONEDAS - CHILE
            ═══════════════════════════════════════
            1) Peso Chileno --> Dólar (USD)
            2) Dólar --> Peso Chileno (CLP)
            3) Peso Chileno --> Sol Peruano (PEN)
            4) Sol Peruano --> Peso Chileno (CLP)
            5) Peso Chileno --> Peso Argentino (ARS)
            6) Peso Argentino --> Peso Chileno (CLP)
            7) Peso Chileno --> Real Brasileño (BRL)
            8) Real Brasileño --> Peso Chileno (CLP)
            9) Salir
            ═══════════════════════════════════════
            Seleccione una opción:""";
            case USA -> """
            ═══════════════════════════════════════
              CONVERSOR DE MONEDAS - ESTADOS UNIDOS
            ═══════════════════════════════════════
            1) Dólar --> Peso Argentino (ARS)
            2) Peso Argentino --> Dólar (USD)
            3) Dólar --> Sol Peruano (PEN)
            4) Sol Peruano --> Dólar (USD)
            5) Dólar --> Real Brasileño (BRL)
            6) Real Brasileño --> Dólar (USD)
            7) Dólar --> Peso Colombiano (COP)
            8) Peso Colombiano --> Dólar (USD)
            9) Salir
            ═══════════════════════════════════════
            Seleccione una opción:""";
        };
        System.out.println(menuPais);
    }
}