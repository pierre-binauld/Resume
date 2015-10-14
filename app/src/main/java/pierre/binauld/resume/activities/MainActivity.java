package pierre.binauld.resume.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.ButterKnife;
import pierre.binauld.resume.R;
import pierre.binauld.resume.activities.initializer.ActivityViewHolderVisitor;
import pierre.binauld.resume.activities.view.ActivityViewHolder;
import pierre.binauld.resume.application.Application;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected ActivityViewHolder viewHolder;

    @Inject
    protected ActivityViewHolderVisitor viewInitializer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Application) getApplication()).getObjectGraph().inject(this);
        ButterKnife.bind(viewHolder, this);

        viewHolder.accept(this, viewInitializer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
