package de.hrforecast.demo.mpandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.hrforecast.demo.R;

/**
 * {@link Fragment} responsible for showing the details of the selected chart
 * type. It receives a call whenever new chart type is selected
 */
public class ChartDetailFragment extends Fragment {

	private int selectedChart;

	public ChartDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Edit this to inflate the corresponding layout of your
		 * chartDetailFragment class
		 */
		View rootView = inflater.inflate(
				R.layout.mpandroid_activity_line_chart, container, false);

		return rootView;
	}

	/**
	 * This method is called when a new chart type is selected
	 * 
	 * @param position
	 *            It's the position of the selected chart type in the
	 *            corresponding {@link ChartListFragment}
	 */
	public void updateChartDetails(int position) {
		this.selectedChart = position;

		/**
		 * Dummy TextView, to be changed to the actual implementation of the
		 * library charts
		 */
		((TextView) this.getView().findViewById(R.id.chart_detailText))
				.setText("Chart in position " + selectedChart + " is selected");
	}
}
