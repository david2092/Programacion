/**
 * Nombre, address and teletelefono number details.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class DatosDelContacto implements Comparable<DatosDelContacto>
{
    private String nombre;
    private String telefono;
    private String direccion;

    /**
     * Set up the contact details. All details are trimmed to remove
     * trailing white space.
     * @param nombre The nombre.
     * @param telefono The telefono number.
     * @param direccion The direccion.
     */
    public DatosDelContacto(String nombre, String telefono, String direccion)
    {
        // Use blank strings if any of the arguments is null.
        if(nombre == null) {
            nombre = "";
        }
        if(telefono == null) {
            telefono = "";
        }
        if(direccion == null) {
            direccion = "";
        }
        this.nombre = nombre.trim();
        this.telefono = telefono.trim();
        this.direccion = direccion.trim();
    }
    
    /**
     * @return The nombre.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return The teletelefono number.
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @return The direccion.
     */
    public String getDireccion()
    {
        return direccion;
    }
    
    /**
     * Test for content equality between two objects.
     * @param other The object to compare to this one.
     * @return true if the argument object is a set
     *              of contact details with matching attributes.
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof DatosDelContacto) {
            DatosDelContacto otroContacto = (DatosDelContacto) obj;
            return nombre.equals(otroContacto.getNombre()) &&
                    telefono.equals(otroContacto.getTelefono()) &&
                     direccion.equals(otroContacto.getDireccion());
        }
        else {
            return false;
        }
    }

    /**
     * Compare these details against another set, for the purpose
     * of sorting. The fields are sorted by nombre, telefono, and direccion.
     * @param otherDetails The details to be compared against.
     * @return a negative integer if this comes before the parombreter,
     *         zero if they are equal and a positive integer if this
     *         comes after the second.
     */
    public int compareTo(DatosDelContacto otroContacto)
    {
        int comparacion = nombre.compareTo(otroContacto.getNombre());
        if(comparacion != 0){
            return comparacion;
        }
        comparacion = telefono.compareTo(otroContacto.getTelefono());
        if(comparacion != 0){
            return comparacion;
        }
        return direccion.compareTo(otroContacto.getDireccion());
    }

    /**
     * @return A multi-line string containing the nombre, telefono, and direccion.
     */
    public String toString()
    {
        return nombre + "\n" + telefono + "\n" + direccion;
    }

    /**
     * Compute a hashcode using the rules to be found in
     * "Effective Java", by Joshua Bloch.
     * @return A hashcode for ContactDetails.
     */
    public int hashCode()
    {
        int code = 17;
        code = 37 * code + nombre.hashCode();
        code = 37 * code + telefono.hashCode();
        code = 37 * code + direccion.hashCode();
        return code;
    }
}
