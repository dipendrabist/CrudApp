package dipendra.np.com.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {
private EditText editTextInputTime;
Button buttonSetAlarm;
Button buttonStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        editTextInputTime=findViewById(R.id.et_input_time);
        buttonSetAlarm=findViewById(R.id.btn_set_alarm);
        buttonStop=findViewById(R.id.btn_stop);
        buttonSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time=Integer.parseInt(editTextInputTime.getText().toString());
                AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intent=new Intent(AlarmActivity.this,MyBroadcastReceiver.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(AlarmActivity.this,24444,intent,0);
                alarmManager.set(AlarmManager.RTC_WAKEUP,time,pendingIntent);
                Toast.makeText(AlarmActivity.this, "Alarm is set to "
                        +editTextInputTime
                        .getText()
                        .toString()+"ms", Toast
                        .LENGTH_SHORT)
                        .show();
                editTextInputTime.setText("");
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        }
        });

    }

}
