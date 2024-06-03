package com.example.a4_notifications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SeconActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_help) {
            // Open the help window
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        }

        if (item.getItemId() == R.id.action_info) {
            // Open the help window
            showInfoDialog(this);
            return true;
        }

        if (item.getItemId() == R.id.action_home){
            startActivity(new Intent(getBaseContext(), MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void showInfoDialog(Context context){
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_info, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        // Set up the button in the custom view
        Button btnOk = dialogView.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v -> dialog.dismiss());


        dialog.show();
    }

}