package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.admin.auth.LoginActivity;
import com.example.admin.ebook.UploadPdfActivity;
import com.example.admin.image.UploadImage;
import com.example.admin.notice.DeleteNoticeActivity;
import com.example.admin.notice.UploadNotice;
import com.example.admin.teacher.AddTeacher;
import com.example.admin.teacher.Uploadfaculty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView uploadNotice, uploadImage, addEbook, faculty, news, student,  delete, logout;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Admin Dashboard");

        sharedPreferences = this.getSharedPreferences("login", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("isLogin", "false").equals("false")){
            openLogin();

        }

        uploadNotice = findViewById(R.id.uploadNotice);
        uploadImage = findViewById(R.id.uploadImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        delete = findViewById(R.id.delete);
        logout = findViewById(R.id.logout);


        uploadNotice.setOnClickListener(this);
        uploadImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        logout.setOnClickListener(this);
        delete.setOnClickListener(this);
        faculty.setOnClickListener(this);
    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){

            case  R.id.uploadNotice:
                intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;

            case  R.id.uploadImage:
                intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
                break;

            case  R.id.addEbook:
                intent = new Intent(MainActivity.this, UploadPdfActivity.class);
                startActivity(intent);
                break;

            case  R.id.faculty:
                intent = new Intent(MainActivity.this, Uploadfaculty.class);
                startActivity(intent);
                break;


            case  R.id.delete:
                intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;

            case R.id.logout:
                editor.putString("isLogin","false");
                editor.commit();
                openLogin();
                break;
        }
    }
}