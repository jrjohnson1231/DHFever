package johnjohnson.dhfever;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends Activity {

    public final static String INTENT_HALL = "com.johnjohnson.dhfever.HALL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView sdh = (TextView) findViewById(R.id.sdh_id);
        final TextView ndh = (TextView) findViewById(R.id.ndh_id);

        sdh.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    openMeal("South");
                }
                return false;
            }
        });

        ndh.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    openMeal("North");
                }
                return false;
            }
        });
    }

    protected void openMeal(String hall) {
        Intent launchSdh = new Intent(HomeActivity.this, MealActivity.class);
        launchSdh.putExtra(INTENT_HALL, hall);
        startActivity(launchSdh);

    }
}
