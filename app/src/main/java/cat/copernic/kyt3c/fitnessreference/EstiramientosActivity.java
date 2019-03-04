package cat.copernic.kyt3c.fitnessreference;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class EstiramientosActivity extends AppCompatActivity {
    VideoView videoView;
    ListView listView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estiramientos);
        videoView=findViewById(R.id.estiramientosVView);
        listView=findViewById(R.id.EstiramientosList);
        videoList=new ArrayList<>();
        videoList.add("Antes");
        videoList.add("Despues");

        adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,videoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.Antes));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.Despues));
                        break;
                        default:
                            break;


                }
                videoView.setMediaController(new MediaController(EstiramientosActivity.this));
            videoView.requestFocus();
            videoView.start();}
        });
    }
}

