package ms.sapa.usuarios.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.util.Date;

@Getter
public class UserDetailReq implements Serializable, DTO {
    @NotNull(message = "username can't be null")
    @NotEmpty(message = "username can't be empty")
    private String firstName;

    @NotNull(message = "username can't be null")
    @NotEmpty(message = "username can't be empty")
    private String lastName;

    @NotNull(message = "password can't be null")
    @NotEmpty(message = "password can't be empty")
    private Integer age;

    @NotNull(message = "email can't be null")
    @NotEmpty(message = "email can't be empty")
    private Date birthDay;

    @NotNull(message = "userId can't be null")
    @NotEmpty(message = "userId can't be empty")
    @Positive(message = "userId can't be zero")
    private Long userId;
}
