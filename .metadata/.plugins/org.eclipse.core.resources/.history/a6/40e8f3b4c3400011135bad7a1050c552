package com.krakedev.financiero.entidades;

public class Cuenta {
	private String id;
	private double SaldoActual;
	private String tipo;
	private Cliente cliente;
	
	public Cuenta(String id) {
		super();
		this.id = id;
		this.SaldoActual = 0;
		this.tipo = "A";
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSaldoActual() {
		return SaldoActual;
	}
	public void setSaldoActual(double saldoActual) {
		SaldoActual = saldoActual;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void imprimir() {
		String msgCliente = "Cedula: "+cliente.getCedula()
				+"\nPropietario: "+cliente.getNombre() + " "+cliente.getApellido();
		String msgCuenta = "ID: "+ id
				+ "\nSaldo Actual: "+ SaldoActual
				+"\nTipo: "+ tipo;
		System.out.println(msgCliente + "\n" + msgCuenta);
	}
	
}
