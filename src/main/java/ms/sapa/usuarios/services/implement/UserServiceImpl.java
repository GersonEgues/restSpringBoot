package ms.sapa.usuarios.services.implement;

import ms.sapa.usuarios.domain.entities.Users;
import ms.sapa.usuarios.dto.request.UserReq;
import ms.sapa.usuarios.dto.response.UserRes;
import ms.sapa.usuarios.repositories.spring.data.UserRepository;
import ms.sapa.usuarios.services.UserService;
import ms.sapa.usuarios.services.customException.DuplicatedKey;
import ms.sapa.usuarios.services.customException.NotFoundException;
import ms.sapa.usuarios.services.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserRes findById(Long id) throws Exception {
        Optional<Users> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userMapper.toDto(userOptional.get());
        }else{
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
        try{
            Users user = userMapper.toEntity(userReq);
            return userMapper.toDto(userRepository.save(user));
        }catch (Exception e){
            if(e instanceof DataIntegrityViolationException) {
                throw new DuplicatedKey(e.getMessage());
            }else{
                throw new Exception(e.getMessage());
            }
        }
    }

    @Override
    public UserRes update(Long id, UserReq userReq) throws Exception {
        Optional<Users> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            Users user = userMapper.merge(userOptional.get(),userReq);
            user = userRepository.save(user);
            return userMapper.toDto(user);
        }else{
            throw new NotFoundException("there is not found user with id");
        }
    }
}
