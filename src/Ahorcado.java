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

      //Estructura de control iterativa para inicializar el arreglo de letras adivinadas
      // y mostrar el estado inicial del juego.
      //Bucle for para recorrer cada letra de la palabra secreta
      for (int i = 0; i < letrasAdivinadas.length; i++) {
         letrasAdivinadas[i] = '_'; // Inicializar con guiones bajos
         System.out.println(letrasAdivinadas[i]);
      }
    
     //Estructura de control iterativa (bucle while) para permitir al usuario adivinar letras
     while (!palabraAdivinada && intentos < intentosMaximos) {
         // Esto se usa para mostrar el estado actual de las letras adivinadas
         System.out.println("Palabra a adivinar "  + String.valueOf(letrasAdivinadas) + " (" +palabraSecreta.length() + " letras)");

         System.out.println("Introduce una letra, por favor:");
         // Leer la letra ingresada por el usuario
         char letra = Character.toLowerCase(scanner.next().charAt(0)); // Convertir a minúscula para evitar problemas de mayúsculas
         boolean letraCorrecta = false;

         //Estructura de control iterativa para verificar si la letra adivinada está en la palabra secreta
         for (int i = 0; i < palabraSecreta.length(); i++) {
            //Estructura de control condicional para comparar la letra ingresada con cada letra de la palabra secreta
            if (palabraSecreta.charAt(i) == letra) {
               letrasAdivinadas[i] = letra; // Actualizar la letra adivinada en el arreglo
               letraCorrecta= true; // Marcar que la letra fue encontrada
            }
         }

         //Verificar si la letra fue encontrada y actualizar el estado del juego
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
         //Cierre del scanner para liberar recursos
         scanner.close();
      
     }
   }

   }

