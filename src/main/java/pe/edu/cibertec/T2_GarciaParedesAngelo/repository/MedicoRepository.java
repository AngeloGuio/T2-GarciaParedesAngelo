package pe.edu.cibertec.T2_GarciaParedesAngelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.T2_GarciaParedesAngelo.model.bd.Especialidad;

@Repository
public interface MedicoRepository extends
        JpaRepository<Especialidad, Integer> {
}
