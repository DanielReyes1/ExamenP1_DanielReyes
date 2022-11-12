
package examen1p1_danielreyes;

import java.util.Scanner;
import java.util.Random;

public class Examen1P1_DanielReyes {

 static Scanner leer = new Scanner(System.in);
 
    public static void main(String[] args) {
        
        int resp;
        do{
            System.out.println("-------Menu-------");
            System.out.println("1- Divisores primos");
            System.out.println("2- Contorno de Pirámide");
            System.out.println("3- Vecinos");
            System.out.println("4- Salir del sistema");
            System.out.println("Ingrese una opción: ");
            resp = leer.nextInt();
            
            switch (resp){
                case 1: 
                    System.out.println("Ha elegido la primera opción");
                    System.out.println("Inserte un número entero: ");
                    int N = leer.nextInt();
                    if (N >= 1){
                        System.out.println("Los números primos que dividen el número "+ N+ " son: "+ primos(N));
                    }
                    else{
                        System.out.println("Su número debe ser mayor a 0");
                    }
                       
                    break;
                    
                case 2:
                    System.out.println("Ha elegido la segunda opción");
                    System.out.println("Ingrese un tamaño: ");
                    int num = leer.nextInt();
                    contorno (num);
                    break;
                    
                case 3:
                    System.out.println("Ha elegido la tercera opción");
                    System.out.println("Ingrese una cadena: ");
                    String cadena = leer.nextLine();
                    cadena = leer.nextLine();
                    
                    System.out.println(""+ vecinos(cadena));
                    break;
                    
            }// switch
        }while (resp != 4);// do while
        
    }// main
    
    public static String primos(int N){
        String prime = "1 ";
        int factor = 0, cont = 0;
        for (int i = 1; i <= N; i++){
            if (N % i == 0){  // si i es residuo de N significa que es factor
                factor = i;
                
                for (int j = factor; j > 0; j--){
                    if (factor % j == 0){
                        cont++;
                    }//if
                }//for para verificar si el factor es un primo 
                if (cont == 2){
                    prime += factor + " ";
                }// si el contador es 2 es porque el factor es un numero primo     
            }// if para separar el factor
            cont= 0;
        }// for 
           return prime;
        
    }// public static String
    
    public static void contorno(int num){
        int num1=0;
        int num3=(num-1)/2;
        
        if (num%2 == 0){
            System.out.println("Debe ingresar un número impar");
        }
        else{
            num1 = (num+1) / 2;
            
            for (int f = 0; f < num1; f++){
                for (int e = 0; e < num; e++){
                    if(f==num3-1 && e>0 && e <num-1){
                        System.out.print("+");
                    }
                    else if((e==num3-f||e==num3+f) &&f!=num1-1){
                        System.out.print("+");
                    }else if((e<num3-f||e>num3+f) || f==num1-1){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                    
                }// for menor
                System.out.println("");
             
            }// for que imprime nueva linea
        }// else
        
        // System.out.println("");
    }// public static void
    
    public static String vecinos(String cadena){
      String newcadena= " ";
      Random aleatorio = new Random();
      int r = aleatorio.nextInt(2) + 0;
      int cont = 0;
      for (int i = 65; i <= 90; i++){
          for (int k = 0; k < cadena.length(); k++){
            char a = cadena.charAt(k);
                if (a == i|| a == 32){
                    cont++;                             // contador para despues sumar otro contador
                }
        }// for 2
      }// for 
      for (int i = 97; i <= 122; i++){
          for (int k = 0; k < cadena.length(); k++){
            char a = cadena.charAt(k);
            if (a == i ){
                cont++;
            }
          }//for 2
      }//for
      if (cont == cadena.length()){
          if (r == 0){
             newcadena = cadena; 
          }
          else if (r == 1){
             newcadena = cadena;
          }
      }// se valida la cadena tiene unicamente letras o espacios
      else{
          newcadena = "Tiene otros caracteres";
      }// la cadena tiene otros caracteres
        return newcadena;
    }//public static String 2
    
}// public class