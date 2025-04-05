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
        private String DiscoMasVendido;
        private int DiscosVendidos;


        // Constructor/es
        public Artista(int ID, String Nombre, int Edad, String DiscoMasVendido, int DiscosVendidos) {
            this.ID = ID;
            this.Nombre = Nombre;
            this.DiscoMasVendido = DiscoMasVendido;
            this.Edad = Edad;
            this.DiscosVendidos =DiscosVendidos;
        }
        public Artista() {
            // Constructor por defecto sin inicializar los atributos
        }

        // Métodos (comportamiento de la clase)
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

        // Getter y Setter para DiscoMasVendido
        public String getDiscoMasVendido() {
            return DiscoMasVendido;
        }

        public void setDiscoMasVendido(String DiscoMasVendido) {
            this.DiscoMasVendido = DiscoMasVendido;
        }

        // Getter y Setter para DiscosVendidos
        public int getDiscosVendidos() {
            return DiscosVendidos;
        }

        public void setDiscosVendidos(int DiscosVendidos) {
            this.DiscosVendidos = DiscosVendidos;
        }

        public String toString() {
            return "Artista {" +
                    "ID=" + ID +
                    ", Nombre='" + Nombre + '\'' +
                    ", Edad=" + Edad +
                    ", DiscoMásVendido='" + DiscoMasVendido + '\'' +
                    ", DiscosVendidos=" + DiscosVendidos +
                    '}';
        }

    }
    public static void main(String[] args) {

        Artista artista = new Artista();

        // Configurar los atributos usando setters
        artista.setID(1);
        artista.setNombre("Luis Miguel");
        artista.setEdad(50);
        artista.setDiscoMasVendido("Romance");
        artista.setDiscosVendidos(1000000);

        // Imprimir el objeto usando toString
        System.out.println(artista); // Se llamará al método toString automáticamente



    }
}