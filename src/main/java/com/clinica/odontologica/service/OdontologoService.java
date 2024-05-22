package com.clinica.odontologica.service;

import com.clinica.odontologica.dao.OdontologoDAO;
import com.clinica.odontologica.model.Odontologo;
import java.util.List;

public class OdontologoService {

    private OdontologoDAO odontologoDAO;

    public OdontologoService(OdontologoDAO odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }

    public void guardar(Odontologo odontologo) {
        odontologoDAO.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return odontologoDAO.listarTodos();
    }
}

