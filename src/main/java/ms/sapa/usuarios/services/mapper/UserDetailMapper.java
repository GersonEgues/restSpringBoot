package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.domain.entities.UserDetail;
import ms.sapa.usuarios.dto.DTO;

public class UserDetailMapper implements CustomMapper<DTO, UserDetail> {
    @Override
    public DTO toDto(UserDetail userDetail) {
        return null;
    }

    @Override
    public UserDetail toEntity(DTO dto) {
        return null;
    }
}
