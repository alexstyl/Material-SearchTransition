package com.alexstyl.searchtransition.searchscreen;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import com.alexstyl.searchtransition.boilerplate.BoilerplateActivity;
import com.alexstyl.searchtransition.R;
import com.alexstyl.searchtransition.transition.FadeInTransition;
import com.alexstyl.searchtransition.transition.FadeOutTransition;
import com.alexstyl.searchtransition.transition.SimpleTransitionListener;

public class SearchActivity extends BoilerplateActivity {

    private Searchbar searchbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchbar = (Searchbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(searchbar);



        // make sure to check if this is the first time running the activity
        // we don't want to play the enter animation on configuration changes (i.e. orientation)
        if (isFirstTimeRunning(savedInstanceState)) {
            // Start with an empty looking Toolbar
            // We are going to fade its contents in, as long as the activity finishes rendering
            searchbar.hideContent();

            ViewTreeObserver viewTreeObserver = searchbar.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    searchbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    // after the activity has finished drawing the initial layout, we are going to continue the animation
                    // that we left off from the MainActivity
                    showSearch();
                }

                private void showSearch() {
                    // use the TransitionManager to animate the changes of the Toolbar
                    TransitionManager.beginDelayedTransition(searchbar, FadeInTransition.createTransition());
                    // here we are just changing all children to VISIBLE
                    searchbar.showContent();
                }
            });
        }
    }

    private boolean isFirstTimeRunning(Bundle savedInstanceState) {
        return savedInstanceState == null;
    }

    @Override
    public void finish() {
        // when the user tries to finish the activity we have to animate the exit
        // let's start by hiding the keyboard so that the exit seems smooth
        hideKeyboard();

        // at the same time, start the exit transition
        exitTransitionWithAction(new Runnable() {
            @Override
            public void run() {
                // which finishes the activity (for real) when done
                SearchActivity.super.finish();

                // override the system pending transition as we are handling ourselves
                overridePendingTransition(0, 0);
            }
        });
    }

    private void exitTransitionWithAction(final Runnable endingAction) {

        Transition transition = FadeOutTransition.withAction(new SimpleTransitionListener() {
            @Override
            public void onTransitionEnd(Transition transition) {
                endingAction.run();
            }
        });

        TransitionManager.beginDelayedTransition(searchbar, transition);
        searchbar.hideContent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.action_clear) {
            searchbar.clearText();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
