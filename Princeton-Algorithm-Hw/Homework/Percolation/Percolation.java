import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
   private int width;
   private int[] table_map; 
   private WeightedQuickUnionUF id_map;
   private int openSites;
   private static void pop() throws IllegalArgumentException
   {
       throw new IllegalArgumentException("");
   }
   public Percolation(int n)   // create n-by-n grid, with all sites blocked
   {
       width=n;
       table_map=new int[n*n];
       id_map=new WeightedQuickUnionUF(n*n+2);
       openSites=0;
       for(int i=0;i<n;i++)
       {
           id_map.union(0,i+1);
           id_map.union(n*n+1,n*n-i);
       }
       for(int i=0;i<n*n;i++)
       {
          table_map[i]=0;
       }
   }
   private int in_UF(int row,int col)
   {
       return (row-1)*width+col;
   }
   public void open(int row, int col)    // open site (row, col) if it is not open already
   {
       if((row<0)||(col<0))
       {
           pop();
           return;
       }
       if(isOpen(row,col))
       {
           return;
       }
       else
       {
           table_map[in_UF(row,col)-1]=1;
           openSites++;
           union_all(row,col);
       }
   }
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
       if((row<0)||(col<0))
       {
           pop();
           return false;
       }
       int i=in_UF(row,col)-1;
       return (table_map[i]==1);
   }
   public boolean isFull(int row, int col)  // is site (row, col) full
   {
       if((row<0)||(col<0))
       {
           pop();
           return false;
       }
      return (id_map.connected(0,in_UF(row,col))&&isOpen(row,col));
   }
   public     int numberOfOpenSites()       // number of open sites
   {
       return openSites;
   }
   public boolean percolates()              // does the system percolate?
   {
       if(width>1)
       {
           return (id_map.connected(0,width*width+1));
       }
       else
       {
           return isOpen(1,1);
       }
   }


  
   private void union_all(int row,int col)
   {
      int index=in_UF(row,col);
      if(row-1>0)
      {
          if(isOpen(row-1,col))
          {
              id_map.union(index,index-width);
          }
      }
      if(row+1<=width)
      {
          if(isOpen(row+1,col))
          {
              id_map.union(index,index+width);
          }
      }
      if(col-1>0)
      {
          if(isOpen(row,col-1))
          {
              id_map.union(index,index-1);
          }
      }
      if(col+1<=width)
      {
          if(isOpen(row,col+1))
          {
              id_map.union(index,index+1);
          }
      }
           
           
       
   }
//   private String PtoString()
//   {
//       StringBuilder s="Open Status\r\n";
//       for(int i=0;i<width;i++)
//       {
//           for(int j=0;j<width;j++)
//           {
//               s+="|"+Integer.toString(table_map[i*width+j]);
//           }
//           s+="!\r\n";
//       }
//       s+=("ID_Map:\r\n");
//       s+="|"+Integer.toString(id_map.find(0))+"\r\n";
//       for(int i=0;i<width;i++)
//       {
//           for(int j=0;j<width;j++)
//           {
//               s+="|"+Integer.toString(id_map.find(in_UF(i+1,j+1)));
//           }
//           s+="!\r\n";
//       }
//       s+=id_map.find(width*width+1)+"\r\n";
//       return s;
//       
//   }
   public static void main(String[] args)   // test client (optional)    
   {
       Percolation Pe1=new Percolation(1);
       // System.out.print(Pe1.PtoString());
        if(Pe1.isFull(1,1))
       {
           System.out.println("11Full");
       }
       else
       {
           System.out.println("11NotFull");
       }
       Pe1.open(1,1);
        if(Pe1.isFull(1,1))
       {
           System.out.println("11Full");
       }
       else
       {
           System.out.println("11NotFull");
       }
       Pe1=new Percolation(2);
       Pe1.open(1,1);
       Pe1.open(2,2);
       Pe1.open(1,2);
       // System.out.print(Pe1.PtoString());
       if(Pe1.isFull(2,1))
       {
           System.out.println("12Full");
       }
       else
       {
           System.out.println("12NotFull");
       }
        if(Pe1.percolates())
        {
            System.out.println("Percolate!");
        }
        else
        {
            System.out.println("Not Percolate!");
        }
   }
}

