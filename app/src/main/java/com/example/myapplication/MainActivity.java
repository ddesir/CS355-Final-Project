package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

class LoginManager {
    /** Are the given user name and password known to the system? */
    public static boolean isKnownUser(String name, String psswd) {
        if(name.equals("test") && psswd.equals("passwd")) {
            return true;
        }
        return false;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoview = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video3);
        videoview.setVideoURI(uri);
        videoview.start();
    }
    public void validateUser(View view){
        Intent intent = new Intent(this, WelcomeActivity.class);
        EditText name = findViewById(R.id.editTextUserName);
        EditText passw =  findViewById(R.id.editTextPsswd);
        String username = name.getText().toString();
        String password = passw.getText().toString();
        if(LoginManager.isKnownUser(username, password)){
            intent.putExtra("user",username);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong Credentials. Try Again.",Toast.LENGTH_LONG).show();
        }
    }

}
