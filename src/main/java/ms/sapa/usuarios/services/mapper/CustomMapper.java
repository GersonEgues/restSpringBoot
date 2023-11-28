package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.Users;
import ms.sapa.usuarios.dto.request.RolReq;
import ms.sapa.usuarios.dto.response.UserRes;

public interface CustomMapper <DTO, E> {
    DTO toDto(E e);
    E toEntity(DTO dto);

    E merge(E e, DTO dto);
}