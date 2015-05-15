/**
 * Proporciona una demostraci�n simple de la clase LibretaDeDirecciones
 * Una serie de datos son a�adidos a la libreta mediante una interface textual
 * 
 * @author Apah (es una traducci�n de sus AddressBookDemo)
 * @version 20.05.2012
 */
public class DemoLibretaDeDirecciones
{
    private LibretaDeDirecciones libreta;
    private InterfaceTextoLibretaDirecciones interaccion;

    
    public static void main (String args[]){
        DemoLibretaDeDirecciones demo = new DemoLibretaDeDirecciones();
        demo.mostrarInterface();
    }
    /**
     * Inicializa una LibretaDeDirecciones con una serie de datos
     * La libreta de direcciones es pasadoa u una GUI para proporcionar una vista d elos datos.
     */
    public DemoLibretaDeDirecciones()
    {
        DatosDelContacto[] contactos = {
            new DatosDelContacto("david",   "08459 100000", "direccion 1"),
            new DatosDelContacto("michael", "08459 200000", "direccion 2"),
            new DatosDelContacto("john",    "08459 300000", "direccion 3"),
            new DatosDelContacto("helen",   "08459 400000", "direccion 4"),
            new DatosDelContacto("emma",    "08459 500000", "direccion 5"),
            new DatosDelContacto("kate",    "08459 600000", "direccion 6"),
            new DatosDelContacto("chris",   "08459 700000", "direccion 7"),
            new DatosDelContacto("ruth",    "08459 800000", "direccion 8"),
        };
        libreta = new LibretaDeDirecciones();
        for(DatosDelContacto contacto : contactos) {
            libreta.agregarContacto(contacto);
        }
        interaccion = new InterfaceTextoLibretaDirecciones(libreta);
    }

    /**
     * Permite al usuario interatuar con la libreta de direcciones
     */
    public void mostrarInterface()
    {
        interaccion.ejecutar();
    }

    /**
     * @return La libreta de direcciones
     */
    public LibretaDeDirecciones getLibreta()
    {
        return libreta;
    }
}
