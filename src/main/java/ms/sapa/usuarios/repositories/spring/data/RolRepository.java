package ms.sapa.usuarios.repositories.spring.data;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findById(Long id);

    @Query("SELECT rol FROM UserRol ur,Rol rol WHERE ur.users.id = ?1 and ur.rol.id = rol.id")
    List<Rol> findRolListFromUser(Long userId);


}
