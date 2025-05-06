package infrastructure.api.controller;

import domain.model.Ativo;
import domain.service.AtivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ativos")
@RequiredArgsConstructor
public class AtivoController {

    private final AtivoService ativoService;

    @PostMapping
    public ResponseEntity<Ativo> criar(@RequestBody Ativo ativo) {
        Ativo criado = ativoService.salvar(ativo);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<Ativo>> listarTodos() {
        return ResponseEntity.ok(ativoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ativo> buscarPorId(@PathVariable String id) {
        return ativoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        ativoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
