package de.hrforecast.demo.main;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import de.hrforecast.demo.william.ChartActivity;

/**
 * Launcher {@link ListActivity} responsible for launching the libraries intents
 */
public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] libraries = { "HelloChart", "HZ Graph", "AFreeChart",
				"MP Android", "Eaze Graph", "Holograph", "William Charts",
				"AChart Engine", "Android Plot" };
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

			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:
			this.startActivity(new Intent(this,
					de.hrforecast.demo.holograph.ChartActivity.class));
			break;
		case 6:
			this.startActivity(new Intent(this,
					de.hrforecast.demo.william.ChartActivity.class));
			break;
		case 7:

			break;
		case 8:

			break;
		case 9:

			break;
		}
	}
}