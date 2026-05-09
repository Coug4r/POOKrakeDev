package com.krakedev.asistencias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import com.krakedev.asistencias.services.ServicioAsistencia;
import com.krakedev.asistencias.services.ServicioEstudiantes;

public class TestServicioAsistencia {

    @Test
    public void testRegistrarAsistenciaEstudianteExistente() {
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        servicioEstudiantes.agregar(new Estudiante("123", "Juan", "Perez"));

        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);
        RegistroAsistencia registro = servicioAsistencia.registrarAsistencia("123");

        assertNotNull(registro);
        assertEquals("P", registro.getAsistencia().getEstado());
        assertEquals("Juan", registro.getEstudiante().getNombre());
    }

    @Test
    public void testRegistrarAsistenciaEstudianteNoExistente() {
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);

        RegistroAsistencia registro = servicioAsistencia.registrarAsistencia("999");
        assertNull(registro);
    }

    @Test
    public void testConsultarAsistencia() {
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        servicioEstudiantes.agregar(new Estudiante("123", "Juan", "Perez"));

        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);
        servicioAsistencia.registrarAsistencia("123");
        servicioAsistencia.registrarAsistencia("123");

        ArrayList<Asistencia> asistencias = servicioAsistencia.consultarAsistencia("123");
        assertEquals(2, asistencias.size());
        assertEquals("P", asistencias.get(0).getEstado());
    }
}
