package project;

import java.awt.Color;
import java.awt.Graphics;


public class Enemy2 extends Enemy1 implements Sprite
{
    private Location pos;

    private static final Color color = new Color( 127, 0, 255 );

    private static final int dim = 25;

    private int moveTimer = 0;

    private boolean remove = false;

    private int health = 3;

    private final static int HEALTH = 3;

    private final static int DAMAGE = 2;

    private boolean end = false;

    private int worth = 10;


    public Enemy2()
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
        if ( moveTimer % 15 == 0 )
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


    public boolean remove()
    {
        return remove;
    }


    public int getX()
    {
        return pos.getX();
    }


    public int getY()
    {
        return pos.getY();
    }


    public int getWorth()
    {
        return worth;
    }


    public boolean end()
    {
        return end;
    }


    public int getDMG()
    {
        return DAMAGE;
    }


    public Location getLoc()
    {
        return pos;
    }


    public void setLoc( Location l )
    {

    }
}
