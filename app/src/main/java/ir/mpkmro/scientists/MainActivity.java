package ir.mpkmro.scientists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupViews();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void setupViews() {
        bottomNavigationView = findViewById(R.id.bottom_nav_id);
        frameLayout = findViewById(R.id.frame_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new HomeFragment()).commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int navID = menuItem.getItemId();
        switch (navID) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new HomeFragment()).commit();
                break;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new ProfileFragment()).commit();
                break;
            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new SearchFragment()).commit();
                break;

        }
        return true;
    }
}
