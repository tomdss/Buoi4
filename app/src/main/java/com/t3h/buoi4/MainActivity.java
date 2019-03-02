package com.t3h.buoi4;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_REGISTER = 1;
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnRegister;
    private Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){

        edtUsername=findViewById(R.id.edt_username);
        edtPassword=findViewById(R.id.edt_password);
        btnOk=findViewById(R.id.btn_ok);
        btnRegister=findViewById(R.id.btn_register);
        btnOk.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_ok:
                String username = edtUsername.getText().toString();
                String password =edtPassword.getText().toString();
                if(username.isEmpty()||password.isEmpty()){
                    Toast.makeText(this,R.string.data_emply,Toast.LENGTH_LONG).show();
                    return;
                }
                Intent login = new Intent(this,ContentActivity.class);
                login.putExtra(RegisterActivity.EXTRA_USER_NAME,username);
                login.putExtra(RegisterActivity.EXTRA_PASSWORD,password);
                startActivity(login);
                finish();

                break;

            case R.id.btn_register:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivityForResult(intent, REQUEST_REGISTER);

                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_REGISTER){
            if(resultCode==RESULT_OK){
                String username = data.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
                String password = data.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
                edtUsername.setText(username);
                edtPassword.setText(password);
            }else {
                Toast.makeText(this,R.string.register_cancel,Toast.LENGTH_LONG).show();
            }
        }
    }
}
