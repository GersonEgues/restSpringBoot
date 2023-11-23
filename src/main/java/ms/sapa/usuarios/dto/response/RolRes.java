package ms.sapa.usuarios.dto.response;

import lombok.Getter;
import lombok.Setter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;

@Getter
@Setter
public class RolRes implements Serializable, DTO {
    private Long id;
    private String name;
}
