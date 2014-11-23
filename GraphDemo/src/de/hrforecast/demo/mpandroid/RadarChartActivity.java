package de.hrforecast.demo.mpandroid;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.YLabels;
import com.github.mikephil.charting.utils.Legend;
import com.github.mikephil.charting.utils.Legend.LegendPosition;

import de.hrforecast.demo.R;
import android.os.Bundle;
import android.view.WindowManager;

public class RadarChartActivity extends DemoBase {

	private RadarChart radarChart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mpandroid_activity_radar_chart);

		radarChart = (RadarChart) findViewById(R.id.chart1);

		radarChart.setDescription("");
		radarChart.setUnit("h");
		radarChart.setDrawUnitsInChart(true);

		radarChart.setWebLineWidth(1.5f);
		radarChart.setWebLineWidthInner(0.75f);
		radarChart.setWebAlpha(100);

		radarChart.setDrawYValues(false);

		setData();

		XLabels xl = radarChart.getXLabels();
		xl.setTextSize(9f);

		YLabels yl = radarChart.getYLabels();
		yl.setLabelCount(5);
		yl.setTextSize(9f);
		yl.setDrawUnitsInYLabel(true);

		Legend l = radarChart.getLegend();
		l.setPosition(LegendPosition.RIGHT_OF_CHART);
		l.setXEntrySpace(7f);
		l.setYEntrySpace(5f);
	}

	public void setData() {

		float mult = 150;
		int cnt = 9;

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();
		ArrayList<Entry> yVals2 = new ArrayList<Entry>();

		// IMPORTANT: In a PieChart, no values (Entry) should have the same
		// xIndex (even if from different DataSets), since no values can be
		// drawn above each other.
		for (int i = 0; i < cnt; i++) {
			yVals1.add(new Entry((float) (Math.random() * mult) + mult / 2, i));
		}

		for (int i = 0; i < cnt; i++) {
			yVals2.add(new Entry((float) (Math.random() * mult) + mult / 2, i));
		}

		ArrayList<String> xVals = new ArrayList<String>();

		for (int i = 0; i < cnt; i++)
			xVals.add(mParties[i % mParties.length]);

		RadarDataSet set1 = new RadarDataSet(yVals1, "Set 1");
		set1.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
		set1.setDrawFilled(true);
		set1.setLineWidth(2f);

		RadarDataSet set2 = new RadarDataSet(yVals2, "Set 2");
		set2.setColor(ColorTemplate.VORDIPLOM_COLORS[4]);
		set2.setDrawFilled(true);
		set2.setLineWidth(2f);

		ArrayList<RadarDataSet> sets = new ArrayList<RadarDataSet>();
		sets.add(set1);
		sets.add(set2);

		RadarData data = new RadarData(xVals, sets);

		radarChart.setData(data);

		// undo all highlights
		radarChart.highlightValues(null);

		radarChart.invalidate();
	}

}
