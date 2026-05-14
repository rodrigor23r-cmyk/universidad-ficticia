package com.example;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Facultad {

	private NombreFacultad nombreFacultad;

	private List<Profesor> listaProfesores;
	
	private List<Estudiante> listaEstudiantes;


	/*public String toString() {
	    return String.format(
	        "\n================ FACULTAD ================\n" +
	        "  Nombre completo: %s \n" +
	        "  Nacimiento     : %s\n" +
	        "  Género         : %s\n" +
	        "---------------------------------------------------\n" +
	        "  Departamento   : %s\n" +
	        "  Fecha de Alta  : %s\n" +
	        "  Salario        : %.2f €\n" + 
	        "===================================================\n",
	        super.getNombre(), super.getPrimerApellido(), super.getSegundoApellido(), // Atributos de Persona
	        super.getFechaNacimiento(), super.getGenero(),
	        this.getDpto(), this.getFechaAlta(), this.getSalario()                    // Atributos de Empleado
	    );
	}*/
}
