package cat.copernic.kyt3c.fitnessreference;

import android.content.Intent;
import android.net.Uri;
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
        Button btnNavegar = (Button) vista.findViewById(R.id.btnNavegar);
        btnNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = txtweb.getText().toString();


                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "No funciona el link");
                }
            }
        });
        Button btnCompartir = (Button) vista.findViewById(R.id.btnComparte);
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = "Enviado desde FitnessReference: " + txtcom.getText().toString();
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(getActivity())
                        .setType(mimeType)
                        .setChooserTitle("Compartir con")
                        .setText(txt)
                        .startChooser();
            }
        });


        return vista;
    }


}