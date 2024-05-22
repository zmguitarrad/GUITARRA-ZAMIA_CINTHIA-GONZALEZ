package com.clinica.odontologica.dao;

import com.clinica.odontologica.model.Odontologo;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOMemoria implements OdontologoDAO {
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologos;
    }
}
