package com.example.balog.rssi_location;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        final TableLayout distanceTable = (TableLayout) findViewById(R.id.table_distance);
        final TableLayout.LayoutParams paramTableRow = new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        paramTableRow.setMargins(50, 0, 0, 0);
        final LayoutParams paramTextView = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);

        // Set a button to show info
        final Button infoButton = (Button) findViewById(R.id.info_button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distanceTable.removeAllViews();

                TableRow textRow = new TableRow(HomeActivity.this);
                textRow.setLayoutParams(paramTableRow);

                TextView infoText = new TextView(HomeActivity.this);
                infoText.setLayoutParams(paramTextView);
                infoText.setText("\nUUID: The ID of a beacon. They all have the same value " +
                        "at production." + "\n\nMajor/Minor: 5 Digit identifier for the beacon. This " +
                        "identifies only by the minor." + "\n\nRSSI: Received Signal Strength Indicator. This, together " +
                        "measured power calculates the distance through a algorithm." + "\n\nMeasured Power: The RSSI " +
                        "at a distance of 1 meter." + "\n\n\nThe distance is calculated through the median of a certain" +
                        "amount of measurements.");

                textRow.addView(infoText);
                distanceTable.addView(textRow);
            }
        });
    }
}