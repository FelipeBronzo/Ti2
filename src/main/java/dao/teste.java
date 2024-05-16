package dao;

import java.sql.*;
import model.User;

public class teste {

    public static void main(String[]args){
        UserDAO user = new UserDAO();
        User u = new User("nome", "email", "123", "2319083");
        user.inserirEstudantes(u);
    }

} 
