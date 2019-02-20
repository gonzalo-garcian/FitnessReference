package cat.copernic.kyt3c.fitnessreference;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerviewFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;
    ArrayList<String> actividades;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.activity_recicler,container,false);

        actividades = new ArrayList<>();

        actividades.add("Actividad 1: Saltos");
        actividades.add("Actividad 2: Sprints");
        actividades.add("Actividad 3: Saltos");
        actividades.add("Actividad 4: Sprints");
        actividades.add("Actividad 5: Saltos");
        actividades.add("Actividad 6: Sprints");
        actividades.add("Actividad 7: Saltos");
        actividades.add("Actividad 8: Sprints");
        actividades.add("Actividad 9: Saltos");
        actividades.add("Actividad 10: Sprints");
        actividades.add("Actividad 11: Saltos");
        actividades.add("Actividad 12: Sprints");
        actividades.add("Actividad 1: Saltos");
        actividades.add("Actividad 2: Sprints");
        actividades.add("Actividad 3: Saltos");
        actividades.add("Actividad 4: Sprints");
        actividades.add("Actividad 5: Saltos");
        actividades.add("Actividad 6: Sprints");
        actividades.add("Actividad 7: Saltos");
        actividades.add("Actividad 8: Sprints");
        actividades.add("Actividad 9: Saltos");
        actividades.add("Actividad 10: Sprints");
        actividades.add("Actividad 11: Saltos");
        actividades.add("Actividad 12: Sprints");

        RecyclerView recyclerView = vista.findViewById(R.id.activi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyRecyclerViewAdapter(getContext(), actividades);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return vista;
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "Este ejericio es" + adapter.getItem(position) + " y debes repetirlo " + position + " veces.", Toast.LENGTH_SHORT).show();
    }
}
