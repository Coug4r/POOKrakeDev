package com.krakedev.clientes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

public class TestServiciosCliente {

    @Test
    public void testBuscarPorCedulaExistente() {
        ServicioCliente servicio = new ServicioCliente();
        Cliente c1 = new Cliente();
        c1.setCedula("0101");
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        c1.setEmail("juan@correo.com");
        servicio.crear(c1);

        Cliente resultado = servicio.buscarPorCedula("0101");
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
        assertEquals("Perez", resultado.getApellido());
        assertEquals("juan@correo.com", resultado.getEmail());
    }

    @Test
    public void testBuscarPorCedulaNoExistente() {
        ServicioCliente servicio = new ServicioCliente();
        assertNull(servicio.buscarPorCedula("9999"));
    }

    @Test
    public void testCrearClienteNuevo() {
        ServicioCliente servicio = new ServicioCliente();
        Cliente nuevo = new Cliente();
        nuevo.setCedula("0303");
        nuevo.setNombre("Carlos");
        nuevo.setApellido("Ramirez");
        nuevo.setEmail("carlos@correo.com");

        Cliente resultado = servicio.crear(nuevo);
        assertNotNull(resultado);
        assertEquals("0303", resultado.getCedula());

        List<Cliente> lista = servicio.listar();
        assertEquals(1, lista.size());
        Cliente guardado = servicio.buscarPorCedula("0303");
        assertNotNull(guardado);
        assertEquals("Carlos", guardado.getNombre());
        assertEquals("Ramirez", guardado.getApellido());
        assertEquals("carlos@correo.com", guardado.getEmail());
    }

    @Test
    public void testCrearClienteDuplicado() {
        ServicioCliente servicio = new ServicioCliente();
        Cliente c1 = new Cliente();
        c1.setCedula("0101");
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        c1.setEmail("juan@correo.com");
        servicio.crear(c1);

        Cliente duplicado = new Cliente();
        duplicado.setCedula("0101");
        duplicado.setNombre("Juan");
        duplicado.setApellido("Perez");
        duplicado.setEmail("juan@correo.com");

        Cliente resultado = servicio.crear(duplicado);
        assertNull(resultado);
        assertEquals(1, servicio.listar().size());
    }

    @Test
    public void testListarClientes() {
        ServicioCliente servicio = new ServicioCliente();
        Cliente c1 = new Cliente();
        c1.setCedula("0101");
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        c1.setEmail("juan@correo.com");

        Cliente c2 = new Cliente();
        c2.setCedula("0202");
        c2.setNombre("Maria");
        c2.setApellido("Lopez");
        c2.setEmail("maria@correo.com");

        servicio.crear(c1);
        servicio.crear(c2);

        List<Cliente> lista = servicio.listar();
        assertEquals(2, lista.size());

        assertNotNull(servicio.buscarPorCedula("0101"));
        assertNotNull(servicio.buscarPorCedula("0202"));
    }

    @Test
    public void testActualizarClienteExistente() {
        ServicioCliente servicio = new ServicioCliente();
        Cliente c1 = new Cliente();
        c1.setCedula("0101");
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        c1.setEmail("juan@correo.com");
        servicio.crear(c1);

        Cliente actualizado = new Cliente();
        actualizado.setCedula("0101");
        actualizado.setNombre("Pedro");
        actualizado.setApellido("Gomez");
        actualizado.setEmail("pedro@correo.com");

        Cliente resultado = servicio.actualizar("0101", actualizado);
        assertNotNull(resultado);
        assertEquals("Pedro", resultado.getNombre());
        assertEquals("Gomez", resultado.getApellido());
        assertEquals("pedro@correo.com", resultado.getEmail());
        assertEquals("0101", resultado.getCedula());
    }

    @Test
    public void testActualizarClienteNoExistente() {
        ServicioCliente servicio = new ServicioCliente();
        Cliente actualizado = new Cliente();
        actualizado.setCedula("9999");
        actualizado.setNombre("Luis");
        actualizado.setApellido("Martinez");
        actualizado.setEmail("luis@correo.com");

        Cliente resultado = servicio.actualizar("9999", actualizado);
        assertNull(resultado);
    }

    @Test
    public void testEliminarClienteExistente() {
        ServicioCliente servicio = new ServicioCliente();
        Cliente c1 = new Cliente();
        c1.setCedula("0202");
        c1.setNombre("Maria");
        c1.setApellido("Lopez");
        c1.setEmail("maria@correo.com");
        servicio.crear(c1);

        boolean eliminado = servicio.eliminar("0202");
        assertTrue(eliminado);
        assertNull(servicio.buscarPorCedula("0202"));
        assertEquals(0, servicio.listar().size());
    }

    @Test
    public void testEliminarClienteNoExistente() {
        ServicioCliente servicio = new ServicioCliente();
        boolean eliminado = servicio.eliminar("9999");
        assertFalse(eliminado);
        assertEquals(0, servicio.listar().size());
    }
}
