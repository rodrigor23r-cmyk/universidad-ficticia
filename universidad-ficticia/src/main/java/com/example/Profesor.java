package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Profesor extends Persona implements Comparable<Profesor> {
	
	private int totalEstudiantes;
	
	private Dpto dpto;
	
	private LocalDate fechaIncioFacultad;
	
	private BigDecimal salario;
	
	
	
	
	public String toString() {
    return String.format(
        "  Profesor: %s %s %s" +
        "  Nacimiento: %s" +
        "  Estudiantes: %s" +
        "  Departamento: %s" +
        "  Fecha de Alta: %s" +
        "  Salario: %.2f €\n" ,
        super.getNombre(), super.getPrimerApellido(), super.getSegundoApellido(),
        super.getFechaDeNacimiento(), this.getTotalEstudiantes(),
        this.getDpto(), this.getFechaIncioFacultad(), this.getSalario()
    );
}




	@Override
	public int compareTo(Profesor otro) {
		
		int cmpSalario = this.getSalario().compareTo(otro.getSalario());
		
		return cmpSalario != 0 ? cmpSalario : this.getFechaIncioFacultad().compareTo(otro.getFechaIncioFacultad());
	}

}	
