package ms.sapa.usuarios.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserReq implements Serializable, DTO {
    @NotNull(message = "userName can't be null")
    @NotEmpty(message = "userName can't be empty")
    private String userName;

    @NotNull(message = "password can't be null")
    @NotEmpty(message = "password can't be empty")
    private String password;

    @NotNull(message = "email can't be null")
    @NotEmpty(message = "email can't be empty")
    private String email;

    @NotNull(message = "createedAt can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createedAt;

    private List<UserRolReq> userRolReqList;
    private UserDetailReq userDetailReq;
}
