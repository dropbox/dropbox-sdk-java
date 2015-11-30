package com.dropbox.core.examples.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dropbox.core.android.Auth;
import com.dropbox.core.v2.DbxUsers;


/**
 * Activity that shows information about the currently logged in user
 */
public class UserActivity extends DropboxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button loginButton = (Button)findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.startOAuth2Authentication(UserActivity.this, getString(R.string.app_key));
            }
        });

        Button filesButton = (Button)findViewById(R.id.files_button);
        filesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FilesActivity.getIntent(UserActivity.this, ""));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (hasToken()) {
            findViewById(R.id.login_button).setEnabled(false);
            findViewById(R.id.files_button).setEnabled(true);
        } else {
            findViewById(R.id.login_button).setEnabled(true);
            findViewById(R.id.files_button).setEnabled(false);
        }
    }

    @Override
    protected void loadData() {
        new GetCurrentAccountTask(DropboxClient.DbxUsers(), new GetCurrentAccountTask.Callback() {
            @Override
            public void onComplete(DbxUsers.FullAccount result) {
                ((TextView) findViewById(R.id.email_text)).setText(result.email);
                ((TextView) findViewById(R.id.name_text)).setText(result.name.displayName);
                ((TextView) findViewById(R.id.type_text)).setText(result.accountType.toString());
            }

            @Override
            public void onError(Exception e) {

            }
        }).execute();
    }

}
