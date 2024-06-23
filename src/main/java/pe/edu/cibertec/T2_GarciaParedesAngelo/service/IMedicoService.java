package pe.edu.cibertec.T2_GarciaParedesAngelo.service;

import pe.edu.cibertec.T2_GarciaParedesAngelo.model.bd.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    List<Medico> listarMedicos();
    Medico guardarMedico(Medico medico);
    Optional<Medico> obtenerMedicoxId(Integer id);
}
