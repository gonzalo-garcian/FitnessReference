package cat.copernic.kyt3c.fitnessreference;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TabEntrenamiento extends Fragment {

    RecyclerView recyclerEntrenamientos;
    ArrayList<Entrenamiento> listaEntrenamientos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.tabentrenamientos, container, false);
        listaEntrenamientos = new ArrayList<>();
        recyclerEntrenamientos = vista.findViewById(R.id.recyclerEntrenamiento);
        recyclerEntrenamientos.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        return vista;

    }

    private void llenarLista() {
        listaEntrenamientos.add(new Entrenamiento("Sprints","Carrerar cortas donde priorizamos velocidad"));
    }

}
