package ca.nanometrics.gflot.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class GFlotSample implements EntryPoint
{

    private final TabPanel m_tabs = new TabPanel();

    private void addExamples() {
        addExample(new SimplePlotExample());
        addExample(new BarChartExample());
        addExample(new PlotWithInteractiveLegendExample());
        addExample(new PlotWithOverviewExample());
        addExample(new HoverExample());
        addExample(new SlidingWindowExample());
        addExample(new DecimationExample());
        addExample(new MarkingsExample());
    }

    private void addExample(GFlotExample example) {
        m_tabs.add(example.createExample(), example.getName());
    }

    public void onModuleLoad() {

        addExamples();

        m_tabs.setWidth("100%");
        m_tabs.setHeight("100%");

        RootPanel.get().add(m_tabs);

        m_tabs.selectTab(0);
    }

}
