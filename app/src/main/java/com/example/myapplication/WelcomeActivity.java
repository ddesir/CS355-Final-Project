package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class WelcomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    public void allGames(View view)
    {
        Intent i = new Intent(this, Listings.class);
        i.putExtra("query","select Name, Type from Listings;");
        startActivity(i);
        //finish();
    }

    public void Type(View view)
    {
        Intent i = new Intent(this, Listings.class);
        i.putExtra("query", "select GameServers, count(DevName) from Servers, DevInfo" +
                " where Servers.ServerID=DevInfo.ServerID group by GameServers;");
        startActivity(i);
        //finish();
    }
}
