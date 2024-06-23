package pe.edu.cibertec.T2_GarciaParedesAngelo.model.bd;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private Date fechgraduacion;
}
