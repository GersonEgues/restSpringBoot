package ms.sapa.usuarios.services;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.UserDetail;
import ms.sapa.usuarios.dto.request.UserDetailReq;
import ms.sapa.usuarios.dto.request.UserReq;
import ms.sapa.usuarios.dto.response.UserDetailRes;
import ms.sapa.usuarios.dto.response.UserRes;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {
    UserDetailRes findById(Long id) throws Exception;

    UserDetailRes findFromUser(Long id) throws Exception;
    UserDetailRes save(UserDetailReq userDetailReq) throws Exception;

    UserDetailRes update(Long id, UserDetailReq userDetailReq) throws Exception;

    void delete(Long userId) throws Exception;
}
