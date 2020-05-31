package project;

import java.awt.Color;
import java.awt.Graphics;


public class Enemy1 implements Sprite
{
    private Location pos;

    private static final Color color = Color.RED;

    private static final int dim = 25;

    private int moveTimer = 0;

    private boolean remove = false;

    private int health = 1;

    private final static int HEALTH = 1;

    private final static int DAMAGE = 1;

    private boolean end = false;

    private int worth = 5;


    public Enemy1()
    {
        pos = new Location( true, 0, 2 );
    }


    public void draw( Graphics g )
    {
        g.setColor( color );
        g.fillOval( pos.getX() + 7, pos.getY() + 7, dim, dim );
        g.setColor( Color.DARK_GRAY );
        g.drawRect( getX(), getY() + 34, 38, 6 );
        g.setColor( Color.LIGHT_GRAY );
        g.fillRect( getX() + 1, getY() + 35, 37, 5 );
        g.setColor( Color.RED );
        g.fillRect( getX() + 1,
            getY() + 35,
            (int)( ( ( (double)health % ( HEALTH + 1 ) ) / (double)( HEALTH ) )
                * 37 ),
            5 );
    }


    public void update()
    {
        moveTimer++;
        Location newPos = pos;
        if ( moveTimer % 20 == 0 )
        {
            newPos = Main.gh.nextMove( pos );
        }
        if ( newPos == null )
        {
            end = true;
        }
        else
        {
            pos = newPos;
        }

    }


    public void takeDmg( int amt )
    {
        health -= amt;
        if ( health <= 0 )
        {
            remove = true;
        }
    }


    public int getWorth()
    {
        return worth;
    }


    public boolean remove()
    {
        return remove;
    }


    public boolean end()
    {
        return end;
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


    public int getDMG()
    {
        return DAMAGE;
    }


    public void setLoc( Location l )
    {

    }
}
