package infrastructure.api.controller;

import domain.model.Cotacao;
import domain.service.CotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cotacoes")
@RequiredArgsConstructor
public class CotacaoController {

    private final CotacaoService cotacaoService;

    @PostMapping
    public ResponseEntity<Cotacao> criar(@RequestBody Cotacao cotacao) {
        Cotacao salva = cotacaoService.salvar(cotacao);
        return ResponseEntity.ok(salva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cotacao> buscar(@PathVariable String id) {
        return cotacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Cotacao>> listar() {
        return ResponseEntity.ok(cotacaoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        cotacaoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
