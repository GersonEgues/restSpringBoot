package ms.sapa.usuarios.services.implement;

import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.dto.request.RolReq;
import ms.sapa.usuarios.dto.response.RolRes;
import ms.sapa.usuarios.repositories.spring.data.RolRepository;
import ms.sapa.usuarios.services.RolService;
import ms.sapa.usuarios.services.customException.DuplicatedKey;
import ms.sapa.usuarios.services.customException.NotFoundException;
import ms.sapa.usuarios.services.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private RolMapper rolMapper;

    @Override
    public RolRes findById(Long id) throws Exception {
        RolRes rolRes=null;
        Optional<Rol> optionalRol = rolRepository.findById(id);
        if(optionalRol.isPresent()){
            return rolMapper.toDto(optionalRol.get());
        }
        else{
            throw new NotFoundException("Rol not found");
        }
    }

    @Override
    public List<RolRes> findAll() {
        List<Rol> rolList = rolRepository.findAll();
        return rolList.stream()
                .map(rolMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolRes save(RolReq rolReq) throws Exception {
        try{
            Rol newRol = rolRepository.save(rolMapper.toEntity(rolReq));
            return rolMapper.toDto(newRol);
        }catch (Exception e){
            if(e instanceof DataIntegrityViolationException) {
                throw new DuplicatedKey(e.getMessage());
            }else{
                throw new Exception(e.getMessage());
            }
        }
    }

    public RolRes update(Long id,RolReq rolReq) throws Exception {
        try{
            Optional<Rol> rolOptional = rolRepository.findById(id);
            if(rolOptional.isPresent()){
                Rol rol = rolMapper.merge(rolOptional.get(),rolReq);
                return rolMapper.toDto(rolRepository.save(rol));
            }else{
                throw new NotFoundException("Rol not found");
            }
        }catch (Exception e){
            if(e instanceof DataIntegrityViolationException) {
                throw new DuplicatedKey(e.getMessage());
            }else{
                throw new Exception(e.getMessage());
            }
        }
    }

    @Override
    public List<RolRes> findRolListFromUser(Long userId) {
        List<Rol> rolList = rolRepository.findRolListFromUser(userId);
        return rolList.stream()
                .map(rolMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Optional<Rol> optionalRol = rolRepository.findById(id);
            if(optionalRol.isPresent()){
                rolRepository.delete(optionalRol.get());
            }else{
                throw new NotFoundException("There is not rol with id :" + id);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
