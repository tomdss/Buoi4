package com.t3h.buoi4;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvContent;
    private EditText edtContent;
    private Button btnCall;
    private Button btnBrowser;
    private Button btnPick;
    private ImageView imPick;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_content);
//        setContentView(R.layout.layout_call);
        initViews();
    }

    private void initViews() {
        tvContent=findViewById(R.id.tv_info);
        Intent intent = getIntent();//nhan du lieu truyen sang dung get Intent
        String username = intent.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
        String password = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
        tvContent.setText("HI,"+username+","+password);

        edtContent=findViewById(R.id.edt_content);
        btnCall=findViewById(R.id.btn_call);
        btnBrowser=findViewById(R.id.btn_browser);
        btnPick=findViewById(R.id.btn_pick);
        imPick=findViewById(R.id.im_pick);

        btnCall.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
        btnPick.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String content = edtContent.getText().toString();
        switch (v.getId()){
            case R.id.btn_browser:
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse(content));//dia chi trang web
                startActivity(browser);
                break;

            case R.id.btn_call:
                Intent call=new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:"+content));
                startActivity(call);
                break;

            case R.id.btn_pick:
                break;
        }
    }
}
