package com.proy.jsdv.proylevelea.presentation;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.proy.jsdv.proylevelea.R;
import com.proy.jsdv.proylevelea.presentation.DisplayAdapter;
import com.proy.jsdv.proylevelea.registration.LogInFragment;
import com.proy.jsdv.proylevelea.registration.RegistrationFragment;

import org.w3c.dom.Text;


public class MainSwiperLevelea extends ActionBarActivity {
    ViewPager paper;
    PagerTabStrip tab_strp;
    private static final String REGISTER_FRAGMENT_TAG = "register_fragment";
    private static final String LOG_IN_FRAGMENT_TAG = "log_in_frag";
    Button logInBtnVisibility, registerBtnVisibility;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_main);

        DisplayAdapter<DisplayAdapter> dpaper = new DisplayAdapter<DisplayAdapter>(getSupportFragmentManager());
        paper = (ViewPager)findViewById(R.id.pager);

        paper.setAdapter(dpaper);
        tab_strp = (PagerTabStrip)findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.WHITE);
        //btnLogIn = (Button)findViewById(R.id.BtnLogin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // if (id == R.id.reload_page) {
        //     return true;
        // }
        return false;
        // return super.onOptionsItemSelected(item);
    }
    public void toggleCancelRegistration(View view) {
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
                                    .instantiate(this, RegistrationFragment.class.getName()),
                            REGISTER_FRAGMENT_TAG
                    )
                    .addToBackStack(null).commit();
        }
        setButtonVisibility();
    }
    public void toggleCancelLogIn(View view) {
        Fragment f = getFragmentManager().findFragmentByTag(LOG_IN_FRAGMENT_TAG);
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up)
                    .add(R.id.log_in_frag, LogInFragment
                                    .instantiate(this, LogInFragment.class.getName()),
                            LOG_IN_FRAGMENT_TAG
                    ).addToBackStack(null).commit();
        }
        setButtonVisibility();
    }
    public void setButtonVisibility(){
        logInBtnVisibility = (Button)findViewById(R.id.log_in_btn);
        registerBtnVisibility =(Button)findViewById(R.id.register_btn1);
        logInBtnVisibility.setVisibility(View.VISIBLE);
        registerBtnVisibility.setVisibility(View.VISIBLE);
    }
}