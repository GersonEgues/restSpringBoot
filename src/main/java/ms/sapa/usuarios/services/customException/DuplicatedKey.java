package ms.sapa.usuarios.services.customException;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicatedKey extends DataIntegrityViolationException {
    public DuplicatedKey(String msg){
        super(msg);
    }
}
