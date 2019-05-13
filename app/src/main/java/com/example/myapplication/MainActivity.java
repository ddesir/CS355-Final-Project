package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;


class LoginManager {
    /** Are the given user name and password known to the system? */
    public static boolean isKnownUser(String name, String psswd) {
        if(name.equals("test") && psswd.equals("test")) {
            return true;
        }
        return false;
    }
}

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {
    // Google Sign In
    SignInButton signInButton;
    Button signOutButton;
    TextView statusTextView;
    GoogleApiClient mGoogleApiClient;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient().Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListenter */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        statusTextView = (TextView) findViewById(R.id.status_texview);
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(this);

        signOutButton = (Button) findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(this);

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sign_in_button:
                    signIn();
                    break;
                case R.id.signOutButton:
                    signOut();
                    break;
            }
        }

        private void signIn() {
            Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent (mGoogleApiClient);
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Result returned from launching the Intent from GoogleSignInApi. getSignInIntent(...);
            if (requestCode == RC_SIGN_IN) {
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                handleSignInResult (result);
            }
        }

        public void handleSignInResult(GoogleSignInResult result) {
            Log.d(TAG, "handleSignInResult:" + result.isSuccess());

            if (result.isSuccess()) {
                // Signed in successfully, show authenticated UI.
                GoogleSignInAccount acct = result.getSignInAccount();
                statusTextView.setText("Hello, " + acct.getDisplayName());
            } else {
                
            }
        }

        /*
        {
            @Override
            public boolean hasConnectedApi(@NonNull Api<?> api) {
                return false;
            }

            @NonNull
            @Override
            public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
                return null;
            }

            @Override
            public void connect() {

            }

            @Override
            public ConnectionResult blockingConnect() {
                return null;
            }

            @Override
            public ConnectionResult blockingConnect(long l, @NonNull TimeUnit timeUnit) {
                return null;
            }

            @Override
            public void disconnect() {

            }

            @Override
            public void reconnect() {

            }

            @Override
            public PendingResult<Status> clearDefaultAccountAndReconnect() {
                return null;
            }

            @Override
            public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {

            }

            @Override
            public boolean isConnected() {
                return false;
            }

            @Override
            public boolean isConnecting() {
                return false;
            }

            @Override
            public void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {

            }

            @Override
            public boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
                return false;
            }

            @Override
            public void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {

            }

            @Override
            public void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {

            }

            @Override
            public boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
                return false;
            }

            @Override
            public void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {

            }

            @Override
            public void dump(String s, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strings) {

            }
        }
        */

        // Background Video
        VideoView videoview = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video3);
        videoview.setVideoURI(uri);
        videoview.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((EditText) findViewById(R.id.editTextUserName)).setText("");
        ((EditText) findViewById(R.id.editTextPsswd)).setText("");
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
