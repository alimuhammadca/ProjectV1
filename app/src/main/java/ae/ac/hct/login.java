package ae.ac.hct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private ProgressBar progressBar;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();
    }


    public void onSignInClick(View view){
        if(isInputEmpty()){
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String message = "Sign In successful";
                Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(login.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String message = "Sign in failed! " + e.getMessage();
                        Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
    }

    public void onRegisterClick(View view){
        if(isInputEmpty()){
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String message = "Registration successful";
                Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String message = "Registration failed! " + e.getMessage();
                        Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
    }


    public void onBackClick(View view){
        finish();
    }

    private boolean isInputEmpty(){
        if(TextUtils.isEmpty(etEmail.getText().toString())){
            etEmail.setError("REQUIRED!");
            return true;
        }
        if(TextUtils.isEmpty(etPassword.getText().toString())){
            etPassword.setError("REQUIRED!");
            return true;
        }
        return false;
    }
}
