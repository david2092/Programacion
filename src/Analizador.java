import java.util.Scanner;

/**
 * Una clase que lee las l�neas de entrada del usuario
 * La entrada es filtrada via getComando para validar el comando
 *
 * @author  Apah (es una traduci�n de su Parser)
 * @version 20.05.2012
 */
public class Analizador 
{
    private PalabrasComando comandos;   // El constructor carga todas las palabras comando v�lidas
    private Scanner lector;             // Para leer la entrada del usuario

    public Analizador() 
    {
        comandos = new PalabrasComando();
        lector = new Scanner(System.in);
    }

    
    /**
     * Lee el siguiente comando del usuario
     * El comando devuelto ser� v�lido
     * @return Un comando v�lido
     */
    public String getComando() 
    {
        String comando = null;
        do {
            System.out.print("> "); // Visualiza el prompt
            String palabra = lector.next();
            leerLinea();   // Descarta el resto de la l�nea
            if(comandos.esComando(palabra)) {
                comando = palabra;
            }
            else{
                System.out.println("Comando no reconocido: " + palabra);
                System.out.print("Los comandos v�lidos son: ");
                comandos.mostrarTodos();
            }
        } while(comando == null);
    
        return comando;
    }

    
    /**
     * Visualiza la lista de palabras comando v�lidas
     */
    public void mostrarComandos()
    {
        comandos.mostrarTodos();
    }

    
    /**
     * @return Una linea de texto del usuario
     */
    public String leerLinea()
    {
        return lector.nextLine();
    }
}
