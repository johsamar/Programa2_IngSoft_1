/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import misExcepciones.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SAMUEL-PC
 */
public class ControlArchivosTest {
    
    public ControlArchivosTest() {
    }

    @Test
    public void testRutaQueNoExisteBuscarArchivos() {
        String ruta = "casa";
        String palabra = "arar";
        ControlArchivos controlArchivos = new ControlArchivos(ruta, palabra);
        
        assertThrows(DirectorioInexistenteException.class, () -> {
        controlArchivos.buscarArchivos();
        });
    }
    @Test
    public void testRutaQueNoTieneArchivosBuscarArchivos() {
        String ruta = "C:\\";
        String palabra = "arar";
        ControlArchivos controlArchivos = new ControlArchivos(ruta, palabra);
        
        assertThrows(DirectorioSinArchicosException.class, () -> {
        controlArchivos.buscarArchivos();
        });
    }
}
