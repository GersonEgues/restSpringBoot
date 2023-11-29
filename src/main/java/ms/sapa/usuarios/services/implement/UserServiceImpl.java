package ms.sapa.usuarios.services.implement;


import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.domain.entities.UserDetail;
import ms.sapa.usuarios.domain.entities.UserRol;
import ms.sapa.usuarios.domain.entities.Users;
import ms.sapa.usuarios.dto.request.UserDetailReq;
import ms.sapa.usuarios.dto.request.UserReq;
import ms.sapa.usuarios.dto.request.UserRolReq;
import ms.sapa.usuarios.dto.response.UserRes;
import ms.sapa.usuarios.repositories.spring.data.RolRepository;
import ms.sapa.usuarios.repositories.spring.data.UserDetailRepository;
import ms.sapa.usuarios.repositories.spring.data.UserRepository;
import ms.sapa.usuarios.repositories.spring.data.UserRolRepository;
import ms.sapa.usuarios.services.RolService;
import ms.sapa.usuarios.services.UserDetailService;
import ms.sapa.usuarios.services.UserRolService;
import ms.sapa.usuarios.services.UserService;
import ms.sapa.usuarios.services.customException.DuplicatedKey;
import ms.sapa.usuarios.services.customException.NotFoundException;
import ms.sapa.usuarios.services.mapper.UserDetailMapper;
import ms.sapa.usuarios.services.mapper.UserMapper;
import ms.sapa.usuarios.services.mapper.UserRolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolService rolService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private UserRolRepository userRolRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRolMapper userRolMapper;
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UserRolService userRolService;


    @Override
    public UserRes findById(Long id) throws Exception {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userMapper.toDto(userOptional.get());
        } else {
            throw new NotFoundException("there is not found user with id : " + id);
        }
    }

    @Override
    public UserRes findFullDataUserById(Long id) throws Exception {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserRes userRes = userMapper.toDto(userOptional.get());
            userRes.setRolResList(rolService.findRolListFromUser(userRes.getId()));
            userRes.setUserDetailRes(userDetailService.findFromUser(userRes.getId()));
            return userRes;
        } else {
            throw new NotFoundException("there is not found user with id : " + id);
        }
    }

    @Override
    public List<UserRes> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserRes save(UserReq userReq) throws Exception {
        try {
            Users user = userMapper.toEntity(userReq);
            return userMapper.toDto(userRepository.save(user));
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new DuplicatedKey(e.getMessage());
            } else {
                throw new Exception(e.getMessage());
            }
        }
    }

    @Override
    public UserRes update(Long id, UserReq userReq) throws Exception {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Users user = userMapper.merge(userOptional.get(), userReq);
            user = userRepository.save(user);
            return userMapper.toDto(user);
        } else {
            throw new NotFoundException("there is not found user with id");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Optional<Users> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                Optional<UserDetail> optionalUserDetail = userDetailRepository.findFromUser(id);
                List<UserRol> userRolList = userRolRepository.findAllFromUser(id);
                if (optionalUserDetail.isPresent()) {
                    userDetailRepository.delete(optionalUserDetail.get());
                }

                if (userRolList.size() > 0) {
                    userRolList.forEach(userRol -> {
                        userRolRepository.delete(userRol);
                    });
                }

                userRepository.delete(optionalUser.get());
            } else {
                throw new NotFoundException("There is not user with id " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserRes saveFullData(UserReq userReq) throws Exception {
        try {
            Users user = userMapper.toEntity(userReq);
            user = userRepository.save(user);

            UserDetailReq userDetailReq = userReq.getUserDetailReq();
            userDetailReq.setUserId(user.getId());
            userDetailService.save(userDetailReq);

            List<UserRolReq> userRolReqList = userReq.getUserRolReqList();
            for (UserRolReq userRolReq : userRolReqList) {
                Optional<Rol> optionalRol = rolRepository.findById(userRolReq.getRolId());
                if (optionalRol.isPresent()) {
                    userRolReq.setUserId(user.getId());
                    userRolService.save(userRolReq);
                } else {
                    throw new NotFoundException("There is not found rol");
                }
            }
            return findFullDataUserById(user.getId());
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new DuplicatedKey(e.getMessage());
            } else {
                throw new Exception(e.getMessage());
            }
        }
    }


}
