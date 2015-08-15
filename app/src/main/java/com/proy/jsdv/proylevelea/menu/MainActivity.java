package com.proy.jsdv.proylevelea.menu;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.proy.jsdv.proylevelea.R;
import com.proy.jsdv.proylevelea.presentation.DisplayAdapter;

public class MainActivity extends AppCompatActivity {
    public final static String MAIN_CONTENT_TAG = "main_content";
    /**
     * Instancia del drawer
     */
    private DrawerLayout drawerLayout;

    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;


    /**
     *
     * Para el swiper view
     */
    ViewPager paper;
    PagerTabStrip tab_strp;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        /**
         * Llamar a los tabs
         */

        DisplayAdapter<DisplayAdapter> dpaper = new DisplayAdapter<DisplayAdapter>(getSupportFragmentManager());
        paper = (ViewPager)findViewById(R.id.pager);

        paper.setAdapter(dpaper);
        tab_strp = (PagerTabStrip)findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.WHITE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.opportunity_item);
        if (savedInstanceState == null) {
            selectItem2(drawerTitle);
        }

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();
                        selectItem2(title);
                        return true;
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*private void selectItem(String title) {
        // Enviar título como arguemento del fragmento
        Bundle args = new Bundle();
        args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);

        Fragment fragment = PlaceholderFragment.newInstance(title);
        fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();

        drawerLayout.closeDrawers(); // Cerrar drawer

        setTitle(title); // Setear título actual

    }*/

    private void selectItem2(String Item) {
        if (Item.equals("Profile")) {
            Bundle args = new Bundle();
            args.putString(ProfileFragment.ARG_SECTION_TITLE, Item);

            android.app.Fragment fragment = SearchFragment.newInstance(Item);
            fragment.setArguments(args);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, ProfileFragment.
                            instantiate(MainActivity.this, ProfileFragment.class.getName()))
                    .commit();
            drawerLayout.closeDrawers(); // Cerrar drawer
            setTitle(Item); // Setear título actual
        } else if (Item.equals("Setting")) {
            Bundle args = new Bundle();
            args.putString(SettingsFragment.ARG_SECTION_TITLE, Item);

            android.app.Fragment fragment = SearchFragment.newInstance(Item);
            fragment.setArguments(args);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, SettingsFragment.
                            instantiate(MainActivity.this, SettingsFragment.class.getName()))
                    .commit();
            drawerLayout.closeDrawers(); // Cerrar drawer
            setTitle(Item); // Setear título actual
        }else if (Item.equals("Feedback")) {
            Bundle args = new Bundle();
            args.putString(FeedbackFragment.ARG_SECTION_TITLE, Item);

            android.app.Fragment fragment = SearchFragment.newInstance(Item);
            fragment.setArguments(args);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, FeedbackFragment.
                            instantiate(MainActivity.this, FeedbackFragment.class.getName()))
                    .commit();
            drawerLayout.closeDrawers(); // Cerrar drawer
            setTitle(Item); // Setear título actual
        }else if (Item.equals("Log_out")) {
            Bundle args = new Bundle();
            args.putString(Main_Log_out.ARG_SECTION_TITLE, Item);

            android.app.Fragment fragment = SearchFragment.newInstance(Item);
            fragment.setArguments(args);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content,Main_Log_out.
                            instantiate(MainActivity.this, Main_Log_out.class.getName()))
                    .commit();
            drawerLayout.closeDrawers(); // Cerrar drawer
            setTitle(Item); // Setear título actual
        }
        else if (Item.equals("Inbox")) {
            Bundle args = new Bundle();
            args.putString(InboxFragment.ARG_SECTION_TITLE, Item);

            android.app.Fragment fragment = SearchFragment.newInstance(Item);
            fragment.setArguments(args);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, InboxFragment.
                            instantiate(MainActivity.this, InboxFragment.class.getName()))
                    .commit();
            drawerLayout.closeDrawers(); // Cerrar drawer
            setTitle(Item); // Setear título actual
        }else if (Item.equals("Opportunity")) {
            Bundle args = new Bundle();
            args.putString(OpportunityFragment.ARG_SECTION_TITLE, Item);

            android.app.Fragment fragment = SearchFragment.newInstance(Item);
            fragment.setArguments(args);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, OpportunityFragment.
                            instantiate(MainActivity.this, OpportunityFragment.class.getName()))
                    .commit();
            drawerLayout.closeDrawers(); // Cerrar drawer
            setTitle(Item); // Setear título actual
        }else if (Item.equals("Search")) {
            Bundle args = new Bundle();
            args.putString(SearchFragment.ARG_SECTION_TITLE, Item);
            android.app.Fragment fragment = SearchFragment.newInstance(Item);
            fragment.setArguments(args);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, SearchFragment.
                            instantiate(MainActivity.this, SearchFragment.class.getName()))
                    .commit();
            drawerLayout.closeDrawers(); // Cerrar drawer
            setTitle(Item); // Setear título actual
        }
    }

}
