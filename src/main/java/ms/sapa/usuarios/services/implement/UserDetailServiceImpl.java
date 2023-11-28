package ms.sapa.usuarios.services.implement;

import ms.sapa.usuarios.domain.entities.UserDetail;
import ms.sapa.usuarios.repositories.spring.data.UserDetailRepository;
import ms.sapa.usuarios.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public Optional<UserDetail> findById(Long id) {
        return userDetailRepository.findById(id);
    }

    @Override
    public List<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }

    @Override
    public UserDetail save(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }
}
