public class BruteCollinearPoints {
    private Point[] AllPoints;
    private int n;    // number of points
    private LineSegment[] AllLs;
   public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   {
       n=points.length;
       //m=0;
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
       
       AllPoints=points;
       //n=points.length;
       //AllLs=segments();
   }
   public int numberOfSegments()        // the number of line segments
   {
       AllLs=segments();
       return AllLs.length;
   }
   public LineSegment[] segments()                // the line segments
   {
      LineSegment[] ls1,ls;
      ls1=new LineSegment[n*(n-1)];
      //int min=0,max=0;
      int k=0;
//      for(int i=0;i<n;i++)
//      {
//          int c=1;
//          max=i;
//          min=i;
//          for(int j=i+1;j<n;j++)
//          {
//             
//              double slo=AllPoints[i].slopeTo(AllPoints[j]);
//               c=2;
//              if(AllPoints[min].compareTo(AllPoints[j])>0)
//              {
//                  min=j;
//                  //max=i;
//              }
//              if(AllPoints[j].compareTo(AllPoints[max])>0)
//              {
//                  max=j;
//              }
//              for(int p=j+1;p<n;p++)
//              { 
//                  double slo1=AllPoints[i].slopeTo(AllPoints[p]);
//                  if(slo==slo1)
//                  {
//                      c=3;
//                      // System.out.println("j "+j+" p: "+p);
//                       if(AllPoints[min].compareTo(AllPoints[p])>0)
//                       {
//                           min=p;
//                       }
//                      if(AllPoints[p].compareTo(AllPoints[max])>0)
//                       {
//                           max=p;
//                       }
//                      for(int q=p+1;q<n;q++)
//                      {
//                          double slo2=AllPoints[i].slopeTo(AllPoints[q]);
//                          if(slo2==slo1)
//                          {
//                             
//                              c=4;
//                             //  System.out.println("j "+j+" p: "+p+" q: "+q+" c:"+c);
//                              if(c==4)
//                              {
//                                  if(AllPoints[min].compareTo(AllPoints[q])>0)
//                                  {
//                                      min=q;
//                                  }
//                                  if(AllPoints[q].compareTo(AllPoints[max])>0)
//                                  {
//                                      max=q;
//                                  }
//                                  ls1[k]=new LineSegment(AllPoints[min],AllPoints[max]);
//                                  //System.out.println(i+"+"+j+"+"+p+"+"+q);
//                                  //System.out.println(ls1[k].toString());
//                                  k++;
//                              }
//                          }
//                      }
//                  }
//              }
//          }
//      }
      for(int i=0;i<n;i++)
      {
         
          for(int j=i+1;j<n;j++)
          {
              for(int p=j+1;p<n;p++)
              {
                  
                  for(int l=p+1;l<n;l++)
                  {
                      int min=i,max=i;
                      if((AllPoints[i].slopeTo(AllPoints[j])==AllPoints[i].slopeTo(AllPoints[p]))&&(AllPoints[i].slopeTo(AllPoints[j])==AllPoints[i].slopeTo(AllPoints[l])))
                      {
                          if(AllPoints[min].compareTo(AllPoints[j])==1)
                          {
                              min=j;
                          }
                          if(AllPoints[max].compareTo(AllPoints[j])==-1)
                          {
                              max=j;
                          }
                         if(AllPoints[min].compareTo(AllPoints[p])==1)
                          {
                              min=p;
                          }
                          if(AllPoints[max].compareTo(AllPoints[p])==-1)
                          {
                              max=p;
                          }
                          if(AllPoints[min].compareTo(AllPoints[l])==1)
                          {
                              min=l;
                          }
                          if(AllPoints[max].compareTo(AllPoints[l])==-1)
                          {
                              max=l;
                          }
                          ls1[k]=new LineSegment(AllPoints[min],AllPoints[max]);
                          // System.out.println(i+"+"+j+"+"+p+"+"+l);
                          // System.out.println("min"+min+"max"+max);
                          // System.out.println(ls1[k].toString());
                          k++;
                          
                      }
                  }
              }
          }
      }
       ls=new LineSegment[k];
     for(int m=0;m<k;m++)
     {
          ls[m]=ls1[m];
         }
      return ls;
   }
   public static void main(String arg[])
   {
         Point[] points=new Point[8];
//       points[0]=new Point(10000,0);
//       points[1]=new Point(8000,2000);
//       points[2]=new Point(2000,8000);
//       points[3]=new Point(0,10000);
//       points[4]=new Point(20000,0);
//       points[5]=new Point(18000,2000);
//       points[6]=new Point(2000,18000);
//       points[7]=new Point(10000,20000);
//       points[8]=new Point(30000,0);
//       points[9]=new Point(0,30000);
//       points[10]=new Point(20000,10000);
//       points[11]=new Point(13000,0);
//       points[12]=new Point(11000,3000);
//       points[13]=new Point(5000,12000);
//       points[14]=new Point(9000,6000);
//         points[0]=new Point(10000,0);
//         points[1]=new Point(0,10000);
//         points[2]=new Point(3000,7000);
//         points[3]=new Point(7000,3000);
//         points[4]=new Point(20000,21000);
//         points[5]=new Point(3000,4000);
//         points[6]=new Point(14000,15000);
//         points[7]=new Point(6000,7000);
       points[0]=new Point(10000,0);
       points[1]=new Point(10000,1);
       points[2]=new Point(10001,0);
       points[3]=new Point(10001,1);
       points[4]=new Point(10002,0);
       points[5]=new Point(10002,1);
       points[6]=new Point(10003,0);
       points[7]=new Point(10003,1);
       
       
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
       BruteCollinearPoints bp=new BruteCollinearPoints(points);
       System.out.println(bp.numberOfSegments());
       
   }
}