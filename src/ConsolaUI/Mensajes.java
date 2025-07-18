package ConsolaUI;

import ConversionDatos.Pais;

import java.util.Scanner;

public class Mensajes {
    private Scanner scanner = new Scanner(System.in);


    public void mostrarBienvenida(Pais pais) {
        System.out.println("----Bienvenido al conversor de monedas UTP----");
        System.out.println("País: " + pais.getNombre());
        System.out.println("Moneda base: " + pais.getMonedaCodigo());
        System.out.println("═══════════════════════════════════════");
    }

    public void paisesLista() {
        String menuPaises = """
                ═══════════════════════════════════════
                  SELECCIONE SU PAÍS DE ORIGEN
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

    public void generarMenuPais(Pais pais) {
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
