package org.example;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Save this code as Main.java
public class Main {

    static class Artista {
        private static List<Artista> artistasRegistrados = new ArrayList<>(); // Lista global de artistas

        private int ID;
        private String Nombre;
        private int Edad;
        private int DiscosVendidos;

        public Artista(int ID, String Nombre, int Edad, int DiscosVendidos) {
            this.ID = ID;
            this.Nombre = Nombre;
            this.Edad = Edad;
            this.DiscosVendidos = DiscosVendidos;
            artistasRegistrados.add(this); // Agregar el artista a la lista automáticamente
        }

        // Constructor vacío, por si fuera necesario
        public Artista() {}

        // Metodo estático para obtener la lista de artistas registrados
        public static List<Artista> getArtistasRegistrados() {
            return artistasRegistrados;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public int getEdad() {
            return Edad;
        }

        public void setEdad(int Edad) {
            this.Edad = Edad;
        }

        public int getDiscosVendidos() {
            return DiscosVendidos;
        }

        public void setDiscosVendidos(int DiscosVendidos) {
            this.DiscosVendidos = DiscosVendidos;
        }

        @Override
        public String toString() {
            return "Artista:" +
                    "ID=" + ID +
                    ", Nombre='" + Nombre + '\'' +
                    ", Edad=" + Edad +
                    ", DiscosVendidos=" + DiscosVendidos;
        }


    }
    static class Disco {
        private static List<Disco> discosRegistrados = new ArrayList<>(); // Lista global de discos

        private Artista artista;
        private String titulo;
        private int ventasTotales;

        public Disco(Artista artista, String titulo, int ventasTotales) {
            this.artista = artista;
            this.titulo = titulo;
            this.ventasTotales = ventasTotales;

            // Registrar este disco en la lista
            discosRegistrados.add(this);
        }


        // Getters y Setters
        public static List<Disco> getDiscosRegistrados() {
            return discosRegistrados;
        }

        public Artista getArtista() {
            return artista;
        }

        public void setArtista(Artista artista) {
            this.artista = artista;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public int getVentasTotales() {
            return ventasTotales;
        }

        public void setVentasTotales(int ventasTotales) {
            this.ventasTotales = ventasTotales;
        }

        public void registrarVentas(int cantidad) {
            this.ventasTotales += cantidad;
            artista.setDiscosVendidos(artista.getDiscosVendidos() + cantidad);
        }

        @Override
        public String toString() {
            return "Disco :" +
                    "Artista='" + artista.getNombre() + '\'' +
                    ", Titulo='" + titulo + '\'' +
                    ", VentasTotales=" + ventasTotales;
        }
    }

    public static void main(String[] args) {

        // Crear artistas
        Artista artista1 = new Artista(1, "Luis Miguel", 50, 0);
        Artista artista2 = new Artista(2, "Shakira", 47, 0);

        // Crear discos
        Disco disco1 = new Disco(artista1, "Romance", 0);
        Disco disco2 = new Disco(artista2, "Fijacion Oral Vol. 1", 0);
        Disco disco3 = new Disco(artista1, "Aries", 0);

        Scanner scanner = new Scanner(System.in);
        List<Artista> artistas = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar Artista");
            System.out.println("2. Registrar Disco");
            System.out.println("3. Ver Artistas");
            System.out.println("4. Ver Discos");
            System.out.println("5. Registrar Ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el ID del artista: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingrese el nombre del artista: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad del artista: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el total de discos vendidos: ");
                    int discosVendidos = scanner.nextInt();
                    new Artista(id, nombre, edad, discosVendidos); // Se agrega automáticamente a la lista
                    System.out.println("¡Artista registrado exitosamente!");
                }


                case 2 -> {
                    System.out.println("Seleccione un artista por ID:");
                    artistas = Artista.getArtistasRegistrados(); // Lista global
                    artistas.forEach(a -> System.out.println(a.getID() + ": " + a.getNombre()));

                    System.out.print("ID del artista: ");
                    int idArtista = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea

                    Artista artista = artistas.stream()
                            .filter(a -> a.getID() == idArtista)
                            .findFirst()
                            .orElse(null);

                    if (artista == null) {
                        System.out.println("Artista no encontrado.");
                        break;
                    }

                    System.out.print("Ingrese el título del disco: ");
                    String titulo = scanner.nextLine();
                    int ventas = 0;
                    new Disco(artista, titulo, ventas);
                    System.out.println("¡Disco registrado exitosamente!");
                }


                case 3 -> {
                    System.out.println("\n--- Lista de Artistas ---");
                    List<Artista> artistasRegistrados = Artista.getArtistasRegistrados(); // Obtener la lista desde la clase
                    if (artistasRegistrados.isEmpty()) {
                        System.out.println("No hay artistas registrados.");
                    } else {
                        artistasRegistrados.forEach(System.out::println);
                    }
                }


                case 4 -> {
                    System.out.println("\n--- Lista de Discos ---");
                    List<Disco> discos = Disco.getDiscosRegistrados();
                    if (discos.isEmpty()) {
                        System.out.println("No hay discos registrados.");
                    } else {
                        discos.forEach(System.out::println);
                    }
                }

                case 5 -> {
                    System.out.println("Seleccione un disco por título:");
                    Disco.getDiscosRegistrados().forEach(d -> System.out.println(d.getTitulo()));
                    System.out.print("Título del disco: ");
                    String titulo = scanner.nextLine();
                    Disco disco = Disco.getDiscosRegistrados().stream()
                            .filter(d -> d.getTitulo().equalsIgnoreCase(titulo))
                            .findFirst()
                            .orElse(null);
                    if (disco == null) {
                        System.out.println("Disco no encontrado.");
                        break;
                    }
                    System.out.print("Ingrese la cantidad de ventas a registrar: ");
                    int cantidad = scanner.nextInt();
                    disco.registrarVentas(cantidad);
                    System.out.println("¡Ventas registradas exitosamente!");
                }

                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 0);

    }
}