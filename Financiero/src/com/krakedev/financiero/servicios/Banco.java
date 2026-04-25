package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {
	private int ultimoCodigo = 1000;

	public Banco() {
		super();
	}

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	public Cuenta crearCuenta(Cliente cliente) {
		String codigoStr = ultimoCodigo + "";
		ultimoCodigo ++;
		Cuenta cuenta = new Cuenta(codigoStr);
		return cuenta;
	}
	
	public boolean depositar(double monto, Cuenta cuenta) {
		if(monto > 0) {
			double total = cuenta.getSaldoActual() + monto; 
			cuenta.setSaldoActual(total);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean retirar(double monto, Cuenta cuenta) {
		if(monto > 0 & monto <= cuenta.getSaldoActual()) {
			double retiro = cuenta.getSaldoActual() - monto;
			cuenta.setSaldoActual(retiro);
			return true;
		}else {
			return false;
		}
	}
}
