package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BaseDatosUniversidad {
	
	public static List<Facultad> obtenerFacultades() {
		
    	Facultad facultad1 = Facultad.builder()
       		    .nombreFacultad(NombreFacultad.MATEMATICAS)
       		    .listaProfesores(new ArrayList<Profesor>())
       		    .listaEstudiantes(new ArrayList<Estudiante>())
    		    .build();
    	
    	Facultad facultad2 = Facultad.builder()
    	        .nombreFacultad(NombreFacultad.INFORMATICA)
    	        .listaProfesores(new ArrayList<Profesor>())
    	        .listaEstudiantes(new ArrayList<Estudiante>())
    	        .build();

    	Facultad facultad3 = Facultad.builder()
    	        .nombreFacultad(NombreFacultad.FISICA)
    	        .listaProfesores(new ArrayList<Profesor>())
    	        .listaEstudiantes(new ArrayList<Estudiante>())
    	        .build();

    	
    	List<Facultad> facultades = List.of(facultad1, facultad2, facultad3);
		
		return facultades;
    	
		}

	public static List<Estudiante> obtenerEstudiantes() {
	
		Estudiante estudiante1 = Estudiante.builder()
   		    .nombre("Ernesto")
   		    .primerApellido("Rivero")
   		    .segundoApellido("Fernández")
   		    .fechaDeNacimiento(LocalDate.of(1986, Month.DECEMBER, 29))
   		    .nombreFacultad(NombreFacultad.FISICA)
   		    .totalAsignaturasMatriculadas(4)
		    .fechaAltaFacultad(LocalDate.of(2000, Month.APRIL, 1))
   		    .build();
		
		Estudiante estudiante2 = Estudiante.builder()
		        .nombre("Laura")
		        .primerApellido("Gómez")
		        .segundoApellido("Sánchez")
		        .fechaDeNacimiento(LocalDate.of(2002, Month.MARCH, 15))
		        .nombreFacultad(NombreFacultad.MATEMATICAS)
		        .totalAsignaturasMatriculadas(5)
		        .fechaAltaFacultad(LocalDate.of(2021, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante3 = Estudiante.builder()
		        .nombre("Alejandro")
		        .primerApellido("Martínez")
		        .segundoApellido("López")
		        .fechaDeNacimiento(LocalDate.of(2001, Month.JULY, 22))
		        .nombreFacultad(NombreFacultad.MATEMATICAS)
		        .totalAsignaturasMatriculadas(6)
		        .fechaAltaFacultad(LocalDate.of(2020, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante4 = Estudiante.builder()
		        .nombre("Sofía")
		        .primerApellido("Rodríguez")
		        .segundoApellido("Pérez")
		        .fechaDeNacimiento(LocalDate.of(2003, Month.JANUARY, 10))
		        .nombreFacultad(NombreFacultad.MATEMATICAS)
		        .totalAsignaturasMatriculadas(4)
		        .fechaAltaFacultad(LocalDate.of(2022, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante5 = Estudiante.builder()
		        .nombre("Carlos")
		        .primerApellido("Fernández")
		        .segundoApellido("García")
		        .fechaDeNacimiento(LocalDate.of(2000, Month.NOVEMBER, 5))
		        .nombreFacultad(NombreFacultad.FISICA)
		        .totalAsignaturasMatriculadas(5)
		        .fechaAltaFacultad(LocalDate.of(2019, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante6 = Estudiante.builder()
		        .nombre("Elena")
		        .primerApellido("Ruiz")
		        .segundoApellido("Hernández")
		        .fechaDeNacimiento(LocalDate.of(2002, Month.MAY, 18))
		        .nombreFacultad(NombreFacultad.FISICA)
		        .totalAsignaturasMatriculadas(6)
		        .fechaAltaFacultad(LocalDate.of(2021, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante7 = Estudiante.builder()
		        .nombre("David")
		        .primerApellido("Díaz")
		        .segundoApellido("Moreno")
		        .fechaDeNacimiento(LocalDate.of(2003, Month.AUGUST, 30))
		        .nombreFacultad(NombreFacultad.FISICA)
		        .totalAsignaturasMatriculadas(4)
		        .fechaAltaFacultad(LocalDate.of(2022, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante8 = Estudiante.builder()
		        .nombre("Lucía")
		        .primerApellido("Álvarez")
		        .segundoApellido("Jiménez")
		        .fechaDeNacimiento(LocalDate.of(2001, Month.DECEMBER, 12))
		        .nombreFacultad(NombreFacultad.INFORMATICA)
		        .totalAsignaturasMatriculadas(5)
		        .fechaAltaFacultad(LocalDate.of(2020, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante9 = Estudiante.builder()
		        .nombre("Pablo")
		        .primerApellido("Torres")
		        .segundoApellido("Navarro")
		        .fechaDeNacimiento(LocalDate.of(2002, Month.OCTOBER, 25))
		        .nombreFacultad(NombreFacultad.INFORMATICA)
		        .totalAsignaturasMatriculadas(5)
		        .fechaAltaFacultad(LocalDate.of(2021, Month.SEPTEMBER, 1))
		        .build();

		Estudiante estudiante10 = Estudiante.builder()
		        .nombre("Marta")
		        .primerApellido("Castillo")
		        .segundoApellido("Rubio")
		        .fechaDeNacimiento(LocalDate.of(2004, Month.FEBRUARY, 3))
		        .nombreFacultad(NombreFacultad.INFORMATICA)
		        .totalAsignaturasMatriculadas(4)
		        .fechaAltaFacultad(LocalDate.of(2023, Month.SEPTEMBER, 1))
		        .build();

		
		
		List<Estudiante> estudiantes = List.of(estudiante1, estudiante2, estudiante3, estudiante4, estudiante5, estudiante6, estudiante7,
				estudiante8, estudiante9, estudiante10);
		
		return estudiantes;
	}



	public static List<Profesor> obtenerProfesores() {
		
		Profesor profesor1 = Profesor.builder()
   		    .nombre("Ramiro")
   		    .primerApellido("López")
   		    .segundoApellido("Fernández")
   		    .fechaDeNacimiento(LocalDate.of(1966, Month.OCTOBER, 15))
   		    .totalEstudiantes(0)
   		    .dpto(Dpto.DOCENCIA)
		    .fechaIncioFacultad(LocalDate.of(1999, Month.APRIL, 1))
		    .salario(BigDecimal.valueOf(2700.20))
   		    .build();
		
		Profesor profesor2 = Profesor.builder()
		        .nombre("Beatriz")
		        .primerApellido("García")
		        .segundoApellido("Martínez")
		        .fechaDeNacimiento(LocalDate.of(1975, Month.MARCH, 22))
		        .totalEstudiantes(0)
		        .dpto(Dpto.INVESTIGACION)
		        .fechaIncioFacultad(LocalDate.of(2005, Month.SEPTEMBER, 1))
		        .salario(BigDecimal.valueOf(3800.50))
		        .build();

		Profesor profesor3 = Profesor.builder()
		        .nombre("Manuel")
		        .primerApellido("Sánchez")
		        .segundoApellido("Rodríguez")
		        .fechaDeNacimiento(LocalDate.of(1982, Month.JANUARY, 8))
		        .totalEstudiantes(0)
		        .dpto(Dpto.DOCENCIA)
		        .fechaIncioFacultad(LocalDate.of(2010, Month.FEBRUARY, 15))
		        .salario(BigDecimal.valueOf(3200.00))
		        .build();

		Profesor profesor4 = Profesor.builder()
		        .nombre("Irene")
		        .primerApellido("Jiménez")
		        .segundoApellido("Ortiz")
		        .fechaDeNacimiento(LocalDate.of(1968, Month.JULY, 30))
		        .totalEstudiantes(0)
		        .dpto(Dpto.INVESTIGACION)
		        .fechaIncioFacultad(LocalDate.of(1995, Month.OCTOBER, 1))
		        .salario(BigDecimal.valueOf(4200.75))
		        .build();

		Profesor profesor5 = Profesor.builder()
		        .nombre("Fernando")
		        .primerApellido("Rubio")
		        .segundoApellido("Sanz")
		        .fechaDeNacimiento(LocalDate.of(1988, Month.DECEMBER, 12))
		        .totalEstudiantes(0)
		        .dpto(Dpto.DOCENCIA)
		        .fechaIncioFacultad(LocalDate.of(2026, Month.MAY, 28))
		        .salario(BigDecimal.valueOf(3500.40))
		        .build();

		Profesor profesor6 = Profesor.builder()
	   		    .nombre("Ramiro")
	   		    .primerApellido("López")
	   		    .segundoApellido("Fernández")
	   		    .fechaDeNacimiento(LocalDate.of(1966, Month.OCTOBER, 15))
	   		    .totalEstudiantes(0)
	   		    .dpto(Dpto.DOCENCIA)
			    .fechaIncioFacultad(LocalDate.of(1999, Month.APRIL, 1))
			    .salario(BigDecimal.valueOf(3500.20))
	   		    .build();
		
		List<Profesor> profesores = List.of(profesor1, profesor2, profesor3, profesor4, profesor5);
		
		return profesores;
	}
	
	
	
	
}
/*	
	private int totalEstudiantes;
	
	private Dpto dpto;
	
	private LocalDate fechaIncioFacultad;
	
	private BigDecimal salario;
	*/