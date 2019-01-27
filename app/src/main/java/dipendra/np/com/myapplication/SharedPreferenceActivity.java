package dipendra.np.com.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferenceActivity extends AppCompatActivity {
private Button button;
String FileName ="myFile";
private EditText editText;
String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        button=findViewById(R.id.btn_ok);
        editText=findViewById(R.id.et_shared_preference);
        final SharedPreferences sharedPreferences=getSharedPreferences(FileName,Context.MODE_PRIVATE);
        String res=sharedPreferences.getString("res","");
        editText.setText(res);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result=editText.getText().toString();
                SharedPreferences sharedPreferences1=getSharedPreferences(FileName,Context.MODE_PRIVATE);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("res",result);
                editor.commit();
                editText.setText("");
                Toast.makeText(SharedPreferenceActivity.this, "Your data is saved.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
