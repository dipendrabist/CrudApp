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
        editTextEnterUserName = view.findViewById(R.id.et_user_name_for_sign_up);
        editTextEnterPassword = view.findViewById(R.id.et_password_for_sign_up);
        editTextConfirmPassword = view.findViewById(R.id.et_confirm_password);
        checkBoxTermsConditions = view.findViewById(R.id.checkbox_terms_conditions);
        buttonSignUp = view.findViewById(R.id.btn_sign_up);
        textViewSignIn = view.findViewById(R.id.tv_sign_in);

        // Inflate the layout for this fragment


        return view;
    }

}
