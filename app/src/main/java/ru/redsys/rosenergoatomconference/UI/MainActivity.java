package ru.redsys.rosenergoatomconference.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ru.redsys.rosenergoatomconference.R;

import static ru.redsys.rosenergoatomconference.utils.Helpers.getTextFromRawFile;

public class MainActivity extends AppCompatActivity {

    TextView tvSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initChildViews();
    }

    /**
     * Initialize all views
     */
    private void initChildViews() {
        tvSchedule = findViewById(R.id.recycler_schedule);

        tvSchedule.setText(getTextFromRawFile(this, R.raw.schedule));
    }
}
