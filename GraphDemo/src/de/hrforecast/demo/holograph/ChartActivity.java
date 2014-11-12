package de.hrforecast.demo.holograph;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import de.hrforecast.demo.R;

/**
 * {@link FragmentActivity} responsible for populating both the
 * {@link ChartListFragment} and {@link ChartDetailFragment}. It receives
 * callback from {@link ChartListFragment} whenever new chart type is selected,
 * and notifies the {@link ChartDetailFragment}
 */
public class ChartActivity extends FragmentActivity implements
		ChartListFragment.Callbacks {

	private ChartDetailFragment chartDetailFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart_twopane);

		ChartListFragment chartListFragment = new ChartListFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.charts_listContainer, chartListFragment).commit();

		chartDetailFragment = new ChartDetailFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.charts_detailContainer, chartDetailFragment)
				.commit();
	}

	@Override
	public void onChartSelected(int position) {
		chartDetailFragment.updateChartDetails(position);
	}
}