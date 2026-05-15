package com.example;

import java.math.BigDecimal;
import java.nio.file.DirectoryStream.Filter;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


public class App {
	public static void main(String[] args) {
		
		// ============================== RECUPERO LA INFO DE LA BASE DE DATOS =======================
		List<Estudiante> listaEstudiantes = BaseDatosUniversidad.obtenerEstudiantes();
		List<Profesor> listaProfesores = BaseDatosUniversidad.obtenerProfesores();
		List<Facultad> listaFacultades = BaseDatosUniversidad.obtenerFacultades();

		// ============================= COMPRUEBO DUPLICIDADES ======================================
	
		// Para cumplir con el enunciado de que no haya alumnos y profes en varias Facultades a la vez
		// como agrego personas de forma secuencial, lo único que tengo que comprobar es que en la base de 
		// datos no haya personas repetidas.

			if (listaProfesores.stream().map(p -> p.getNombre() + " " + p.getPrimerApellido() + " " + p.getSegundoApellido())
					.distinct().count() < listaProfesores.size()) {
			    System.out.println("¡Atención! Hay profesores duplicados en la lista.");
			}
			
			if (listaEstudiantes.stream().map(p -> p.getNombre() + " " + p.getPrimerApellido() + " " + p.getSegundoApellido())
					.distinct().count() < listaEstudiantes.size()) {
			    System.out.println("¡Atención! Hay estudiantes duplicados en la lista.");
			}
		
		// ================== inserto los estudiantes que tienen asignados dicha facultad ==========================
		for (Facultad facultad : listaFacultades) {

			for (Estudiante estudiante : listaEstudiantes) {

				if (estudiante.getNombreFacultad() == facultad.getNombreFacultad()) {

					facultad.getListaEstudiantes().add(estudiante);

				}
 
			}

		}

		// ======================== INGRESO DE LOS PROFESORES ========================================
		
		// ingresar profesores con ITERATOR y modifico su campo totalestudiantes a un valor aleatorio
		// de alumnos sin exceder el máximo de alumnos de la facultad (por lógica).

		int indiceFacultad = 0;

		Iterator<Profesor> it = listaProfesores.iterator();

		while (it.hasNext()) { // hasta que me quede sin profes

			if (indiceFacultad >= listaFacultades.size()) {

				indiceFacultad = 0; // recorro las facultades en orden tantas veces sea necesario para introducir profes.
			}
			// añado un profe
			listaFacultades.get(indiceFacultad).getListaProfesores().add(it.next());
			// determino el máximo número de alumnos de la facultad en question:
			int totalEstudiantesFacultad = listaFacultades.get(indiceFacultad).getListaEstudiantes().size();
			//creo un valor aleatorio entre 1 y el totalEstudiantesFacultad
			Random aleatorio = new Random();
			int estudiantesAleatorios = aleatorio.nextInt(totalEstudiantesFacultad) + 1;
			// asigno el número de alumnos aleatorio al campo del profesor que dice total estudiantes.
			listaFacultades.get(indiceFacultad).getListaProfesores().getLast()
					.setTotalEstudiantes(estudiantesAleatorios);

			indiceFacultad++;
		}

		System.out.println(listaFacultades);
// ===========================================================================================================
		
	System.out.println("\n2. Recorrer la lista de facultades y crear una nueva colección que agrupe estudiantes por facultad.\n");
		 
		Map<NombreFacultad, List<Estudiante>> ejercicio2 = listaFacultades.stream()
				.collect(Collectors.toMap(Facultad::getNombreFacultad, Facultad::getListaEstudiantes));
		System.out.println(ejercicio2);
		
	// ===========================================================================================================
		
	System.out.println("\n3. Recorrer la lista de facultades y obtener una nueva colección que agrupe\r\n"
			+ "profesores por facultad y Dpto.\n");
		
	
	Map<NombreFacultad, Map<Dpto, List<Profesor>>> ejercicio3 = listaFacultades.stream()
			.collect(Collectors.toMap(Facultad::getNombreFacultad,
					f -> f.getListaProfesores().stream()
					.collect(Collectors.groupingBy(Profesor::getDpto))));
		System.out.println(ejercicio3);
		
		// ===========================================================================================================
		
		System.out.println("\n4. Recorrer la lista de estudiantes, agrupada por facultad, y mostrar la lista de\r\n"
				+ "estudiantes de cada facultad ordenada por el total de asignaturas, según el\r\n"
				+ "orden natural.\r\n"
				+ "\n");
		// los enteros como es el caso de el total de asignaturas ya se ordenan naturalmente
		// (no hace falta implementar la comparación en la clase Estudiante).
		
		listaEstudiantes.stream().sorted(Comparator.comparing(Estudiante::getTotalAsignaturasMatriculadas))
			.collect(Collectors.groupingBy(Estudiante::getNombreFacultad)).forEach((facultad, listaestudiantes) ->
			System.out.println("Facultad: "+ facultad + "\n" + listaestudiantes));
		
		// ===========================================================================================================
		
				System.out.println("\n5. Recorrer la colección que agrupa profesores por facultad y Dpto y mostrar\r\n"
						+ "la lista de profesores de cada facultad ordenada por salario y antigüedad\r\n"
						+ "del profesor, según el orden natural.\r\n"
						+ "\n");
				
			// --- ESTRUCTURA: Map<NombreFacultad, Map<Dpto, List<Profesor>>> -----
				
			// -------------- implementada la Interfaz Comparable en la clase Profesor ------------
		ejercicio3.forEach((facultad, mapaAnidado) -> {
				
				System.out.println("Facultad: " + facultad);
				mapaAnidado.values().stream().flatMap(profes -> profes.stream())
						.sorted().forEach(System.out::println);
				
				});
				
		
		// ===========================================================================================================
		
		System.out.println("\n6. Mostrar el nombre y los apellidos del profesor que tiene mayor salario de\r\n"
				+ "todas las facultades.\n");
		
		listaFacultades.stream().flatMap(f -> f.getListaProfesores().stream())
			.max(Comparator.comparing(Profesor::getSalario))
			.ifPresent(p -> 
				System.out.println("El profesor con más salario (" + p.getSalario() + ") es: "
					+ p.getNombre() + " " + p.getPrimerApellido()));;
		
					
		// ===========================================================================================================
					
		System.out.println("\n7. Obtener una colección que agrupe estudiantes por total de asignaturas\r\n"
				+ "matriculadas.\r\n");
	
		Map<Integer, List<Estudiante>> estudiantesPorNumAsignaturas = listaEstudiantes.stream()
				.collect(Collectors.groupingBy(Estudiante::getTotalAsignaturasMatriculadas,
						Collectors.toList()));
		
		System.out.println(estudiantesPorNumAsignaturas);
		
		// ===========================================================================================================
		
		System.out.println("\n8. Crear una colección que permita almacenar estudiantes y profesores en la\r\n"
				+ "misma colección.\r\n");
			
		List<? super Persona> personas = new ArrayList<>();
		
		personas.addAll(listaEstudiantes);
		personas.addAll(listaProfesores);
		
		System.out.println(personas);
		
		// ===========================================================================================================
		
		System.out.println("\n9. Recorrer la colección creada en el punto anterior y mostrar solamente los\r\n"
				+ "profesores que tengan salario superior a la media y hayan comenzado a\r\n"
				+ "trabajar en la facultad en los últimos 5 días del mes en curso.\r\n");
		
		// previamente genero las fechas de comparación
		LocalDate hoy = LocalDate.now();
		LocalDate finDeMes = hoy.with(TemporalAdjusters.lastDayOfMonth());
		LocalDate fechaCorte = finDeMes.minusDays(4);
		
		// calculo el salario medio recorriendo previamente la lista en estudio:
		Double salarioMedio = personas.stream().filter(p -> p instanceof Profesor)
				.map(p -> (Profesor) p)
				.collect(Collectors.averagingDouble(p -> p.getSalario().doubleValue()));
		
		// recorro la lista con tres filtros:
		personas.stream().filter(p -> p instanceof Profesor)
			.map(p -> (Profesor) p)
			.filter(p -> p.getSalario().doubleValue() > salarioMedio)
			// .filter(p -> p.getSalario().compareTo(salarioMedio) > 0)
			.filter(p -> !p.getFechaIncioFacultad().isAfter(finDeMes) && !p.getFechaIncioFacultad().isBefore(fechaCorte))
			.forEach(System.out::println);

		// ===========================================================================================================
		
		System.out.println("\n10. Recorrer la lista de facultades y obtener una nueva colección que agrupe\r\n"
				+ "por el total de asignaturas matriculadas por facultad.\r\n");
	
		// Map<Integer, Facultad> está mal planteado porque podría haber más de una facultad con el mismo núm. de asignaturas
		Map<Integer, List<Facultad>> ejercicio10 = listaFacultades.stream()
				.collect(Collectors.groupingBy(f -> f.getListaEstudiantes().stream()
						.mapToInt(e -> e.getTotalAsignaturasMatriculadas()).sum()));
		
		System.out.println(ejercicio10);
		
	}
}
