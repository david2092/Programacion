/**
 * This class holds an enumeration of all command words known
 * to the program.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class PalabrasComando
{
    // Un array constante que contiene todas las palabras comando v�lidas
    private static final String comandosValidos[] = {"agregar", "buscar", "listar", "ayuda", "salir", "borrar", "localizar"};

    /**
     * Constructor 
     */
    public PalabrasComando()
    {
    }

    /**
     * Comprueba si una cadena es una palabra comando v�lida
     * @param cadena La cadena a ser comprobada
     * @return true si es v�lida o false en caso contrario
     */
    public boolean esComando(String cadena)
    {
        if(cadena != null){
            for(int i = 0; i < comandosValidos.length; i++) {
                if(comandosValidos[i].equals(cadena))
                    return true;
            }
        }
        // si llega hasta aqu�, es que no ha encontrado ninguna palabra que coincida con la buscada
        return false;
    }

    /**
     * Muestra todos los comandos v�lidos
     */
    public void mostrarTodos() 
    {
        for(String comando : comandosValidos) {
            System.out.print(comando + "  ");
        }
        System.out.println();
    }
}
