package com.krakedev.asistencias.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public void agregar(Estudiante estudiante) {
        // Evitar duplicados por cédula
        if (buscarPorCedula(estudiante.getCedula()) == null) {
            estudiantes.add(estudiante);
        }
    }

    public Estudiante buscarPorCedula(String cedula) {
        return estudiantes.stream()
                .filter(e -> e.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    public void eliminar(String cedula) {
        estudiantes.removeIf(e -> e.getCedula().equals(cedula));
    }

    public void actualizar(String cedula, Estudiante nuevo) {
        eliminar(cedula);
        estudiantes.add(nuevo);
    }

    public ArrayList<Estudiante> listar() {
        return estudiantes;
    }
}