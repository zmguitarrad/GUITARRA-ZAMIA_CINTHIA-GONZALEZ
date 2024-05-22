package com.clinica.odontologica.dao;

import com.clinica.odontologica.model.Odontologo;
import java.util.List;

public interface OdontologoDAO {
    void guardar(Odontologo odontologo);
    List<Odontologo> listarTodos();
}

