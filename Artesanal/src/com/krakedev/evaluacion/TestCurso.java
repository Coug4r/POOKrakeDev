package com.krakedev.evaluacion;

public class TestCurso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Curso A = new Curso("001");
		estudiantes David = new estudiantes("1150626693", "David", "Burneo");
		estudiantes Pedro = new estudiantes("11506421343", "Pedro", "Perez");
		estudiantes Juan = new estudiantes("115062214213", "Juan", "Jimenez");
		
		A.agregar(David);
		A.agregar(Pedro);
		A.agregar(Juan);
		
		estudiantes estBuscado = A.buscarPorCedula("1150626693");
		System.out.println("Nombre: "+estBuscado.getNombre());
		
		estudiantes estBuscadoError = A.buscarPorCedula("26693");
		System.out.println("Nombre: "+estBuscadoError.getNombre());
	}
}
