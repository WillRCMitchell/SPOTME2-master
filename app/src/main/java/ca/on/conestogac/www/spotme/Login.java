package ca.on.conestogac.www.spotme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;



    public class Login extends AppCompatActivity implements OnClickListener,
            OnEditorActionListener {
        private EditText username;
        private EditText password;
        private Button loginButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            username = (EditText) findViewById(R.id.loginInput);
            password = (EditText) findViewById(R.id.passwordInput);
            loginButton = (Button) findViewById(R.id.loginButton);
            username.setOnEditorActionListener(this);
            password.setOnEditorActionListener(this);
            loginButton.setOnClickListener(this);
        }
        int counter = 3;

        public void onClick(View view) {
            if (username.getText().toString().equals("admin") &&
                    password.getText().toString().equals("admin")) {
                Toast.makeText(getApplicationContext(), "Redirecting",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this,userProfile.class));
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Credentials",
                        Toast.LENGTH_SHORT).show();
            }
            counter--;
            if (counter == 0) {
                loginButton.setEnabled(false);
            }

        }
        public void onClickSignUp(View view) {

                Toast.makeText(getApplicationContext(), "Redirecting",
                        Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this,SignUpScreen.class));
        }
        public void onClickForgot(View view) {

            Toast.makeText(getApplicationContext(), "Redirecting",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this,forgotPasswordScreen.class));
        }
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            return false;
        }
    }
