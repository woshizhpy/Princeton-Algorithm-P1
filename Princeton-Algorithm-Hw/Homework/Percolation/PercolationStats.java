public class PercolationStats {
   private double[] record_p;
   // private int width;
   private int T;
   private static void pop() throws IllegalArgumentException
   {
       throw new IllegalArgumentException("");
   }
   public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {
       if((n<0)||(trials<0))
       {
           pop();
           return;
       }
       // width=n;
       T=trials;
       record_p=new double[T];
       for(int i=0;i<T;i++)
       {
           PerformOnce(n,i);
       }
   }
   public double mean()                          // sample mean of percolation threshold
   {
       double sum=(double) 0;
       double m;
       int l=record_p.length;
       for(int i=0;i<l;i++)
       {
           sum+=record_p[i];
       }
       m=sum/l;
       return m;
   }
   public double stddev()                        // sample standard deviation of percolation threshold
   {
       double dev;
       double sum=(double) 0;
       double m=mean();
       int l=record_p.length;
       for(int i=0;i<l;i++)
       {
           sum+=(record_p[i]-m)*(record_p[i]-m);
       }
       dev=sum/(l-1);
       return Math.sqrt(dev);
   }
   public double confidenceLo()                  // low  endpoint of 95% confidence interval
   {
       return (mean()-1.96*stddev()/Math.sqrt(T));
   }
   public double confidenceHi()                 // high endpoint of 95% confidence interval
   {
        return (mean()+1.96*stddev()/Math.sqrt(T));
   }
   private void PerformOnce(int n,int i)
   {
      Percolation p=new Percolation(n);
      while(!p.percolates())
      {
          java.util.Random Ra=new java.util.Random();
          int r=Math.abs(Ra.nextInt())%(n*n);
          int row=r/n+1;
          int col=r%n+1;
          p.open(row,col);
      }
      record_p[i]=(double) p.numberOfOpenSites();
      record_p[i]/=(n*n);
   }
//   private String PPtoString()
//   {
//       String s=new String("%java PercolationStats             ");
//       s+=width+"  "+T+"\r\n";
//       s+="mean                   ="+mean()+"\r\n";
//       s+="stddev                 ="+stddev()+"\r\n";
//       s+="95% confidence interval=["+confidenceLo()+","+confidenceHi()+"]\r\n";
//       return s;
//   }

   public static void main(String[] args)        // test client (described below)
   {
      //  PercolationStats PeS1=new PercolationStats(200, 100);
       // System.out.println(PeS1.PPtoString());
      // PeS1=new PercolationStats(200, 100);
      // System.out.println(PeS1.mean());
      // PeS1=new PercolationStats(2, 10000);
       // System.out.println(PeS1.PPtoString());
     //  PeS1=new PercolationStats(2, 10000);
      //  System.out.println(PeS1.PPtoString());
      
       
   }
}