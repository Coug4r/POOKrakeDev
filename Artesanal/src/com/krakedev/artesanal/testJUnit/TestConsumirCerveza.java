package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.*;

import java.util.ArrayList;

public class TestConsumirCerveza {

    @Test
    public void testConsumirCervezaClienteYMaquinaActualizados() {
        NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());

        // Registrar cliente
        negocio.registrarCliente("David", "123456789");
        Cliente cliente = negocio.getClientes().get(0);
        int codigoCliente = cliente.getCodigo();

        // Agregar máquina
        negocio.agregarMaquina("Cerveza Club", "Fria", 0.2);
        Maquina maquina = negocio.getMaquinas().get(0);
        String codigoMaquina = maquina.getCodigo();

        // Llenar máquina
        maquina.llenarMaquina();
        double cantidadInicial = maquina.getCantidadActual();

        // Consumir cerveza
        double valor = negocio.consumirCerveza(codigoCliente, codigoMaquina, 100);

        // Validar retorno
        assertTrue(valor > 0, "El valor retornado debe ser mayor a 0");

        // Cliente actualizado
        assertEquals(valor, cliente.getTotalConsumido(),
            "El cliente debe acumular el valor consumido");

        // Máquina afectada
        assertEquals(cantidadInicial - 100, maquina.getCantidadActual(),
            "La máquina debe haber disminuido su cantidad en 100 ml");
    }

    @Test
    public void testConsumirCervezaClienteNoExistente() {
        NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());
        negocio.agregarMaquina("Pilsener", "Rubia", 0.3);
        Maquina maquina = negocio.getMaquinas().get(0);
        maquina.llenarMaquina();

        assertThrows(IllegalArgumentException.class, () -> {
            negocio.consumirCerveza(9999, maquina.getCodigo(), 50);
        });
    }

    @Test
    public void testConsumirCervezaMaquinaNoExistente() {
        NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());
        negocio.registrarCliente("Juan", "987654321");
        Cliente cliente = negocio.getClientes().get(0);

        assertThrows(IllegalArgumentException.class, () -> {
            negocio.consumirCerveza(cliente.getCodigo(), "CODIGO_INEXISTENTE", 50);
        });
    }
}