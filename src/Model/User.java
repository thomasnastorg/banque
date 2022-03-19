package Model;

import java.util.ArrayList;

public class User {

    private int niveaux;
    private String login;
    private String pwd;

    public User(int niveaux, String login, String pwd) {
        this.niveaux = niveaux;
        this.login = login;
        this.pwd = pwd;
    }

    public int getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(int niveaux) {
        this.niveaux = niveaux;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}

