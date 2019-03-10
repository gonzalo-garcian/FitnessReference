package cat.copernic.kyt3c.fitnessreference;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    public FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.txtViewCorreoUsuarioActual);
        navUsername.setText(mAuth.getCurrentUser().getEmail());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new RecyclerviewFragment()).commit();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.ic_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RecyclerviewFragment()).commit();
                break;


            case R.id.ic_horario:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CalendarFragment()).commit();
                break;

            case R.id.ic_estirar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EstiramientosFragment()).commit();
                break;

            case R.id.ic_ajustes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EditarPerfilFragment()).commit();
                break;

            case R.id.ic_geolocalizacion:

                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]
                                    {Manifest.permission.ACCESS_FINE_LOCATION},
                            3);
                }

                Intent intent = new Intent(MenuActivity.this, maps.class);
                startActivity(intent);
                break;

            case R.id.ic_reiniciar_progreso:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle(getString(R.string.title_delete_acc));
                dialog.setMessage(getString(R.string.description_delete_acc));
                dialog.setPositiveButton(getString(R.string.positiveButton), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).removeValue();
                        Objects.requireNonNull(mAuth.getCurrentUser()).delete();
                        MenuActivity.this.finish();
                    }
                });

                dialog.setNegativeButton(getString(R.string.negativeButton), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
