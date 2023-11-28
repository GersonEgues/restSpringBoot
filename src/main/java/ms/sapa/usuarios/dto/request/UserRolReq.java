package ms.sapa.usuarios.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class UserRolReq implements Serializable, DTO {
    @NotNull(message = "username can't be null")
    private Boolean active;

    @NotNull(message = "createedAt can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createedAt;

    @NotNull(message = "userId can't be null")
    private Long userId;

    @NotNull(message = "rolId can't be null")
    private Long rolId;
}
