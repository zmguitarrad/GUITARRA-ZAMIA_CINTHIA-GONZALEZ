package com.clinica.odontologica.dao;

import com.clinica.odontologica.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2Impl implements OdontologoDAO {

    private static final Logger logger = LogManager.getLogger(OdontologoDAOH2Impl.class);
    private static final String URL = "jdbc:h2:~/odontologos;INIT=RUNSCRIPT FROM 'classpath:schema.sql'";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Error al cargar el driver H2", e);
        }
    }

    @Override
    public void guardar(Odontologo odontologo) {
        String sql = "INSERT INTO odontologos (numero_matricula, nombre, apellido) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            logger.info("Odontólogo guardado en la base de datos: " + odontologo);
        } catch (SQLException e) {
            logger.error("Error al guardar odontólogo en la base de datos", e);
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        String sql = "SELECT * FROM odontologos";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String numeroMatricula = resultSet.getString("numero_matricula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                Odontologo odontologo = new Odontologo(numeroMatricula, nombre, apellido);
                odontologos.add(odontologo);
            }
            logger.info("Listado de odontólogos obtenido de la base de datos");
        } catch (SQLException e) {
            logger.error("Error al listar odontólogos de la base de datos", e);
        }
        return odontologos;
    }
}
