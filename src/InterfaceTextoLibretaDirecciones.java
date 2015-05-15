/** <pre>
 * Proporciona una interface textual para la Libreta de Direcciones
 * Diferentes comandos proporcionan acceso a los datos en la libreta de direcciones
 *
 *      Uno para buscar.
 *
 *      Uno para a�adir un nuevo contacto
 *
 *      Uno para mostrar todas las entradas de la libreta
 *</pre>
 * @author Apah (es una traducci�n de su AddressBookTextInterfaces
 * @version 20.05.2012
 */
public class InterfaceTextoLibretaDirecciones
{
    private LibretaDeDirecciones libreta;   // La libreta de direcciones a ser visualizada y manipulada
    private Analizador analizador;          // El analizador de comandos

    /**
     * Constructor 
     * @param libreta La libreta de direcciones a ser manipulada
     */
    public InterfaceTextoLibretaDirecciones(LibretaDeDirecciones libreta)
    {
        this.libreta = libreta;
        analizador = new Analizador();
    }

    /**
     * Lee una serie de comandos del usuario para interactuar con la libreta de direcciones
     * Para cuando el usuario escribe 'salir'
     */
    public void ejecutar()
    {
        System.out.println("Libreta de direcciones");
        System.out.println("Escribe 'ayuda' para una lista de los comandos");

        String comando;
        do{
            comando = analizador.getComando();
            if(comando.equals("agregar")){ 
                añadir();
            }
            else if(comando.equals("listar")){
                listar();
            }
            else if(comando.equals("buscar")){
                encontrar();
            }
            else if(comando.equals("ayuda")){
                ayuda();
            }
            else if(comando.equals("borrar")){
                borrar();
            }
            else if(comando.equals("localizar")){
                localizar();
            }
            else{
                // No hace nada
            }
        } while(!(comando.equals("salir")));

        System.out.println("Adi�s");
    }

    /**
     * A�ade una nueva entrada
     */
    private void añadir()
    {
        System.out.print("Nombre: ");
        String nombre = analizador.leerLinea();
        System.out.print("Telefono: ");
        String telefono = analizador.leerLinea();
        System.out.print("Direcci�n: ");
        String direccion = analizador.leerLinea();
        libreta.agregarContacto(new DatosDelContacto(nombre, telefono, direccion));
        if(libreta.agregarContacto(new DatosDelContacto(nombre, telefono, direccion))){
            System.out.println("El contacto se ha a�adido a la agenda");
        }
        else System.out.println("Los datos no son validos");
    }

    /**
     * Busca las entradas que coincidan con el prefijo de la clave
     */
    private void encontrar()
    {
        System.out.println("Escribe el prefijo de la clave a buscar");
        String prefijo = analizador.leerLinea();
        DatosDelContacto[] resultados = libreta.buscar(prefijo);
        if(resultados == null){
            System.out.println("No se han encontrado resultados");
        }
        else{
            for(int i = 0; i < resultados.length; i++){
                System.out.println(resultados[i]);
                System.out.println("=====");
            }
        }
    }

    /**
     * Lista los comandos v�lidos
     */
    private void ayuda()
    {
        analizador.mostrarComandos();
    }

    /**
     * Lista el contenido de la libreta de direcciones
     */
    private void listar()
    {
        System.out.println(libreta.listarContactos());
    }

    /**
     * Pide la clave del contacto a eliminar y... 
     * Elimina el contacto
     */
    private void borrar()
    {
        System.out.print("Clave: ");
        String clave = analizador.leerLinea();
        if(libreta.eliminarContacto(clave)){
            System.out.println("El contacto ha sido borrado");
        }
        else{
            System.out.println("El contacto no se ha podido borrar");
        }
    }

    /**
     * Pide la clave del contacto a eliminar y... 
     * Elimina el contacto
     */
    private void localizar()
    {
        System.out.print("Clave: ");
        String clave = analizador.leerLinea();
        DatosDelContacto contacto = libreta.getContacto(clave);
        if(contacto != null){
            System.out.println(contacto);
        }else{
            System.out.println("No existe ese contacto que buscas");
        }
        //         throw new NullPointerException("No existe ese contacto");
    }
}
