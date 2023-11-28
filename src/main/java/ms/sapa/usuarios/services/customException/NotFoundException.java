package ms.sapa.usuarios.services.customException;

public class NotFoundException extends Exception{
    public NotFoundException(String msg){
        super(msg);
    }
}
