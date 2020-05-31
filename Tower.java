package project;

import java.awt.Color;
import java.awt.Graphics;


public class Tower implements Sprite
{

    private Location pos;

    private static final Color color = Color.CYAN;

    private static final int dim = 25;

    private int range = 280;

    private static final int COST = 100;

    private int time = 0;

    private boolean shooting = false;

    private final int cd = 100;

    private int power = 1;


    public Tower( Location l )
    {
        pos = l;

    }


    public Tower()
    {

    }


    public void draw( Graphics g )
    {
        g.setColor( color );
        g.fillOval( pos.getX() + 7, pos.getY() + 7, dim, dim );
        g.drawOval( pos.getX() + 20 - range / 2,
            pos.getY() - range / 2 + 20,
            range,
            range );

        g.setColor( Color.DARK_GRAY );
        g.drawRect( getX(), getY() + 34, 38, 6 );
        g.setColor( Color.LIGHT_GRAY );
        g.fillRect( getX() + 1, getY() + 35, 37, 5 );
        g.setColor( Color.GREEN );
        g.fillRect( getX() + 1,
            getY() + 35,
            (int)( ( ( (double)time % ( cd + 1 ) ) / ( cd + 1 ) ) * 38 ),
            5 );

    }


    public void update()
    {
        if ( time == cd )
        {
            shooting = true;
        }
        else
        {
            time++;
        }
    }


    public void shot()
    {
        shooting = false;
        time = 0;
    }


    public int getCost()
    {
        return COST;
    }


    public int getRange()
    {
        return range;
    }


    public boolean shooting()
    {
        return shooting;
    }


    public int getX()
    {

        return pos.getX();
    }


    public int getY()
    {

        return pos.getY();
    }


    public Location getLoc()
    {
        return pos;
    }


    public int getPower()
    {
        return power;
    }


    public void setLoc( Location l )
    {
        pos = l;
    }
}
