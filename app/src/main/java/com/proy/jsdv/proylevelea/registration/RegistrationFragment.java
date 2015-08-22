package com.proy.jsdv.proylevelea.registration;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.proy.jsdv.proylevelea.R;
import com.proy.jsdv.proylevelea.menu.search.CustomItemSelectedListener;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class RegistrationFragment extends Fragment {
    private Button registerBtn;
    private Spinner countrySpinner;
    private EditText firstNametxt, lastNametxt, idNumbertxt, emailtxt, passwordtxt, retypePasswordtxt, phoneNumbertxt;
    private static final String SERVICE_URL = "http://192.168.1.9:8080/RestWebServiceDemo/rest/person";
    private static final String TAG = "MainSwiperLevelea";

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
        registerBtn=(Button)view.findViewById(R.id.bn_register);
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
                postData();
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
    public void postData() {

        firstNametxt = (EditText) getView().findViewById(R.id.first_name);
        lastNametxt = (EditText) getView().findViewById(R.id.last_name);
        idNumbertxt = (EditText) getView().findViewById(R.id.id_number);
        phoneNumbertxt = (EditText) getView().findViewById(R.id.phone_number);
        countrySpinner = (Spinner) getView().findViewById(R.id.country_spinner);
        emailtxt = (EditText) getView().findViewById(R.id.email_field);
        passwordtxt = (EditText) getView().findViewById(R.id.password_field);
        retypePasswordtxt = (EditText) getView().findViewById(R.id.retype_password_field);

        String firstName = firstNametxt.getText().toString();
        String lastName = lastNametxt.getText().toString();
        String email = emailtxt.getText().toString();
        String id = idNumbertxt.getText().toString();
        String phoneNumber = phoneNumbertxt.getText().toString();
        String password = passwordtxt.getText().toString();
        String retypePassword = retypePasswordtxt.getText().toString();
        String country = String.valueOf(countrySpinner.getSelectedItem());
        if (firstName.equals("") || lastName.equals("") || email.equals("")) {
            Toast.makeText(getActivity(), "Please enter in all required fields.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, getActivity(), "Posting data...");

        wst.addNameValuePair("firstName", firstName);
        wst.addNameValuePair("lastName", lastName);
        wst.addNameValuePair("email", email);
        wst.addNameValuePair("password", password);
        wst.addNameValuePair("country", country);
        wst.addNameValuePair("id", id);
        wst.addNameValuePair("phone_number",phoneNumber);

        // the passed String is the URL we will POST to
        wst.execute(new String[] { SERVICE_URL });

    }
    public void handleResponse(String response) {

        firstNametxt = (EditText) getView().findViewById(R.id.first_name);
        lastNametxt = (EditText) getView().findViewById(R.id.last_name);
        idNumbertxt = (EditText) getView().findViewById(R.id.id_number);
        phoneNumbertxt = (EditText) getView().findViewById(R.id.phone_number);
        countrySpinner = (Spinner) getView().findViewById(R.id.country_spinner);
        emailtxt = (EditText) getView().findViewById(R.id.email_field);
        passwordtxt = (EditText) getView().findViewById(R.id.password_field);

        firstNametxt.setText("");
        lastNametxt.setText("");
        idNumbertxt.setText("");
        phoneNumbertxt.setText("");


        try {

            JSONObject jso = new JSONObject(response);

            String firstName = jso.getString("firstName");
            String lastName = jso.getString("lastName");
            String email = jso.getString("email");
            String password = jso.getString("password");
            String phoneNumber = jso.getString("phone_number");

            firstNametxt.setText(firstName);
            lastNametxt.setText(lastName);
            emailtxt.setText(email);
            passwordtxt.setText(password);
            phoneNumbertxt.setText(phoneNumber);


        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
        }

    }

    private void hideKeyboard() {

        InputMethodManager inputManager = (InputMethodManager)getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(
                getActivity().getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    private class WebServiceTask extends AsyncTask<String, Integer, String> {

        public static final int POST_TASK = 1;
        public static final int GET_TASK = 2;

        private static final String TAG = "WebServiceTask";

        // connection timeout, in milliseconds (waiting to connect)
        private static final int CONN_TIMEOUT = 3000;

        // socket timeout, in milliseconds (waiting for data)
        private static final int SOCKET_TIMEOUT = 5000;

        private int taskType = GET_TASK;
        private Context mContext = null;
        private String processMessage = "Processing...";

        private ArrayList<NameValuePair> params = new ArrayList<>();

        private ProgressDialog pDlg = null;

        public WebServiceTask(int taskType, Context mContext, String processMessage) {

            this.taskType = taskType;
            this.mContext = mContext;
            this.processMessage = processMessage;
        }

        public void addNameValuePair(String name, String value) {

            params.add(new BasicNameValuePair(name, value));
        }

        private void showProgressDialog() {

            pDlg = new ProgressDialog(mContext);
            pDlg.setMessage(processMessage);
            pDlg.setProgressDrawable(mContext.getWallpaper());
            pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDlg.setCancelable(false);
            pDlg.show();

        }

        @Override
        protected void onPreExecute() {

            hideKeyboard();
            showProgressDialog();

        }

        protected String doInBackground(String... urls) {

            String url = urls[0];
            String result = "";

            HttpResponse response = doResponse(url);

            if (response == null) {
                return result;
            } else {

                try {

                    result = inputStreamToString(response.getEntity().getContent());

                } catch (IllegalStateException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);

                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                }

            }

            return result;
        }

        @Override
        protected void onPostExecute(String response) {

            handleResponse(response);
            pDlg.dismiss();

        }

        // Establish connection and socket (data retrieval) timeouts
        private HttpParams getHttpParams() {

            HttpParams http = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(http, CONN_TIMEOUT);
            HttpConnectionParams.setSoTimeout(http, SOCKET_TIMEOUT);

            return http;
        }

        private HttpResponse doResponse(String url) {

            // Use our connection and data timeouts as parameters for our
            // DefaultHttpClient
            HttpClient httpclient = new DefaultHttpClient(getHttpParams());

            HttpResponse response = null;

            try {
                switch (taskType) {

                    case POST_TASK:
                        HttpPut httpPut = new HttpPut(url);
                        // Add parameters
                        httpPut.setEntity(new UrlEncodedFormEntity(params));

                        response = httpclient.execute(httpPut);
                        break;
                    case GET_TASK:
                        HttpGet httpget = new HttpGet(url);
                        response = httpclient.execute(httpget);
                        break;
                }
            } catch (Exception e) {

                Log.e(TAG, e.getLocalizedMessage(), e);

            }

            return response;
        }

        private String inputStreamToString(InputStream is) {

            String line = "";
            StringBuilder total = new StringBuilder();

            // Wrap a BufferedReader around the InputStream
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                // Read response until the end
                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }
            } catch (IOException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }

            // Return full string
            return total.toString();
        }

    }

}
