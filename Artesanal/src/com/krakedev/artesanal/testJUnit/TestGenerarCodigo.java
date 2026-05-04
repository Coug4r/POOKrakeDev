package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigo {

    @Test
    public void testGenerarCodigoNoEsNulo() {
        NegocioMejorado negocio = new NegocioMejorado(null);
        String codigo = negocio.generarCodigo();
        assertNotNull(codigo, "El código generado no debe ser nulo");
    }

    @Test
    public void testGenerarCodigoEmpiezaConPrefijo() {
        NegocioMejorado negocio = new NegocioMejorado(null);
        String codigo = negocio.generarCodigo();
        assertTrue(codigo.startsWith("M "), "El código debe empezar con 'M '");
    }

    @Test
    public void testGenerarCodigosDistintos() {
        NegocioMejorado negocio = new NegocioMejorado(null);
        String codigo1 = negocio.generarCodigo();
        String codigo2 = negocio.generarCodigo();
        assertNotEquals(codigo1, codigo2, "Cada llamada debe generar un código distinto");
    }
}
