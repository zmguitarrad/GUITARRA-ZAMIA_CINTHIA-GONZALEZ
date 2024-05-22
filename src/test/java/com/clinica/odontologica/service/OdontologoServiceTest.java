package com.clinica.odontologica.service;

import com.clinica.odontologica.dao.OdontologoDAO;
import com.clinica.odontologica.dao.OdontologoDAOCollectionImpl;
import com.clinica.odontologica.model.Odontologo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OdontologoServiceTest {

    private OdontologoService odontologoService;

    @Before
    public void setUp() {
        OdontologoDAO odontologoDAO = new OdontologoDAOCollectionImpl();
        odontologoService = new OdontologoService(odontologoDAO);
    }

    @Test
    public void testGuardarYListarOdontologos() {
        Odontologo odontologo1 = new Odontologo("12345", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo("67890", "Maria", "Gomez");

        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        List<Odontologo> odontologos = odontologoService.listarTodos();
        assertEquals(2, odontologos.size());
        assertEquals("Juan", odontologos.get(0).getNombre());
        assertEquals("Maria", odontologos.get(1).getNombre());
    }
}


