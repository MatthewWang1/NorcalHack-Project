package project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Laser implements Sprite
{
    private Location l1;

    private Location l2;

    private int time = 0;

    private boolean remove = false;


    public Laser( Location l1, Location l2 )
    {
        this.l1 = l1;
        this.l2 = l2;
    }


    public void draw( Graphics g )
    {
        Graphics2D g2 = (Graphics2D)g;

        int shift = 20;
        int x1 = l1.getX() + shift;
        int y1 = l1.getY() + shift;
        int x2 = l2.getX() + shift;
        int y2 = l2.getY() + shift;

        g2.setColor( new Color( 255, 171, 255 ) );
        g2.setStroke( new BasicStroke( 5 ) );
        g2.drawLine( x1, y1, x2, y2 );

        g2.setColor( new Color( 255, 112, 255 ) );
        g2.setStroke( new BasicStroke( 3 ) );
        g2.drawLine( x1, y1, x2, y2 );

        g2.setStroke( new BasicStroke( 1 ) );
    }


    public void update()
    {
        time++;
        if ( time > 10 )
        {
            remove = true;
        }

    }


    public boolean remove()
    {
        return remove;
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
