package ae.ac.hct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import ae.ac.hct.model.UserDetails;

public class add extends AppCompatActivity {

    private EditText etWord;
    private EditText etMeaning;
    private EditText etExample;
    private EditText etPos;
    private Button btnSave;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        etExample = findViewById(R.id.etExample);
        etPos = findViewById(R.id.etPos);
        btnSave = findViewById(R.id.btnSave);
    }

    public void onSaveClick(View view) {
        UserDetails user = UserDetails.instance();
        String userId = user.getUserId();
        String word = etWord.getText().toString();
        String meaning = etMeaning.getText().toString();
        String example = etExample.getText().toString();
        String pos = etPos.getText().toString();
        Map<String, Object> data = new HashMap<>();
        data.put("meaning", meaning);
        data.put("example", example);
        data.put("pos", pos);
        db.collection(userId).document(word).set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(add.this, "Word saved successfully!", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void OnBackClick(View view)
    {

        finish();
    }
}
