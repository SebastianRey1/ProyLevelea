package com.proy.jsdv.proylevelea.menu.search;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.proy.jsdv.proylevelea.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchSpecifications extends Fragment {
    private Spinner jobType, jobArea;
    private Button searchBtn;
    public SearchSpecifications() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_specifications, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addListenerOnSpinnerJobAreaSelection();
        addListenerOnSpinnerJobTypeSelection();
        addListenerOnButton();
    }

    public void addListenerOnSpinnerJobAreaSelection() {
        jobArea=(Spinner)getView().findViewById(R.id.job_area_spinner);
        jobArea.setOnItemSelectedListener(new CustomItemSelectedListener());
    }
    public void addListenerOnSpinnerJobTypeSelection(){
        jobType=(Spinner)getView().findViewById(R.id.job_type_spinner);
        jobType.setOnItemSelectedListener(new CustomItemSelectedListener());
    }
    public void addListenerOnButton() {

        jobArea=(Spinner)getView().findViewById(R.id.job_area_spinner);
        jobType=(Spinner)getView().findViewById(R.id.job_type_spinner);
        searchBtn=(Button)getView().findViewById(R.id.search_btn);

        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),
                        "OnClickListener : " +
                                "\nSpinner 1 : " + String.valueOf(jobArea.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(jobType.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}
