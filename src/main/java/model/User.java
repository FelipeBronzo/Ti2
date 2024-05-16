package model;

public class User {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String nome_faculdade;
    private String descricao;
    private String curso;
    private int ano_previsto_conclusao;

    public User(String nome, String email, String senha, String telefone) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setTelefone(telefone);
    }
  
    public User(int id,String nome, String email, String senha, String telefone) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setTelefone(telefone);
    }

    public User(int id,String nome, String email, String senha, String telefone, String nome_faculdade, String descricao, String curso, int ano_previsto_conclusao) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setTelefone(telefone);
        setNome_faculdade(nome_faculdade);
        setDescricao(descricao);
        setCurso(curso);
        setAno_previsto_conclusao(ano_previsto_conclusao);
    }

    public int getAno_previsto_conclusao() {
        return ano_previsto_conclusao;
    }
    public String getCurso() {
        return curso;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getNome_faculdade() {
        return nome_faculdade;
    }
    public String getTelefone() {
        return telefone;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    public void setAno_previsto_conclusao(int ano_previsto_conclusao) {
        this.ano_previsto_conclusao = ano_previsto_conclusao;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setNome_faculdade(String nome_faculdade) {
        this.nome_faculdade = nome_faculdade;
    }
}
