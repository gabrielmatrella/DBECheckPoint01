package br.com.healthtrack.platform.controller;

import br.com.healthtrack.platform.domain.Receptor;
import br.com.healthtrack.platform.dto.ReceptorDTO;
import br.com.healthtrack.platform.service.hospital.ReceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receptores")
public class ReceptorController {

    @Autowired
    ReceptorService receptorService;

    @GetMapping
    public ResponseEntity<List<ReceptorDTO>> getReceptores() {
        return ResponseEntity.ok(
                receptorService.findReceptores()
                        .stream()
                        .map(ReceptorDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ReceptorDTO> getReceptor(@PathVariable Integer codigo) {
        return receptorService.findReceptor(codigo)
                .map(r -> ResponseEntity.ok(new ReceptorDTO(r)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReceptorDTO> createReceptor(@RequestBody @Valid Receptor receptor) {
        return ResponseEntity.ok(new ReceptorDTO(receptorService.createReceptor(receptor)));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ReceptorDTO> updateReceptor(@PathVariable Integer codigo, @RequestBody @Valid Receptor updatedData) {
        return receptorService.updateReceptor(codigo, updatedData)
                .map(r -> ResponseEntity.ok(new ReceptorDTO(r)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deleteReceptor(@PathVariable Integer codigo) {
        boolean deleted = receptorService.deleteReceptor(codigo);
        if(deleted) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
