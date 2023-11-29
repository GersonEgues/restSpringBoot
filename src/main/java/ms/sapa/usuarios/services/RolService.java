package ms.sapa.usuarios.services;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.dto.request.RolReq;
import ms.sapa.usuarios.dto.response.RolRes;
import ms.sapa.usuarios.services.customException.DuplicatedKey;

import java.util.List;
import java.util.Optional;

public interface RolService {
    RolRes findById(Long id) throws Exception;
    List<RolRes> findAll();
    RolRes save(RolReq rolReq) throws Exception;
    RolRes update(Long id,RolReq rolReq) throws Exception;
    List<RolRes> findRolListFromUser(Long userId);
    void delete(Long id) throws Exception;
}