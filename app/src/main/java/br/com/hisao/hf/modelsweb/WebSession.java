package br.com.hisao.hf.modelsweb;

/**
 * Created by viniciushisao.
 */


public class WebSession {

    private static WebSession instance;

    private WebSession() {
    }

    public static WebSession getInstance(){
        if (instance == null){
            instance = new WebSession();
        }
        return instance;
    }

    //TODO implement it
    public boolean isLogged(){
        return false;
    }
}
