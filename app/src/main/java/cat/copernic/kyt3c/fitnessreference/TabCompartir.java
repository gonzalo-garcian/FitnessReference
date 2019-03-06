package cat.copernic.kyt3c.fitnessreference;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TabCompartir extends Fragment {
    private EditText txtweb;
    private EditText txtcom;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.tabcompartir, container, false);

        txtweb = vista.findViewById(R.id.txtweb);
        txtcom = vista.findViewById(R.id.txtcom);


        return vista;
    }



    public void openWebsite(View view) {
        String url = txtweb.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "No funciona el link");
        }
    }

    public void shareText(View view) {
        String txt = "Enviado desde FitnessReference: "+txtcom.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(getActivity())
                .setType(mimeType)
                .setChooserTitle("compartir con")
                .setText(txt)
                .startChooser();
    }

    public void openMap(View view){
        if (ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    3);
        } else {

        }
        Intent intent = new Intent(getActivity(), maps.class);
        startActivity(intent);
    }



}