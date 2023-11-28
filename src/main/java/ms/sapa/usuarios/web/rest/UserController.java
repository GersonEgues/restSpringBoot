package ms.sapa.usuarios.web.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ms.sapa.usuarios.dto.request.RolReq;
import ms.sapa.usuarios.dto.request.UserReq;
import ms.sapa.usuarios.dto.response.RolRes;
import ms.sapa.usuarios.dto.response.UserRes;
import ms.sapa.usuarios.services.RolService;
import ms.sapa.usuarios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserRes> findById(@NotNull @PathVariable(name = "id") Long id) throws Exception{
        UserRes userRes = userService.findById(id);
        return ResponseEntity.ok().body(userRes);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserRes>> findAll(){
        List<UserRes> userResList = userService.findAll();
        return ResponseEntity.ok().body(userResList);
    }

    @PostMapping()
    public ResponseEntity<UserRes> create(@Valid @RequestBody UserReq userReq) throws Exception{
        UserRes userRes = userService.save(userReq);
        return ResponseEntity.ok().body(userRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRes> update(@NotNull @PathVariable(name = "id") Long id,
                                         @Valid @RequestBody UserReq userReq) throws Exception{
        UserRes userRes = userService.update(id,userReq);
        return ResponseEntity.ok().body(userRes);
    }
}
