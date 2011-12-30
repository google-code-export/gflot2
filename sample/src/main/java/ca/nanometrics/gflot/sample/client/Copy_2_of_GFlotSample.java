package ca.nanometrics.gflot.sample.client;

import ca.nanometrics.gflot.client.DataPoint;
import ca.nanometrics.gflot.client.PlotModel;
import ca.nanometrics.gflot.client.SeriesHandler;
import ca.nanometrics.gflot.client.SimplePlot;
import ca.nanometrics.gflot.client.options.PlotOptions;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Copy_2_of_GFlotSample implements EntryPoint {

	private SimplePanel plotContainer;

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
	}

	protected void generatePlot() {
		plotContainer.clear();

		PlotModel model = new PlotModel();
		PlotOptions plotOptions = new PlotOptions();

		// create a series
		SeriesHandler handler1 = model.addSeries("Serie 1");
		SeriesHandler handler2 = model.addSeries("Serie 2");

		for (int i = 1; i < 100; i++) {
			handler1.add(new DataPoint(i, Random.nextDouble()*100));
			handler2.add(new DataPoint(i, Random.nextDouble()*100));
		}

		// add data
//		handler1.add(new DataPoint(1, -10.5));
//		handler1.add(new DataPoint(2, -8.6));
//		handler1.add(new DataPoint(3, -2.4));
//		handler1.add(new DataPoint(4, 6));
//		handler1.add(new DataPoint(5, 13.6));
//		handler1.add(new DataPoint(6, 18.4));
//		handler1.add(new DataPoint(7, 21));
//		handler1.add(new DataPoint(8, 19.7));
//		handler1.add(new DataPoint(9, 14.7));
//		handler1.add(new DataPoint(10, 8.2));
//		handler1.add(new DataPoint(11, 1.5));
//		handler1.add(new DataPoint(12, -6.6));

		// create the plot
		SimplePlot plot = new SimplePlot(model, plotOptions);

		plotContainer.add(plot);
	}

}