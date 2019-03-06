package cat.copernic.kyt3c.fitnessreference;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class WebImplicitIntentActivity extends AppCompatActivity {
    private EditText txtweb;
    private EditText txtcom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webitext);
        txtweb = findViewById(R.id.txtweb);
        txtcom = findViewById(R.id.txtcom);
    }

    public void openWebsite(View view) {
        String url = txtweb.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "No funciona el link");
        }
    }

    public void shareText(View view) {
        String txt = "Enviado desde FitnessReference: "+txtcom.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("compartir con")
                .setText(txt)
                .startChooser();
    }

    public void openMap(View view){
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    3);
        } else {

        }
        Intent intent = new Intent(WebImplicitIntentActivity.this, maps.class);
        startActivity(intent);
    }


}
