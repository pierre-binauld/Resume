package pierre.binauld.resume.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pierre.binauld.resume.R;
import pierre.binauld.resume.activities.initializer.ActivityInitializer;
import pierre.binauld.resume.application.Application;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.drawer_layout)   DrawerLayout drawerLayout;
    @Bind(R.id.toolbar)         Toolbar toolbar;

    @Inject
    protected ActivityInitializer initializer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Application) getApplication()).getObjectGraph().inject(this);
        ButterKnife.bind(this);

        initializer.initActivity(this, toolbar, drawerLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
