package com.gdg.eventmanager.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gdg.eventmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atilabraga on 3/18/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        if (hasBackButton()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (hasBackButton()) {
                    onBackPressed();
                }
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @LayoutRes
    public abstract int getContentView();

    /**
     * The back button action will call the onBackPressed() action
     *
     * @return true if the toolbar has the back button, false otherwise
     */
    public abstract boolean hasBackButton();
}
