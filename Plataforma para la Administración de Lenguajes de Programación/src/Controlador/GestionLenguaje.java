package Controlador;

import Modelo.LenguajeProgramacion;


public class GestionLenguaje {
    private static final int FACTOR_CRECIMIENTO = 2;
    private LenguajeProgramacion[] arregloLenguajes;
    private int contadorLenguajes;

    public GestionLenguaje() {
        arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
        contadorLenguajes = 0;
    }

    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == arregloLenguajes.length) {
            aumentarCapacidad();
        }
        arregloLenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }

    private void aumentarCapacidad() {
        LenguajeProgramacion[] nuevoArray = new LenguajeProgramacion[arregloLenguajes.length + FACTOR_CRECIMIENTO];
        System.arraycopy(arregloLenguajes, 0, nuevoArray, 0, arregloLenguajes.length);
        arregloLenguajes = nuevoArray;
    }

    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null;
    }

    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < contadorLenguajes - 1; j++) {
                    arregloLenguajes[j] = arregloLenguajes[j + 1];
                }
                arregloLenguajes[--contadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }

    public LenguajeProgramacion[] getArregloLenguajes() {
        LenguajeProgramacion[] lenguajes = new LenguajeProgramacion[contadorLenguajes];
        System.arraycopy(arregloLenguajes, 0, lenguajes, 0, contadorLenguajes);
        return lenguajes;
    }

    public void imprimirLenguajes() {
        for (int i = 0; i < contadorLenguajes; i++) {
            System.out.println(arregloLenguajes[i]);
        }
    }
}
