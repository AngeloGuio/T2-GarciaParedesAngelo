package pe.edu.cibertec.T2_GarciaParedesAngelo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_GarciaParedesAngelo.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_GarciaParedesAngelo.model.bd.Especialidad;
import pe.edu.cibertec.T2_GarciaParedesAngelo.service.EspecialidadService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/especialidad")
public class EspecialidadController {

    private EspecialidadService especialidadService;

    @GetMapping("")
    public ResponseEntity<List<Especialidad>> listarEspecialidades(){
        List<Especialidad> especialidadList = new ArrayList<>(
                especialidadService.listarEspecialidades());
        if(especialidadList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(especialidadList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerEspecialidadXId(
            @PathVariable Integer id){
        Especialidad especialidad = especialidadService
                .obtenerEspecialidadxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("La categoria con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(especialidad, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Especialidad> registrarEspecialidad(
            @RequestBody Especialidad especialidad
    ){
        return new ResponseEntity<>(
                especialidadService.guardarEspecialidad(especialidad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(
            @PathVariable Integer id,
            @RequestBody Especialidad especialidad
    ){
        Especialidad newEspecialidad = especialidadService.obtenerEspecialidadxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con Id "
                        + id +" no existe"));
        newEspecialidad.setTitulo(especialidad.getTitulo());
        newEspecialidad.setFuncion(especialidad.getFuncion());
        newEspecialidad.setFechgraduacion(especialidad.getFechgraduacion());
        return new ResponseEntity<>(
                especialidadService.guardarEspecialidad(newEspecialidad),
                HttpStatus.OK);
    }
}
