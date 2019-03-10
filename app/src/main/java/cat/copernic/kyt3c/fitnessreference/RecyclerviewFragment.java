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
import java.util.Objects;

public class RecyclerviewFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    ArrayList<String> actividades;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.activity_recicler, container, false);

        actividades = new ArrayList<>();

        for (int i = 1; i <= 25; i++) {
            actividades.add(getString(R.string.dia) + " #" + i);
        }

        RecyclerView recyclerView = vista.findViewById(R.id.activi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyRecyclerViewAdapter(getContext(), actividades);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        return vista;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "Este ejericio es del DIA #" + position + " quieres compartirlo? Entra en el tab compartir.", Toast.LENGTH_SHORT).show();
        actividades.set(position, getString(R.string.exercici));
        Intent intent = new Intent(getActivity(), DiaActivity.class);
        startActivity(intent);
    }
}
