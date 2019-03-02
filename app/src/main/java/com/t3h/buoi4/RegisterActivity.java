package com.t3h.buoi4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_USER_NAME = "extra.user.name";//dat kieu public de main doc dc
    public static final String EXTRA_PASSWORD = "extra.password";

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnOk;

    //phai dung protected cho onCreate
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        initViews();
    }

    private void initViews(){

        edtUsername=findViewById(R.id.edt_username);
        edtPassword=findViewById(R.id.edt_password);
        btnOk=findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if(username.isEmpty()||password.isEmpty()){

            Toast.makeText(this,R.string.data_emply,Toast.LENGTH_SHORT).show();
            return;

        }

        //SET data tra ve cho main
        Intent intent =new Intent();
        intent.putExtra(EXTRA_USER_NAME,username);//chi put dc kieu du lieu nguyen thuy
        intent.putExtra(EXTRA_PASSWORD,password);

        setResult(RESULT_OK,intent);
        finish();

//        switch(v.getId()){
//            case R.id.btn_ok:
//
//                break;
//
//
//
//        }

    }
}
