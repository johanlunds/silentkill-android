package com.example.johanoanton.silentkill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_email)
    EditText mEmailEditText;
    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnEditorAction(R.id.et_password)
    boolean onEditorAction(KeyEvent key) {
        Toast.makeText(this, "Pressed: " + key, Toast.LENGTH_SHORT).show();
        return true;
    }
}
