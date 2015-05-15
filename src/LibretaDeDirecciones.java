import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A class to maintain an arbitrary number of contact contacto.
 * contacto are indexed by both name and phone number.
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LibretaDeDirecciones
{
    // Storage for an arbitrary number of contacto.
    private TreeMap<String, DatosDelContacto> libro;
    private int numeroDeEntradas;

    /**
     * Perform any initialization for the address libro.
     */
    public LibretaDeDirecciones()
    {
        libro = new TreeMap<String, DatosDelContacto>();
        numeroDeEntradas = 0;
    }

    /**
     * Look up a name or phone number and return the
     * corresponding contact contacto.
     * @param clave The name or number to be looked up.
     * @return The contacto corresponding to the clave.
     */
    public DatosDelContacto getContacto(String clave)
    {
        return libro.get(clave);
    }

    /**
     * Return whether or not the current clave is in use.
     * @param clave The name or number to be looked up.
     * @return true if the clave is in use, false otherwise.
     */
    public boolean claveEnUso(String clave)
    {
        return libro.containsKey(clave);
    }

    /**
     * Add a new set of contacto to the notelibro.
     * @param contacto The contacto to associate with the person.
     */
    public boolean agregarContacto(DatosDelContacto contacto)
    {
        //         if(!contacto.getNombre().equals("") && !contacto.getTelefono().equals("") && !contacto.getDireccion().equals("")){
        try{  
            libro.put(contacto.getNombre(), contacto);
            libro.put(contacto.getTelefono(), contacto);
            numeroDeEntradas++;
            return true;
        }catch(NullPointerException e){
            return false;
        }
    }

    /**
     * Change the contacto previously stored under the given clave.
     * @param oldclave One of the claves used to store the contacto.
     * @param contacto The replacement contacto.
     */
    public boolean modificarContacto(String claveVieja, DatosDelContacto contacto)
    {
        if(claveEnUso(claveVieja) && contacto != null){
            eliminarContacto(claveVieja);
            agregarContacto(contacto);
            return true;
        }
        return false;
    }

    /**
     * Search for all contacto stored under a clave that starts with
     * the given prefix.
     * @param clavePrefix The clave prefix to search on.
     * @return An array of those contacto that have been found.
     */
    public DatosDelContacto[] buscar(String prefijoClave)
    {
        // Build a list of the matches.
        List<DatosDelContacto> coincidencias = new LinkedList<DatosDelContacto>();
        // Find claves that are equal-to or greater-than the prefix.
        if(prefijoClave != null){
            SortedMap<String, DatosDelContacto> cola = libro.tailMap(prefijoClave);
            Iterator<String> it = cola.keySet().iterator();
            // Stop when we find a mismatch.
            boolean finDeBusqueda = false;
            while(!finDeBusqueda && it.hasNext()) {
                String clave = it.next();
                if(clave.startsWith(prefijoClave)) {
                    coincidencias.add(libro.get(clave));
                }
                else {
                    finDeBusqueda = true;
                }
            }
        }
        if(coincidencias.size() == 0)return null;
        DatosDelContacto[] resultados = new DatosDelContacto[coincidencias.size()];
        coincidencias.toArray(resultados);
        return resultados;
    }

    /**
     * @return The number of entries currently in the
     *         address libro.
     */
    public int getNumeroDeEntradas()
    {
        return numeroDeEntradas;
    }

    /**
     * Remove an entry with the given clave from the address libro.
     * @param clave One of the claves of the entry to be removed.
     */
    public boolean eliminarContacto(String clave)
    {
        DatosDelContacto contacto = libro.get(clave);
        if(claveEnUso(clave)){
            libro.remove(contacto.getNombre());
            libro.remove(contacto.getTelefono());
            numeroDeEntradas--;
            return true;
        }
        return false;
    }

    /**
     * @return All the contact contacto, sorted according
     * to the sort order of the DatosDelContacto class.
     */
    public String listarContactos()
    {
        // Because each entry is stored under two claves, it is
        // necessary to build a set of the DatosDelContacto. This
        // eliminates duplicates.
        StringBuffer todasEntradas = new StringBuffer();
        Set<DatosDelContacto> contactosOrdenados = new TreeSet<DatosDelContacto>(libro.values());
        for(DatosDelContacto contacto : contactosOrdenados) {
            todasEntradas.append(contacto);
            todasEntradas.append('\n');
            todasEntradas.append('\n');
        }
        return todasEntradas.toString();
    }
}
