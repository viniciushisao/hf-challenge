package br.com.hisao.hf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.login);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText email = (EditText) findViewById(R.id.email);
        final TextView result = (TextView) findViewById(R.id.result);
        result.setVisibility(View.GONE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isValidEmail(email.getText().toString().trim())) {
                    result.setVisibility(View.VISIBLE);
                    result.setText(R.string.email_not_valid);
                } else if (!isValidPassword(password.getText().toString().trim())) {
                    result.setVisibility(View.VISIBLE);
                    result.setText(R.string.password_not_valid);
                } else {
                    result.setVisibility(View.GONE);
                    //TODO implement login
                }
            }
        });

    }

    private boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        return (password != null && password.length() > 0);
    }
}
