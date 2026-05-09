package com.krakedev.clientes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

@RestController

@RequestMapping("/clientes")
public class ClienteController {
	
	
	private final ServicioCliente ServicioCliente = new ServicioCliente();
	
	@PostMapping
	public Cliente crear(@RequestBody Cliente cliente) {
		return ServicioCliente.crear(cliente);
	}
	@GetMapping
	public List<Cliente> listar(){
		return ServicioCliente.listar();
	}
	@GetMapping("/{cedula}")
	public Cliente buscar(@PathVariable String cedula) {
		return ServicioCliente.buscarPorCedula(cedula);
	}
	@PutMapping("/{cedula}")
	public Cliente actualizar(@PathVariable String cedula,@RequestBody Cliente clietnteActualizado) {
		return ServicioCliente.actualizar(cedula, clietnteActualizado);
	}
	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return ServicioCliente.eliminar(cedula);
	}
}
