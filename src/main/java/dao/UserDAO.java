package dao;

import java.sql.*;
import model.User;
import model.UserInstituicao;

public class UserDAO extends DAO {
    
    public UserDAO() {
		super();
		conectar();
	}

    public boolean inserirEstudantes(User user) {
		boolean status = false;

		try {
			String sql = "INSERT INTO usuariosestudantes (nomecompleto, email, senha, telefone) VALUES (?, ?, ?, ?)";

			PreparedStatement preparedStatement = conexao.prepareStatement(sql);

			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getSenha());
			preparedStatement.setString(4, user.getTelefone());

			preparedStatement.executeUpdate();
			preparedStatement.close();

			status = true;
		} catch (SQLException e) {
			System.err.println(e);
		}

		return status;
	}

	public boolean inserirInstituicao(UserInstituicao user) {
		boolean status = false;

		try {
			String sql = "INSERT INTO usuariosinstitucionais (nomeinstituicao, endereco, emailinstitucional, cnpj, senha) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = conexao.prepareStatement(sql);

			preparedStatement.setString(1, user.getNomeInstituicao());
			preparedStatement.setString(2, user.getEnderecoInstituicao());
			preparedStatement.setString(3, user.getEmailInstituicao());
			preparedStatement.setString(4, user.getCnpj());
			preparedStatement.setString(5, user.getSenhaInstituicao());

			preparedStatement.executeUpdate();
			preparedStatement.close();

			status = true;
		} catch (SQLException e) {
			System.err.println(e);
		}

		return status;
	}

	public User getEstudantes(String email, String senha) {
		User user = null;

		try {
			String sql = "SELECT * FROM usuariosestudantes WHERE email=? AND senha=?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("nomecompleto"), rs.getString("email"),
						rs.getString("senha"), rs.getString("telefone") );
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

		return user;
	}

	public UserInstituicao getInstituicoes(String email, String senha) {
		UserInstituicao userInstituicao = null;

		try {
			String sql = "SELECT * FROM usuariosinstitucionais WHERE emailinstitucional=? AND senha=?";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userInstituicao = new UserInstituicao(rs.getInt("id"), rs.getString("nomeinstituicao"), rs.getString("endereco"),
						rs.getString("emailinstitucional"), rs.getString("cnpj"), rs.getString("senha") );
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

		return userInstituicao;
	}

}
