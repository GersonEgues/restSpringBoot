package ms.sapa.usuarios.repositories.spring.data;

import ms.sapa.usuarios.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
