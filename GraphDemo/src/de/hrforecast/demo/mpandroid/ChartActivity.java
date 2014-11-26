package de.hrforecast.demo.mpandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChartActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] libraries = { "Line Chart", "Bar Chart", "Radar Chart",
				"Pie Chart" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, libraries);
		setListAdapter(adapter);
	}

	/**
	 * Insert your activity intent here at your corresponding case number.
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
		case 0:
			this.startActivity(new Intent(this, LineChartActivity.class));
			break;
		case 1:
			this.startActivity(new Intent(this, BarChartActivity.class));
			break;
		case 2:
			this.startActivity(new Intent(this, RadarChartActivity.class));
			break;
		case 3:
			this.startActivity(new Intent(this, PieChartActivity.class));
			break;
		}
	}
}