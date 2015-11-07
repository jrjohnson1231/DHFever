package johnjohnson.dhfever;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent getMeal = getIntent();
        String meal = getMeal.getStringExtra(MealActivity.INTENT_MEAL);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(MealActivity.dh + " - " + meal);
    }
}
