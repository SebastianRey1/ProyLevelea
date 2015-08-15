package com.proy.jsdv.proylevelea.menu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proy.jsdv.proylevelea.R;
import com.proy.jsdv.proylevelea.menu.search.SearchResults;
import com.proy.jsdv.proylevelea.menu.search.SearchSpecifications;

public class SearchFragment extends android.app.Fragment {
    public static final String ARG_SECTION_TITLE = "section_number";

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
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getJobSpecificationsFragment();
       // getJobSearchResultsFragment();
    }

    public void getJobSpecificationsFragment(){
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        SearchSpecifications fragB = new SearchSpecifications ();
        childFragTrans.add(R.id.search_specifications_fragment, fragB);
        childFragTrans.addToBackStack("B");
        childFragTrans.commit();
    }
 /*   public void getJobSearchResultsFragment(){
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        SearchResults fragB = new SearchResults ();
        childFragTrans.add(R.id.search_results_fragment, fragB);
        childFragTrans.addToBackStack("B");
        childFragTrans.commit();
    }*/
}
