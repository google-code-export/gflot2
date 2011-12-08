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

/**
 * @author AlexanderDeleon
 */
public class BarSeriesOptions
    extends AbstractSeriesOptions<BarSeriesOptions>
{
    public enum BarAlignment
    {
        CENTER( "center" ), LEFT( "left" );

        private final String m_stringRepresentation;

        private BarAlignment( String stringRepresentation )
        {
            m_stringRepresentation = stringRepresentation;
        }

        public String getStringRepresentation()
        {
            return m_stringRepresentation;
        }
    }

    /**
     * Set the width of the bars in units of the x axis (or the y axis if "horizontal" is true), contrary to most other
     * measures that are specified in pixels. For instance, for time series the unit is milliseconds so 24 * 60 * 60 *
     * 1000 produces bars with the width of a day.
     */
    public BarSeriesOptions setBarWidth( double width )
    {
        put( "barWidth", new Double( width ) );
        return this;
    }

    /**
     * Set whether a bar should be left-aligned (default) or centered on top of the value it represents.
     */
    public BarSeriesOptions setAlignment( BarAlignment alignment )
    {
        assert null != alignment : "alignment can't be null";

        put( "align", alignment.getStringRepresentation() );
        return this;
    }

    /**
     * Set if the bars are drawn horizontally, i.e. from the y axis instead of the x axis; note that
     * the bar end points are still defined in the same way so you'll probably want to swap the coordinates if you've
     * been plotting vertical bars first.
     */
    public BarSeriesOptions setHorizontal( boolean horizontal )
    {
        put( "horizontal", horizontal );
        return this;
    }
}
