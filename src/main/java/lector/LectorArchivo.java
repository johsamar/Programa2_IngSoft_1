/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Busca la ruta de un archivo .txt y lo abre
 *
 * @author SAMUEL MARIN
 * @version 1.0
 */
public class LectorArchivo {

    private File archivo = null;
    private FileReader fileReader = null;
    private BufferedReader bufferedReader = null;
    private String texto;

    public LectorArchivo() {
        texto = "";
    }

    /**
     * Abre la ruta del archivo txt
     *
     * @param ruta Ruta de un archivo con extension .txt
     * @return Contenido del archicho
     */
    public String leerArchivo(String ruta) throws FileNotFoundException {

        try {
            archivo = new File(ruta);
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                texto += linea;
            }
            return texto;

        } catch (FileNotFoundException fe) {
            throw new FileNotFoundException("Archivo No encontrado");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileReader) {
                    fileReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
