package cat.copernic.kyt3c.fitnessreference;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class LogInActivity extends BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "EmailPassword";
    Button btnIdioma;
    private EditText mEmailField;
    private EditText mPasswordField;
    ImageView imageView;

    // [START declare_auth]
    public FirebaseAuth mAuth = FirebaseAuth.getInstance();
    // [END declare_auth]

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_login);

        // Views
        mEmailField = findViewById(R.id.etEmailLogin);
        mPasswordField = findViewById(R.id.etPasswordLogin);
        btnIdioma = findViewById(R.id.btnIdioma);
        btnIdioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();

            }
        });



        // Buttons
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnSignUp).setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        rotarImagen(imageView);
    }

    private void showChangeLanguageDialog() {
        final String[] listIdiomas = {"Español", "Català"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(LogInActivity.this);
        mBuilder.setTitle("Seleccione Idioma : ");
        mBuilder.setSingleChoiceItems(listIdiomas, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i == 0){
                    setLocale("es");
                    recreate();
                }
                else if(i == 1){
                    setLocale("ca");
                    recreate();
                }

            }
        });
        AlertDialog mDialog = mBuilder.create();

        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();

    }
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

    private void rotarImagen(View view){
        RotateAnimation animation = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(2000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    // [END on_start_check_user]


    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            Intent intent = new Intent(LogInActivity.this, MenuActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }


    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }

    private void updateUI(FirebaseUser user) {
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnLogin) {
            signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());

        } else if (i == R.id.btnSignUp) {
            Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);

        }

    }

}