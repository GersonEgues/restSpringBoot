package ms.sapa.usuarios.services;

import ms.sapa.usuarios.domain.entities.UserRol;
import ms.sapa.usuarios.dto.request.UserRolReq;
import ms.sapa.usuarios.dto.response.UserRolRes;

import java.util.List;
import java.util.Optional;

public interface UserRolService {
    UserRolRes findById(Long id) throws Exception;

    List<UserRolRes> findAllFromUser(Long userId);

    UserRolRes save(UserRolReq userRol) throws Exception;

    UserRolRes update(Long id, UserRolReq userRolReq) throws Exception;
}
