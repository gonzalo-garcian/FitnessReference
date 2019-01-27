package cat.copernic.kyt3c.fitnessreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    // MENU TEMPORAL DE GONZALO

    Button btnRecicler;
    Button btnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnRecicler = findViewById(R.id.btnRecicler);
        btnCalendar = findViewById(R.id.btnCalendar);
    }

    public void recicler(View view) {
        Intent recicler = new Intent(menu.this, recicler.class);
        startActivity(recicler);
    }
    public void calendar(View view) {
        Intent calendar = new Intent(menu.this, calendar.class);
        startActivity(calendar);
    }
}
