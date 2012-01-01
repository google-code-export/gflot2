/*
 * Copyright (c) 2008 Nanometrics Inc.
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 *	of this software and associated documentation files (the "Software"), to deal
 *	in the Software without restriction, including without limitation the rights
 *	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *	copies of the Software, and to permit persons to whom the Software is
 *	furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in
 *	all copies or substantial portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *	THE SOFTWARE.
 */
package ca.nanometrics.gflot.client.options;

import ca.nanometrics.gflot.client.util.JSONHelper;
import ca.nanometrics.gflot.client.util.JSONObjectWrapper;

import com.google.gwt.json.client.JSONObject;

/**
 * @author AlexanderDeleon
 */
public class PlotOptions
    extends JSONObjectWrapper
{
    private static final String COLORS_KEY = "colors";

    private static final String LEGEND_KEY = "legend";

    private static final String X_AXIS_KEY = "xaxis";

    private static final String Y_AXIS_KEY = "yaxis";

    private static final String SERIES_KEY = "series";

    private static final String GRID_KEY = "grid";

    private static final String SELECTION_KEY = "selection";

    private LegendOptions legendOptions;

    private AbstractAxisOptions<?> xAxisOptions;

    private AbstractAxisOptions<?> yAxisOptions;

    private SelectionOptions selectionOptions;

    private GridOptions gridOptions;

    private GlobalSeriesOptions globalSeriesOptions;

    public PlotOptions()
    {
        super();
    }

    public PlotOptions( JSONObject jsonObj )
    {
        super( jsonObj );
        globalSeriesOptions = new GlobalSeriesOptions( getObject( SERIES_KEY ) );
        selectionOptions = new SelectionOptions( getObject( SELECTION_KEY ) );
        gridOptions = new GridOptions( getObject( GRID_KEY ) );
        legendOptions = new LegendOptions( getObject( LEGEND_KEY ) );
        xAxisOptions = AbstractAxisOptions.createAxisOptions( getObject( X_AXIS_KEY ) );
        yAxisOptions = AbstractAxisOptions.createAxisOptions( getObject( Y_AXIS_KEY ) );
    }

    /**
     * Set a default color theme to get colors for the data series from. You can specify as many colors as you like,
     * like this:
     * <p>
     * colors: ["#d18b2c", "#dba255", "#919733"]
     * </p>
     * If there are more data series than colors, Flot will try to generate extra colors by lightening and darkening
     * colors in the theme.
     */
    public PlotOptions setDefaultColorTheme( String[] colors )
    {
        assert null != colors && colors.length > 0 : "colors can't be null or empty";

        put( COLORS_KEY, JSONHelper.wrapArray( colors ) );
        return this;
    }

    /**
     * @return the default color theme to get colors for the data series from
     */
    public String[] getDefaultColorTheme()
    {
        return getStringArray( COLORS_KEY );
    }

    /**
     * Set the legend options
     */
    public PlotOptions setLegendOptions( LegendOptions legendOptions )
    {
        this.legendOptions = legendOptions;
        put( LEGEND_KEY, legendOptions );
        return this;
    }

    public LegendOptions getLegendOptions()
    {
        return legendOptions;
    }

    public PlotOptions setXAxisOptions( AbstractAxisOptions<?> xAxisOptions )
    {
        this.xAxisOptions = xAxisOptions;
        put( X_AXIS_KEY, xAxisOptions );
        return this;
    }

    public AbstractAxisOptions<?> getXAxisOptions()
    {
        return xAxisOptions;
    }

    public PlotOptions setYAxisOptions( AbstractAxisOptions<?> yAxisOptions )
    {
        this.yAxisOptions = yAxisOptions;
        put( Y_AXIS_KEY, yAxisOptions );
        return this;
    }

    public AbstractAxisOptions<?> getyAxisOptions()
    {
        return yAxisOptions;
    }

    public PlotOptions setSelectionOptions( SelectionOptions selectionOptions )
    {
        this.selectionOptions = selectionOptions;
        put( SELECTION_KEY, selectionOptions );
        return this;
    }

    public SelectionOptions getSelectionOptions()
    {
        return selectionOptions;
    }

    public PlotOptions setGridOptions( GridOptions gridOptions )
    {
        this.gridOptions = gridOptions;
        put( GRID_KEY, gridOptions );
        return this;
    }

    public GridOptions getGridOptions()
    {
        return gridOptions;
    }

    public PlotOptions setGlobalSeriesOptions( GlobalSeriesOptions globalSeriesOptions )
    {
        this.globalSeriesOptions = globalSeriesOptions;
        put( SERIES_KEY, globalSeriesOptions );
        return this;
    }

    public GlobalSeriesOptions getGlobalSeriesOptions()
    {
        return globalSeriesOptions;
    }
}
