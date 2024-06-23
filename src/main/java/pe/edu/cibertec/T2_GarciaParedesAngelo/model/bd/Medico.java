package pe.edu.cibertec.T2_GarciaParedesAngelo.model.bd;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    private Date fechanacmedico;

}
