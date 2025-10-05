package br.com.biblioteca.biblioteca_pessoal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    // Criar um novo livro
    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    // Ler todos os livros
    @GetMapping
    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    // Ler um livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um livro
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro detalhesLivro) {
        return livroRepository.findById(id)
                .map(livro -> {
                    livro.setTitulo(detalhesLivro.getTitulo());
                    livro.setAutor(detalhesLivro.getAutor());
                    livro.setAnoPublicacao(detalhesLivro.getAnoPublicacao());
                    livro.setLido(detalhesLivro.isLido());
                    Livro livroAtualizado = livroRepository.save(livro);
                    return ResponseEntity.ok(livroAtualizado);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(livro -> {
                    livroRepository.delete(livro);
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}