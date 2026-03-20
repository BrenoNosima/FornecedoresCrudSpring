package com.bn.fornecedorcs.services;

import com.bn.fornecedorcs.models.FornecedorModel;
import com.bn.fornecedorcs.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorModel criar(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }

    public List<FornecedorModel> listar() {
        return fornecedorRepository.findAll();
    }

    public FornecedorModel procurarPorId(Long id) {
        return fornecedorRepository.findById(id).get();
    }

    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
