package cat.copernic.kyt3c.fitnessreference;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

import java.util.ArrayList;

public class TabEntrenamiento extends Fragment {
    ArrayAdapter adapter;
    ArrayList<String> lista;
    String url;
    Uri webpage;
    Intent intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabentrenamientos, container, false);
        // Inflate the layout for this fragment
        ListView lv = (ListView) view.findViewById(R.id.listaEntrenamientos);
        lista = new ArrayList<>();
        lista.add("Step Ups");
        lista.add("Jumping Jacks");
        lista.add("High Knees Running in Place");
        lista.add("Plank");
        lista.add("Push-Ups With Torso Rotation");
        lista.add("Side Plank");
        lista.add("Tricep bench dips");
        lista.add("Forward Lunges");
        lista.add("Wall sit");
        lista.add("Abdominal Crunch");
        lista.add("Squat");
        lista.add("Push - Ups");
        lista.add("Abdominales");
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, lista);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        url = "https://www.youtube.com/watch?v=8wugVATDFok";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 1:
                        url = "https://www.youtube.com/watch?v=95j1mH27eXc";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 2:
                        url = "https://www.youtube.com/watch?v=j8XGysKsPFc";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 3:
                        url = "https://www.youtube.com/watch?v=OuFDY0fwlvk";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 4:
                        url = "https://www.youtube.com/watch?v=5w6k8WJlEeA";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 5:
                        url = "https://www.youtube.com/watch?v=npzvRa-15SY";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 6:
                        url = "https://www.youtube.com/watch?v=EtPHEAOIxUU";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 7:
                        url = "https://www.youtube.com/watch?v=oyLAcXHZTOc";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 8:
                        url = "https://www.youtube.com/watch?v=B5PPBUagc_4";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 9:
                        url = "https://www.youtube.com/watch?v=OsUz898onTE";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 10:
                        url = "https://www.youtube.com/watch?v=beSvHVN8pyc";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 11:
                        url = "https://www.youtube.com/watch?v=NklcXdowKww";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    case 12:
                        url = "https://www.youtube.com/watch?v=dgCRY7L52mE";
                        webpage = Uri.parse(url);
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        intent.resolveActivity(getActivity().getPackageManager());
                        startActivity(intent);
                        break;
                    default:

                        break;


                }
            }
        });
        return view;
    }
}




