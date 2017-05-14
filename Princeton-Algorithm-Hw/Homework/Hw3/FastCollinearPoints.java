//import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdDraw;
//import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
public class FastCollinearPoints {
   private int n;
//   private LineSegment[] AllLs;
   private Point[] AllPoints;
//   //private double[] Allslope;
//   public FastCollinearPoints()
//   {}
   public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
   {
      n=points.length;
      for(int i=0;i<n;i++)
           {
               if(points[i]==null)
               {
                   throw new java.lang.NullPointerException();
               }
               for(int j=0;j<n;j++)
               {
                   if(i!=j)
                   {
                       if(points[i].compareTo(points[j])==0)
                       {
                           throw new java.lang.IllegalArgumentException();
                       }
                   }
                  
               }
           }
       
       //Arrays.sort(points);
       AllPoints=points;
       //Arrays.sort(AllPoints);
   }
//   private double[] CountSlope(int i)
//   {
//       double[] Aslo=new double[n-1];
//       for(int k=0,j=0;(k<n)&&(j<n-1);k++)
//       {
//           if(k!=i)
//           {
//               Aslo[j]=AllPoints[i].slopeTo(AllPoints[k]);
//               j++;
//           }
//       }
//       return Aslo;
//   }
   public int numberOfSegments()        // the number of line segments
   {
       LineSegment[] ls1=segments();
       int n=ls1.length;
       return n;
   }
   public LineSegment[] segments()                // the line segments
   {
       LineSegment[] ls,ls1;
       ls=new LineSegment[n*n];
       //ls=new LineSegment[n];
       int p=0;
       Point[] tempoints=new Point[n-1];
       for(int i=0;i<n;i++)
       {
           for(int j=0,k=0;j<n;j++)
           {
               if(j!=i)
               {
                   tempoints[k++]=AllPoints[j];
                   //k++;
               }
           }
           Arrays.sort(tempoints,AllPoints[i].slopeOrder());
           //Arrays.sort(tempPoints, clone[i].slopeOrder());
           for(int j=0;j<n-1;j++)
           {
               int head=j,tail=j;
               while((j<n-2)&&(AllPoints[i].slopeTo(tempoints[head])==AllPoints[i].slopeTo(tempoints[j+1])))
               {
                   j++;
                   tail++;
               }
               if(tail-head>=2)
               {
                   //Point[] temp2=new Point[tail-head+]
                   int min=head,max=head;
                   for(int l=head;l<=tail;l++)
                   {
                       if(tempoints[min].compareTo(tempoints[l])==1)
                       {
                           min=l;
                       }
                       if(tempoints[max].compareTo(tempoints[l])==-1)
                       {
                           max=l;
                       }
                       
                   }
                   if(AllPoints[i].compareTo(tempoints[min])==-1)
                   {
                       ls[p++]=new LineSegment(AllPoints[i],tempoints[max]);
                       //System.out.println("min"+min+"max"+max);
                       System.out.println(ls[p-1].toString());
                       
                   }
               }
           }
       }
       ls1=new LineSegment[p];
       for(int m=0;m<p;m++)
     {
          ls1[m]=ls[m];
         }
      //return ls;
      return ls1;
   }
//   public static void main(String arg[])
//   {
//       double[] a=new double[12];
//       FastCollinearPoints fp=new FastCollinearPoints(); 
//       for(int i=0;i<12;i++)
//       {
//           a[i]=12.5-i;
//       }
//       for(int i=0;i<12;i++)
//       {
//           System.out.print(a[i]+" ");
//       }
//       System.out.print("\r\n");
//       fp.sort(a);
//       for(int i=0;i<12;i++)
//       {
//           System.out.print(a[i]+" ");
//       }
//        System.out.print("\r\n");
//   }
      public static void main(String arg[])
   {
         Point[] points=new Point[15];
       points[0]=new Point(10000,0);
       points[1]=new Point(8000,2000);
       points[2]=new Point(2000,8000);
       points[3]=new Point(0,10000);
       points[4]=new Point(20000,0);
       points[5]=new Point(18000,2000);
       points[6]=new Point(2000,18000);
       points[7]=new Point(10000,20000);
       points[8]=new Point(30000,0);
       points[9]=new Point(0,30000);
       points[10]=new Point(20000,10000);
       points[11]=new Point(13000,0);
       points[12]=new Point(11000,3000);
       points[13]=new Point(5000,12000);
       points[14]=new Point(9000,6000);
//         points[0]=new Point(10000,0);
//         points[1]=new Point(0,10000);
//         points[2]=new Point(3000,7000);
//         points[3]=new Point(7000,3000);
//         points[4]=new Point(20000,21000);
//         points[5]=new Point(3000,4000);
//         points[6]=new Point(14000,15000);
//         points[7]=new Point(6000,7000);
//       points[0]=new Point(10000,0);
//       points[1]=new Point(10000,1);
//       points[2]=new Point(10001,0);
//       points[3]=new Point(10001,1);
//       points[4]=new Point(10002,0);
//       points[5]=new Point(10002,1);
//       points[6]=new Point(10003,0);
//       points[7]=new Point(10003,1);
//       
       
       if(points[0].compareTo(points[1])==0)
       {
           System.out.println("Ilegal");
       }
       double a=Double.NEGATIVE_INFINITY;
       double b=Double.NEGATIVE_INFINITY;
       if(a==b)
       {
           System.out.println("Infinity Equal");
       }
       FastCollinearPoints bp=new FastCollinearPoints(points);
       System.out.println(bp.numberOfSegments());
       
   }
}