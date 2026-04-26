package com.krakedev.contacto.entidades;

import java.util.ArrayList;

public class Directorio {
	private ArrayList<Contacto> contactos ;

	public Directorio() {
		super();
		this.contactos = new ArrayList<Contacto>();
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	public boolean agregarContacto(Contacto con) {
		
		Contacto existente = buscarContacto(con.getCelular());
		if(existente == null) {
			contactos.add(con);
			return true;
		}else {
			return false;
		}
	}
	
	public int cantidadContactos() {
		int cantidad = contactos.size();
		return cantidad;
	}
	public Contacto obtenerContacto(int pos) {
		return contactos.get(pos);
	}
	public void imprimirContactos() {
		for(int i=0 ; i<contactos.size();i++) {
			Contacto contac = contactos.get(i);
			System.out.println(contac.getNombre());
		}
	}
	public String recuperarNumero(int pos) {
		return contactos.get(pos).getCelular();
	}
	public Contacto buscarContacto(String num) {
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getCelular().equals(num)){
				return contactos.get(i);
			}	
		}
		return null;
	}
	public boolean eliminarContacto(String numero) {
	    Contacto encontrado = buscarContacto(numero);
	    if(encontrado == null) {
	        return false;
	    } else {
	        contactos.remove(encontrado);
	        return true;
	    }
	}
	
	public ArrayList<Contacto> buscarContactosCoincidencia(String subcadena){
	    ArrayList<Contacto> encontrados = new ArrayList<Contacto>();
	    for(int i = 0; i < contactos.size(); i++) {
	        Contacto c = contactos.get(i);
	        if(c.getNombre().startsWith(subcadena)) {
	            encontrados.add(c);
	        }
	    }
	    return encontrados;
	}

}
