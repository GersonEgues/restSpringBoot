package ms.sapa.usuarios.services.implement;

import ms.sapa.usuarios.domain.entities.UserDetail;
import ms.sapa.usuarios.domain.entities.Users;
import ms.sapa.usuarios.dto.request.UserDetailReq;
import ms.sapa.usuarios.dto.response.UserDetailRes;
import ms.sapa.usuarios.repositories.spring.data.UserDetailRepository;
import ms.sapa.usuarios.repositories.spring.data.UserRepository;
import ms.sapa.usuarios.services.UserDetailService;
import ms.sapa.usuarios.services.customException.NotFoundException;
import ms.sapa.usuarios.services.mapper.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailRes findById(Long id) throws Exception {
        Optional<UserDetail> optionalUserDetail = userDetailRepository.findById(id);
        if (optionalUserDetail.isPresent()) {
            UserDetail userDetail = optionalUserDetail.get();
            return userDetailMapper.toDto(userDetail);
        } else {
            throw new NotFoundException("Thres is not found userDetail with id: " + id);
        }
    }

    @Override
    public UserDetailRes findFromUser(Long id) {
        Optional<UserDetail> userDetail = userDetailRepository.findFromUser(id);
        return userDetailMapper.toDto(userDetail.get());
    }

    @Override
    public UserDetailRes save(UserDetailReq userDetailReq) throws Exception {
        Optional<Users> optionalUser = userRepository.findById(userDetailReq.getUserId());
        try {
            if (optionalUser.isPresent()) {
                Users user = optionalUser.get();
                UserDetail userDetail = userDetailMapper.toEntity(userDetailReq);
                userDetail.setUsers(user);
                userDetail = userDetailRepository.save(userDetail);
                return userDetailMapper.toDto(userDetail);
            } else {
                throw new NotFoundException("There is not user from id: " + userDetailReq.getUserId());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public UserDetailRes update(Long id, UserDetailReq userDetailReq) throws Exception {
        Optional<Users> optionalUser = userRepository.findById(userDetailReq.getUserId());
        Optional<UserDetail> optionalUserDetail = userDetailRepository.findById(id);
        try {
            if (optionalUser.isPresent() && optionalUserDetail.isPresent()) {
                Users user = optionalUser.get();
                UserDetail userDetail = optionalUserDetail.get();
                userDetail = userDetailMapper.merge(userDetail,userDetailReq);
                userDetail.setUsers(user);
                userDetail = userDetailRepository.save(userDetail);
                return userDetailMapper.toDto(userDetail);
            } else {
                throw new NotFoundException("There is not user from id: " + userDetailReq.getUserId());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
