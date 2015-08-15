package com.proy.jsdv.proylevelea.menu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.proy.jsdv.proylevelea.R;
import com.proy.jsdv.proylevelea.menu.search.CustomItemSelectedListener;
import com.proy.jsdv.proylevelea.menu.search.SearchResults;
import com.proy.jsdv.proylevelea.menu.search.SearchSpecifications;

public class SearchFragment extends android.app.Fragment {
    public static final String ARG_SECTION_TITLE = "section_number";
    private Spinner jobType, jobArea;
    private Button searchBtn;

    public static SearchFragment newInstance(String sectionTitle) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addListenerOnSpinnerJobAreaSelection();
        addListenerOnSpinnerJobTypeSelection();
        addListenerOnButton();
        getJobSearchResultsFragment();
    }
    public void getJobSearchResultsFragment(){
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        SearchResults fragB = new SearchResults ();
        childFragTrans.add(R.id.search_results_fragment, fragB);
        childFragTrans.addToBackStack("B");
        childFragTrans.commit();
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
