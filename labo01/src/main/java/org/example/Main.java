package org.example;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Save this code as Main.java
public class Main {

    static class Artista {

        // Atributos
        private int ID;
        private String Nombre;
        private int Edad;
        private int DiscosVendidos;


        // Constructor/es
        public Artista(int ID, String Nombre, int Edad, int DiscosVendidos) {
            this.ID = ID;
            this.Nombre = Nombre;
            this.Edad = Edad;
            this.DiscosVendidos = DiscosVendidos;
        }

        public Artista() {

        }

        //metodos
        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        // Getter y Setter para Nombre
        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        // Getter y Setter para Edad
        public int getEdad() {
            return Edad;
        }

        public void setEdad(int Edad) {
            this.Edad = Edad;
        }

        // Getter y Setter para DiscosVendidos
        public int getDiscosVendidos() {
            return DiscosVendidos;
        }

        public void setDiscosVendidos(int DiscosVendidos) {
            this.DiscosVendidos = DiscosVendidos;
        }

        public Disco obtenerDiscoMasVendido(List<Disco> discos) {
            return discos.stream()
                    .filter(d -> d.getArtista().equals(this))
                    .max(Comparator.comparing(Disco::getVentasTotales))
                    .orElse(null);
        }

        @Override
        public String toString() {
            return "Artista :" +
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
        Disco disco1 = new Disco(artista1, "Romance", 500000);
        Disco disco2 = new Disco(artista2, "Fijacion Oral Vol. 1", 700000);
        Disco disco3 = new Disco(artista1, "Aries", 300000);

    }
}