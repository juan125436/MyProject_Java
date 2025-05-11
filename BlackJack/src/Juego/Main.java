package Juego;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Integer> valores = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            valores.add(i);
        }
        int jug1 = 5, jug2 = 5, juego, devolver = 0;
        ArrayList<Integer> mazo = new ArrayList<>();
        ArrayList<Integer> mano1 = new ArrayList<>();
        ArrayList<Integer> mano2 = new ArrayList<>();
        String opcion1, opcion2;
        int pedirX, sumaMano1, sumaMano2;
        boolean encontrar;
        
        // Introducción
        System.out.println("=============================================");
        System.out.println("           ¡Bienvenido a BlackJack!         ");
        System.out.println("=============================================");
        System.out.println("El mazo tiene 11 cartas, del 1 al 10 y el AS");
        System.out.println("Empezará el jugador 1 y luego jugará el jugador 2");
        System.out.println("Ambos jugadores comienzan con 5 de vida.");
        System.out.println("=============================================");
        
        // Elección del objetivo
        System.out.print("Jugador 1, elige el objetivo (17/21/23): ");
        opcion1 = datos.nextLine();
        while (!opcion1.equals("17") && !opcion1.equals("21") && !opcion1.equals("23")) {
            System.out.print("Opción no válida. Elige el objetivo (17/21/23): ");
            opcion1 = datos.nextLine();
        }

        System.out.print("Jugador 2, elige el objetivo (17/21/23): ");
        opcion2 = datos.nextLine();
        while (!opcion2.equals("17") && !opcion2.equals("21") && !opcion2.equals("23")) {
            System.out.print("Opción no válida. Elige el objetivo (17/21/23): ");
            opcion2 = datos.nextLine();
        }

        if (!opcion1.equals(opcion2)) {
            juego = 21;
        } else {
            juego = Integer.parseInt(opcion1);
        }
        
        System.out.println("=============================================");
        System.out.println("¡Objetivo definido! El objetivo es: " + juego);
        System.out.println("=============================================");

        // Ciclo principal del juego
        while (jug1 > 0 && jug2 > 0) {
            System.out.println("\n--- Comienza un nuevo round ---");
            mazo.clear();
            mano1.clear();
            mano2.clear();

            // Llenar el mazo
            int rellenar = 0;
            for (int i = 0; i < 11; i++) {
                rellenar = rand.nextInt(valores.size());
                mazo.add(valores.get(rellenar));
                valores.remove(rellenar);
            }

            sumaMano1 = 0;
            sumaMano2 = 0;

            while (!mazo.isEmpty()) {
                // Jugador 1 toma su acción
                System.out.println("\nAcciones disponibles para Jugador 1:");
                System.out.println("1) Pedir carta  2) Pedir X  3) Devolver carta  4) Desactivar As  5) Robar carta al rival");
                System.out.print("Elige una acción: ");
                opcion1 = datos.nextLine();
                
                if (opcion1.contains("pedir carta")) {
                    mano1.add(mazo.get(0));
                    mazo.remove(0);     
                    System.out.println("¡Carta asignada a Jugador 1!");
                    
                } else if (opcion1.contains("pedir X")) {
                    System.out.print("Digite el valor de la carta que quieres pedir: ");
                    pedirX = datos.nextInt();
                    datos.nextLine();
                    encontrar = false;
                    
                    for (int j = 0; j < mazo.size(); j++) {
                        if (pedirX == mazo.get(j)) {
                            mano1.add(pedirX);  
                            mazo.remove(j);      
                            encontrar = true;   
                            break;
                        }
                    }
        
                    if (!encontrar) {
                        System.out.println("¡Carta no encontrada en el mazo!");
                    } else {
                        System.out.println("¡Carta agregada a tu mano!");
                    }
                
                } else if (opcion1.contains("devolver")) {
                    System.out.println("¿Qué carta quieres devolver? ");
                    devolver = datos.nextInt();
                    datos.nextLine();
                    if (mano1.contains(devolver)) {
                        mano1.remove((Integer) devolver);
                        System.out.println("¡Carta devuelta!");
                    } else {
                        System.out.println("¡No tienes esa carta en tu mano!");
                    }
                } else if (opcion1.contains("desactivar")) {
                    encontrar = false;
                    for (int i = 0; i < mano1.size(); i++) {
                        if (11 == mano1.get(i)) {
                            mano1.set(i, 1);
                            encontrar = true;
                            break;
                        }
                    }
                    if (!encontrar) {
                        System.out.println("No se encontró el As en tu mano.");
                    } else {
                        System.out.println("¡As desactivado correctamente!");
                    }
                } else if (opcion1.contains("robar")) {
                    System.out.println("Elige una carta para robar al rival: ");
                    int cartaRival = datos.nextInt();
                    datos.nextLine();
                    if (mano2.contains(cartaRival)) {
                        mano1.add(cartaRival);
                        mano2.remove((Integer) cartaRival);
                        System.out.println("¡Carta robada exitosamente!");
                    } else {
                        System.out.println("¡El rival no tiene esa carta!");
                    }
                } else {
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    continue;
                }
                
                // Jugador 2 toma su acción
                System.out.println("\nAcciones disponibles para Jugador 2:");
                System.out.println("1) Pedir carta  2) Pedir X  3) Devolver carta  4) Desactivar As  5) Robar carta al rival");
                System.out.print("Elige una acción: ");
                opcion2 = datos.nextLine();
                
                if (opcion2.contains("pedir carta")) {
                    mano2.add(mazo.get(0));
                    mazo.remove(0);     
                    System.out.println("¡Carta asignada a Jugador 2!");
                    
                } else if (opcion2.contains("pedir X")) {
                    System.out.print("Digite el valor de la carta que quieres pedir: ");
                    pedirX = datos.nextInt();
                    datos.nextLine();
                    encontrar = false;
                    
                    for (int j = 0; j < mazo.size(); j++) {
                        if (pedirX == mazo.get(j)) {
                            mano2.add(pedirX);  
                            mazo.remove(j);      
                            encontrar = true;   
                            break;
                        }
                    }
        
                    if (!encontrar) {
                        System.out.println("¡Carta no encontrada en el mazo!");
                    } else {
                        System.out.println("¡Carta agregada a tu mano!");
                    }
                
                } else if (opcion2.contains("devolver")) {
                    System.out.println("¿Qué carta quieres devolver? ");
                    devolver = datos.nextInt();
                    datos.nextLine();
                    if (mano2.contains(devolver)) {
                        mano2.remove((Integer) devolver);
                        System.out.println("¡Carta devuelta!");
                    } else {
                        System.out.println("¡No tienes esa carta en tu mano!");
                    }
                } else if (opcion2.contains("desactivar")) {
                    encontrar = false;
                    for (int i = 0; i < mano2.size(); i++) {
                        if (11 == mano2.get(i)) {
                            mano2.set(i, 1);
                            encontrar = true;
                            break;
                        }
                    }
                    if (!encontrar) {
                        System.out.println("No se encontró el As en tu mano.");
                    } else {
                        System.out.println("¡As desactivado correctamente!");
                    }
                } else if (opcion2.contains("robar")) {
                    System.out.println("Elige una carta para robar al rival: ");
                    int cartaRival = datos.nextInt();
                    datos.nextLine();
                    if (mano1.contains(cartaRival)) {
                        mano2.add(cartaRival);
                        mano1.remove((Integer) cartaRival);
                        System.out.println("¡Carta robada exitosamente!");
                    } else {
                        System.out.println("¡El rival no tiene esa carta!");
                    }
                } else {
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    continue;
                }

                // Calcular y mostrar resultados
                sumaMano1 = 0;
                sumaMano2 = 0;
                for (int i = 0; i < mano1.size(); i++) {
                    sumaMano1 += mano1.get(i);
                }
                for (int i = 0; i < mano2.size(); i++) {
                    sumaMano2 += mano2.get(i);
                }

                // Condiciones de victoria y derrota
                if (sumaMano1 > juego) {
                    System.out.println("\n--- ¡Jugador 1 se pasó del objetivo! ---");
                    System.out.println("Gana Jugador 2\n");
                    jug1--;
                } else if (sumaMano2 > juego) {
                    System.out.println("\n--- ¡Jugador 2 se pasó del objetivo! ---");
                    System.out.println("Gana Jugador 1\n");
                    jug2--;
                }

                if (sumaMano1 <= juego && sumaMano1 > sumaMano2) {
                    System.out.println("\n--- Jugador 1 gana por acercarse más al objetivo ---");
                    System.out.println("Gana Jugador 1\n");
                    jug2--;
                } else if (sumaMano2 <= juego && sumaMano2 > sumaMano1) {
                    System.out.println("\n--- Jugador 2 gana por acercarse más al objetivo ---");
                    System.out.println("Gana Jugador 2\n");
                    jug1--;
                }

                if (mazo.isEmpty()) {
                    break;
                }
            }
        }

        // Resultado final
        if (jug1 == 0) {
            System.out.println("\n--- ¡Jugador 1 ha perdido toda su vida! ---");
            System.out.println("¡Gana Jugador 2!");
        } else {
            System.out.println("\n--- ¡Jugador 2 ha perdido toda su vida! ---");
            System.out.println("¡Gana Jugador 1!");
        }
    }
}
