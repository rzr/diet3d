/**
 * @author www.Philippe.COVAL.free.fr
 * Copyright and License : http://rzr.online.fr/license.htm
 **/

/*
 http://jmge.net/java/gifenc/Gif89Encoder090b.zip

javac -classpath ../extra/gif/lib/classes.jar:../jclasses-awt  Diet3DCommandLine.java  && java -classpath ../extra/gif/lib/classes.jar:../jclasses-awt:.  Diet3DCommandLine

*/
import net.jmge.gif.*;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Vector;



public final class Diet3DCommandLine
{

    static int h_ = 200;
    static int w_ = h_;
    static Image  gi = null;
    static Gif89Encoder ge = null;
    static Graphics g = null; 
    final long mspf = 40;// 1 / fps


    static Diet3DApplet o = new Diet3DApplet();
    static Frame f = new Frame();

    static Diet3D m_ = o.mRender;

    public static void loop(int n) throws Exception
    {
        for(int i=0;i<n;i++) {
            m_.paint(g);
            m_.update();
            ge.addFrame( gi );
        }
    }

    public static void demo() throws Exception
    {
        /*
            m_.toggleMode(1);
            loop(8);
            m_.toggleMode(2);
            loop(8);
            m_.toggleMode(4);
            loop(16);
            m_.toggleMode(5);
            loop(16);
            m_.toggleMode(7);
            loop(16);
        */
        /*
        for(int i=0;i<12;i++) {
            loop(8);
            m_.tick();
            } */
    }

    public static void gif(String[] arg)
    {
        //BufferedReader in = new BufferedReader(new FileReader(args[0]));   
        
        String filename = "gif89out.gif";
        if ( arg.length > 0 ) filename = arg[0];
        //System.out.println( arg[0] );

        try {
            Toolkit      tk = Toolkit.getDefaultToolkit();
            OutputStream out = new BufferedOutputStream
                ( new FileOutputStream(filename) );
            
            gi = new BufferedImage( m_.w_  , m_.h_ ,
                                          BufferedImage.TYPE_4BYTE_ABGR  );
            g = gi.getGraphics();
            ge = new Gif89Encoder();   

            demo();
            //m_.toggleMode(10);
            //loop( 2 );


            ge.setComments("http://rzr.online.fr/java.htm");
            ge.setLoopCount(0);  // let's loop indefinitely 
            ge.encode(out);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void show(String[] arg)
    {
        f.resize( o.w_ , o.h_ );
        f.add(o);

        //o.start();
        o.validate();
        for(int i=0; i<64; i++) {
            o.repaint();
            //m_.update();
            //System.sleep(500);
        }
        f.show();
        //o.stop();
    }

    public static void init(String[] arg)
    {
        o.init();
        m_.toggleAnim(2);
        m_.toggleShape(0);
        m_.toggleMode(12);
    }

    public static void main(String[] arg)
    {
        //init(arg);
        //show(arg);
        gif(arg);
    }
}
