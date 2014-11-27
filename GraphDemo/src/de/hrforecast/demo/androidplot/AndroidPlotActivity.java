package de.hrforecast.demo.androidplot;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * {@link FragmentActivity} responsible for populating both the
 * {@link ChartListFragment} and {@link ChartDetailFragment}. It receives
 * callback from {@link ChartListFragment} whenever new chart type is selected,
 * and notifies the {@link ChartDetailFragment}
 */
public class AndroidPlotActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] libraries = { "Pie Chart", "Bar Chart", "XY Region", "List View" };
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
			this.startActivity(new Intent(this, PieChartActivity.class));
			break;
		case 1:
			this.startActivity(new Intent(this, BarChartActivity.class));
			break;
		case 2:
			this.startActivity(new Intent(this, XYRegionActivity.class));
			break;
		case 3:
			this.startActivity(new Intent(this, ListViewActivity.class));
			break;
		}
	}
}