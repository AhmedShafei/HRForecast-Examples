package de.hrforecast.demo.mpandroid;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.graphics.PointF;
import android.graphics.RectF;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.XLabels.XLabelPosition;
import com.github.mikephil.charting.utils.YLabels;
import com.github.mikephil.charting.utils.YLabels.YLabelPosition;

import de.hrforecast.demo.R;
import de.hrforecast.demo.mpandroid.DemoBase;

public class BarChartActivity extends DemoBase implements
		OnChartValueSelectedListener {

	private BarChart barChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mpandroid_activity_bar_chart);

		barChart = (BarChart) findViewById(R.id.chart1);
		barChart.setOnChartValueSelectedListener(this);

		// enable the drawing of values
		barChart.setDrawYValues(true);

		barChart.setDescription("");

		// if more than 60 entries are displayed in the chart, no values will be
		// drawn
		barChart.setMaxVisibleValueCount(60);

		// scaling can now only be done on x- and y-axis separately
		barChart.setPinchZoom(true);

		barChart.setUnit(" h");

		barChart.setDrawGridBackground(false);
		barChart.setDrawHorizontalGrid(true);
		barChart.setDrawVerticalGrid(false);

		// sets the text size of the values inside the chart
		barChart.setValueTextSize(10f);

		barChart.setDrawBorder(false);

		XLabels xl = barChart.getXLabels();
		xl.setPosition(XLabelPosition.BOTTOM);
		xl.setCenterXLabelText(true);

		YLabels yl = barChart.getYLabels();
		yl.setLabelCount(8);
		yl.setPosition(YLabelPosition.BOTH_SIDED);

		//sets test data for the Chart
		setData(14, 80);

	}

	@Override
	public void onValueSelected(Entry entry, int dataSetIndex) {
		// TODO Auto-generated method stub
		if (entry == null)
			return;

		RectF bounds = barChart.getBarBounds((BarEntry) entry);
		PointF position = barChart.getPosition(entry);

		Log.i("bounds", bounds.toString());
		Log.i("position", position.toString());
	}

	@Override
	public void onNothingSelected() {
		// TODO Auto-generated method stub

	}

	private void setData(int count, float range) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add(mMonths[i % 12]);
		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

		for (int i = 0; i < count; i++) {
			float mult = (range + 1);
			float val = (float) (Math.random() * mult);
			yVals1.add(new BarEntry(val, i));
		}

		BarDataSet set1 = new BarDataSet(yVals1, "Test Data Set");
		set1.setBarSpacePercent(35f);

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);

		BarData data = new BarData(xVals, dataSets);

		barChart.setData(data);
	}
}
