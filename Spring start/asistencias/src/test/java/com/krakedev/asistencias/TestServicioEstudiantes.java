package com.krakedev.asistencias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.services.ServicioEstudiantes;

public class TestServicioEstudiantes {

    @Test
    public void testAgregarYBuscar() {
        ServicioEstudiantes servicio = new ServicioEstudiantes();
        Estudiante e1 = new Estudiante("123", "Juan", "Perez");
        servicio.agregar(e1);

        Estudiante resultado = servicio.buscarPorCedula("123");
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    public void testEvitarDuplicados() {
        ServicioEstudiantes servicio = new ServicioEstudiantes();
        Estudiante e1 = new Estudiante("123", "Juan", "Perez");
        Estudiante e2 = new Estudiante("123", "Carlos", "Lopez");

        servicio.agregar(e1);
        servicio.agregar(e2); // no debe agregar duplicado

        ArrayList<Estudiante> lista = servicio.listar();
        assertEquals(1, lista.size());
    }

    @Test
    public void testEliminar() {
        ServicioEstudiantes servicio = new ServicioEstudiantes();
        servicio.agregar(new Estudiante("123", "Juan", "Perez"));
        servicio.eliminar("123");

        assertNull(servicio.buscarPorCedula("123"));
    }

    @Test
    public void testActualizar() {
        ServicioEstudiantes servicio = new ServicioEstudiantes();
        servicio.agregar(new Estudiante("123", "Juan", "Perez"));

        Estudiante nuevo = new Estudiante("123", "Carlos", "Lopez");
        servicio.actualizar("123", nuevo);

        Estudiante actualizado = servicio.buscarPorCedula("123");
        assertEquals("Carlos", actualizado.getNombre());
    }

    @Test
    public void testListar() {
        ServicioEstudiantes servicio = new ServicioEstudiantes();
        servicio.agregar(new Estudiante("111", "Ana", "Diaz"));
        servicio.agregar(new Estudiante("222", "Luis", "Mora"));

        ArrayList<Estudiante> lista = servicio.listar();
        assertEquals(2, lista.size());
    }
}
