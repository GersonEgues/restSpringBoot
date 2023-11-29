package ms.sapa.usuarios.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;

@Getter
@Setter
public class RolReq implements Serializable, DTO {
    @NotNull(message = "name can't be null")
    private String name;
}
