package com.proy.jsdv.proylevelea.menu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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





    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

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
            case R.id.contact_us:
            LayoutInflater inflater = getLayoutInflater();

            View dialogLayout = inflater.inflate(R.layout.activity_contact_us, null);

            final EditText etAsunto = (EditText) dialogLayout.findViewById(R.id.et_EmailAsunto);
            final EditText etMensaje = (EditText) dialogLayout.findViewById(R.id.et_EmailMensaje);

            Button sendMailBtn = (Button) dialogLayout.findViewById(R.id.btn_send_mail);
            sendMailBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String subject = etAsunto.getText().toString();
                    String message = etMensaje.getText().toString();

                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[] { "sebastianr1232@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, message);

                    // need this to prompts email client only
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, getString(R.string.choose_mail)));

                }
            });

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setView(dialogLayout);
            builder.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
