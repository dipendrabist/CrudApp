package dipendra.np.com.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

private Button buttonSharedPreference;
private Button buttonDatabase;
Button buttonAlarm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSharedPreference=findViewById(R.id.btn_shared_preference);
        buttonDatabase=findViewById(R.id.btn_database);
        buttonAlarm=findViewById(R.id.btn_alarm);
buttonSharedPreference.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,SharedPreferenceActivity.class);
        startActivity(intent);
    }
});
buttonDatabase.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,SQLiteActivity.class);
        startActivity(intent);
    }
});

buttonAlarm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,AlarmActivity.class);
        startActivity(intent);
    }
});

    }


}