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
import android.widget.Toast;

import com.proy.jsdv.proylevelea.R;
import com.proy.jsdv.proylevelea.menu.MainActivity;
import com.proy.jsdv.proylevelea.menu.search.CustomItemSelectedListener;


public class RegistrationFragment extends Fragment {
    private static final String REGISTER_FRAGMENT_TAG = "register_fragment";
    private Button registerBtn, cancelBtn;
    private Spinner countrySpinner;
    private String firstName, lastName, idNumber, email, password, retypePassword, phoneNumber, country;
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
        cancelBtn = (Button) view.findViewById(R.id.bn_cancel2);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFragment();
            }
        });
    }

    private void toggleFragment() {
        Fragment f = getFragmentManager().findFragmentByTag(REGISTER_FRAGMENT_TAG);
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up)
                    .add(R.id.register_fragment, RegistrationFragment
                                    .instantiate(getActivity(), RegistrationFragment.class.getName()),
                            REGISTER_FRAGMENT_TAG
                    )
                    .addToBackStack(null).commit();
        }
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
                EditTextSetter();
                if (getFirstName().isEmpty() && getLastName().isEmpty() &&
                        getIdNumber().isEmpty() && getCountry().isEmpty() &&
                        getEmail().isEmpty() && getPhoneNumber().isEmpty() &&
                        getPassword().isEmpty()) {
                    if (getPassword().equals(getRetypePassword())) {

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getActivity(),
                                getString(R.string.password_match),
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(),
                            getString(R.string.missing_values),
                            Toast.LENGTH_SHORT).show();
                }
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

    public void EditTextSetter() {
        setCountry(String.valueOf(countrySpinner.getSelectedItem()));
        setFirstName(firstNametxt.getText().toString());
        setLastName(lastNametxt.getText().toString());
        setIdNumber(idNumbertxt.getText().toString());
        setEmail(emailtxt.getText().toString());
        setPassword(passwordtxt.getText().toString());
        setRetypePassword(retypePasswordtxt.getText().toString());
        setPhoneNumber(phoneNumbertxt.getText().toString());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
