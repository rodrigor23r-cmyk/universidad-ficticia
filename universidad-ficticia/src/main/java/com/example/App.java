package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**

 */
public class App {
    public static void main(String[] args) {
    
    	
    	List<Estudiante> listaEstudiantes = BaseDatosUniversidad.obtenerEstudiantes();
    	List<Profesor> listaProfesores = BaseDatosUniversidad.obtenerProfesores();
    	
    	List<Facultad> listaInmutableFacultades = BaseDatosUniversidad.obtenerFacultades();
    	
    	List<Facultad> listaFacultades = new ArrayList<>(listaInmutableFacultades); // tengo que modificarla
    	
		
    	// inserto los estudiantes que tienen asignados dicha facultad
    	for (Facultad facultad : listaFacultades) {

    		for (Estudiante estudiante : listaEstudiantes) {
    	
    			if (estudiante.getNombreFacultad() == facultad.getNombreFacultad()) {
    				
    				facultad.getListaEstudiantes().add(estudiante);
    			
    			}
    			
    		}
    		
    	}
    	
    	
    	// ingresar profesores por índice y modifico sus estudiantes al máx. de alumnos de la facultad.
    	int indice = 0;
    	
		int indiceFacultad = 0;
		
		while (indice < listaProfesores.size()) {
			
			while (indiceFacultad < listaFacultades.size()) {

				listaFacultades.get(indiceFacultad).getListaProfesores().add(listaProfesores.get(indice));
				
				int totalEstudiantesFacultad = listaFacultades.get(indiceFacultad).getListaEstudiantes().size();
				
				listaFacultades.get(indiceFacultad).getListaProfesores().getLast().setTotalEstudiantes(totalEstudiantesFacultad);
								
				
				indiceFacultad++;
				
			}
			indice++;
		}	
   
    		System.out.println(listaProfesores);

//    	Map<Facultad, Estudiante> punto2 = listaFacultades.stream().collect(Collectors.groupingBy(classifier))
    	
    }
}
