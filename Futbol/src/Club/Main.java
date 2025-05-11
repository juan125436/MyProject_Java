package Club;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner datos = new Scanner(System.in); // Para capturar datos del usuario
    static Random rand = new Random(); // Para generar números aleatorios
    static ArrayList<Persona> personas = new ArrayList<>(); // Lista de personas (jugadores, entrenador, médico)
    static ArrayList<String> equipos = new ArrayList<>(); // Lista de equipos contrincantes
    static boolean jugar = true; // Si se puede jugar o no el partido
    static boolean entrenamiento = false; // Si el equipo ya ha entrenado o no
    static boolean lesionado = false; // Si hay algún jugador lesionado
    static boolean viaje = false; // Si el equipo ha viajado para el partido

    public static void main(String[] args) {
        club(); // Inicializa los datos del club
        equipos(); // Inicializa la lista de equipos
        menu(); // Muestra el menú para interactuar con el programa
    }

    // Método que agrega equipos a la lista de equipos
    public static void equipos() {
        equipos.add("Audax italiano");
        equipos.add("Palestino");
        equipos.add("Colo Colo");
        equipos.add("U de chile");
        equipos.add("Catolica");
        equipos.add("Everton");
        equipos.add("Cobresal");
    }

    // Método que crea los miembros del club (entrenador, jugadores y médico)
    public static void club() {
        Entrenador sierra = new Entrenador("Presion ofensiva", "Jose luis", "Sierra", 48);
        personas.add(sierra);
        Futbolista fTogna = new Futbolista(1, "POR", "Franco", "Tognascholi", 33, false);
        personas.add(fTogna);
        Futbolista nDiaz = new Futbolista(2, "DFC", "Nicolas", "Diaz", 25, false);
        personas.add(nDiaz);
        Futbolista vVidal = new Futbolista(3, "DFC", "Valentin", "Vidal", 20, false);
        personas.add(vVidal);
        Futbolista gNorambuena = new Futbolista(18, "LI", "Gabriel", "Norambuena", 20, false);
        personas.add(gNorambuena);
        Futbolista sRamirez = new Futbolista(16, "LD", "Simon", "Ramirez", 24, false);
        personas.add(sRamirez);
        Futbolista bJauregui = new Futbolista(6, "MCD", "Bruno", "Jauregui", 21, false);
        personas.add(bJauregui);
        Futbolista aNadruz = new Futbolista(5, "MCD", "Agustin", "Nadruz", 28, false);
        personas.add(aNadruz);
        Futbolista aUribe = new Futbolista(10, "MCO", "Ariel", "Uribe", 26, false);
        personas.add(aUribe);
        Futbolista pAranguiz = new Futbolista(8, "MCO", "Pablo", "Aranguiz", 27, false);
        personas.add(pAranguiz);
        Futbolista iJeraldino = new Futbolista(19, "DC", "Ignacio", "Jeraldino", 28, false);
        personas.add(iJeraldino);
        Futbolista mSuarez = new Futbolista(9, "DC", "Matias", "Suarez", 37, false);
        personas.add(mSuarez);
        Doctor juancito = new Doctor("Medicina General", 6, "Juan", "Correa", 31);
        personas.add(juancito);
    }

    // Método que muestra el menú y permite al usuario elegir una opción
    public static void menu() {
        int opcion;
        System.out.println("Eres el gerente deportivo del Club Union española");
        System.out.println("A continuación, le presentaremos el menú de opciones ");
        while (true) {
            System.out.println("1.Viaje de equipo\n"
                    + "2.Entrenamiento\n"
                    + "3.Partido de fútbol\n"
                    + "4.Planificar entrenamiento\n"
                    + "5.Entrevista\n"
                    + "6.Curar lesión\n"
                    + "7.Salir");
            System.out.print("Elige opción: ");
            opcion = datos.nextInt();
            while (opcion < 1 || opcion > 7) {
                System.out.print("Elige opción: ");
                opcion = datos.nextInt();
            }
            switch (opcion) {
                case 1:
                    viaje(); // Opción para hacer un viaje con el equipo
                    break;
                case 2:
                    entrenamiento(); // Opción para hacer un entrenamiento
                    break;
                case 3:
                    partido(); // Opción para jugar un partido
                    break;
                case 4:
                    planificar(); // Opción para planificar un entrenamiento específico
                    break;
                case 5:
                    entrevista(); // Opción para ver una entrevista con el entrenador
                    break;
                case 6:
                    curar(); // Opción para curar una lesión
                    break;
                case 7:
                    System.exit(0); // Sale del programa
                default:
                    break;
            }
        }
    }

    // Método que simula el viaje del equipo a un partido
    public static void viaje() {
        if (!jugar) {
            System.out.println("\nJuegue su partido\n");
            return;
        }
        if (!equipos.isEmpty()) {
            int indice = rand.nextInt(equipos.size()); // Selecciona un equipo aleatorio
            System.out.println("\nVas a jugar contra " + equipos.get(indice) + "\n");
            equipos.remove(indice); // Elimina el equipo de la lista de contrincantes
            jugar = false;
            viaje = true;
        } else {
            System.out.println("\nTerminó la temporada\n");
            System.exit(0); // Termina el programa si ya no hay equipos
        }
    }

    // Método que simula el partido de fútbol
    public static void partido() {
        if (lesionado) {
            System.out.println("Jugador lesionado en plantilla, debe curarlo");
            return;
        }
        if (!viaje) {
            System.out.println("\nDebe viajar\n");
            return;
        } else {
            System.out.println("Viaje listo");
        }
        if (!entrenamiento) {
            System.out.println("\nDebe entrenar a los jugadores\n");
            return;
        }
        if (!jugar) {
            System.out.println("\nSe jugó el partido\n");
            jugar = true;
            entrenamiento = false;
            viaje = false;
        }
    }

    // Método que simula el entrenamiento del equipo
    public static void entrenamiento() {
        if (lesionado) {
            System.out.println("Jugador lesionado en plantilla, debe curarlo");
            return;
        }
        int probabilidad = rand.nextInt(110); // Genera una probabilidad de lesión
        if (!entrenamiento) {
            System.out.println("\nEntrenamiento listo\n");
            entrenamiento = true;
        } else {
            System.out.println("\nYa entrenó a su club \n");
        }
        if (probabilidad >= 100) {
            for (int i = 0; i < personas.size(); i++) {
                int indice = rand.nextInt(12);
                Persona persona = personas.get(indice);
                if (persona instanceof Futbolista) {
                    Futbolista futbolista = (Futbolista) persona;
                    futbolista.setLesion(true); // Lesiona al jugador aleatoriamente
                    lesionado = true;
                    System.out.println("Se lesionó: " + futbolista.getNombre() + " Su posición es: " + futbolista.getPosicion());
                }
            }
        }
    }

    // Método que planifica un entrenamiento específico
    public static void planificar() {
        if (lesionado) {
            System.out.println("Jugador lesionado en plantilla, debe curarlo");
        }
        if (entrenamiento) {
            System.out.println("\nYa ha completado su entrenamiento\n");
            return;
        }
        System.out.print("\nEsta opción es para planificar un entrenamiento específico"
                + "\n1.Táctico"
                + "\n2.Físico"
                + "\n3.Técnico"
                + "\nAl usar esto las lesiones podrían aumentar al sobreesforzar al equipo"
                + "¿Desea continuar? s/n ");
        datos.nextLine();
        String opcion = datos.nextLine().toLowerCase();
        while (!opcion.equals("s") && !opcion.equals("n")) {
            System.out.println("Elige bien: ");
            opcion = datos.nextLine().toLowerCase();
        }
        if (opcion.equals("n")) {
            return;
        }
        System.out.println("Elija 1.Táctico 2.Físico 3.Técnico \nOpción: ");
        opcion = datos.nextLine().toLowerCase();
        while (!opcion.equals("tactico") && !opcion.equals("fisico") && !opcion.equals("tecnico")) {
            System.out.print("Elija 1.Táctico 2.Físico 3.Técnico \nOpción: ");
            opcion = datos.nextLine().toLowerCase();
        }
        System.out.println("Se ha planificado su entrenamiento\n");
        int probabilidad = rand.nextInt(101);
        if (probabilidad >= 77) { // Si hay una alta probabilidad, se genera una lesión
            for (int i = 0; i < personas.size(); i++) {
                int indice = rand.nextInt(12);
                Persona persona = personas.get(indice);
                if (persona instanceof Futbolista) {
                    Futbolista futbolista = (Futbolista) persona;
                    futbolista.setLesion(true); // Lesiona al jugador aleatoriamente
                    lesionado = true;
                    System.out.println("Se lesionó: " + futbolista.getNombre() + " Su posición es: " + futbolista.getPosicion());
                }
            }
        }
    }

    // Método que muestra una entrevista con el entrenador
    public static void entrevista() {
        System.out.println("\nEsta opción muestra la entrevista que le hacen al entrenador luego del partido\n");
        if (!jugar) {
            System.out.println("Juegue el partido");
            return;
        }
        System.out.println("Periodista: ¿Del 1 al 10 qué puntuación le das al juego?");
        int puntuacion = rand.nextInt(11);
        System.out.println("DT: Le doy un: " + puntuacion);
        System.out.println("Periodista: ¿Estás satisfecho con el juego?");
        if (puntuacion > 6) {
            System.out.println("DT: Sí, jugaron bien.");
        } else {
            System.out.println("DT: No, no me gustó");
        }
        System.out.println("Periodista: Muchas gracias por responder, suerte en su próximo encuentro");
        System.out.println("DT: Vale.");
    }

    // Método que cura a los jugadores lesionados
    public static void curar() {
        if (!lesionado) {
            System.out.println("No hay jugador lesionado");
            return;
        }
    
        // Iteramos sobre el ArrayList de personas
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
    
            // Verificamos si la persona es un Futbolista
            if (persona instanceof Futbolista) {
                Futbolista futbolista = (Futbolista) persona; // Hacemos el casteo a Futbolista
                if (futbolista.getLesion()) {
                    // Si está lesionado, lo curamos
                    futbolista.setLesion(false);
                    System.out.println("Se curó al futbolista: " + futbolista.getNombre() + " de la posición: " + futbolista.getPosicion());
                    lesionado = false; // Actualizamos la variable de estado
                    return; // Solo curamos el primer futbolista lesionado
                }
            }
        }
    }
}
