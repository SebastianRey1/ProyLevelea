package com.proy.jsdv.proylevelea.registration;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.proy.jsdv.proylevelea.R;

public class SignInOptionsFragment extends Fragment {
    private static final String LOG_IN_FRAGMENT_TAG = "log_in_frag";
    private static final String REGISTER_FRAGMENT_TAG = "register_fragment";
    private Button logInBtn;
    private Button registerBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in_options, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logInBtn = (Button) view.findViewById(R.id.log_in_btn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleLogInFragment();
            }
        });
        registerBtn=(Button)view.findViewById(R.id.register_btn1);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleRegisterFragment();
            }
        });
    }
    private void toggleLogInFragment() {
        Fragment f = getFragmentManager().findFragmentByTag(LOG_IN_FRAGMENT_TAG);
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .add(R.id.log_in_frag, LogInFragment
                                    .instantiate(getActivity(), LogInFragment.class.getName()),
                            LOG_IN_FRAGMENT_TAG
                    ).addToBackStack(null).commit();
        }
        logInBtn.setVisibility(View.INVISIBLE);
        registerBtn.setVisibility(View.INVISIBLE);
    }
    private void toggleRegisterFragment() {
        Fragment f = getFragmentManager().findFragmentByTag(REGISTER_FRAGMENT_TAG);
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .add(R.id.register_fragment, RegistrationFragment
                                    .instantiate(getActivity(), RegistrationFragment.class.getName()),
                            REGISTER_FRAGMENT_TAG
                    ).addToBackStack(null).commit();
        }
        logInBtn.setVisibility(View.INVISIBLE);
        registerBtn.setVisibility(View.INVISIBLE);
    }

}
