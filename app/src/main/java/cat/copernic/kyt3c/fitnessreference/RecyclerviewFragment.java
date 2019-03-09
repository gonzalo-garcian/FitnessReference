package cat.copernic.kyt3c.fitnessreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
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

        actividades.add("DIA #1");
        actividades.add("DIA #2");
        actividades.add("DIA #3");
        actividades.add("DIA #4");
        actividades.add("DIA #5");
        actividades.add("DIA #6");
        actividades.add("DIA #7");
        actividades.add("DIA #8");
        actividades.add("DIA #9");
        actividades.add("DIA #10");
        actividades.add("DIA #11");
        actividades.add("DIA #12");
        actividades.add("DIA #13");
        actividades.add("DIA #14");
        actividades.add("DIA #15");
        actividades.add("DIA #16");
        actividades.add("DIA #17");
        actividades.add("DIA #18");
        actividades.add("DIA #19");
        actividades.add("DIA #20");
        actividades.add("DIA #21");
        actividades.add("DIA #22");
        actividades.add("DIA #23");
        actividades.add("DIA #24");
        actividades.add("DIA #25");

        RecyclerView recyclerView = vista.findViewById(R.id.activi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyRecyclerViewAdapter(getContext(), actividades);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        return vista;
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "Este ejericio del " + adapter.getItem(position) + " quieres compartirlo con tus amigos? Mandales un mensaje.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DiaActivity.class);
        startActivity(intent);
    }
}
