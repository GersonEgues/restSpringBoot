package ms.sapa.usuarios.dto.response;

import lombok.Getter;
import lombok.Setter;
import ms.sapa.usuarios.dto.DTO;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserDetailRes implements Serializable, DTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthDay;
    private Long userId;
}
