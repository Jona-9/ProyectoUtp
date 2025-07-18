package Operaciones;

import ConversionDatos.MonedaSimbolo;
import ConversionDatos.Pais;
import ConversionDatos.TransformandoDatos;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class FormatosPaises {

    RealizarOperaciones realizarOpera = new RealizarOperaciones();

    public void formatoConversion(Pais pais) {
        Double cantidadDinero = solicitarCantidad();
        int opcionConversion = validarOpcionConversion();

        Map<Integer, MonedaSimbolo> elecciones = new HashMap<>();
        switch (pais) {
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
