package com.spencerstudios.debugapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.spencerstudios.debugapp.R;
import com.spencerstudios.debugapp.Utilities.ExceptionFactory;

public class LauncherActivity extends AppCompatActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            launchGitHubRepoUrl();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void buttonClick(View view) {

        switch (view.getId()) {

            case R.id.btn_index_out_of_bounds:
                ExceptionFactory.indexOutOfBounds(context);
                break;

            case R.id.btn_null_pointer:
                ExceptionFactory.nullPointer(context);
                break;

            case R.id.btn_arithmetic:
                ExceptionFactory.arithmetic(context);
                break;
        }
    }

    private void launchGitHubRepoUrl() {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Binary-Finery/DebugApp2"));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
