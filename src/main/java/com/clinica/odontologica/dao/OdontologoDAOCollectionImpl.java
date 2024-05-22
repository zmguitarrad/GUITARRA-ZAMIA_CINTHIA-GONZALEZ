package com.clinica.odontologica.dao;

import com.clinica.odontologica.model.Odontologo;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOCollectionImpl implements OdontologoDAO {

    private List<Odontologo> odontologos;

    public OdontologoDAOCollectionImpl() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return new ArrayList<>(odontologos);
    }
}
