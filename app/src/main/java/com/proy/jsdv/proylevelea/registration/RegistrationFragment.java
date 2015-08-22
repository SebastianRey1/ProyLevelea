package com.proy.jsdv.proylevelea.registration;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.proy.jsdv.proylevelea.R;
import com.proy.jsdv.proylevelea.menu.search.CustomItemSelectedListener;


public class RegistrationFragment extends Fragment {
    private static final String REGISTER_FRAGMENT_TAG = "register_fragment";
    private Button registerBtn, cancelBtn;
    private Spinner countrySpinner;
    private EditText firstNametxt, lastNametxt, idNumbertxt, emailtxt, passwordtxt, retypePasswordtxt, phoneNumbertxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addRegistrationListenerButton();
        addListenerOnCountrySpinnerSelection();
        registerBtn=(Button)view.findViewById(R.id.bn_register);
    }

    public void addListenerOnCountrySpinnerSelection() {
        countrySpinner = (Spinner) getView().findViewById(R.id.country_spinner);
        countrySpinner.setOnItemSelectedListener(new CustomItemSelectedListener());
    }

    public void addRegistrationListenerButton() {
        EditTextInitializer();

        registerBtn = (Button) getView().findViewById(R.id.bn_register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void EditTextInitializer() {
        firstNametxt = (EditText) getView().findViewById(R.id.first_name);
        lastNametxt = (EditText) getView().findViewById(R.id.last_name);
        idNumbertxt = (EditText) getView().findViewById(R.id.id_number);
        phoneNumbertxt = (EditText) getView().findViewById(R.id.phone_number);
        countrySpinner = (Spinner) getView().findViewById(R.id.country_spinner);
        emailtxt = (EditText) getView().findViewById(R.id.email_field);
        passwordtxt = (EditText) getView().findViewById(R.id.password_field);
        retypePasswordtxt = (EditText) getView().findViewById(R.id.retype_password_field);

    }


}
