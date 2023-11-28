package ms.sapa.usuarios.services.mapper;

import ms.sapa.usuarios.domain.entities.UserDetail;
import ms.sapa.usuarios.dto.DTO;
import ms.sapa.usuarios.dto.request.UserDetailReq;
import ms.sapa.usuarios.dto.response.UserDetailRes;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<DTO, UserDetail> {
    @Override
    public UserDetailRes toDto(UserDetail userDetail) {
        UserDetailRes userDetailRes = new UserDetailRes();
        userDetailRes.setId(userDetail.getId());
        userDetailRes.setUserId(userDetail.getUsers().getId());
        userDetailRes.setAge(userDetail.getAge());
        userDetailRes.setFirstName(userDetail.getFirstName());
        userDetailRes.setLastName(userDetail.getLastName());
        userDetailRes.setBirthDay(userDetail.getBirthDay());
        return userDetailRes;
    }

    @Override
    public UserDetail toEntity(DTO dto) {
        UserDetailReq userDetailReq = (UserDetailReq) dto;
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(userDetailReq.getAge());
        userDetail.setBirthDay(userDetailReq.getBirthDay());
        userDetail.setFirstName(userDetailReq.getFirstName());
        userDetail.setLastName(userDetailReq.getLastName());
        return userDetail;
    }

    @Override
    public UserDetail merge(UserDetail userDetail, DTO dto) {
        UserDetailReq userDetailReq = (UserDetailReq) dto;
        userDetail.setFirstName(userDetailReq.getFirstName());
        userDetail.setLastName(userDetail.getLastName());
        userDetail.setBirthDay(userDetail.getBirthDay());
        userDetail.setAge(userDetailReq.getAge());
        return userDetail;
    }
}
