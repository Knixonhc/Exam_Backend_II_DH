package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOEnMemoriaImpl implements OdontologoDAO {
    private static final Logger logger = LogManager.getLogger(OdontologoDAOEnMemoriaImpl.class);
    private List<Odontologo> odontologos;

    public OdontologoDAOEnMemoriaImpl() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado: " + odontologo.getNumeroMatricula() + " - " + odontologo.getNombre() + " " + odontologo.getApellido());
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listando todos los odontólogos. Total: " + odontologos.size());
        return new ArrayList<>(odontologos);
    }
}

