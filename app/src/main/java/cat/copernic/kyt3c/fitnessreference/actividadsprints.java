package cat.copernic.kyt3c.fitnessreference;

import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class actividadsprints extends AppCompatActivity {
    private EditText txtcom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividadsprints);
        txtcom = findViewById(R.id.txtcom);

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
