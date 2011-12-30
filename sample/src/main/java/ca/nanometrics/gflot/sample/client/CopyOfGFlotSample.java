package ca.nanometrics.gflot.sample.client;

import ca.nanometrics.gflot.client.DataPoint;
import ca.nanometrics.gflot.client.PlotItem;
import ca.nanometrics.gflot.client.PlotModel;
import ca.nanometrics.gflot.client.PlotPosition;
import ca.nanometrics.gflot.client.Series;
import ca.nanometrics.gflot.client.SeriesHandler;
import ca.nanometrics.gflot.client.SimplePlot;
import ca.nanometrics.gflot.client.event.PlotHoverListener;
import ca.nanometrics.gflot.client.jsni.Plot;
import ca.nanometrics.gflot.client.options.LegendOptions;
import ca.nanometrics.gflot.client.options.LegendOptions.LabelFormatter;
import ca.nanometrics.gflot.client.options.GridOptions;
import ca.nanometrics.gflot.client.options.LineSeriesOptions;
import ca.nanometrics.gflot.client.options.PlotOptions;
import ca.nanometrics.gflot.client.options.PointsSeriesOptions;
import ca.nanometrics.gflot.client.options.LegendOptions.LegendPosition;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CopyOfGFlotSample implements EntryPoint {

	private SimplePanel plotContainer;

	private SimplePlot plot;

	private SeriesHandler handler1;
	private SeriesHandler handler2;

	private PlotOptions plotOptions;
	private static final String INSTRUCTIONS = "Point your mouse to a data point on the chart";
	private final Label selectedPointLabel = new Label(INSTRUCTIONS);
	private final Label positionLabel = new Label();

	private boolean fill = true;

	public void onModuleLoad() {

		plotContainer = new SimplePanel();

		VerticalPanel panel = new VerticalPanel();
		panel.add(plotContainer);

		Button button = new Button("generate");
		panel.add(button);

		RootPanel.get().add(panel);

		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				generatePlot();
			}
		});

		PlotModel model = new PlotModel();
		plotOptions = new PlotOptions();
		plotOptions.setDefaultLineSeriesOptions(new LineSeriesOptions().setLineWidth(1).setShow(true));
		plotOptions.setDefaultPointsOptions(new PointsSeriesOptions().setRadius(2).setShow(true));
		plotOptions.setGridOptions(new GridOptions().setHoverable(true));
		plotOptions.setLegendOptions(new LegendOptions().setLabelFormatter(new LabelFormatter() {

			@Override
			public String formatLabel(String label, Series series) {

				return "toto" + label;
			}
		}));
		// plotOptions.setDefaultLineSeriesOptions(new
		// LineSeriesOptions().setFill(fill));

		// create a series
		handler1 = model.addSeries("Serie 1");
		handler2 = model.addSeries("Serie 2");

		plot = new SimplePlot(model, plotOptions);
		plotContainer.add(plot);

		final PopupPanel popup = new PopupPanel();
		final Label label = new Label();
		popup.add(label);

		plot.addHoverListener(new PlotHoverListener() {
			public void onPlotHover(Plot plot, PlotPosition position, PlotItem item) {
				if (position != null) {
					positionLabel.setText("position: (" + position.getX() + "," + position.getY() + ")");
				}
				if (item != null) {
					String text = "x: " + item.getDataPoint().getX() + ", y: " + item.getDataPoint().getY();

					selectedPointLabel.setText(text);

					label.setText(text);
					popup.setPopupPosition(item.getPageX() + 10, item.getPageY() - 25);
					popup.show();
				} else {
					selectedPointLabel.setText(INSTRUCTIONS);
					popup.hide();
				}
			}
		}, false);
	}

	protected void generatePlot() {
		plotContainer.setVisible(false);

		// if (null == plot) {
		//
		// }

		handler1.clear();
		handler2.clear();

		for (int i = 1; i < 100; i++) {
			handler1.add(new DataPoint(i, Random.nextDouble() * 100));
			handler2.add(new DataPoint(i, Random.nextDouble() * 100));
		}

		fill = !fill;
		PlotOptions opt = plot.getOptions();
		if (fill) {
			opt.setLegendOptions(new LegendOptions().setShow(true).setNumOfColumns(1).setLabelBoxBorderColor("#ccc")
					.setPosition(LegendPosition.NORTH_EAST).setMargin(5).setBackgroundOpacity(0.85).setLabelFormatter(new LabelFormatter() {

						@Override
						public String formatLabel(String label, Series series) {
							return "hihi" + label;
						}
					}));
		} else {
			opt.setLegendOptions(new LegendOptions().setShow(true).setNumOfColumns(1).setLabelBoxBorderColor("#ccc")
					.setPosition(LegendPosition.NORTH_EAST).setMargin(5).setBackgroundOpacity(0.85).setLabelFormatter(new LabelFormatter() {

						@Override
						public String formatLabel(String label, Series series) {
							return "haha" + label;
						}
					}));
		}

		plotContainer.setVisible(true);
		plot.redraw();

		// create the plot
		// Scheduler.get().scheduleDeferred(new ScheduledCommand() {
		//
		// @Override
		// public void execute() {
		//
		// }
		// });
	}

}