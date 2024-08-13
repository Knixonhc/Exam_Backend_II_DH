package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOImpl implements OdontologoDAO {
    private static final Logger logger = LogManager.getLogger(OdontologoDAOImpl.class);
    private static final String URL = "jdbc:h2:~/odontologos_db";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    @Override
    public void guardar(Odontologo odontologo) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO odontologos (numero_matricula, nombre, apellido) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, odontologo.getNumeroMatricula());
                statement.setString(2, odontologo.getNombre());
                statement.setString(3, odontologo.getApellido());
                statement.executeUpdate();
                logger.info("Odontólogo guardado en la base de datos: " + odontologo.getNumeroMatricula() + " - " + odontologo.getNombre() + " " + odontologo.getApellido());
            }
        } catch (SQLException e) {
            logger.error("Error al guardar el odontólogo en la base de datos", e);
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT numero_matricula, nombre, apellido FROM odontologos";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int numeroMatricula = resultSet.getInt("numero_matricula");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    odontologos.add(new Odontologo(numeroMatricula, nombre, apellido));
                }
                logger.info("Odontólogos listados desde la base de datos. Total: " + odontologos.size());
            }
        } catch (SQLException e) {
            logger.error("Error al listar los odontólogos desde la base de datos", e);
        }
        return odontologos;
    }
}

