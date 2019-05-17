package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);

        Intent i = getIntent();
        String g = i.getStringExtra("query");
        ArrayList<String> glist = queryGB(g);

        RecyclerView rvProducts = findViewById(R.id.gameList);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        GamesAdapter adapter = new GamesAdapter(glist);
        rvProducts.setAdapter(adapter);
    }

    ArrayList<String> queryGB (String query)
    {
        ArrayList<String> list = new ArrayList<>();
        try
        {
            SQLiteDatabase db = openOrCreateDatabase ("games.db", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery(query, null);
            while(cursor.moveToNext())
            {
                StringBuilder data = new StringBuilder();
                for(int i = 0; i < cursor.getColumnCount(); i++)
                {
                    if(i > 0) data.append("-");
                    String colvalue = cursor.getString(i);
                    data.append(colvalue);
                }
                list.add(data.toString());
            }
            cursor.close();
            db.close();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Error opening/querying Database", Toast.LENGTH_LONG).show();
        }
        return list;
    }
}
