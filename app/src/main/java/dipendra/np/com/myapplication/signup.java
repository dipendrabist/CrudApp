package dipendra.np.com.myapplication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class signup extends Fragment {

    OnSignUpFormActivityListener onSignUpFormActivityListener;

    public signup() {
        // Required empty public constructor
    }

    private EditText editTextEnterEmail, editTextEnterUserName, editTextEnterPassword, editTextConfirmPassword;
    Button buttonSignUp;
    TextView textViewSignIn;
    CheckBox checkBoxTermsConditions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        editTextEnterEmail = view.findViewById(R.id.et_enter_email);
        editTextEnterUserName = view.findViewById(R.id.et_user_name_for_sign_up);
        editTextEnterPassword = view.findViewById(R.id.et_password_for_sign_up);
        editTextConfirmPassword = view.findViewById(R.id.et_confirm_password);
        checkBoxTermsConditions = view.findViewById(R.id.checkbox_terms_conditions);
        buttonSignUp = view.findViewById(R.id.btn_sign_up);
        textViewSignIn = view.findViewById(R.id.tv_sign_in);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration();
            }
        });
        // Inflate the layout for this fragment


        return view;
    }

    public void registration() {
        String email = editTextEnterEmail.getText().toString();
        String user_name = editTextEnterUserName.getText().toString();
        String password = editTextEnterPassword.getText().toString();
        String confirm_password = editTextConfirmPassword.getText().toString();
        Call<User> call = MainActivity.apiInterface.performRegistration(email, user_name, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body().getResponse().equals("ok")) {
                    MainActivity.prefConfig.displayToast("Registration success..");
                } else if (response.body().getResponse().equals("exist")) {
                    MainActivity.prefConfig.displayToast("The Email is already used");
                } else if (response.body().getResponse().equals("error")) {
                    MainActivity.prefConfig.displayToast("Error in registration process..");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        editTextEnterEmail.setText("");
        editTextEnterUserName.setText("");
        editTextEnterPassword.setText("");
        editTextConfirmPassword.setText("");
    }
}
