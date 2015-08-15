package com.proy.jsdv.proylevelea.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proy.jsdv.proylevelea.R;

public class Main_Log_out extends android.app.Fragment {
    public static final String ARG_SECTION_TITLE = "section_number";

    public static Main_Log_out newInstance(String sectionTitle) {
        Main_Log_out fragment = new Main_Log_out();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public Main_Log_out() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main__log_out, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
