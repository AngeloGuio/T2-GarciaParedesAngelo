package pe.edu.cibertec.T2_GarciaParedesAngelo.service;

import pe.edu.cibertec.T2_GarciaParedesAngelo.model.bd.Especialidad;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    List<Especialidad> listarEspecialidades();
    Especialidad guardarEspecialidad(Especialidad especialidad);
    Optional<Especialidad> obtenerEspecialidadxId(Integer id);
}
