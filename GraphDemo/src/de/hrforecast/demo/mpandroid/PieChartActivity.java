package de.hrforecast.demo.mpandroid;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.interfaces.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import de.hrforecast.demo.R;
import de.hrforecast.demo.mpandroid.DemoBase;

public class PieChartActivity extends DemoBase implements
		OnChartValueSelectedListener {

	private PieChart pieChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mpandroid_acitivity_pie_chart);

		pieChart = (PieChart) findViewById(R.id.chart1);

		// change the color of the center hole
		pieChart.setHoleColor(Color.rgb(235, 235, 235));

		pieChart.setHoleRadius(55f);

		pieChart.setDescription("");

		pieChart.setDrawYValues(true);
		pieChart.setDrawCenterText(true);

		pieChart.setDrawHoleEnabled(true);

		pieChart.setRotationAngle(0);

		// draws the corresponding description value into the slice
		pieChart.setDrawXValues(true);

		// enable rotation of the chart by touch
		// pieChart.setRotationEnabled(true);

		// display percentage values
		pieChart.setUsePercentValues(true);
		pieChart.setUnit("h");
		pieChart.setDrawUnitsInChart(true);

		// add a selection listener
		pieChart.setOnChartValueSelectedListener(this);

		pieChart.setCenterText("HRForecast\nMobileScorecard");

		// sets chart test data
		setData(3, 100);

	}

	@Override
	public void onValueSelected(Entry e, int dataSetIndex) {

	}

	@Override
	public void onNothingSelected() {

	}

	private void setData(int count, float range) {

		float mult = range;

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();

		// IMPORTANT: In a PieChart, no values (Entry) should have the same
		// xIndex (even if from different DataSets), since no values can be
		// drawn above each other.
		for (int i = 0; i < count + 1; i++) {
			yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5, i));
		}

		ArrayList<String> xVals = new ArrayList<String>();

		for (int i = 0; i < count + 1; i++)
			xVals.add(mParties[i % mParties.length]);

		PieDataSet set1 = new PieDataSet(yVals1, "Working Hours");
		set1.setSliceSpace(3f);

		// add parts colors

		ArrayList<Integer> colors = new ArrayList<Integer>();

		for (int c : ColorTemplate.VORDIPLOM_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.JOYFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.COLORFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.LIBERTY_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.PASTEL_COLORS)
			colors.add(c);

		colors.add(ColorTemplate.getHoloBlue());

		set1.setColors(colors);

		PieData data = new PieData(xVals, set1);
		pieChart.setData(data);

	}

}
