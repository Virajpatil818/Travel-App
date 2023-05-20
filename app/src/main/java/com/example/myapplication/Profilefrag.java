package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Profilefrag extends Fragment {

    private FirebaseAuth mAuth;

    public Profilefrag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilefrag, container, false);

        mAuth = FirebaseAuth.getInstance();

        Button logoutButton = view.findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        return view;
    }

    private void logoutUser() {
        mAuth.signOut();
        Toast.makeText(getActivity(), "Logged out", Toast.LENGTH_SHORT).show();
        navigateToMainPage();
    }

    private void navigateToMainPage() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}
