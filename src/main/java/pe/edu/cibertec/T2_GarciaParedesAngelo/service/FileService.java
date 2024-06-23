package pe.edu.cibertec.T2_GarciaParedesAngelo.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService{

    private final Path pathFolder = Paths.get("uploads");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        Files.copy(archivo.getInputStream(),
                this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {

    }
}
