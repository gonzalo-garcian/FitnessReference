package cat.copernic.kyt3c.fitnessreference;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TabEntrenamiento extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabentrenamientos, container, false);
        // Inflate the layout for this fragment
        String[] lista =  {
                "Saltos",
                "Sprints",
                "Nadar"
        };

        ListView lv = (ListView) view.findViewById(R.id.listaEntrenamientos);

        ArrayAdapter<String> lva = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, lista);
        lv.setAdapter(lva);


        return view;



}
}
