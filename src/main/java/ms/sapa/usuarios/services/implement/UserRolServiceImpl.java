package ms.sapa.usuarios.services.implement;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.UserRol;
import ms.sapa.usuarios.domain.entities.Users;
import ms.sapa.usuarios.dto.request.UserRolReq;
import ms.sapa.usuarios.dto.response.UserRolRes;
import ms.sapa.usuarios.repositories.spring.data.RolRepository;
import ms.sapa.usuarios.repositories.spring.data.UserRepository;
import ms.sapa.usuarios.repositories.spring.data.UserRolRepository;
import ms.sapa.usuarios.services.UserRolService;
import ms.sapa.usuarios.services.customException.DuplicatedKey;
import ms.sapa.usuarios.services.customException.NotFoundException;
import ms.sapa.usuarios.services.mapper.UserRolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {
    @Autowired
    private UserRolRepository userRolRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolMapper userRolMapper;

    @Override
    public UserRolRes findById(Long id) throws Exception {
        Optional<UserRol> optionalUserRol = userRolRepository.findById(id);
        if (optionalUserRol.isPresent()) {
            return userRolMapper.toDto(optionalUserRol.get());
        } else {
            throw new NotFoundException("Rol not found");
        }
    }

    @Override
    public List<UserRolRes> findAllFromUser(Long userId) {
        List<UserRol> userRolList = userRolRepository.findAllFromUser(userId);
        return userRolList.stream()
                .map(userRolMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserRolRes save(UserRolReq userRolReq) throws Exception {
        try {
            UserRol userRol = userRolMapper.toEntity(userRolReq);
            Optional<Rol> optionalRol = rolRepository.findById(userRolReq.getRolId());
            Optional<Users> optionalUser = userRepository.findById(userRolReq.getUserId());
            if (optionalRol.isPresent() && optionalUser.isPresent()) {
                userRol.setRol(optionalRol.get());
                userRol.setUsers(optionalUser.get());
                return userRolMapper.toDto(userRolRepository.save(userRol));
            } else {
                throw new NotFoundException("There is not rol or user registered yet for ids entered");
            }
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new DuplicatedKey(e.getMessage());
            } else {
                throw new Exception(e.getMessage());
            }
        }
    }

    @Override
    public UserRolRes update(Long id, UserRolReq userRolReq) throws Exception {
        try {
            Optional<UserRol> optionalUserRol = userRolRepository.findById(id);
            Optional<Rol> optionalRol = rolRepository.findById(userRolReq.getRolId());
            Optional<Users> optionalUser = userRepository.findById(userRolReq.getUserId());
            if (optionalUserRol.isPresent() && optionalRol.isPresent() && optionalUser.isPresent()) {
                UserRol userRol = optionalUserRol.get();
                userRol.setRol(optionalRol.get());
                userRol.setUsers(optionalUser.get());
                userRol = userRolMapper.merge(userRol, userRolReq);
                return userRolMapper.toDto(userRolRepository.save(userRol));
            } else {
                throw new NotFoundException("There is not rol or user registered yet for ids entered");
            }
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new DuplicatedKey(e.getMessage());
            } else {
                throw new Exception(e.getMessage());
            }
        }
    }

}
