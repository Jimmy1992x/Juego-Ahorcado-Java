// Scanner permitirá leer datos desde la entrada estándar
import java.util.Scanner;

public class Ahorcado{
   public static void main(String[] args) throws Exception {
      //Clase scanner para leer la entrada del usuario
      Scanner scanner = new Scanner(System.in);
     
      //Declaraciones y asignaciones de variables
      String palabraSecreta = "inteligencia";
      int intentosMaximos = 10;
      int intentos = 0;
      boolean palabraAdivinada = false;
      
      //Arreglo para almacenar las letras adivinadas
      char[] letrasAdivinadas = new char[palabraSecreta.length()];

      // Inicializar el arreglo de letras adivinadas con guiones bajos
      for (int i = 0; i < letrasAdivinadas.length; i++) {
         letrasAdivinadas[i] = '_';
      }
    
      // Bucle while para permitir al usuario adivinar letras
      while (!palabraAdivinada && intentos < intentosMaximos) {
         // Mostrar el estado actual de las letras adivinadas
         System.out.println("Palabra a adivinar: "  + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

         System.out.println("Introduce una letra, por favor:");
         // Leer la letra ingresada por el usuario
         char letra = Character.toLowerCase(scanner.next().charAt(0)); // Convertir a minúscula para evitar problemas de mayúsculas
         boolean letraCorrecta = false;

         // Verificar si la letra adivinada está en la palabra secreta
         for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
               letrasAdivinadas[i] = letra; // Actualizar la letra adivinada en el arreglo
               letraCorrecta = true; // Marcar que la letra fue encontrada
            }
         }

         // Verificar si la letra fue encontrada y actualizar el estado del juegogi
         if (!letraCorrecta) {
            intentos++; // Incrementar el contador de intentos si la letra no está en la palabra
            System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
         } 
         if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
            palabraAdivinada = true; // Si todas las letras han sido adivinadas, marcar la palabra como adivinada
            System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
         } 
      }

      if (!palabraAdivinada) {
         System.out.println("¡Qué pena te has quedado sin intentos! GAME OVER ");
      }
      //Cierre del scanner para liberar recursos
      scanner.close();
   }
}