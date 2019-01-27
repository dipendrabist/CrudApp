package dipendra.np.com.myapplication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn extends Fragment {
    OnLogInFormActivityListener onLogInFormActivityListener;

public interface OnLogInFormActivityListener{
    public void register();
    public void performLogin(String email);

}
    public SignIn() {
        // Required empty public constructor
    }
    private EditText editTextUserName, editTextPassword;
    private TextView textViewForgetPassword, textViewSignUp;
    private Button buttonSignIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        editTextUserName=    view.findViewById(R.id.et_user_name);
        editTextPassword=view.findViewById(R.id.et_password);
        textViewForgetPassword=view.findViewById(R.id.tv_forget_password);
        textViewSignUp=view.findViewById(R.id.tv_sign_up);
        buttonSignIn=view.findViewById(R.id.btn_login);
        // Inflate the layout for this fragment
  textViewSignUp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
         onLogInFormActivityListener.register();
      }
  });
  return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity) context;
        onLogInFormActivityListener=(OnLogInFormActivityListener) activity;
    }



}
