package com.weatherdesigndemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CollapseModePin extends AppCompatActivity {

    Toolbar toolbar;
    Menu collapsedMenu;
    private boolean appBarExpanded = true;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_header_parallex);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        //for include menu
        setSupportActionBar(toolbar);
        // below line for back symbol in home page.
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.d(CollapseModePin.class.getSimpleName(), "onOffsetChanged: verticalOffset: " + verticalOffset);

                //  Vertical offset == 0 indicates appBar is fully expanded.
                if (Math.abs(verticalOffset) > 200) {
                    appBarExpanded = false;
                    invalidateOptionsMenu();
                } else {
                    appBarExpanded = true;
                    invalidateOptionsMenu();
                }
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header_menu, menu);
        collapsedMenu = menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (collapsedMenu != null
                && (/*!appBarExpanded || */collapsedMenu.size() != 1)) {
            //collapsed
            collapsedMenu.add("Add")
                    .setIcon(R.drawable.ic_my_account_active)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        } else {
            //expanded
        }
        return super.onPrepareOptionsMenu(collapsedMenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_add:
                Toast.makeText(this, "add button clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
