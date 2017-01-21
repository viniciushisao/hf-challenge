package br.com.hisao.hf.Model;

/**
 * Created by viniciushisao.
 */

public class User {

    public String email;

    public User(String email, String latlng, String name) {
        this.email = email;
        this.latlng = latlng;
        this.name = name;
    }

    public String latlng;
    public String name;
}
