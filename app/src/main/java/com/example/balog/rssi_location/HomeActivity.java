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
                infoText.setText(new StringBuilder().append("\nUUID: ID of a beacon.")
                        .append("\n\nMajor/Minor: 5 Digit identifier for the beacon.")
                        .append("\n\nRSSI: Received Signal Strength Indicator.")
                        .append("This is used to calculate the distance")
                        .toString());
                textRow.addView(infoText);
                distanceTable.addView(textRow);
            }
        });
    }
}