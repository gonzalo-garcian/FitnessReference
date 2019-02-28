package cat.copernic.kyt3c.fitnessreference;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class webitext extends AppCompatActivity {
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


}
