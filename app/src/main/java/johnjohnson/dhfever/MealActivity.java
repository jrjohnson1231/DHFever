package johnjohnson.dhfever;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MealActivity extends AppCompatActivity {

    public final static String INTENT_MEAL = "com.johnjohnson.dhfever.MEAL";

    protected static String dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        Intent getHall = getIntent();
        String hall = getHall.getStringExtra(HomeActivity.INTENT_HALL);

        switch (hall) {
            case "South":
                dh = "SDH";
                break;
            case "North":
                dh = "NDH";
                break;
        }

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(hall + " Dining Hall");


        final TextView breakfast = (TextView) findViewById(R.id.breakfast_id);
        final TextView lunch = (TextView) findViewById(R.id.lunch_id);
        final TextView dinner = (TextView) findViewById(R.id.dinner_id);

        breakfast.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    openMenu("Breakfast");
                }
                return false;
            }
        });

        lunch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    openMenu("Lunch");
                }
                return false;
            }
        });

        dinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    openMenu("Dinner");
                }
                return false;
            }
        });
    }

    protected void openMenu(String meal) {
        Intent launchMenu = new Intent(MealActivity.this, MenuActivity.class);
        launchMenu.putExtra(INTENT_MEAL, meal);
        startActivity(launchMenu);
    }
}
