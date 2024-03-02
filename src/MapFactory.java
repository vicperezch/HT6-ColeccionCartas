package src;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

/**
 * @author Victor Pérez
 * @since 02/03/2024
 * @description Clase que maneja la creación de implementaciones de Map
 */
public class MapFactory<K, V> {

    /**
     * Crea y devuelve una implementación de Map
     * @param <K> Tipo de dato de la llave
     * @param <V> Tipo de dato del valor
     * @param option Opción que indica la implementación de Map que se desea crear
     * @return Implementación de Map
     */
    public static <K, V> Map<K, V> createMap(int option) {
        switch (option) {
            case 1:
                return new HashMap<K, V>();

            case 2:
                return new TreeMap<K, V>();

            case 3:
                return new LinkedHashMap<K, V>();

            default:
                return null;
        }
    }
}
