import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
public class RandomizedQueue<Item> implements Iterable<Item> {
   private int N;
   private Item[] Rq;
   //private int head;
   //private int tail;
   private class QueueArrayIterator implements Iterator<Item>
   //private class QueueArrayIterator implements Iterator<Item>
   {
       private Item[] perm;
       private int i;
       //private current=head;
       //private int[] order;
       public QueueArrayIterator()
       {
           i=N-1;
           perm=(Item[]) new Object[N];
           for(int j=0;j<N;j++)
           {
               perm[j]=Rq[j];
           }
           StdRandom.shuffle(perm);
           
       }
       public boolean hasNext()
       {
           return (i>=0);
       }
       public Item next()
       {
           if(hasNext())
           {
               return perm[i--];
           }
           else
          {
               throw new java.util.NoSuchElementException();
           }
       }
       public void remove()
       {
           throw new UnsupportedOperationException();
       }
   }
   private void resize(int len)
   {
      Item[] s=(Item[]) new Object[len]; 
      for(int i=0;i<N;i++)
      {
//          if(Rp[j]!=null)
//          {
//              s[i]=Rp[j];
//              j++;
//          }
//          else
//          {
//              j++;
//          }
          s[i]=Rq[i];
      }
      Rq=s;
      //head=len/4;
      //tail=len/4+N-1;
   }
   public RandomizedQueue()                 // construct an empty randomized queue
   {
       N=0;
       Rq=(Item[]) new Object[2];
   }
   public boolean isEmpty()                 // is the queue empty?
   {
       return (N==0);
   }
   public int size()                        // return the number of items on the queue
   {
       return N;
   }
   public void enqueue(Item item)           // add the item
   {
       if(item==null)
       {
           throw new java.lang.NullPointerException();
       }
       if(N==Rq.length)
       {
            resize(2*Rq.length); 
       }
       Rq[N++]=item;
           //N++;
   }
   public Item dequeue()                    // remove and return a random item
   {
       if(isEmpty())
       {
           throw new java.util.NoSuchElementException();
           //return null;
       }
       int ra=StdRandom.uniform(N);
       //System.out.println(ra);
       Item x=Rq[ra];
       Rq[ra]=Rq[N-1];
       N--;
       return x;
       
   }
   public Item sample()                     // return (but do not remove) a random item
   {
       if(isEmpty())
       {
          throw new java.util.NoSuchElementException(); 
       }
       int ra=StdRandom.uniform(N);
       return Rq[ra];
   }
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   {
       return new  QueueArrayIterator();
   }
//   private String ItoString()
//   {
//       String s=new String(" ");
//       for(int m=0;m<N;m++)
//       {
//           s+=Rq[m]+" ";
//       }
//       s+="\r\nsize:"+N+"\r\n";
//       System.out.println(s);
//       return s;
//   }
   public static void main(String[] args)   // unit testing (optional)
   {
       RandomizedQueue<String> deque = new RandomizedQueue<String> ();
       for(int i=0;i<12000;i++)
       {
           deque.enqueue("aa");
           // deque.ItoString();
           deque.enqueue("bb");
           
          deque.dequeue();
           //deque.ItoString();
          deque.dequeue();
       }
       //deque.ItoString();
       //deque.dequeue();
       //StdOut.print("size:"+deque.size());
//       if(deque.isEmpty())
//       {
//           StdOut.print("Empty!");
//       }
   }
}