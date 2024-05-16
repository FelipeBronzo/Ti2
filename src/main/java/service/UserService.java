package service;

import spark.*;
import dao.UserDAO;
import model.User;
import model.UserInstituicao;
import model.UserInstituicao;

import java.security.*;
import java.time.*;

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
			response.redirect("/teste");
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
			response.redirect("/teste");
		} else {
			response.status(401);
			response.redirect("/registro");
		}
	
		return response;
	}

}
