package de.hrforecast.demo.mpandroid;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.LimitLine;
import com.github.mikephil.charting.utils.LimitLine.LimitLabelPosition;

import com.github.mikephil.charting.charts.LineChart;

import de.hrforecast.demo.R;

public class LineChartActivity extends DemoBase {
	private LineChart lineChart;
	// private SeekBar mSeekBarX, mSeekBarY;
	private TextView tvX;
	private TextView tvY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mpandroid_activity_line_chart);

		tvX = (TextView) findViewById(R.id.tvXMax);
		tvY = (TextView) findViewById(R.id.tvYMax);

		// mSeekBarX = (SeekBar) findViewById(R.id.seekBar1);
		// mSeekBarY = (SeekBar) findViewById(R.id.seekBar2);

		// mSeekBarX.setProgress(45);
		// mSeekBarY.setProgress(100);

		// mSeekBarY.setOnSeekBarChangeListener(this);
		// mSeekBarX.setOnSeekBarChangeListener(this);

		lineChart = (LineChart) findViewById(R.id.chart1);
		// lineChart.setOnChartGestureListener(this);
		// lineChart.setOnChartValueSelectedListener(this);

		lineChart.setUnit(" $");
		lineChart.setDrawUnitsInChart(true);

		// if enabled, the chart will always start at zero on the y-axis
		lineChart.setStartAtZero(false);
		// add data
		setData(45, 100);

		// disable the drawing of values into the chart
		// lineChart.setDrawYValues(false);

		// lineChart.setDrawBorder(true);
		// lineChart.setBorderPositions(new BorderPosition[] {
		// BorderPosition.BOTTOM
		// });
	}

	private void setData(int count, float range) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
		}

		ArrayList<Entry> yVals = new ArrayList<Entry>();

		for (int i = 0; i < count; i++) {
			float mult = (range + 1);
			float val = (float) (Math.random() * mult) + 3;// + (float)
															// ((mult *
															// 0.1) / 10);
			yVals.add(new Entry(val, i));
		}

		// create a dataset and give it a type
		LineDataSet set1 = new LineDataSet(yVals, "DataSet 1");
		// set1.setFillAlpha(110);
		// set1.setFillColor(Color.RED);

		// set the line to be drawn like this "- - - - - -"
		set1.enableDashedLine(10f, 5f, 0f);
		set1.setColor(Color.BLACK);
		set1.setCircleColor(Color.BLACK);
		set1.setLineWidth(1f);
		set1.setCircleSize(4f);
		set1.setFillAlpha(65);
		set1.setFillColor(Color.BLACK);
		// set1.setShader(new LinearGradient(0, 0, 0, mChart.getHeight(),
		// Color.BLACK, Color.WHITE, Shader.TileMode.MIRROR));

		ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
		dataSets.add(set1); // add the datasets

		// create a data object with the datasets
		LineData data = new LineData(xVals, dataSets);

		LimitLine ll1 = new LimitLine(130f);
		ll1.setLineWidth(4f);
		ll1.enableDashedLine(10f, 10f, 0f);
		ll1.setDrawValue(true);
		ll1.setLabelPosition(LimitLabelPosition.RIGHT);

		LimitLine ll2 = new LimitLine(-30f);
		ll2.setLineWidth(4f);
		ll2.enableDashedLine(10f, 10f, 0f);
		ll2.setDrawValue(true);
		ll2.setLabelPosition(LimitLabelPosition.RIGHT);

		data.addLimitLine(ll1);
		data.addLimitLine(ll2);

		// set data
		lineChart.setData(data);
	}

}
