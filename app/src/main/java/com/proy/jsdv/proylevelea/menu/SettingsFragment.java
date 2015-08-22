package com.proy.jsdv.proylevelea.menu;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.proy.jsdv.proylevelea.AboutActivity;
import com.proy.jsdv.proylevelea.R;


public class SettingsFragment extends android.app.Fragment {
    private Switch OppState;
    private Button btnChangePass;


    public static final String ARG_SECTION_TITLE = "section_number";

    public static SettingsFragment newInstance(String sectionTitle) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_settings, container, false);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OppState = (Switch) view.findViewById(R.id.oppSta);

        OppState.setChecked(true);

        OppState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity().getApplicationContext(), "Active", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Inactive", Toast.LENGTH_SHORT).show();
                }
            }
        });






       btnChangePass = (Button) view.findViewById(R.id.btnChangePass);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordChangeDialog();

            }
        });

    }
    public void PasswordChangeDialog() {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View dialogLayout = layoutInflater.inflate(R.layout.activity_change_password, null);
        final EditText oldPassText = (EditText)getView().findViewById(R.id.editOldPass);
        final EditText newPassText = (EditText)getView().findViewById(R.id.editNewPass);
        final EditText retypeNewPassText = (EditText)getView().findViewById(R.id.editReNewPass);
        Button cancelPassRequest = (Button)getView().findViewById(R.id.btnCancel_password_change);
        final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
        builder.setView(dialogLayout);
        builder.show();
        cancelPassRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
        Button changePassword = (Button)getView().findViewById(R.id.btnConfirm);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPass = oldPassText.getText().toString();
                String newPass = newPassText.getText().toString();
                String retypeNewPass = retypeNewPassText.getText().toString();

            }
        });
    }
}




