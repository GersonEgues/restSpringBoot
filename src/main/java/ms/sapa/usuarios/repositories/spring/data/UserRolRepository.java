package ms.sapa.usuarios.repositories.spring.data;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRolRepository extends JpaRepository<UserRol, Long> {
    Optional<UserRol> findById(Long id);

    @Query("SELECT ur FROM UserRol ur WHERE ur.users.id = ?1")
    List<UserRol> findAllFromUser(Long userId);

}
