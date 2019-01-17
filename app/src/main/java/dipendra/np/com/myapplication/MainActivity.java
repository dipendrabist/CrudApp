package dipendra.np.com.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SignIn.OnLogInFormActivityListener {
    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefConfig = new PrefConfig(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            if (prefConfig.readLoginStatus()) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new WelcomeFragment()).commit();
            } else {

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new SignIn()).commit();

            }
        }

    }

    @Override
    public void register() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new signup()).addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String email) {
        prefConfig.writeEmail(email);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WelcomeFragment()).commit();
    }
}
