package ms.sapa.usuarios.dto.response;

import lombok.Getter;
import lombok.Setter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserRes implements Serializable, DTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createedAt;
}
