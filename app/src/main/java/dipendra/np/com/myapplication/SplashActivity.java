package dipendra.np.com.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
TextView textViewWelcome;
ImageView imageViewLogo;
Animation animation1,animation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textViewWelcome=findViewById(R.id.tv_splash_text);
        imageViewLogo=findViewById(R.id.iv_logo);
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
},5*1000);
animation1= AnimationUtils.loadAnimation(this,R.anim.anim_bounce);
imageViewLogo.startAnimation(animation1);
animation2=AnimationUtils.loadAnimation(this,R.anim.slide_from_right);
textViewWelcome.startAnimation(animation2);


    }
}
