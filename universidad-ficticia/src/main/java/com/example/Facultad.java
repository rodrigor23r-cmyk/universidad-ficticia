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


	public String toString() {
    return String.format(
        "\n================ FACULTAD de %s ================\n" +
        "  %s\n" +
        "  %s\n" +
        "===================================================\n",
        this.getNombreFacultad(), this.getListaProfesores(), this.getListaEstudiantes()
    );
}
}
