package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.dto.DTO;
import ms.sapa.usuarios.dto.request.RolReq;
import ms.sapa.usuarios.dto.response.RolRes;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<DTO, Rol> {
    @Override
    public RolRes toDto(Rol rol) {
        RolRes rolRes = new RolRes();
        rolRes.setId(rol.getId());
        rolRes.setName(rol.getName());
        return rolRes;
    }

    @Override
    public Rol toEntity(DTO dto) {
        RolReq rolReq = (RolReq)dto;
        Rol rol = new Rol();
        rol.setName(rolReq.getName());
        return rol;
    }

    @Override
    public Rol merge(Rol rol, DTO dto) {
        RolReq rolReq = (RolReq)dto;
        rol.setName(rolReq.getName());
        return rol;
    }
}
