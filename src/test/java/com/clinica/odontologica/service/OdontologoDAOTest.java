package com.clinica.odontologica.service;

import com.clinica.odontologica.dao.OdontologoDAO;
import com.clinica.odontologica.dao.OdontologoDAOCollectionImpl;
import com.clinica.odontologica.model.Odontologo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoDAOTest {

    private OdontologoDAO odontologoDAO;

    @BeforeEach
    public void setUp() {
        odontologoDAO = new OdontologoDAOImpl();
    }

    @AfterEach
    public void tearDown() {    }

    @Test
    public void testGuardarYListarOdontologos() {
        // Crear y guardar algunos odontólogos
        Odontologo odontologo1 = new Odontologo();
        odontologo1.setNumeroMatricula("123456");
        odontologo1.setNombre("Juan");
        odontologo1.setApellido("Perez");

        Odontologo odontologo2 = new Odontologo();
        odontologo2.setNumeroMatricula("654321");
        odontologo2.setNombre("Maria");
        odontologo2.setApellido("Gomez");

        odontologoDAO.guardar(odontologo1);
        odontologoDAO.guardar(odontologo2);

   
        List<Odontologo> odontologos = odontologoDAO.listarTodos();

        // Verificar el tamaño de la lista
        assertEquals(2, odontologos.size());

        // Verificar los detalles de los odontólogos
        assertEquals("Juan", odontologos.get(0).getNombre());
        assertEquals("Perez", odontologos.get(0).getApellido());
        assertEquals("Maria", odontologos.get(1).getNombre());
        assertEquals("Gomez", odontologos.get(1).getApellido());
    }
}
