package ru.redsys.rosenergoatomconference.UI;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import ru.redsys.rosenergoatomconference.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    // UI references.
    AutoCompleteTextView emailView;
    EditText passwordView;
    Button submit;
    AlertDialog dialog;
    TextView event, title, date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        initChildViews();
        bindValues();


    }

    /**
     * Initialize all views
     */
    private void initChildViews() {


        passwordView = findViewById(R.id.password);
        emailView = findViewById(R.id.email);
        submit = findViewById(R.id.email_sign_in_button);
        dialog = new AlertDialog.Builder(this).create();

        event = findViewById(R.id.login_event_type);
        title = findViewById(R.id.login_event_title);
        date = findViewById(R.id.login_event_date);

        event.setText(getTextFromRawFile(R.raw.event));
        title.setText(getTextFromRawFile(R.raw.title));
        date.setText(getTextFromRawFile(R.raw.date));

    }

    private String getTextFromRawFile(int resourceId) {

        InputStream inputStream = getResources().openRawResource(resourceId);

        byte[] b = new byte[0];
        try {
            b = new byte[inputStream.available()];
            inputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }


    private void bindValues() {


//        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
//                if (id == R.id.login || id == EditorInfo.IME_NULL) {
//
//                    return true;
//                }
//                return false;
//            }
//        });
//
        submit.setOnClickListener(this);


    }


    /**
     * validate credentials
     *
     * @param username
     * @param password
     * @return
     */
    private boolean validated(String username, String password) {
        username.trim();
        password.trim();

        if (username.length() == 0 || password.length() == 0) {
            return false;
        } else {
            return true;
        }

    }


    @Override
    public void onClick(View view) {

//        if (view == submit) {
//
//            String username = emailView.getText().toString();
//            String password = passwordView.getText().toString();
//
//
//            if (validated(username, password)) {
//                doLogin(username, password);
//            } else {
//                dialog.setMessage("Username or password cannot be empty");
//            }
//
//
//        }

        startActivity(new Intent(this, MainActivity.class));

    }


    /**
     * Login using Volley.  This implementation makes a post request using username and
     * password parameters
     *
     * @param username
     * @param password
     */
    private void doLogin(String username, String password) {
        dialog.setTitle("Login");
        dialog.setMessage("Authenticating..");
        dialog.show();
    }
}

