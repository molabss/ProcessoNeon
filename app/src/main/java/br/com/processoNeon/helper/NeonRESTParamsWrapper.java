package br.com.processoNeon.helper;

/**
 * Created by Moisés on 07/08/2016.
 */
public class NeonRESTParamsWrapper {

    public NeonRESTParamsWrapper(String url, String token, String clientID, String valor) {
        this.url = url;
        this.token = token;
        this.clientID = clientID;
        this.valor = valor;
    }

    public NeonRESTParamsWrapper(String url, String token) {
        this.url = url;
        this.token = token;
    }

    private String url;
    private String token;
    private String email;
    private String nome;
    private String clientID;
    private String valor;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getValor() {
        valor = valor.replace("R$","").trim();
        return valor;
    }

    public void setValor(String valor) {
        if(valor.length() == 0)valor = "0";
        this.valor = valor;
    }
}
