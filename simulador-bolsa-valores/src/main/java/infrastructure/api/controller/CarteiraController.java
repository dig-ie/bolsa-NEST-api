package infrastructure.api.controller;

import domain.model.Carteira;
import domain.service.CarteiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carteiras")
@RequiredArgsConstructor
public class CarteiraController {

    private final CarteiraService carteiraService;

    @PostMapping
    public ResponseEntity<Carteira> criar(@RequestBody Carteira carteira) {
        Carteira criada = carteiraService.salvar(carteira);
        return ResponseEntity.ok(criada);
    }

    @GetMapping
    public ResponseEntity<List<Carteira>> listarTodas() {
        return ResponseEntity.ok(carteiraService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carteira> buscarPorId(@PathVariable String id) {
        return carteiraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        carteiraService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
