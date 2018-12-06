package com.example.zfox.courseselection2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public enum LoginSuccess{
        Login(1),
        Password(2),
        Success(0);

        private int intValue;
        LoginSuccess(int value){
            intValue = value;
        }

        public int getIntValue(){
            return intValue;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtLogin = (TextView) findViewById(R.id.idLoginTxt);
        final TextView txtPassword = (TextView) findViewById(R.id.idPasswordTxt);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastError = null;

                switch (checkLogin(txtLogin.getText().toString(), txtPassword.getText().toString())){
                    case Login:
                        toastError.makeText(getApplicationContext(),getString(R.string.errLogin), toastError.LENGTH_LONG).show();
                        txtLogin.requestFocus();
                        break;

                    case Password:
                        toastError.makeText(getApplicationContext(),getString(R.string.errPassword), toastError.LENGTH_LONG).show();
                        txtPassword.requestFocus();
                        break;

                    default:
                        toastError.makeText(getApplicationContext(), "Success", toastError.LENGTH_LONG).show();
                        break;
                }

            }
        });
    }
    LoginSuccess checkLogin(String txtLogin, String txtPassword){
        String HoldLogin = "zach";
        String HoldPassword = "password";

        if(!(HoldLogin.equals(txtLogin))){
            return LoginSuccess.Login;
        }

        if(!(HoldPassword.equals(txtPassword))){
            return LoginSuccess.Password;
        }

        return LoginSuccess.Success;

    }
}




