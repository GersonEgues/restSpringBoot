package ms.sapa.usuarios.web.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ms.sapa.usuarios.domain.entities.Rol;
import ms.sapa.usuarios.dto.request.RolReq;
import ms.sapa.usuarios.dto.response.RolRes;
import ms.sapa.usuarios.services.RolService;
import ms.sapa.usuarios.services.implement.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/{id}")
    public ResponseEntity<RolRes> findById(@NotNull @PathVariable(name = "id") Long id) throws Exception{
        RolRes rolRes = rolService.findById(id);
        return ResponseEntity.ok().body(rolRes);
    }

    @GetMapping("/list")
    public ResponseEntity<List<RolRes>> findAll(){
        List<RolRes> roleResList = rolService.findAll();
        return ResponseEntity.ok().body(roleResList);
    }

    @PostMapping()
    public ResponseEntity<RolRes> create(@Valid @RequestBody RolReq rolReq) throws Exception{
        RolRes rolRes = rolService.save(rolReq);
        return ResponseEntity.ok().body(rolRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolRes> update(@NotNull @PathVariable(name = "id") Long id,
                                         @Valid @RequestBody RolReq rolReq) throws Exception{
        RolRes rolRes = rolService.update(id,rolReq);
        return ResponseEntity.ok().body(rolRes);
    }
}
