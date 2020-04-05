package ae.ac.hct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
    }
    public void OnAddClick(View view)
    {
        Intent intent = new Intent(this , add.class);
        startActivity(intent);
    }

    public void OnUpdateClick(View view)
    {
        Intent intent = new Intent(this , update.class);
        startActivity(intent);
    }
    public void OnBackClick(View view)
    {
        finish();
    }
}
