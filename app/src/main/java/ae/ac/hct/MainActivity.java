package ae.ac.hct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
    }

    // This event handles the click event on the menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.search:
                // go to the AddCarActivity
                Intent newCarIntent = new Intent(this, display.class);
                startActivity(newCarIntent);
                return true;

        /**    case R.id.menuUpdateCar:
                // go to the AddCarActivity
                Intent updateCarIntent = new Intent(this, UpdateCarActivity.class);
                startActivity(updateCarIntent);
                return true;**/

            case R.id.menuLogin:
                // go to the login activity
                Intent intent = new Intent(this, login.class);
                startActivity(intent);
                return true;

            case R.id.menuLogout:
                auth.signOut();
                invalidateOptionsMenu();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // This event creates the menu on the activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);

        updateMenu(menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        updateMenu(menu);

        return super.onPrepareOptionsMenu(menu);
    }

    private void updateMenu(Menu menu){
        FirebaseUser user = auth.getCurrentUser();

        if(user != null){
            menu.getItem(0).setVisible(true);
            menu.getItem(1).setVisible(true);
            menu.getItem(2).setVisible(true);
            menu.getItem(3).setVisible(false);
            menu.getItem(4).setVisible(true);
        }
        else{
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
            menu.getItem(3).setVisible(true);
            menu.getItem(4).setVisible(false);
        }
    }
}
