package com.example.funcionario.servico;

import java.util.List;

import com.example.funcionario.entidade.Funcionario;
import com.example.funcionario.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

@Service
public class FuncionarioServico {

	@Autowired
    private FuncionarioRepository repository;
    
    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public boolean salvar(Funcionario funcionario){
        if(funcionario.getNome()==""  | funcionario.getEndereco()== ""  | funcionario.getCpf()=="" | funcionario.getDataInicio()=="" | funcionario.getSetor()=="")
        {
            return false;
        }
        else{
            repository.save(funcionario);
            return true;
        }
        
    }
}
