/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Archivo;
import java.util.ArrayList;

/**
 *
 * @author SAMUEL-PC
 * @version 1.0
 */
public class ControlArchivos {
    private String ruta;
    private String palabra;
    private String extension;
    private ArrayList<Archivo> archivos;

    public ControlArchivos(String ruta, String palabra, 
                            String extensioni) {
        this.ruta = ruta;
        this.palabra = palabra;
        this.extension = extension;
        this.archivos = new ArrayList<>();
    }
    /**
     * 
     * @return 
     */
    public boolean buscarNombreArchivo(){
        return true;
    }
    /**
     * 
     * @return 
     */
    private boolean contarPalabraPorArchivo(){
        return true;
    }
    /**
     * 
     * @return 
     */
    public ArrayList<String> getCantidadPorArchivo(){
        return null;
    }
}
