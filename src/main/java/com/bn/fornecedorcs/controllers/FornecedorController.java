package com.bn.fornecedorcs.controllers;

import com.bn.fornecedorcs.models.FornecedorModel;
import com.bn.fornecedorcs.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> salvar(@RequestBody FornecedorModel fornecedorModel) {
        FornecedorModel request = fornecedorService.criar(fornecedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/fornecedores/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listar() {
        List<FornecedorModel> request = fornecedorService.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorModel> procurarPorId(@PathVariable Long id) {
        FornecedorModel request = fornecedorService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
