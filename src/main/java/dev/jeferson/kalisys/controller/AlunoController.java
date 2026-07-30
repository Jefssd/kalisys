package dev.jeferson.kalisys.controller;

import dev.jeferson.kalisys.dto.AlunoRequest;
import dev.jeferson.kalisys.dto.AlunoResponse;
import dev.jeferson.kalisys.service.AlunoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrar(@RequestBody AlunoRequest alunoRequest){
        return alunoService.cadastrar(alunoRequest);
    }

    @GetMapping
    public Page<AlunoResponse> listar(Pageable pageable){
        return alunoService.listar(pageable);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable  Long id){
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody  AlunoRequest alunoRequest){
        return alunoService.atualizar(id, alunoRequest);
    }

    @DeleteMapping("/{id}")
    public  void excluir(@PathVariable Long id){
        alunoService.excluir(id);
    }
}
