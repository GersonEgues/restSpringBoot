package ms.sapa.usuarios.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
public class UserRol {
    @Id
    private Long id;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private Users users;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rol_id", nullable=false)
    private Rol rol;
}
