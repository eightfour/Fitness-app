package de.university.reutlingen.mobile.computing.fitnessapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.commons.lang3.StringUtils;

import de.university.reutlingen.mobile.computing.fitnessapp.ui.exercise.ExerciseFragement;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.login.LoginFragment;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlanReference;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.TrainingPlansFragment;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail.TrainingPlanDetailFragment;

public class MainActivity extends AppCompatActivity
        implements MainView, NavigationView.OnNavigationItemSelectedListener, LoginFragment.OnLoginListener, TrainingPlansFragment.TrainingPlanSelectionListener {

    public static final String LOGIN_FRAGMENT_BACKSTACK_ENTRY = "main-activity_login-fragment";
    public static final String TRAINING_PLANS_FRAGMENT_BACKSTACK_ENTRY = "main-activity_training-plans-fragment";
    public static final String TRAINING_PLAN_DETAIL_FRAGMENT_BACKSTACK_ENTRY = "main-activity_training-plan-detail-fragment";
    public static final String EXERCISE_DETAIL_FRAGMENT_BACKSTACK_ENTRY = "main-activity_exercise-detail-fragment";
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the presenter
        this.mainPresenter = new MainPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mainPresenter.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            this.replaceFragment(new TrainingPlansFragment(), TRAINING_PLANS_FRAGMENT_BACKSTACK_ENTRY, true);
        } else if ( id == R.id.nav_slideshow ){
            this.replaceFragment(new ExerciseFragement(), EXERCISE_DETAIL_FRAGMENT_BACKSTACK_ENTRY, true);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onLogin() {
        this.mainPresenter.onLogin();
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showLoginFragment() {
        this.replaceFragment(new LoginFragment(), LOGIN_FRAGMENT_BACKSTACK_ENTRY, true);
    }

    @Override
    public void hideLoginFragment() {
        getSupportFragmentManager().popBackStack(LOGIN_FRAGMENT_BACKSTACK_ENTRY, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    /**
     * Utility method to use when changing fragment to be displayed.
     *
     * @param newFragment to display
     * @param backstackEntry name of the fragment on the backstack
     * @param addToBackstack if the fragment should be added to the backstack
     */
    private void replaceFragment(Fragment newFragment, String backstackEntry, boolean addToBackstack) {
        if (newFragment != null) {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, newFragment);
            if (addToBackstack) {
                if (StringUtils.isBlank(backstackEntry)) {
                    throw new IllegalArgumentException(ErrorCodes.MISSING_BACK_STACK_NAME.getMessage());
                }
                fragmentTransaction.addToBackStack(backstackEntry);
            }
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListFragmentInteraction(TrainingPlanReference item) {
        System.out.println(String.format("Selected Training Plan Reference with id %s", item.getIdentifier()));
        final Bundle bundle = new Bundle();
        bundle.putString(TrainingPlanDetailFragment.PLAN_ID, item.getIdentifier());

        final TrainingPlanDetailFragment detailFragment = new TrainingPlanDetailFragment();
        detailFragment.setArguments(bundle);

        this.replaceFragment(detailFragment, TRAINING_PLAN_DETAIL_FRAGMENT_BACKSTACK_ENTRY, true);
    }
}
