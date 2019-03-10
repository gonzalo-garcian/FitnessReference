package cat.copernic.kyt3c.fitnessreference;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class EstiramientosFragment extends Fragment {
    VideoView videoView;
    ListView listView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.activity_estiramientos,container,false);

        videoView = vista.findViewById(R.id.estiramientosVView);
        listView = vista.findViewById(R.id.EstiramientosList);
        videoList=new ArrayList<>();
        videoList.add(getString(R.string.antes));
        videoList.add(getString(R.string.despues));

        adapter= new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,videoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.antes));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.despues));
                        break;
                        default:
                            break;


                }
                videoView.setMediaController(new MediaController(getContext()));
            videoView.requestFocus();
            videoView.start();}
        });
        return vista;
    }
}

