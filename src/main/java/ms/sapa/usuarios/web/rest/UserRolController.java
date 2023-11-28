package ms.sapa.usuarios.web.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ms.sapa.usuarios.dto.request.UserRolReq;
import ms.sapa.usuarios.dto.response.UserRolRes;
import ms.sapa.usuarios.services.UserRolService;
import ms.sapa.usuarios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user-rol")
public class UserRolController {
    @Autowired
    private UserRolService userRolService;

    @GetMapping("/{id}")
    public ResponseEntity<UserRolRes> findById(@NotNull @PathVariable(name = "id") Long id) throws Exception{
        UserRolRes userRes = userRolService.findById(id);
        return ResponseEntity.ok().body(userRes);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<UserRolRes>> findAllFromUser(@NotNull @PathVariable(name = "id") Long id){
        List<UserRolRes> userResList = userRolService.findAllFromUser(id);
        return ResponseEntity.ok().body(userResList);
    }

    @PostMapping()
    public ResponseEntity<UserRolRes> create(@Valid @RequestBody UserRolReq userRolReq) throws Exception{
        UserRolRes userRes = userRolService.save(userRolReq);
        return ResponseEntity.ok().body(userRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRolRes> update(@NotNull @PathVariable(name = "id") Long id,
                                            @Valid @RequestBody UserRolReq userRolReq) throws Exception{
        UserRolRes userRes = userRolService.update(id,userRolReq);
        return ResponseEntity.ok().body(userRes);
    }
}
