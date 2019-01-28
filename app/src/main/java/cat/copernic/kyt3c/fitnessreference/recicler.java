package cat.copernic.kyt3c.fitnessreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class recicler extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler);

        // datos que meter en el recicler
        ArrayList<String> actividades = new ArrayList<>();
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

        //rellenar y  meter el recicler
        RecyclerView recyclerView = findViewById(R.id.activi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, actividades);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Has clickado en " + adapter.getItem(position) + " que es la fila " + position, Toast.LENGTH_SHORT).show();
    }
}