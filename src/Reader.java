package src;

import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nils Muralles
 * @since 26/02/24
 * @description Clase que lee el archivo cards_desc.txt
 */

public class Reader{
    private File data;

    /**
     * Constructor de la clase reader
     */
    public Reader() {
        data = new File("cards_desc.txt");
    }

    /**
     * Lee todas las cartas y las devuelve como una implementación de map
     * @param map Implementación de mapa seleccionada por el usuario
     * @return Mapa con todas las cartas
     */
    public Map<String, String> readCards(Map<String, String> map) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(data));
            String line;
            

            while ((line = br.readLine()) != null) {
                String[] elements = line.split("\\|");
                map.put(elements[0], elements[1]);
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return map;
    }
}
