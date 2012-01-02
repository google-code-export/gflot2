package ca.nanometrics.gflot.client.options;

import com.google.gwt.json.client.JSONObject;

/**
 * @author Nicolas Morel
 */
public class ImageSeriesOptions
    extends AbstractSeriesOptions<ImageSeriesOptions>
{
    public enum ImageAnchor
    {
        CENTER( "center" ), CORNER( "corner" );

        private final String flotValue;

        private ImageAnchor( String flotValue )
        {
            this.flotValue = flotValue;
        }

        public String getFlotValue()
        {
            return flotValue;
        }

        static ImageAnchor findByFlotValue( String flotValue )
        {
            if ( null != flotValue && !"".equals( flotValue ) )
            {
                for ( ImageAnchor mode : values() )
                {
                    if ( mode.getFlotValue().equals( flotValue ) )
                    {
                        return mode;
                    }
                }
            }
            return null;
        }
    }

    private static final String ANCHOR_KEY = "anchor";

    private static final String ALPHA_KEY = "alpha";

    public ImageSeriesOptions()
    {
        super();
    }

    ImageSeriesOptions( JSONObject jsonObj )
    {
        super( jsonObj );
    }

    /**
     * Setting "anchor" to "center" causes the pixels in the image to be anchored at the corner pixel centers inside of
     * at the pixel corners, effectively letting half a pixel stick out to each side in the plot.
     */
    public ImageSeriesOptions setAnchor( ImageAnchor anchor )
    {
        assert null != anchor : "anchor can't be null";

        put( ANCHOR_KEY, anchor.getFlotValue() );
        return this;
    }

    /**
     * @return the anchor
     */
    public ImageAnchor getAnchor()
    {
        return ImageAnchor.findByFlotValue( getString( ANCHOR_KEY ) );
    }

    /**
     * Set the image alpha
     */
    public ImageSeriesOptions setAlpha( double alpha )
    {
        assert alpha >= 0 && alpha <= 1 : "alpha range from 0.0 to 1.0";

        put( ALPHA_KEY, alpha );
        return this;
    }

    /**
     * @return the image alpha
     */
    public Double getAlpha()
    {
        return getDouble( ALPHA_KEY );
    }

}
