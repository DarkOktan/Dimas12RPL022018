package com.example.dimas12rpl022018;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DasboardLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dasboard_layout);

        getSupportActionBar().setTitle("Rental Sepeda");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //if (item.getItemId() == R.id.) {
        //    new AlertDialog.Builder(this)
        //            .setTitle("Really Logout?")
        //            .setMessage("Are you sure you want to logout?")
        //            .setNegativeButton(android.R.string.no, null)
        //            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

        //               public void onClick(DialogInterface arg0, int arg1) {
        //                    Intent intent = new Intent(DasboardLayoutActivity.this, MainActivity.class);
        //                    startActivity(intent);
        //                    finish();
        //                }
        //            }).create().show();
        //    return true;
        //}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        DasboardLayoutActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}