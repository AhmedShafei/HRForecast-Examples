package de.hrforecast.demo.mpandroid;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.LimitLine;
import com.github.mikephil.charting.utils.LimitLine.LimitLabelPosition;

import com.github.mikephil.charting.charts.LineChart;

import de.hrforecast.demo.R;
import de.hrforecast.demo.mpandroid.DemoBase;

public class LineChartActivity extends DemoBase {
	// create the LineChart object
	private LineChart lineChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mpandroid_activity_line_chart);

		lineChart = (LineChart) findViewById(R.id.chart1);

		// set properties like - unit of the values in the chart
		lineChart.setUnit("h");
		lineChart.setDrawUnitsInChart(true);
		// if enabled, the chart will always start at zero on the y-axis
		lineChart.setStartAtZero(false);
		//enables zooming for both X-axis and Y-axis
		lineChart.setPinchZoom(true);

		// add chart data - uses the implementation of setData method, values
		// are just test ones
		setData(12, 60);

	}

	private void setData(int count, float range) {

		// Sets data for the X-axis
		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add((i) + "");
		}

		// Sets data for the Y-axis
		ArrayList<Entry> yVals = new ArrayList<Entry>();

		for (int i = 0; i < count; i++) {
			float mult = (range + 1);
			float val = (float) (Math.random() * mult) + 3;
			yVals.add(new Entry(val, i));
		}

		// create a dataset and give it a type
		LineDataSet set1 = new LineDataSet(yVals, "Test Data Set");

		// sets dashed line visualisation for the graph
		set1.enableDashedLine(10f, 5f, 0f);
		
		set1.setColor(Color.GREEN);
		set1.setCircleColor(Color.BLACK);
		set1.setLineWidth(2f);
		set1.setCircleSize(4f);
		set1.setFillAlpha(65);
		set1.setFillColor(Color.BLACK);
		lineChart.setBackgroundColor(Color.TRANSPARENT);

		ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
		dataSets.add(set1); // adds the datasets

		// create a data object with the datasets
		LineData data = new LineData(xVals, dataSets);

		LimitLine limitLine1 = new LimitLine(130f);
		limitLine1.setLineWidth(4f);
		limitLine1.enableDashedLine(10f, 10f, 0f);
		limitLine1.setDrawValue(true);
		limitLine1.setLabelPosition(LimitLabelPosition.RIGHT);

		LimitLine limitLine2 = new LimitLine(-30f);
		limitLine2.setLineWidth(4f);
		limitLine2.enableDashedLine(10f, 10f, 0f);
		limitLine2.setDrawValue(true);
		limitLine2.setLabelPosition(LimitLabelPosition.RIGHT);

		data.addLimitLine(limitLine1);
		data.addLimitLine(limitLine2);

		// set data
		lineChart.setData(data);
	}

}
