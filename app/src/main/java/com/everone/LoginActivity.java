package com.everone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.everone.custome.CustomActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.hbb20.CountryCodePicker;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends CustomActivity {
    private EditText edt_customer_mobile;
    private Button btn_verify_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUiElement();
    }

    private void setupUiElement() {

        setTouchNClick(R.id.btn_verify_number);

        edt_customer_mobile = (EditText) findViewById(R.id.edt_customer_mobile);

        btn_verify_number=(Button)findViewById(R.id.btn_verify_number);
    }

    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.btn_verify_number) {
            if (TextUtils.isEmpty(edt_customer_mobile.getText().toString())) {
                edt_customer_mobile.setError("Enter your Name");
                return;
            }
            startActivity(new Intent(getContext(), PhoneVerificationActivity.class));
        }

    }

    private Context getContext() {
        return LoginActivity.this;
    }
}
