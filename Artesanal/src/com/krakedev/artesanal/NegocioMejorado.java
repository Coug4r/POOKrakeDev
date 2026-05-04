package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private int ultimoCodigo = 100;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	

	public NegocioMejorado(ArrayList<Maquina> maquinas) {
		super();
		this.maquinas = new ArrayList<Maquina>();
	}
	
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}


	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public String generarCodigo() {
		String codigo = "M "+ Math.random();
		return codigo;
	}
	public boolean agregarMaquina(String nom_cerv, String desc, double precioMl) {
		
		String codigo = generarCodigo();
		if(recuperarMaquina(codigo)==null) {
			Maquina mac = new Maquina(nom_cerv, desc, precioMl, codigo);
			maquinas.add(mac);
			return true;
		}else {
			return false;
		}
	}
	public void cargarMaquinas() {
		for(int i=0; i<maquinas.size();i++) {
			maquinas.get(i).llenarMaquina();
		}
	}
	
	public Maquina recuperarMaquina(String cod) {
		for(int i=0;i<maquinas.size();i++) {
			if(maquinas.get(i).getCodigo().equals(cod)) {
				return maquinas.get(i);
			}
		}
		return null;
	}
	
	public void registrarCliente(String nombre, String cedula) {
		int codigo = ultimoCodigo;
		ultimoCodigo ++;
		Cliente newCliente = new Cliente(nombre,cedula);
		newCliente.setCodigo(codigo);
		clientes.add(newCliente);
	}
	public Cliente buscarCliente(String cedula) {
		for(int i=0;i<clientes.size();i++) {
			if(clientes.get(i).getCedula().equals(cedula)) {
				return clientes.get(i);
			}
		}
		return null;
	}
	
	public Cliente buscarClientePorCodigo(int codigo) {
		for(int i=0;i<clientes.size();i++) {
			if(clientes.get(i).getCodigo()==codigo) {
				return clientes.get(i);
			}
		}
		return null;
	}
	
	public double consumirCerveza(int codCliente, String codMaquina, double cantidad) {
	    Maquina maquina = recuperarMaquina(codMaquina);
	    Cliente cliente = buscarClientePorCodigo(codCliente);
	    if (maquina == null || cliente == null) {
	        throw new IllegalArgumentException("Cliente o máquina no encontrados");
	    }
	    double valor = maquina.servirCerveza(cantidad);
	    cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
	    return valor;
	}
}
