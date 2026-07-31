package dev.jeferson.kalisys.specification;

import dev.jeferson.kalisys.domain.Aluno;
import dev.jeferson.kalisys.dto.AlunoFiltroRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.swing.text.html.HTMLDocument;

public class AlunoSpecification {
    public static HTMLDocument.HTMLReader.SpecialAction<Aluno> comFiltros(AlunoFiltroRequest filtro){
        return Specification
                .where(nomeContem(filtro.nome()))
                .and(emailContem(filtro.email()))
                .and(celularContem(filtro.celular()))
                .and(cidadeContem(filtro.cidade()))
                .and(estadoIgual(filtro.estado()));

    }

    private  static Specification<Aluno> nomeContem(String nome){
        return  (root, query, cb) -> {
            if (nome == null || nome.isBlank()){
                return null;
            }
            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    private  static Specification<Aluno> emailContem(String email){
        return  (root, query, cb) -> {
            if (email == null || email.isBlank()){
                return null;
            }
            return cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
        };
    }

    private  static Specification<Aluno> celularContem(String celular){
        return  (root, query, cb) -> {
            if (celular == null || celular.isBlank()){
                return null;
            }
            return cb.like(cb.lower(root.get("celular")), "%" + celular.toLowerCase() + "%");
        };
    }

    private  static Specification<Aluno> cidadeContem(String cidade){
        return  (root, query, cb) -> {
            if (cidade == null || cidade.isBlank()){
                return null;
            }
            return cb.like(cb.lower(root.get("cidade")), "%" + cidade.toLowerCase() + "%");
        };
    }

    private  static Specification<Aluno> estadoIgual(String estado){
        return  (root, query, cb) -> {
            if (estado == null || estado.isBlank()){
                return null;
            }
            return cb.equal(cb.upper(root.get("estado")), estado.toLowerCase());
        };
    }
}
