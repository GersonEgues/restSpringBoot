package ms.sapa.usuarios.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;

@Getter
public class RolReq implements Serializable, DTO {
    @NotNull(message = "name can't be null")
    @NotEmpty(message = "name can't be empty")
    private String name;
}
