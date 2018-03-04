package com.appham.projectviewer;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity {

    Snackbar snackbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            // User chose the info icon, show info snackbar with Google Play Store button
            case R.id.action_about:

                if (snackbar == null || !snackbar.isShown()) {
                    snackbar = Snackbar.make(findViewById(android.R.id.content),
                            R.string.app_developed_by, Snackbar.LENGTH_LONG)
                            .setDuration(10000)
                            .setAction("Google Play", view -> {
                                try {
                                    openStore(Uri.parse(
                                            "market://dev?id=Thomas+Fuchs-Martin"));
                                } catch (ActivityNotFoundException e) {
                                    openStore(Uri.parse(
                                            "https://play.google.com/store/apps/developer?id=Thomas+Fuchs-Martin"));
                                }
                            });
                    snackbar.show();
                }

                return true;


            // user selected nothing
            default:

                return super.onOptionsItemSelected(item);

        }
    }

    private void openStore(Uri uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }
}
