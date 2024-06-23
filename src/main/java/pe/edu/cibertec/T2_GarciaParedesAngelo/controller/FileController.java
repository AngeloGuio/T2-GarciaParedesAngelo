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

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/files")
public class FileController {
    private FileService fileService;

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "png", "docx");

    @PostMapping("")
    public ResponseEntity<String> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        if (files.length != 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debe subir exactamente 3 archivos.");
        }

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            if (fileName == null || !isAllowedExtension(fileName)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solo se permiten archivos con extensión pdf, png, docx.");
            }
        }


        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos exitosamente.");
    }

    @PostMapping("/uploadSingleFile")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        if (file.getSize() > 25 * 1024 * 1024) { // 25 MB
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo excede el tamaño máximo permitido de 25MB.");
        }



        return ResponseEntity.status(HttpStatus.OK).body("Archivo subido exitosamente.");
    }

    private boolean isAllowedExtension(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        return ALLOWED_EXTENSIONS.contains(extension);
    }
}
