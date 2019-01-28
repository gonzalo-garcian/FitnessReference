package cat.copernic.kyt3c.fitnessreference;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    // MENU TEMPORAL DE GONZALO
    private DrawerLayout drawer;
    Button btnRecicler;
    Button btnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        btnRecicler = findViewById(R.id.btnRecicler);
        btnCalendar = findViewById(R.id.btnCalendar);
    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
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
