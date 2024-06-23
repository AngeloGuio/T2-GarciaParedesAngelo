package pe.edu.cibertec.T2_GarciaParedesAngelo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.T2_GarciaParedesAngelo.model.dto.ArchivoDto;
import pe.edu.cibertec.T2_GarciaParedesAngelo.service.FileService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/files")
public class FileController {
    private FileService fileService;

    @PostMapping("")
    public ResponseEntity<ArchivoDto> subirArchivos(
            @RequestParam("files") List<MultipartFile> multipartFileList
    ) throws Exception{
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Archivos subidos correctamente").build(),
                HttpStatus.OK);
    }
}
