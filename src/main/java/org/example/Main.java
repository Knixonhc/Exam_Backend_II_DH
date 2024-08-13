package org.example;
import java.util.List;
import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
            //Utilizando H2

            OdontologoDAO odontologoDAO = new OdontologoDAOImpl();

            // Guardando un odontólogo
            Odontologo odontologo = new Odontologo(564515485, "Liliana", "Torres");
            odontologoDAO.guardar(odontologo);

            // Listando todos los odontólogos
            List<Odontologo> odontologos = odontologoDAO.listarTodos();
            for (Odontologo o : odontologos) {
                System.out.println(o.getNumeroMatricula() + " - " + o.getNombre() + " " + o.getApellido());

         */

        /*
            //Colección
        */
            OdontologoDAO odontologoDAO = new OdontologoDAOEnMemoriaImpl();

            // Guardar un odontólogo
            Odontologo odontologo = new Odontologo(1212545, "Kenji", "Herrera");
            odontologoDAO.guardar(odontologo);

            // Listar todos los odontólogos
            List<Odontologo> odontologos = odontologoDAO.listarTodos();
            for (Odontologo o : odontologos) {
                System.out.println(o.getNumeroMatricula() + " - " + o.getNombre() + " " + o.getApellido());
        }
    }
}