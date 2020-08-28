package com.dropbox.core.examples.android.internal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import androidx.appcompat.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dropbox.core.android.Auth;
import com.dropbox.core.android.DbxOfficialAppConnector;
import com.dropbox.core.android.DropboxParseException;
import com.dropbox.core.android.DropboxUidNotInitializedException;
import com.dropbox.core.examples.android.DropboxActivity;
import com.dropbox.core.examples.android.R;

/**
 * This example is only for 3rd party apps who registered OpenWith feature at our server side who use
 * intent action {@value DbxOfficialAppConnector#ACTION_DBXC_EDIT} and
 * {@value DbxOfficialAppConnector#ACTION_DBXC_VIEW} to jump to their apps. Don't follow this if
 * you don't need openwith or if you use regular {@value Intent#ACTION_EDIT} and
 * {@value Intent#ACTION_VIEW}.
 */
public class OpenWithActivity extends DropboxActivity {
    private DbxOfficialAppConnector mDoac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_with);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        Button generateIntentButton = (Button)findViewById(R.id.generate_intent);
        generateIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                String path = editText.getText().toString();
                //fake OpenWithIntent with some dummy parameters
                Intent fakeOpenWithIntent = generateOpenWithIntent(path);
                //encode the fake OpenWithIntent into UtmContent
                String encodedFakeIntent = encodeOpenWithIntent(fakeOpenWithIntent);
                try {
                    //test that decoding utmcontent works
                    Intent decodedIntent = DbxOfficialAppConnector
                            .generateOpenWithIntentFromUtmContent(encodedFakeIntent);
                    //start that fake OpenWithIntent. This will lead us to a new OpenWithActivity.
                    startActivity(decodedIntent);
                } catch (DropboxParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Button mInstalled = (Button)findViewById(R.id.is_installed);
        mInstalled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbxOfficialAppConnector.DbxOfficialAppInstallInfo installInfo =
                        DbxOfficialAppConnector.isInstalled(OpenWithActivity.this);
                showToast((installInfo != null)?installInfo.toString():"Not installed!");
            }
        });

        Button mGenLinked = (Button)findViewById(R.id.is_linked_any_button);
        mGenLinked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSigned = DbxOfficialAppConnector.isAnySignedIn(OpenWithActivity.this);
                showToast("Any Signed in?:" + isSigned);
            }
        });

        Button mSpecLinked = (Button)findViewById(R.id.is_linked_spec_button);
        mSpecLinked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSigned = mDoac.isSignedIn(OpenWithActivity.this);
                showToast("Signed in?:" + isSigned);
            }
        });

        Button mPreview = (Button)findViewById(R.id.preview_button);
        mPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                String path = editText.getText().toString();
                Intent pIntent = mDoac.getPreviewFileIntent(OpenWithActivity.this, path, "");
                startActivity(pIntent);
            }
        });

        Button mUpgrade = (Button)findViewById(R.id.upgrade_button);
        mUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uIntent = mDoac.getUpgradeAccountIntent(OpenWithActivity.this);
                startActivity(uIntent);
            }
        });

    }

    /* Because it's just a fake intent, we just print it in Toast and do nothing here. As third
     * party app you should take the intent from Dropbox official app and potentially go through
     * the auth flow. Finally handle that file sent with this intent.
     */
    private void handleFakeOpenWithIntent(Intent intent) {
        if (intent.getAction() == DbxOfficialAppConnector.ACTION_DBXC_EDIT ||
                intent.getAction() == DbxOfficialAppConnector.ACTION_DBXC_VIEW) {
            String path = intent.getStringExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_PATH);
            String uid = intent.getStringExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_UID);
            boolean read_only = intent.getBooleanExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_READ_ONLY, false);
            String session_id = intent.getStringExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_SESSION_ID);
            showToast(path + uid + read_only + session_id);
        }
    }

    protected Intent generateOpenWithIntent(String path) {
        /*
         * Generate an OpenWithIntent.
         * Real 3rd party apps should never run this function as DropboxApp does this entirely
         */
        String uid = Auth.getUid();

        // fake the URI
        // WARNING: URI FORMAT IS NOT FINALIZED AND MAY CHANGE AT ANY TIME
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority("com.dropbox.android.FileCache");
        builder.appendPath("filecache");
        builder.appendPath(uid);

        for (String component : path.substring(1).split("/")) {
            builder.appendPath(component);
        }
        Uri uri = builder.build();
        // end URI fakery

        Intent owpIntent = new Intent(DbxOfficialAppConnector.ACTION_DBXC_EDIT, uri);

        // extras
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_PATH, path);
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_UID, uid);
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_READ_ONLY, false);
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_SESSION_ID, "generated");

        owpIntent.setDataAndType(uri, "text/plain");

        return owpIntent;
    }

    protected String encodeOpenWithIntent(Intent owpIntent) {
        /*
         * Encode OpenWith intent
         * Real 3rd party apps should never run this function as DropboxApp does this entirely
         */

        Bundle extras = owpIntent.getExtras();
        extras.putString("_action", owpIntent.getAction());
        extras.putParcelable("_uri", owpIntent.getData());
        extras.putString("_type", owpIntent.getType());

        // marshall it!
        final Parcel parcel = Parcel.obtain();
        parcel.writeBundle(extras);
        byte[] b = parcel.marshall();
        parcel.recycle();
        return new String(Base64.encode(b, 0));
    }

    private void showToast(String msg) {
        Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        error.show();
    }

    @Override
    protected void loadData() {
        try {
            String uid = Auth.getUid();
            if (uid == null) {
                SharedPreferences prefs = getSharedPreferences("dropbox-sample", MODE_PRIVATE);
                uid = prefs.getString("user-id", null);
            }
            this.mDoac = new DbxOfficialAppConnector(uid);
        } catch (DropboxUidNotInitializedException e) {
            e.printStackTrace();
            return;
        }

        handleFakeOpenWithIntent(getIntent());
    }
}
