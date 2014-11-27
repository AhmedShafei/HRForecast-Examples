package de.hrforecast.demo.androidplot;

import com.androidplot.pie.PieChart;
import com.androidplot.pie.PieRenderer;
import com.androidplot.pie.Segment;
import com.androidplot.pie.SegmentFormatter;

import de.hrforecast.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.graphics.*;

/**
 * {@link ListFragment} responsible for populating list of the supported chart
 * types by the implemented library. It notifies the {@link AndroidPlotActivity}
 * whenever new chart type is selected.
 */
public class PieChartActivity extends Activity {

	private TextView donutSizeTextView;
	private SeekBar donutSizeSeekBar;

	private PieChart pie;

	private Segment s1;
	private Segment s2;
	private Segment s3;
	private Segment s4;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.pie_chart);

		// initialize our XYPlot reference:
		pie = (PieChart) findViewById(R.id.mySimplePieChart);

		// detect segment clicks:
		pie.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				PointF click = new PointF(motionEvent.getX(), motionEvent
						.getY());
				if (pie.getPieWidget().containsPoint(click)) {
					Segment segment = pie.getRenderer(PieRenderer.class)
							.getContainingSegment(click);
					if (segment != null) {
						// handle the segment click...for now, just print
						// the clicked segment's title to the console:
						System.out.println("Clicked Segment: "
								+ segment.getTitle());
					}
				}
				return false;
			}
		});

		donutSizeSeekBar = (SeekBar) findViewById(R.id.donutSizeSeekBar);

		donutSizeSeekBar
				.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					@Override
					public void onProgressChanged(SeekBar seekBar, int i,
							boolean b) {
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						pie.getRenderer(PieRenderer.class).setDonutSize(
								seekBar.getProgress() / 100f,
								PieRenderer.DonutMode.PERCENT);
						pie.redraw();
						updateDonutText();
					}
				});

		donutSizeTextView = (TextView) findViewById(R.id.donutSizeTextView);
		updateDonutText();

		s1 = new Segment("s1", 10);
		s2 = new Segment("s2", 1);
		s3 = new Segment("s3", 10);
		s4 = new Segment("s4", 10);

		EmbossMaskFilter emf = new EmbossMaskFilter(new float[] { 1, 1, 1 },
				0.4f, 10, 8.2f);

		SegmentFormatter sf1 = new SegmentFormatter();
		sf1.configure(getApplicationContext(), R.xml.pie_segment_formatter1);

		sf1.getFillPaint().setMaskFilter(emf);

		SegmentFormatter sf2 = new SegmentFormatter();
		sf2.configure(getApplicationContext(), R.xml.pie_segment_formatter2);

		sf2.getFillPaint().setMaskFilter(emf);

		SegmentFormatter sf3 = new SegmentFormatter();
		sf3.configure(getApplicationContext(), R.xml.pie_segment_formatter3);

		sf3.getFillPaint().setMaskFilter(emf);

		SegmentFormatter sf4 = new SegmentFormatter();
		sf4.configure(getApplicationContext(), R.xml.pie_segment_formatter4);

		sf4.getFillPaint().setMaskFilter(emf);

		pie.addSeries(s1, sf1);
		pie.addSeries(s2, sf2);
		pie.addSeries(s3, sf3);
		pie.addSeries(s4, sf4);

		pie.getBorderPaint().setColor(Color.TRANSPARENT);
		pie.getBackgroundPaint().setColor(Color.TRANSPARENT);
	}

	protected void updateDonutText() {
		donutSizeTextView.setText(donutSizeSeekBar.getProgress() + "%");
	}
}
