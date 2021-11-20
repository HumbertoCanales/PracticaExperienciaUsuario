package com.example.practicahumberto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Mostrar el fragment
        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LoginFragmentActivity())
                    .commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new LoginFragmentActivity(), "LoginFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.info:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new InfoFragmentActivity(), "InfoFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            default:
                break;
        }
        return true;
    }
}