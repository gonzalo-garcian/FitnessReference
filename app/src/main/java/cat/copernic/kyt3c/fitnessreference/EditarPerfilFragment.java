package cat.copernic.kyt3c.fitnessreference;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class EditarPerfilFragment extends Fragment {

    public FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.activity_editar_perfil_fragment, container, false);

        Objects.requireNonNull(mAuth.getCurrentUser()).updateEmail("updated@gmail.com");

        return vista;
    }
}
