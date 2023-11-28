package ms.sapa.usuarios.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.util.Date;

@Getter
public class UserDetailReq implements Serializable, DTO {
    @NotNull(message = "username can't be null")
    private String firstName;

    @NotNull(message = "username can't be null")
    private String lastName;

    @NotNull(message = "password can't be null")
    private Integer age;

    @NotNull(message = "email can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @NotNull(message = "userId can't be null")
    @Positive(message = "userId can't be zero")
    private Long userId;
}
