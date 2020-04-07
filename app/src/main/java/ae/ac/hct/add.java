package ae.ac.hct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import ae.ac.hct.model.UserDetails;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void onSaveClick(View view) {
        UserDetails user = UserDetails.instance();
        String userId = user.getUserId();
    }

    public void OnBackClick(View view)
    {

        finish();
    }
}
