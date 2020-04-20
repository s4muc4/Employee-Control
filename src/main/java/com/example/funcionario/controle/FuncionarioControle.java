package com.example.funcionario.controle;

import com.example.funcionario.entidade.Funcionario;
import com.example.funcionario.servico.FuncionarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioControle {

	@Autowired
    private FuncionarioServico servico;
    
    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios(){
		ModelAndView mv = new ModelAndView("funcionariosTemplate");
		
	    mv.addObject("funcionarios", servico.getFuncionarios());
		System.out.println(mv);

        return mv;
    }

    @GetMapping("/erro")
    public ModelAndView erro(){
		ModelAndView mv = new ModelAndView("erro");
		
        return mv;
    }

    @PostMapping("/salvarFuncionario")
    public String salvar(@ModelAttribute Funcionario funcionario){

        boolean status = servico.salvar(funcionario);

        if(status){
            servico.salvar(funcionario);
            return "redirect:/funcionarios";
        }
        else{
            return "redirect:/erro";
        }
        
        
        
        
    }
}