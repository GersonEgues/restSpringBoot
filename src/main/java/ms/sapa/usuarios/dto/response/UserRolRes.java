package ms.sapa.usuarios.dto.response;

import lombok.Getter;
import lombok.Setter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserRolRes implements Serializable, DTO {
    private Long id;
    private Boolean active;
    private LocalDateTime createedAt;
    private Long userId;
    private Long rolId;
    private String rolName;
}
