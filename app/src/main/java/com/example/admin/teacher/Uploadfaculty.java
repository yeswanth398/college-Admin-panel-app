package com.example.admin.teacher;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Uploadfaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView headTeacher, csDepartment, mechanicalDepartment, physicsDepartment, chmesityDepartment, elDepartment,arDepartment, notechDepartment;
    private LinearLayout headNoData,csNoData, mecNoData, phyNoData, chNoData, elNoData, arNoData, notechNoData;
    private List<TeacherData> list, list1, list2, list3,list4, list5, list6, list7;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadfaculty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Upload Teacher");

        headTeacher = findViewById(R.id.headTeacher);
        csDepartment = findViewById(R.id.csDepartment);
        mechanicalDepartment = findViewById(R.id.mechanicalDepartment);
        physicsDepartment = findViewById(R.id.physicsDepartment);
        chmesityDepartment = findViewById(R.id.chmesityDepartment);
        elDepartment = findViewById(R.id.elDepartment);
        arDepartment = findViewById(R.id.arDepartment);
        notechDepartment = findViewById(R.id.notechDepartment);

        headNoData = findViewById(R.id.headNoData);
        csNoData = findViewById(R.id.csNoData);
        mecNoData = findViewById(R.id.mecNoData);
        phyNoData = findViewById(R.id.phyNoData);
        chNoData = findViewById(R.id.chNoData);
        elNoData = findViewById(R.id.elNoData);
        arNoData = findViewById(R.id.arNoData);
        notechNoData = findViewById(R.id.notechNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        headTeacher();
        csDepartment();
        mechanicalDepartment();
        physicsDepartment();
        chmesityDepartment();
        elDepartment();
        arDepartment();
        notechDepartment();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Uploadfaculty.this, AddTeacher.class));
            }
        });
    }



    private void headTeacher() {
        dbRef = reference.child("Principal");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    headNoData.setVisibility(View.VISIBLE);
                    headTeacher.setVisibility(View.GONE);
                }else {


                    headNoData.setVisibility(View.GONE);
                    headTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list.add(data);
                    }
                    headTeacher.setHasFixedSize(true);
                    headTeacher.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list, Uploadfaculty.this, "Principal");
                    headTeacher.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void csDepartment() {

        dbRef = reference.child("Computer Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {

                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list1, Uploadfaculty.this, "Computer Department");
                    csDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void mechanicalDepartment() {

        dbRef = reference.child("Power Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mecNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else {


                    mecNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list2, Uploadfaculty.this,"Power Department");
                    mechanicalDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void physicsDepartment() {

        dbRef = reference.child("Mechanical Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    phyNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                }else {


                    phyNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list3, Uploadfaculty.this,"Mechanical Department");
                    physicsDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void chmesityDepartment() {

        dbRef = reference.child("Civil Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    chNoData.setVisibility(View.VISIBLE);
                    chmesityDepartment.setVisibility(View.GONE);
                }else {
                    chNoData.setVisibility(View.GONE);
                    chmesityDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    chmesityDepartment.setHasFixedSize(true);
                    chmesityDepartment.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list4, Uploadfaculty.this,"Civil Department");
                    chmesityDepartment.setAdapter(adapter);
                }

            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void elDepartment() {

        dbRef = reference.child("Electrical Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    elNoData.setVisibility(View.VISIBLE);
                    elDepartment.setVisibility(View.GONE);
                }else {
                    elNoData.setVisibility(View.GONE);
                    elDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    elDepartment.setHasFixedSize(true);
                    elDepartment.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list5, Uploadfaculty.this,"Electrical Department");
                    elDepartment.setAdapter(adapter);
                }

            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void arDepartment() {

        dbRef = reference.child("Architecture Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    arNoData.setVisibility(View.VISIBLE);
                    arDepartment.setVisibility(View.GONE);
                }else {
                    arNoData.setVisibility(View.GONE);
                    arDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    arDepartment.setHasFixedSize(true);
                    arDepartment.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list6, Uploadfaculty.this,"Architecture Department");
                    arDepartment.setAdapter(adapter);
                }

            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void notechDepartment() {

        dbRef = reference.child("Non-Tech Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    notechNoData.setVisibility(View.VISIBLE);
                    notechDepartment.setVisibility(View.GONE);
                }else {
                    notechNoData.setVisibility(View.GONE);
                    notechDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    notechDepartment.setHasFixedSize(true);
                    notechDepartment.setLayoutManager(new LinearLayoutManager(Uploadfaculty.this));
                    adapter = new TeacherAdapter(list7, Uploadfaculty.this,"Non-Tech Department");
                    notechDepartment.setAdapter(adapter);
                }

            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Uploadfaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}