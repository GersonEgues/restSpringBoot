package ms.sapa.usuarios.repositories.spring.data;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);

}
