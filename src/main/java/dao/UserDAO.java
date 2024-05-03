package dao;

import java.sql.*;
import model.User;

public class UserDAO extends DAO {
    
    public UserDAO() {
		super();
		conectar();
	}

    public boolean inserir(User user) {
		boolean status = false;

		try {
			String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

			PreparedStatement preparedStatement = conexao.prepareStatement(sql);

			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getSenha());

			preparedStatement.executeUpdate();
			preparedStatement.close();

			status = true;
		} catch (SQLException e) {
			System.err.println(e);
		}

		return status;
	}

}
