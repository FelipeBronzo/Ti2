package model;

public class User {

    private int id;
    private String nome;
    private String email;
    private String senha;

    public User(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }
  
    public User(int id,String nome, String email, String senha) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public int getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getSenha() {
        return this.senha;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
