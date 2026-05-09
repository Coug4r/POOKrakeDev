package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Curso {
	private String id;
	private ArrayList<estudiantes> estudiantes = new ArrayList<estudiantes>();
	
	public Curso(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<estudiantes> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(ArrayList<estudiantes> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public void agregar(estudiantes est) {
		estudiantes.add(est);
	}
	public estudiantes buscarPorCedula(String cedula) {
		estudiantes est=null;
		for(int i=0; i<estudiantes.size();i++) {
			if(estudiantes.get(i).getCedula().equals(cedula)) {
				est = estudiantes.get(i);
				break;
			}
		}
		return est;
	}
}
