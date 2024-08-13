package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class OdontologoDAOEnMemoriaImplTest {
    private OdontologoDAO odontologoDAO;

    @BeforeEach
    public void setUp() {
        odontologoDAO = new OdontologoDAOEnMemoriaImpl();

        odontologoDAO.guardar(new Odontologo(1234, "Juan", "Pérez"));
        odontologoDAO.guardar(new Odontologo(5678, "Ana", "García"));
    }

    @Test
    public void testListarTodos() {

        List<Odontologo> odontologos = odontologoDAO.listarTodos();

        assertEquals(2, odontologos.size(), "El número de odontólogos debe ser 2");

        assertEquals(1234, odontologos.get(0).getNumeroMatricula(), "Número de matrícula incorrecto en el primer odontólogo");
        assertEquals("Juan", odontologos.get(0).getNombre(), "Nombre incorrecto en el primer odontólogo");
        assertEquals("Pérez", odontologos.get(0).getApellido(), "Apellido incorrecto en el primer odontólogo");

        assertEquals(5678, odontologos.get(1).getNumeroMatricula(), "Número de matrícula incorrecto en el segundo odontólogo");
        assertEquals("Ana", odontologos.get(1).getNombre(), "Nombre incorrecto en el segundo odontólogo");
        assertEquals("García", odontologos.get(1).getApellido(), "Apellido incorrecto en el segundo odontólogo");
    }
}

