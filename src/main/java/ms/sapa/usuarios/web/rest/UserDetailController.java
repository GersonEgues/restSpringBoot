package ms.sapa.usuarios.web.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ms.sapa.usuarios.dto.request.UserDetailReq;
import ms.sapa.usuarios.dto.response.UserDetailRes;
import ms.sapa.usuarios.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user-detail")
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailRes> findById(@NotNull @PathVariable(name = "id") Long id) throws Exception{
        UserDetailRes userDetailRes = userDetailService.findById(id);
        return ResponseEntity.ok().body(userDetailRes);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDetailRes> findFromUser(@NotNull @PathVariable(name = "id") Long id) throws Exception {
        UserDetailRes userDetailRes = userDetailService.findFromUser(id);
        return ResponseEntity.ok().body(userDetailRes);
    }

    @PostMapping()
    public ResponseEntity<UserDetailRes> create(@Valid @RequestBody UserDetailReq userDetailReq) throws Exception{
        UserDetailRes userDetailRes = userDetailService.save(userDetailReq);
        return ResponseEntity.ok().body(userDetailRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailRes> update(@NotNull @PathVariable(name = "id") Long id,
                                                @Valid @RequestBody UserDetailReq userDetailReq) throws Exception{
        UserDetailRes userRes = userDetailService.update(id,userDetailReq);
        return ResponseEntity.ok().body(userRes);
    }
}
