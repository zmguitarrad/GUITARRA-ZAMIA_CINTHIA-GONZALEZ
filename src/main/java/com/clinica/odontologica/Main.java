package com.clinica.odontologica;

import com.clinica.odontologica.model.Odontologo;

public class Main {
    public static void main(String[] args) {
        Odontologo odontologo = new Odontologo("12345", "Juan", "Perez");
        System.out.println(odontologo);
    }
}
