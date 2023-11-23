package ms.sapa.usuarios.domain.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="rol")
    private Set<UserRol> userRol;
}
