package dipendra.np.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PrefConfig {
    private SharedPreferences sharedPreferences;
    private Context context;
    public PrefConfig(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(context.getString(R.string.pref_file),Context.MODE_PRIVATE);

    }
    public void writeLoginStatus(Boolean  status){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status),status);
        editor.apply();
    }
    public boolean readLoginStatus(){
        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status),false);
    }
    public void writeEmail(String email){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_user_name),email);
        editor.apply();
    }
    public String readEmail(){
        return sharedPreferences.getString(context.getString(R.string.pref_user_name),"");
    }
    public void displayToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}

