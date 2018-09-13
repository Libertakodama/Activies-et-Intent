package com.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String DEP_DEST = "com.example.myfirstapp.trajet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final Button buttonsearch = findViewById(R.id.button_search);
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editDeparture = findViewById(R.id.edit_departure);
                String edit_departureValue = editDeparture.getText().toString();
                EditText editDestination = findViewById(R.id.edit_destination);
                String edit_destinationValue = editDestination.getText().toString();
                if (edit_departureValue.isEmpty() || edit_destinationValue.equals("")) {
                    Toast.makeText(ItinerarySearchActivity.this, R.string.where_to_go , Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    String trajet = edit_departureValue + " >> " + edit_destinationValue;
                    intent.putExtra(DEP_DEST, trajet);
                    startActivity(intent);
                }
            }
        });

    }
}