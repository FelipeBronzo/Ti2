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

	public User get(String email, String senha) {
		User user = null;

		try {
			String sql = "SELECT * FROM usuario WHERE email=? AND senha=?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
						rs.getString("senha") );
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

		return user;
	}

}
