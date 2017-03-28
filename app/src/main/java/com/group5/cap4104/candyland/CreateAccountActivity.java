package com.group5.cap4104.candyland;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends Activity {

    EditText emailInput, passInput, pass2Input;
    Button saveAcctBtn;
    Toast m_currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        emailInput = (EditText) findViewById(R.id.emailInput);
        passInput = (EditText) findViewById(R.id.passwordInput);
        pass2Input = (EditText) findViewById(R.id.password2Input);

        saveAcctBtn = (Button) findViewById(R.id.saveAcctBtn);
        saveAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Account Created");
                checkIfValid();
            }
        });

    }

    public void checkIfValid() {
        emailInput.setError(null);
        passInput.setError(null);
        pass2Input.setError(null);

        // Store values at the time of the login attempt.
        String email = emailInput.getText().toString();
        String password = passInput.getText().toString();
        String password2 = pass2Input.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passInput.setError(getString(R.string.error_invalid_password));
            focusView = passInput;
            cancel = true;
        }
        else if (!password.equals(password2)) {
            pass2Input.setError("Passwords do not match");
            focusView = pass2Input;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailInput.setError(getString(R.string.error_field_required));
            focusView = emailInput;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailInput.setError(getString(R.string.error_invalid_email));
            focusView = emailInput;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            finish();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    public void showMessage(String message) {
        if(m_currentToast != null)
        {
            m_currentToast.cancel();
        }
        m_currentToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        m_currentToast.show();
    }
}
