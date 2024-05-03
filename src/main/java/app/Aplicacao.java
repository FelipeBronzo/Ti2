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
		post("/registro", (request, response) -> userService.registro(request, response));
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
}