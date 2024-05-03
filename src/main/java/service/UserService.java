package service;

import spark.*;
import dao.UserDAO;
import model.User;
import java.security.*;
import java.time.*;

import org.eclipse.jetty.server.LocalConnector;

import static spark.Spark.halt;
import static spark.Spark.redirect;

import java.math.*;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public Object registro(Request request, Response response) {
		String nome = request.queryParams("fullname");
        String email = request.queryParams("email");
		String senha = request.queryParams("password");

		User user = new User(nome, email, senha);

		if (userDAO.inserir(user) == true) {
        request.session().attribute("message", "Usuário cadastrado com sucesso!");
		} else {
        request.session().attribute("message", "Erro ao cadastrar usuário");
		}

		return response;
	}

	public Object login(Request request, Response response) {
		String email = request.queryParams("emailacesso");
		String senha = request.queryParams("senhaacesso");
	
		User user = userDAO.get(email, senha);
	
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
