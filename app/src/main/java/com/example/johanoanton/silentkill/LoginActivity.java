package com.example.johanoanton.silentkill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_email)
    EditText mEmailEditText;
    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    LoginActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginActivityPresenter();
    }

    @OnEditorAction(R.id.et_password)
    boolean onEditorAction(KeyEvent key) {

        String email = mEmailEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        mPresenter.login(email, password);
        return true;
    }
}
