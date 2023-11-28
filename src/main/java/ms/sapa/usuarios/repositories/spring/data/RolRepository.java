package ms.sapa.usuarios.repositories.spring.data;

import ms.sapa.usuarios.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findById(Long id);
}
