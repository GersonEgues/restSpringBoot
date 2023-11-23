package ms.sapa.usuarios.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class UserRolReq implements Serializable, DTO {
    @NotNull(message = "username can't be null")
    @NotEmpty(message = "username can't be empty")
    private Boolean active;

    @NotNull(message = "createedAt can't be null")
    @NotEmpty(message = "createedAt can't be empty")
    private LocalDateTime createedAt;

    @NotNull(message = "userId can't be null")
    @NotEmpty(message = "userId can't be empty")
    private Long userId;

    @NotNull(message = "rolId can't be null")
    @NotEmpty(message = "rolId can't be empty")
    private Long rolId;
}
