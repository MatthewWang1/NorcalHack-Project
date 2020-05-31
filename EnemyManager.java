package project;

import java.awt.Graphics;
import java.util.ArrayList;


public class EnemyManager
{
    private ArrayList<Sprite> enemies;

    private int time = 0;

    private int totalTime = 0;


    public EnemyManager()
    {
        enemies = new ArrayList<Sprite>();
    }


    public void draw( Graphics g )
    {
        for ( Sprite s : enemies )
        {
            s.draw( g );
        }
    }


    public Sprite isHit( Location l, int range, Sprite tower )
    {
        Sprite ret = null;

        for ( Sprite s : enemies )
        {
            if ( dist( s.getLoc(), l ) < range / 2 )
            {
                ( (Enemy1)s ).takeDmg( ( (Tower)tower ).getPower() );
                ret = s;
                break;
            }
        }

        if ( ret != null )
        {
            if ( ( (Enemy1)ret ).remove() )
            {
                int money = ( (Enemy1)ret ).getWorth();
                enemies.remove( ret );
                Main.gh.addMoney( money );
            }
        }
        return ret;
    }


    public int dist( Location l1, Location l2 )
    {
        return (int)Math
            .sqrt( ( l2.getX() - l1.getX() ) * ( l2.getX() - l1.getX() )
                + ( l2.getY() - l1.getY() ) * ( l2.getY() - l1.getY() ) );
    }


    public void update()
    {
        int temp = (int)( 300 * ( (double)( 10000 - totalTime ) / 10000.0 ) );
        if ( time >= temp )
        {
            int chance = (int)( Math.random() * 100 );
            if ( chance < 20 )
            {
                enemies.add( new Enemy2() );
            }
            else if ( chance < 100 )
            {
                enemies.add( new Enemy1() );
            }
            time = 0;
            if ( Math.random() < 0.5 )
            {
                time += temp / 2;
            }

            if ( Math.random() < 0.5 )
            {
                time += temp / 2;
            }
        }

        time++;
        totalTime++;

        ArrayList<Sprite> removing = new ArrayList<Sprite>();
        ArrayList<Sprite> ending = new ArrayList<Sprite>();

        for ( Sprite s : enemies )
        {
            s.update();
            if ( ( (Enemy1)s ).remove() )
            {
                removing.add( s );
            }
            else if ( ( (Enemy1)s ).end() )
            {
                ending.add( s );
            }
        }
        for ( Sprite s : ending )
        {
            enemies.remove( s );
            Main.gh.loseLife( ( (Enemy1)s ).getDMG() );
        }
        for ( Sprite s : removing )
        {
            enemies.remove( s );
        }
    }

}
