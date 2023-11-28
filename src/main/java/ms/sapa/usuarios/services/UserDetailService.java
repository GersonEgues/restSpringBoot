package ms.sapa.usuarios.services;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.UserDetail;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {
    Optional<UserDetail> findById(Long id);

    List<UserDetail> findAll();

    UserDetail save(UserDetail userDetail);
}
