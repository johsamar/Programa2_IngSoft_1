
package lector;

import java.io.File;
import java.io.FilenameFilter;
import misExcepciones.DirectorioException;


/**
 * Busca la Ruta ingresada
 * @author SAMUEL-PC
 * @version 1.1
 */
public class LectorDirectorio {
    /**
     * Abre la ruta que se ingresa para listar 
     * sus archivos por su extension
     * @param ruta 
     * @param extension 
     * @return Arreglo de nombres de archivos
     *         con la extensión ingresada
     * @throws DirectorioException Si la ruta ingresada no existe
     *         o si no hay archivos con la extension indicada
     */
    public String[] listarArchivos(String ruta,String extension)
                                                    throws DirectorioException{
        
        String[] contenido;
        
        FilenameFilter filter = (File file, String name) -> {
            if (name.endsWith(extension)) {
                return true;
            } else {
                return false;
            }
        };
        
        File directorio = new File(ruta);
        if(!directorio.isDirectory()){
            throw new DirectorioException("No existe la Ruta");
        }
        contenido = directorio.list(filter);
        if (contenido.length == 0) {
            throw new DirectorioException("Ruta sin Arhivos ." + extension);
        }
        return contenido;
        
    }
}
