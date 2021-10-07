package pe.com.ritmocolorsabor.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pe.com.ritmocolorsabor.OrderFragment;
import pe.com.ritmocolorsabor.R;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView menu;

    private BottomNavigationView.OnNavigationItemReselectedListener navListener = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            if(item.getItemId() == R.id.exit){
                finish();
            }
            else{
                switch (item.getItemId()){
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.pedido:
                        selectedFragment = new OrderFragment();
                        break;
                    default:
                        selectedFragment = new HomeFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_container,selectedFragment).commit();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menu = findViewById(R.id.navMemu);
        menu.setOnNavigationItemReselectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_container,new HomeFragment()).commit();
    }



}