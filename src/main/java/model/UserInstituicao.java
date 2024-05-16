package model;

public class UserInstituicao {
    
    private int Id;
    private String nomeInstituicao;
    private String enderecoInstituicao;
    private String emailInstituicao;
    private String cnpj;
    private String senhaInstituicao;

    public UserInstituicao(String nome, String endereco, String email, String cnpj, String senha) {
        setCnpj(cnpj);
        setEmailInstituicao(email);
        setEnderecoInstituicao(endereco);
        setNomeInstituicao(nome);
        setSenhaInstituicao(senha);
    }

    public UserInstituicao(int id, String nome, String endereco, String email, String cnpj, String senha) {
        setId(id);
        setCnpj(cnpj);
        setEmailInstituicao(email);
        setEnderecoInstituicao(endereco);
        setNomeInstituicao(nome);
        setSenhaInstituicao(senha);
    }

    public int getId() {
        return Id;
    }

    public String getCnpj() {
        return cnpj;
    }
    public String getEmailInstituicao() {
        return emailInstituicao;
    }
    public String getEnderecoInstituicao() {
        return enderecoInstituicao;
    }
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    public String getSenhaInstituicao() {
        return senhaInstituicao;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setEmailInstituicao(String emailInstituicao) {
        this.emailInstituicao = emailInstituicao;
    }
    public void setEnderecoInstituicao(String enderecoInstituicao) {
        this.enderecoInstituicao = enderecoInstituicao;
    }
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
    public void setSenhaInstituicao(String senhaInstituicao) {
        this.senhaInstituicao = senhaInstituicao;
    }
    public void setId(int id) {
        Id = id;
    }
}
