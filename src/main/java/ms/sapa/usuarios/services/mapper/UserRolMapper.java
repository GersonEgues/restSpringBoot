package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.domain.entities.UserRol;
import ms.sapa.usuarios.dto.DTO;
import ms.sapa.usuarios.dto.request.UserRolReq;
import ms.sapa.usuarios.dto.response.UserRolRes;
import org.springframework.stereotype.Component;

@Component
public class UserRolMapper implements CustomMapper<DTO, UserRol> {
    @Override
    public UserRolRes toDto(UserRol userRol) {
        UserRolRes userRolRes = new UserRolRes();
        userRolRes.setId(userRol.getId());
        userRolRes.setRolId(userRol.getRol().getId());
        userRolRes.setRolName(userRol.getRol().getName());
        userRolRes.setUserId(userRol.getUsers().getId());
        userRolRes.setActive(userRol.getActive());
        userRolRes.setCreateedAt(userRol.getCreatedAt());
        return userRolRes;
    }

    @Override
    public UserRol toEntity(DTO dto) {
        UserRolReq userRolReq = (UserRolReq) dto;
        UserRol userRol = new UserRol();
        userRol.setActive(userRolReq.getActive());
        userRol.setCreatedAt(userRolReq.getCreateedAt());
        return userRol;
    }

    @Override
    public UserRol merge(UserRol userRol, DTO dto) {
        UserRolReq userRolReq = (UserRolReq) dto;
        userRol.setActive(userRolReq.getActive());
        userRol.setCreatedAt(userRolReq.getCreateedAt());
        return userRol;
    }
}