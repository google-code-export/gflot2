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
public class PointsSeriesOptions
    extends AbstractSeriesOptions
{

    /**
     * Set the radius of the symbol
     */
    public PointsSeriesOptions setRadius( double radius )
    {
        put( "radius", new Double( radius ) );
        return this;
    }

    PointsSeriesOptions setSymbol()
    {
        // TODO
        // For points, you can specify the radius and the symbol. The only
        // built-in symbol type is circles, for other types you can use a plugin
        // or define them yourself by specifying a callback:
        //
        // function cross(ctx, x, y, radius, shadow) {
        // var size = radius * Math.sqrt(Math.PI) / 2;
        // ctx.moveTo(x - size, y - size);
        // ctx.lineTo(x + size, y + size);
        // ctx.moveTo(x - size, y + size);
        // ctx.lineTo(x + size, y - size);
        // }
        //
        // The parameters are the drawing context, x and y coordinates of the
        // center of the point, a radius which corresponds to what the circle
        // would have used and whether the call is to draw a shadow (due to
        // limited canvas support, shadows are currently faked through extra
        // draws). It's good practice to ensure that the area covered by the
        // symbol is the same as for the circle with the given radius, this
        // ensures that all symbols have approximately the same visual weight.

        put( "symbol", "circle" );
        return this;
    }

}
