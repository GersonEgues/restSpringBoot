package ms.sapa.usuarios.services;

import ms.sapa.usuarios.dto.request.UserReq;
import ms.sapa.usuarios.dto.response.UserRes;

import java.util.List;

public interface UserService {
    UserRes findById(Long id) throws Exception;

    List<UserRes> findAll();

    UserRes save(UserReq userReq) throws Exception;

    UserRes update(Long id, UserReq userReq) throws Exception;
}
