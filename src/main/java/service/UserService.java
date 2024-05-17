package service;

import spark.*;
import dao.UserDAO;
import model.User;
import model.UserInstituicao;
import model.UserInstituicao;

import java.security.*;
import java.time.*;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.LocalConnector;

import static spark.Spark.halt;
import static spark.Spark.redirect;

import java.math.*;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public Object registroEstudantes(Request request, Response response) {
		String nome = request.queryParams("fullname");
        String email = request.queryParams("email");
		String senha = request.queryParams("password");
		String telefone = request.queryParams("telefone");

		User user = new User(nome, email, senha, telefone);

		if (userDAO.inserirEstudantes(user) == true) {
        request.session().attribute("message", "Usuário cadastrado com sucesso!");
		response.redirect("/login");
		} else {
        request.session().attribute("message", "Erro ao cadastrar usuário");
		}

		return response;
	}

	public Object registroInstituicoes(Request request, Response response) {
		String nome = request.queryParams("nameinstituicao");
		String endereco = request.queryParams("enderecoinstituicao");
        String email = request.queryParams("emailinstituicao");
		String cnpj = request.queryParams("cnpj");
		String senha = request.queryParams("passwordinstituicao");
		

		UserInstituicao userinstituicao = new UserInstituicao(nome, endereco, email, cnpj, senha);

		if (userDAO.inserirInstituicao(userinstituicao) == true) {
        request.session().attribute("message", "Usuário cadastrado com sucesso!");
		} else {
        request.session().attribute("message", "Erro ao cadastrar usuário");
		}

		return response;
	}

	public Object loginEstudante(Request request, Response response) {
		String email = request.queryParams("emailAcessoEstudante");
		String senha = request.queryParams("senhaAcessoEstudante");
	
		User user = userDAO.getEstudantes(email, senha);
	
		if (user != null) {
			// Cria uma sessão para o usuário
			Session session = request.session(true);
			session.attribute("currentUser", user); // Armazena o objeto do usuário na sessão
			response.redirect("/perfil");
		} else {
			response.status(401);
			response.redirect("/registro");
		}
	
		return response;
	}

	public Object loginInstituicao(Request request, Response response) {
		String email = request.queryParams("emailAcessoInstituicao");
		String senha = request.queryParams("senhaAcessoInstituicao");
	
		UserInstituicao user = userDAO.getInstituicoes(email, senha);
	
		if (user != null) {
			// Cria uma sessão para o usuário
			Session session = request.session(true);
			session.attribute("currentUser", user); // Armazena o objeto do usuário na sessão
			response.redirect("/perfil");
		} else {
			response.status(401);
			response.redirect("/registro");
		}
	
		return response;
	}

	public Object completarRegistro(Request request, Response response) {
        int id = Integer.parseInt(request.queryParams("id"));
        String nomeFaculdade = request.queryParams("nome_faculdade");
        String descricao = request.queryParams("descricao");
        String curso = request.queryParams("curso");
        int anoPrevistoConclusao = Integer.parseInt(request.queryParams("ano_previsto_conclusao"));

        boolean updateSuccess = userDAO.completarRegistro(id, nomeFaculdade, descricao, curso, anoPrevistoConclusao);

        if (updateSuccess) {
            User updatedUser = userDAO.getUserById(id);
            request.session().attribute("currentUser", updatedUser);
            request.session().attribute("message", "Registro completado com sucesso!");
        } else {
            request.session().attribute("message", "Erro ao completar registro");
        }

        response.redirect("/perfil");
        return response;
    }

	public Object deletarUsuario(Request request, Response response) {
        int id = Integer.parseInt(request.queryParams("id"));
        boolean deleteSuccess = userDAO.deletarUsuario(id);

        if (deleteSuccess) {
            request.session().removeAttribute("currentUser");
            request.session().attribute("message", "Usuário deletado com sucesso!");
        } else {
            request.session().attribute("message", "Erro ao deletar usuário");
        }

        response.redirect("/login");
        return response;
    }

	public User getCurrentUser(Request request) {
        return request.session().attribute("currentUser");
    }

}
