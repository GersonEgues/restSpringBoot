package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.dto.DTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<DTO, Rol>{
    @Override
    public DTO toDto(Rol rol) {
        return null;
    }

    @Override
    public Rol toEntity(DTO dto) {
        return null;
    }
}
