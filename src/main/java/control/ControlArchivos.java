
package control;

import entidades.Archivo;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lector.LectorDirectorio;
import misExcepciones.DirectorioInexistenteException;
import misExcepciones.DirectorioSinArchicosException;

/**
 *
 * @author SAMUEL MARIN
 * @version 1.0
 */
public class ControlArchivos {

    private String ruta;
    private String palabra;
    private String extension;
    private ArrayList<Archivo> archivos;
    private int total;
    private int archivosNoEncontrados;

    public ControlArchivos(String ruta, String palabra) {
        this.ruta = ruta;
        this.palabra = palabra;
        this.extension = "txt";
        this.archivos = new ArrayList<>();
        this.archivosNoEncontrados = 0;
        this.total = 0;
    }

    /**
     * 
     * @return
     * @throws DirectorioInexistenteException
     * @throws DirectorioSinArchicosException 
     */
    public boolean buscarArchivos() throws DirectorioInexistenteException, DirectorioSinArchicosException {
        
        String[] nombresDeArchivos;
        
        LectorDirectorio lectorDirectorio = new LectorDirectorio();
        nombresDeArchivos = lectorDirectorio.listarArchivos(ruta, extension);
        
        for (String nombreArchivo : nombresDeArchivos) {
            archivos.add(new Archivo(nombreArchivo));
        }
        contarPalabraPorArchivo();
        return true;
    }

    /**
     *
     * @return
     */
    private boolean contarPalabraPorArchivo() {
        for (int i = 0; i < archivos.size(); i++) {
            try {
                archivos.get(i).contarPalabra(ruta, palabra);
            } catch (FileNotFoundException noEncontrado) {
                this.archivosNoEncontrados++;
            }
        }
        return true;
    }

    /**
     *
     * @return
     */
    public ArrayList<Map<String, Integer>> getCantidadPorArchivo() {
        ArrayList<Map<String, Integer>> cantidadPorArchivo = new ArrayList<>();
        
        for (Archivo archivo : archivos) {
            Map mapa = new HashMap();
            mapa.put("nombreArchivo", archivo.getNombreArchivo());
            mapa.put("cantidadVeces", archivo.getCantidadDeRepeticiones());
            
            cantidadPorArchivo.add(mapa);
        }
        
        return cantidadPorArchivo;
    }
}
