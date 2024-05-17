package app;

import spark.*;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;
import static spark.Spark.*;
import java.util.*;

import dao.*;
import service.*;
import model.*;

public class Aplicacao {
    
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        
        
        VelocityTemplateEngine engine = new VelocityTemplateEngine();
        staticFiles.location("/public");
        
        port(5050);

        get("/registro",(request,response)-> cadastro(request, response), engine);
		post("/registro", (request, response) -> userService.registroEstudantes(request, response));

        get("/registro-instituicao",(request,response)-> cadastro(request, response), engine);
		post("/registro-instituicao", (request, response) -> userService.registroInstituicoes(request, response));

        get("/login",(request,response) -> login(request,response), engine);
		post("/login", (request, response) -> userService.loginEstudante(request, response));

        get("/login-instituicao",(request,response) -> login(request,response), engine);
		post("/login-instituicao", (request, response) -> userService.loginInstituicao(request, response));

        get("/perfil", (request, response) -> perfil(request, response), engine);

        // Rota para completar o registro do usuário
        post("/completarRegistro", (request, response) -> userService.completarRegistro(request, response));

        post("/deletarUsuario", (request, response) -> userService.deletarUsuario(request, response));
    }

        public static ModelAndView cadastro(Request request, Response response) {

            String message = request.session().attribute("message");
		    HashMap<String, Object> model = new HashMap<>();

            if(message != null){
                model.put(message, message);
                request.session().removeAttribute(message);
            }

		    return new ModelAndView(model, "paginas/registro.html");
	}

    public static ModelAndView login(Request request, Response response) {
		HashMap<String, Object> model = new HashMap<>();

		return new ModelAndView(model, "paginas/login.html");
	}

    public static ModelAndView perfil(Request request, Response response) {
        User currentUser = request.session().attribute("currentUser");
        if (currentUser == null) {
            response.redirect("/login");
            halt();
        }
        HashMap<String, Object> model = new HashMap<>();
        model.put("usuario", currentUser);
        return new ModelAndView(model, "paginas/perfil.vm");
    }
}