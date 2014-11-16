package de.hrforecast.demo.william;

import com.db.chart.listener.OnEntryClickListener;
import com.db.chart.model.Bar;
import com.db.chart.model.BarSet;
import com.db.chart.view.BarChartView;
import com.db.chart.view.LineChartView;
import com.db.chart.view.StackBarChartView;
import com.db.chart.view.XController.LabelPosition;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;
import de.hrforecast.demo.R;

/**
 * {@link Fragment} responsible for showing the details of the selected chart
 * type. It receives a call whenever new chart type is selected
 */
public class ChartDetailFragment extends Fragment {

	private ViewFlipper chartFlipper;

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
				R.layout.william_fragment_chart_detail, container, false);

		chartFlipper = (ViewFlipper) rootView
				.findViewById(R.id.william_chartFlipper);

		BarChartView barChart = (BarChartView) rootView
				.findViewById(R.id.william_barChart);
		LineChartView lineChart = (LineChartView) rootView
				.findViewById(R.id.william_lineChart);
		StackBarChartView stackedChart = (StackBarChartView) rootView
				.findViewById(R.id.william_stackChart);

		initializeBarChart(barChart);
		initializeLineChart(lineChart);
		initializeStackedChart(stackedChart);

		return rootView;
	}

	private void initializeBarChart(BarChartView barChart) {
		/**
		 * Library methods barChart.setBarBackground(bool);
		 * barChart.setBarBackgroundColor(color); barChart.setBarSpacing(dimen);
		 * barChart.setBorderSpacing(spacing); barChart.setEntryBehaviour(view);
		 * barChart.setFontSize(size); barChart.setGrid(paint);
		 * barChart.setLabelColor(color);
		 * barChart.setMaxAxisValue(maxAxisValue,step);
		 * barChart.setOnClickListener(listener);
		 * barChart.setOnEntryClickListener(listener);
		 * barChart.setRoundCorners(radius); barChart.setSetSpacing(spacing);
		 * barChart.setStep(step); barChart.setThresholdLine(value, paint);
		 * barChart.setTopSpacing(spacing); barChart.setTypeface(typeface);
		 * barChart.setXAxis(bool); barChart.setXLabels(position);
		 * barChart.setYAxis(bool); barChart.setYLabels(position);
		 * barChart.show(); barChart.notifyDataUpdate();
		 * barChart.showTooltip(tooltip);
		 */

		// set coloring
		barChart.setBarBackgroundColor(Color.WHITE);
		barChart.setBarBackground(true);
		barChart.setLabelColor(Color.CYAN);

		// set space spacings and values
		barChart.setBorderSpacing(10);
		barChart.setTopSpacing(10);
		barChart.setBarSpacing(30);
		barChart.setFontSize(15);
		barChart.setMaxAxisValue(30, 2);
		barChart.setRoundCorners(5);
		barChart.setXLabels(LabelPosition.INSIDE);

		// set Grid
		Paint paint1 = new Paint();
		paint1.setColor(Color.BLUE);
		paint1.setStyle(Paint.Style.FILL_AND_STROKE);
		barChart.setGrid(paint1);

		// Set Threshold
		Paint paint2 = new Paint();
		paint2.setColor(Color.BLACK);
		barChart.setThresholdLine(10, paint2);

		// Set bars data
		final BarSet barSet = new BarSet();
		Bar bar1 = new Bar("Bar 1", 5);
		bar1.setColor(Color.RED);
		Bar bar2 = new Bar("Bar 2", 10.5f);
		bar2.setColor(Color.RED);
		Bar bar3 = new Bar("Bar 3", 7);
		bar3.setColor(Color.GREEN);
		Bar bar4 = new Bar("Bar 4", 20.2f);
		bar4.setColor(Color.GRAY);
		Bar bar5 = new Bar("Bar 5", 15);
		bar5.setColor(Color.MAGENTA);
		Bar bar6 = new Bar("Bar 5", 15);
		bar6.setColor(Color.MAGENTA);
		Bar bar7 = new Bar("Bar 5", 15);
		barSet.addBar(bar1);
		barSet.addBar(bar2);
		barSet.addBar(bar3);
		barSet.addBar(bar4);
		barSet.addBar(bar5);
		barSet.addBar(bar6);
		barSet.addBar(bar7);
		barChart.addData(barSet);

		// set Entry click
		barChart.setOnEntryClickListener(new OnEntryClickListener() {
			@Override
			public void onClick(int setIndex, int entryIndex, Rect rect) {
				Toast.makeText(ChartDetailFragment.this.getActivity(),
						barSet.getEntry(entryIndex).getLabel() + " is clicked",
						Toast.LENGTH_SHORT).show();
			}
		});

		barChart.show();
	}

	private void initializeLineChart(LineChartView lineChart) {

	}

	private void initializeStackedChart(StackBarChartView StackedChart) {

	}

	/**
	 * This method is called when a new chart type is selected
	 * 
	 * @param position
	 *            It's the position of the selected chart type in the
	 *            corresponding {@link ChartListFragment}
	 */
	public void updateChartDetails(int position) {
		/**
		 * String[] charts = { "Bar Chart", "Line Chart", "Stacked Chart" };
		 */
		this.chartFlipper.setDisplayedChild(position);
	}
}
