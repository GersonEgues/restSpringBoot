package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.dto.DTO;
import org.apache.catalina.User;

public class UserMapper implements CustomMapper<DTO, User>{
    @Override
    public DTO toDto(User user) {
        return null;
    }

    @Override
    public User toEntity(DTO dto) {
        return null;
    }
}
