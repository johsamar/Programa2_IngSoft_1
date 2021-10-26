/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.FileNotFoundException;
import lector.LectorArchivo;

/**
 *
 * @author SAMUEL-PC
 * @version 1.0
 */
public class Archivo {
    
    private String nombreArchivo;
    private int cantidadDeRepeticiones;
    private LectorArchivo lectorArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        cantidadDeRepeticiones = 0;
        lectorArchivo = new LectorArchivo();
    }
    /**
     * Busca en el contenido del archivo la 
     * cantidad de repticiones de una palabra
     * @param ruta Ruta del directorio
     * @param palabra palabra a buscar y contar
     * @param extension extension del archivo (.txt)
     * @throws FileNotFoundException 
     */
    public void contarPalabra(String ruta,String palabra,String extension) throws FileNotFoundException{
        String contenido = getContenido(ruta,nombreArchivo,extension);
        
    }
    /**
     * Obtiene el contenido del archivo
     * @param ruta Ruta del directorio
     * @param nombreArchivo  
     * @param extension extension del archivo (.txt)
     * @return El contenido de texto del archivo
     * @throws FileNotFoundException 
     */
    private String getContenido(String ruta,String nombreArchivo,String extension) throws FileNotFoundException{
        String path = ruta+"/"+nombreArchivo+"/"+extension;
        return lectorArchivo.leerArchivo(path);
    }
    
    public int getCantidadDeRepeticiones(){
        return cantidadDeRepeticiones;
    }
}
