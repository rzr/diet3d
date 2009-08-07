/* $Id: MathFixedGenerator.java,v 1.4 2008-10-24 05:44:04 rzr Exp $ */
/**
 * @author www.Philippe.COVAL.free.fr
 * Copyright and License : http://rzr.online.fr/license.htm
 **/
class MathFixedGenerator
{
    
  public static int toFixedPoint( double a,int precision) 
  {
    return  (int) ( ( a  * precision ) 
		    + ( ( a > 0 )  ? (.5) : ( -.5)) );
  }

  public static double toFixedPoint( int a,int precision) 
  {
    return  (double) a / (double) precision;
  }
    
    
  public static void toFixedPoint(double a[], int size,
				  int r[] , int precision)
  {
    int i=0;
    for(i=0;i<size ;i++) 
      r[i]= (int) ( ( a[i]  * precision ) 
		    + ( ( a[i] > 0 )  ? (.5) : ( -.5)) );
        
  }

  public static String toString(double a[], int size)
  {
    String s="{ ";
    int i=0;
    for(i=0;i<size - 1;i++) {
      s+= a[i] +", ";
    }
    s+= a[i] +" }; ";
    return s;
  }

  public static String toString(int a[], int size)
  {
    String s="{ ";
    int i=0;
    for(i=0;i<size - 1;i++) {
      s+= a[i] +", ";
    }
    s+= a[i] +" }; ";
    return s;
  }

  public static double sin(double a, double[] ar , int size)
  {
    a = a%(2. * Math.PI );
    //System.out.println("sin a="+ a ); 
    int i= (int) ( .5 + ( ( a * (double) (size ) /  (2.*Math.PI) ) ) );
    //System.out.println("sin i="+ i ); 
    return ar[i];
  }


  public static void generate(double ar[], int size)
  {
    double pi = Math.PI; //3.14
    double offset = (2. * pi) / (double) (size ); // /4 could save mem
    double a=0;
    for(int i=0;i <size; i++) {
      ar[i] = Math.sin(a);
      //System.out.println( i+ "=" + a +"="+ trigo[ i ]  );
      a+=offset;
    }
  }

  public static void printsin(int precision) 
  {
    //double l= 3.14d / 4.d ;
    // int s=(int) ( l / offset );
    //precision = 100;
    precision = 64
      ;
    double trigo[]=new double[precision];
    double pi = Math.PI; //3.14
    double offset = (2. * pi) 
      / (double) (precision ); // /4 could save mem
    double a=0;
    for(int i=0;i <precision; i++) {
      trigo[i] = Math.sin(a);
      //System.out.println( i+ "=" + a +"="+ trigo[ i ]  );
      a+=offset;
    }
    System.out.println( toString(trigo, precision ) );
    System.out.println(".tests");
    a = 0;
    int ic= 0;
    //a = pi * 2;
    //a = ( pi / 2. ) * 3;
    a = ( pi / 4. );
    a =( pi / 4. ) + 2 * pi; //+ ( (pi / 2.) * 3);
    a =( pi / 4. ) + ( (pi / 2.) * 3);
    System.out.println( a +" / c=" 
			+ Math.sin(a) + " / s="+ Math.sin(a));
    a = a%(2. * pi );
    System.out.println("sin a="+ a ); 
    ic= (int) ( .5 + ( ( a * (double) (precision ) /  (2.*pi) ) ) );
    System.out.println("a/i="+ a + " " + ic ); 
    //% (precision -1) );  
    System.out.println( ic +"=sin=" + trigo[ic] );
        
    a = ( a + (3. * (pi/2.) ) ) % ( 2. * pi );
    System.out.println("sin = sin a="+ a ); 
    ic= (int) ( .5 + ( ( a * (double) (precision ) /  (2.*pi) ) ) ); 
    // %precision;
    System.out.print( ic );
    System.out.println( "=sin=" + trigo[ic] );
    //System.out.println( i +"=" + trigo[i] );
  }

  public static void print(int offset, int sinesize)
  {
    int precision = (int) Math.pow( (double) 2, (double) offset);
    String pre="public static final ";
    String post=";";
    double ar[] = new double[sinesize];
    int arint[] = new int [sinesize];

    double t=Math.PI;

    generate(ar,sinesize);
    toFixedPoint(ar,sinesize ,arint, precision);
    System.out.println( pre + "int offset="+ offset + post );

    System.out.println( pre + "int one="+toFixedPoint( 1.,precision) + post);
    //System.out.println( pre + "boundmax="+0x7FFFFF  + post);
    //System.out.println( pre + "boundmin="+0x800000  + post);

    System.out.println( pre + "int PI="+toFixedPoint( Math.PI,precision) + post);
    System.out.println( pre + "int sqrt2="+ toFixedPoint( Math.sqrt(2.) , precision) + post);
    System.out.println( pre + "int sqrt3="+ toFixedPoint( Math.sqrt(3.) , precision) + post);

    System.out.println( pre + "int exp="+ toFixedPoint( Math.exp(1.) , precision) + post);
    System.out.println( pre + "int log10="+ toFixedPoint( Math.log(10) , precision) + post);
    System.out.println( pre + "int sinesize=" +  sinesize   + post);
    System.out.println( pre + "int sine[]=" + toString( arint, sinesize )  );
  }

  public static void main( String[] arg) 
  {
    System.out.println("//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    print(16,32);
    System.out.println("//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    print(12,32);
    System.out.println("//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    print(8,32);
    System.out.println("//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    print(4,16);
    System.out.println("//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    print(2,8);
    System.out.println("//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    print(16,64);
    System.out.println("//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    print(10,64);

  }
}

/* #eof "$Id: MathFixedGenerator.java,v 1.4 2008-10-24 05:44:04 rzr Exp $" */
