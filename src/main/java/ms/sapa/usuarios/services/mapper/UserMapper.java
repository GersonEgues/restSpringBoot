package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.domain.entities.Users;
import ms.sapa.usuarios.dto.DTO;
import ms.sapa.usuarios.dto.request.UserReq;
import ms.sapa.usuarios.dto.response.UserRes;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<DTO, Users> {
    @Override
    public UserRes toDto(Users user) {
        UserRes userRes = new UserRes();
        userRes.setId(user.getId());
        userRes.setUsername(user.getUsername());
        userRes.setEmail(user.getEmail());
        userRes.setCreateedAt(user.getCreatedAt());
        return userRes;
    }

    @Override
    public Users toEntity(DTO dto) {
        UserReq userReq = (UserReq)dto;
        Users user = new Users();
        user.setUsername(userReq.getUserName());
        user.setPassword(userReq.getPassword());
        user.setEmail(userReq.getEmail());
        user.setCreatedAt(userReq.getCreateedAt());
        return user;
    }

    @Override
    public Users merge(Users user, DTO dto) {
        UserReq userReq = (UserReq)dto;
        user.setUsername(userReq.getUserName());
        user.setPassword(userReq.getPassword());
        user.setEmail(userReq.getEmail());
        return user;
    }
}
