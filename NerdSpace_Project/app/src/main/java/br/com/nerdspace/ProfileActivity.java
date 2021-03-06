package br.com.nerdspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private TextView textViewUserEmail;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() == null){

            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }

        FirebaseUser user = mAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Olá, " + user.getEmail() +
                                "\n\n Seja Bem-vindo! \n" +
                                "\n\n Ainda não fui construído =/ " +
                                "\n\n Mas não se preocupe," +
                                "\n em breve estaremos juntos\n " +
                                "e tenho certeza\n " +
                                "que você irá adorar o nosso encontro! ...bye <3");

        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(this);

    } /***fim onCreate method ***/


    @Override
    public void onClick(View view) {

        if(view == buttonLogout){

            mAuth.signOut();
            LoginManager.getInstance().logOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

    }

} /***fim ProfileActivity ***/

