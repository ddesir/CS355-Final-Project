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
        i.putExtra("query","select Name,Type,Price,Rating from Listings;");
        startActivity(i);
    }

    public void Type(View view)
    {
        Intent i = new Intent(this, Listings.class);
        i.putExtra("query", "select GameServers, count(distinct GameID) from Listings, DevInfo, Servers where Listings.DevID=DevInfo.DevId and Servers.ServerID=DevInfo.ServerID group by GameServers;");
        startActivity(i);
    }

    public void platform(View view){
        Intent i = new Intent(this, Listings.class);
        i.putExtra("query","select Name,Platform from Listings,DevInfo where Listings.DevID = DevInfo.DevID group by GameID;");
        startActivity(i);
    }
}
