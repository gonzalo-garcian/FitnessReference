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
import android.widget.Button;
import android.widget.EditText;

public class TabCompartir extends Fragment {
    private EditText txtweb;
    private EditText txtcom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.tabcompartir, container, false);

        txtweb = vista.findViewById(R.id.txtWeb);
        txtcom = vista.findViewById(R.id.txtCompartir);




        return vista;
    }






}