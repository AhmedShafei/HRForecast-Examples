package de.hrforecast.demo.william;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.db.chart.Tools;
import com.db.chart.listener.OnEntryClickListener;
import com.db.chart.model.Bar;
import com.db.chart.model.BarSet;
import com.db.chart.model.LineSet;
import com.db.chart.model.Point;
import com.db.chart.view.BarChartView;
import com.db.chart.view.LineChartView;
import com.db.chart.view.StackBarChartView;
import com.db.chart.view.XController.LabelPosition;

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

		/**
		 * Charts methods are duplicated in the following three methods for
		 * better illustration for the demo.
		 */
		initializeBarChart(barChart);
		initializeLineChart(lineChart);
		initializeStackedChart(stackedChart);

		return rootView;
	}

	private void initializeBarChart(BarChartView barChart) {
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
		paint1.setStyle(Paint.Style.STROKE);
		paint1.setStrokeWidth(Tools.fromDpToPx(1));
		paint1.setAntiAlias(true);
		paint1.setPathEffect(new DashPathEffect(new float[] { 10, 10 }, 0));
		barChart.setGrid(paint1);
		barChart.setHorizontalGrid(paint1);
		barChart.setVerticalGrid(paint1);

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
		Bar bar6 = new Bar("Bar 5", 13);
		bar6.setColor(Color.MAGENTA);
		Bar bar7 = new Bar("Bar 5", 2);
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

		// show BarChart
		barChart.show();
	}

	private void initializeLineChart(LineChartView lineChart) {
		// Set lines data
		final LineSet lineSet = new LineSet();
		Point point1 = new Point("point1", 5);
		Point point2 = new Point("point2", 10.5f);
		Point point3 = new Point("point3", 7);
		Point point4 = new Point("point4", 20.2f);
		Point point5 = new Point("point5", 15);
		Point point6 = new Point("point6", 13);
		Point point7 = new Point("point7", 2);
		lineSet.addPoint(point1);
		lineSet.addPoint(point2);
		lineSet.addPoint(point3);
		lineSet.addPoint(point4);
		lineSet.addPoint(point5);
		lineSet.addPoint(point6);
		lineSet.addPoint(point7);

		// Style dots
		lineSet.setDots(true);
		lineSet.setDotsColor(Color.RED);
		lineSet.setDotsRadius(6);
		lineSet.setDotsStrokeThickness(2);
		lineSet.setDotsStrokeColor(Color.YELLOW);

		// Style line
		lineSet.setLineThickness(2);
		lineSet.setLineColor(Color.BLUE);

		// Style background fill
		lineSet.setFill(true);
		lineSet.setFill(Color.GREEN);

		// Style type lineSet
		lineSet.setLineDashed(true);
		lineSet.setSmooth(true);
		lineSet.setLineSmooth(true);

		lineChart.addData(lineSet);

		// set Entry click
		lineChart.setOnEntryClickListener(new OnEntryClickListener() {
			@Override
			public void onClick(int setIndex, int entryIndex, Rect rect) {
				Toast.makeText(
						ChartDetailFragment.this.getActivity(),
						lineSet.getEntry(entryIndex).getLabel() + " is clicked",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Show LineChart
		lineChart.show();

	}

	private void initializeStackedChart(StackBarChartView StackedChart) {
		// set coloring
		StackedChart.setBarBackgroundColor(Color.WHITE);
		StackedChart.setBarBackground(true);
		StackedChart.setLabelColor(Color.CYAN);

		// set space spacings and values
		StackedChart.setBorderSpacing(10);
		StackedChart.setTopSpacing(10);
		StackedChart.setBarSpacing(30);
		StackedChart.setFontSize(15);

		// set Grid
		Paint paint1 = new Paint();
		paint1.setColor(Color.BLUE);
		paint1.setStyle(Paint.Style.FILL_AND_STROKE);
		StackedChart.setGrid(paint1);

		// Set Threshold
		Paint paint2 = new Paint();
		paint2.setColor(Color.BLACK);
		StackedChart.setThresholdLine(10, paint2);

		// Set bars data,first bars and then second bars
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
		Bar bar6 = new Bar("Bar 6", 13);
		bar6.setColor(Color.MAGENTA);
		Bar bar7 = new Bar("Bar 7", 2);
		barSet.addBar(bar1);
		barSet.addBar(bar2);
		barSet.addBar(bar3);
		barSet.addBar(bar4);
		barSet.addBar(bar5);
		barSet.addBar(bar6);
		barSet.addBar(bar7);
		final BarSet barSet2 = new BarSet();
		Bar bar11 = new Bar("Bar 1 new", 8);
		bar11.setColor(Color.DKGRAY);
		Bar bar21 = new Bar("Bar 2 new", 4f);
		bar21.setColor(Color.DKGRAY);
		Bar bar31 = new Bar("Bar 3 new", 10);
		bar31.setColor(Color.DKGRAY);
		Bar bar41 = new Bar("Bar 4 new", 6f);
		bar41.setColor(Color.DKGRAY);
		Bar bar51 = new Bar("Bar 5 new", 5);
		bar51.setColor(Color.DKGRAY);
		Bar bar61 = new Bar("Bar 6 new", 7);
		bar61.setColor(Color.DKGRAY);
		Bar bar71 = new Bar("Bar 7 new", 10);
		bar71.setColor(Color.DKGRAY);
		barSet2.addBar(bar11);
		barSet2.addBar(bar21);
		barSet2.addBar(bar31);
		barSet2.addBar(bar41);
		barSet2.addBar(bar51);
		barSet2.addBar(bar61);
		barSet2.addBar(bar71);

		StackedChart.addData(barSet);
		StackedChart.addData(barSet2);

		// set Entry click
		StackedChart.setOnEntryClickListener(new OnEntryClickListener() {
			@Override
			public void onClick(int setIndex, int entryIndex, Rect rect) {
				String text = "";
				if (setIndex == 0)
					text = barSet.getEntry(entryIndex).getLabel();
				else
					text = barSet2.getEntry(entryIndex).getLabel();
				Toast.makeText(ChartDetailFragment.this.getActivity(),
						text + " is clicked", Toast.LENGTH_SHORT).show();
			}
		});

		// Show StackedBarChart
		StackedChart.show();

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
