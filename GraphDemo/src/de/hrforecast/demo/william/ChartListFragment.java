package de.hrforecast.demo.william;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * {@link ListFragment} responsible for populating list of the supported chart
 * types by the implemented library. It notifies the {@link ChartActivity}
 * whenever new chart type is selected.
 */
public class ChartListFragment extends ListFragment {

	private Callbacks listCallback;
	private View tempView;

	public interface Callbacks {
		public void onChartSelected(int position);
	}

	public ChartListFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/**
		 * Edit this with the chart types you choose for your library
		 * implementation
		 */
		String[] charts = { "Bar Chart", "Line Chart", "Stacked Chart" };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this.getActivity(), android.R.layout.simple_list_item_1, charts);
		setListAdapter(adapter);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		this.getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (!(activity instanceof Callbacks))
			throw new IllegalStateException(
					"Activity must implement fragment's callbacks.");
		listCallback = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);
		if (tempView != null)
			tempView.setBackgroundResource(android.R.color.white);
		view.setBackgroundResource(android.R.color.darker_gray);
		tempView = view;
		listCallback.onChartSelected(position);
	}
}
