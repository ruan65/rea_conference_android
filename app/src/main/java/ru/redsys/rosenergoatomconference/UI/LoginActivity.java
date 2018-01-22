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
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    Button mEmailSignInButton;
    AlertDialog dialog;


    TextView title;


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

        InputStream inputStream = getResources().openRawResource(R.raw.text);

        byte[] b = new byte[0];
        try {
            b = new byte[inputStream.available()];
            inputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mPasswordView = (EditText) findViewById(R.id.password);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        dialog = new AlertDialog.Builder(this).create();

        title = findViewById(R.id.main_title);

        title.setText(new String(b));

    }


    private void bindValues() {


//        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
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
        mEmailSignInButton.setOnClickListener(this);


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

//        if (view == mEmailSignInButton) {
//
//            String username = mEmailView.getText().toString();
//            String password = mPasswordView.getText().toString();
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

