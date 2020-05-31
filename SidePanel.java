package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class SidePanel implements Sprite
{

    private int width;

    private int height;

    private GameHandler gh;


    public SidePanel( int w, int h, GameHandler g )
    {
        width = w;
        height = h;
        gh = g;
    }


    public void draw( Graphics g )
    {
        // Panel, Health, and Money
        int h = 70;
        int inc = h;
        for ( int i = 0; i * h < height; i++ )
        {
            g.setColor( new Color( 150, 150, 150 ) );
            g.fillRect( width, i * 2 * h, 200, h );
            g.setColor( new Color( 120, 120, 120 ) );
            g.fillRect( width, i * 2 * h + h, 200, h );
        }
        Font font = new Font( "SansSerif", Font.PLAIN, 25 );

        g.setFont( font );
        g.setColor( Color.BLACK );
        g.drawString( "Health: " + gh.getHealth(), width + 30, 50 );
        g.drawString( "Money: $" + gh.getMoney(), width + 30, 110 );

        // Basic Tower
        h += inc;
        h += 30;
        font = new Font( "SansSerif", Font.PLAIN, 20 );
        g.setFont( font );
        g.setColor( Color.BLACK );
        g.drawString( "Basic Tower", width + 5, h );
        g.drawString( "$100", width + 5, h + 30 );
        g.setColor( Color.CYAN );
        g.fillOval( width + 140, h - 5, 30, 30 );
        if ( gh.getMoney() < 100 )
        {
            g.setColor( new Color( 220, 20, 60, 120 ) );
            g.fillRect( width, h - 30, 200, 70 );
        }
        // Long Ranged Tower
        h += inc;
        font = new Font( "SansSerif", Font.PLAIN, 20 );
        g.setFont( font );
        g.setColor( Color.BLACK );
        g.drawString( "Ranged Tower", width + 5, h );
        g.drawString( "$200", width + 5, h + 30 );
        g.setColor( Color.ORANGE );
        g.fillOval( width + 140, h - 5, 30, 30 );
        if ( gh.getMoney() < 200 )
        {
            g.setColor( new Color( 220, 20, 60, 120 ) );
            g.fillRect( width, h - 30, 200, 70 );
        }
        // Speed Tower
        h += inc;
        font = new Font( "SansSerif", Font.PLAIN, 20 );
        g.setFont( font );
        g.setColor( Color.BLACK );
        g.drawString( "Fast Tower", width + 5, h );
        g.drawString( "$300", width + 5, h + 30 );
        g.setColor( Color.WHITE );
        g.fillOval( width + 140, h - 5, 30, 30 );
        if ( gh.getMoney() < 300 )
        {
            g.setColor( new Color( 220, 20, 60, 120 ) );
            g.fillRect( width, h - 30, 200, 70 );
        }
    }


    public void update()
    {

    }


    public int getX()
    {

        return 0;
    }


    public int getY()
    {

        return 0;
    }


    public Location getLoc()
    {

        return null;
    }


    public void setLoc( Location l )
    {

    }

}
