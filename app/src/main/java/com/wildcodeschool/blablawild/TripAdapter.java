package com.wildcodeschool.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.Locale;

public class TripAdapter extends ArrayAdapter<TripModel> {
    public TripAdapter(Context context, ArrayList<TripModel> trips){
        super(context, 0, trips);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for constructeurs
        TextView tvFirstname = (TextView) convertView.findViewById(R.id.textFirstname);
        TextView tvLastname = (TextView) convertView.findViewById(R.id.textLastname);
        TextView tvDate = (TextView) convertView.findViewById(R.id.textDayHour);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.textPrice);

        // Populate the data into the template view using the trip mode
        tvFirstname.setText(trip.getFirstname());
        tvLastname.setText(trip.getLastname());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE);
        String date = simpleDateFormat.format(trip.getDate());

        tvDate.setText(date);

        String price = Integer.toString(trip.getPrice());
        tvPrice.setText(price);

        // Return the completed view to render on screen
        return convertView;
    }

}
