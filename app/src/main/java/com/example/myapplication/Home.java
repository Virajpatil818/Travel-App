package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bnv=findViewById(R.id.b);
//        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id=item.getItemId();
//                if(id==R.id.home){
//
//                } else if (id==R.id.dir) {
//
//                } else {
//
//                }
//
//                return false;
//            }
//        });
        bnv.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if(id==R.id.home){
                    loadfrag(new Homefrag(),true);
                } else if (id==R.id.dir) {
                    loadfrag(new Directionfrag(),false);
                } else {
                    loadfrag(new Profilefrag(),false);
                }
            }
        });
        bnv.setSelectedItemId(R.id.home);
    }
    public void loadfrag(Fragment fragment,boolean flag){
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if (flag){
            ft.add(androidx.core.R.id.action_container,fragment);
        }
        else{
            ft.replace(androidx.core.R.id.action_container,fragment);
            ft.commit();
        }

    }
}