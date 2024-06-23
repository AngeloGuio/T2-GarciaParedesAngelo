package pe.edu.cibertec.T2_GarciaParedesAngelo.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
