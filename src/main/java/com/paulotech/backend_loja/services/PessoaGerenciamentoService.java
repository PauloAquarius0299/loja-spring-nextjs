package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Pessoa;
import com.paulotech.backend_loja.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    public String solicitarCodico(String email){
        Pessoa pessoa= pessoaRepository.findByEmail(email);
        String codigoRecuperacaoSenha = getCodigoRecuperacaoSenha(pessoa.getId());
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        Date dataValidacaoCodigo;
        pessoa.setDataEnvioCodico(new Date());
        pessoaRepository.save(pessoa);
        emailService.enviarEmailTexto(
                pessoa.getEmail(),
                "Código de recuperação de senha",
                "Aqui está seu código de recuperação de senha: " + codigoRecuperacaoSenha
        );
        return codigoRecuperacaoSenha;
    }

    public String alterarSenha(Pessoa pessoa) {
        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
        if(pessoaBanco != null){
            Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodico().getTime());
            if (diferenca.getTime() / 1000 < 900) {
                pessoaBanco.setSenha(pessoa.getSenha());
                pessoaBanco.setCodigoRecuperacaoSenha(null);
                pessoaRepository.save(pessoaBanco);
                return "Senha alterada com sucesso!";
            } else {
                return "Tempo expirado, solicite um novo codigo";
            }
        } else {
            return "Email ou codigo não encontrado!";
        }

    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssSS");
        return format.format(new Date()) + id;
    }
}
