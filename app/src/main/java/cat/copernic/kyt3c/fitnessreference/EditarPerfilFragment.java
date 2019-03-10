package cat.copernic.kyt3c.fitnessreference;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class EditarPerfilFragment extends Fragment implements View.OnClickListener {

    private EditText editTextName, editTextEmail, editTextPassword, editTextPhone;
    private Button button_update;

    private FirebaseAuth mAuth;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.activity_editar_perfil_fragment,container,false);

        editTextName = vista.findViewById(R.id.update_text_name);
        editTextEmail = vista.findViewById(R.id.update_text_email);
        editTextPassword = vista.findViewById(R.id.update_text_password);
        editTextPhone = vista.findViewById(R.id.update_text_phone);
        button_update = vista.findViewById(R.id.button_update);

        mAuth = FirebaseAuth.getInstance();

        vista.findViewById(R.id.button_update).setOnClickListener(this);

        return vista;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void registerUser() {

        button_update.setEnabled(false);

        final String name = editTextName.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();

        if (name.isEmpty()) {
            editTextName.setError(getString(R.string.input_error_name));
            editTextName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError(getString(R.string.input_error_email));
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError(getString(R.string.input_error_email_invalid));
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError(getString(R.string.input_error_password));
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError(getString(R.string.input_error_password_length));
            editTextPassword.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            editTextPhone.setError(getString(R.string.input_error_phone));
            editTextPhone.requestFocus();
            return;
        }

        if (phone.length() != 9) {
            editTextPhone.setError(getString(R.string.input_error_phone_invalid));
            editTextPhone.requestFocus();
            return;
        }

        Objects.requireNonNull(mAuth.getCurrentUser()).updatePassword(password);
        Objects.requireNonNull(mAuth.getCurrentUser()).updateEmail(email);

        User user = new User(
                name,
                email,
                phone
        );

        FirebaseDatabase.getInstance().getReference("Users")
                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getContext(), "Update Completado", Toast.LENGTH_LONG).show();
                    button_update.setEnabled(false);
                    editTextEmail.setText("");
                    editTextName.setText("");
                    editTextPassword.setText("");
                    editTextPhone.setText("");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_update:
                registerUser();
                break;
        }
    }
}