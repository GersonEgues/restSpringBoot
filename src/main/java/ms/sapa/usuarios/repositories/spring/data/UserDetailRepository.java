package ms.sapa.usuarios.repositories.spring.data;

import ms.sapa.usuarios.domain.entities.UserDetail;
import ms.sapa.usuarios.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    @Query("SELECT ud FROM UserDetail ud WHERE ud.users.id = ?1")
    Optional<UserDetail> findFromUser(Long userId);
}
