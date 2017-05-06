//import java.lang.*;
import java.util.Iterator;
//import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdIn;
public class Deque<Item> implements Iterable<Item> {
   private Node first;
   private Node last;
   private int N;
  private class Node
   {
       Item item;
       Node next;
       Node prev;
   }
  
  // private static void throwe2() throws UnsupportedOperationException
  // {
  //     throw new UnsupportedOperationException("");
  // }
  
   private class ListIterator implements Iterator<Item>
   {
       private Node current;
       public ListIterator()
       {
           //super();
           current=first;
       }
       public boolean hasNext()
       {
           return (current!=null);
       }
       public Item next()
       {
           if(hasNext())
           {
               Item x=current.item;
               current=current.next;
               return x;
           }
           else
           {
               throw new java.util.NoSuchElementException();
               //return null;
           }
       }
       public void remove()
       {
           throw new UnsupportedOperationException();
       }

   }

   public Deque()                           // construct an empty deque
   {
       first=null;
       last=null;
       N=0;
   }
   public boolean isEmpty()                 // is the deque empty?
   {
       return (N==0);
   }
   public int size()                        // return the number of items on the deque
   {
       return N;
   }
   public void addFirst(Item item)          // add the item to the front
   {
       if(item==null)
       {
          throw new java.lang.NullPointerException();
       }
       else
       {
           Node oldfirst=first;
           first=new Node();
           first.item=item;   
           first.prev=null;
           if(isEmpty())
           {
               first.next=null;
               last=first;
           }
           else{
               first.next=oldfirst;
               oldfirst.prev=first;
           }
           N++;
           //System.out.println("last"+last.item);
           //System.out.println("first"+first.item);
           //System.out.println(item+":"+N);
          // this.ItoString();
       }
   }
//   private String ItoString()
//   {
//       Node cnode=first;
//       String s=new String("Listout\r\n");
//       while(cnode!=null)
//       {
//           s+=cnode.item+"->";
//           cnode=cnode.next;
//       }
//       s+="null\r\n";
//       cnode=last;
//       while(cnode!=null)
//       {
//           s+=cnode.item+"<-";
//           cnode=cnode.prev;
//       }
//       s+="null\r\n";
//       System.out.println(s);
//       return s;
//   }
   public void addLast(Item item)           // add the item to the end
   {
       if(item==null)
       {
          throw new java.lang.NullPointerException();
       }
       else
       {
           Node oldlast=last;
           last=new Node();
           last.item=item;
           last.next=null;
           if(isEmpty())
           {
               last.prev=null;
               first=last;
           }
           else
           {
               oldlast.next=last;
               last.prev=oldlast;
           }
            //System.out.println(item+":"+N);
           N++;
       }
   }
   public Item removeFirst()                // remove and return the item from the front
   {
       if(isEmpty())
       {
           throw new java.util.NoSuchElementException();
           //return null;
       }
       else
       {
           
           Item x=first.item;
           first=first.next;
            N--;
           if(N==0)
           {
               last=first;
           }
           else
           {
               first.prev=null;
           }
           //System.out.println(N);
           return x;
       }
   }
   public Item removeLast()                 // remove and return the item from the end
   {
       if(isEmpty())
       {
           throw new java.util.NoSuchElementException();
           //return null;
       }
       else
       {
          
           Item x=last.item;
           last=last.prev;
           N--;
           if(N==0)
           {
               first=last;
           }
           else{
               last.next=null;
           }
           return x;
           
       }
   }
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   {
       return new ListIterator();
       //return new ReverseArrayIterator();
   }
   public static void main(String[] args)   // unit testing (optional)
   {
         Deque<Integer> deque = new Deque<Integer> ();
         deque.addLast(0);
         deque.addFirst(1);
         deque.addFirst(2);
         deque.addFirst(3);
         deque.addFirst(4);
         deque.addFirst(5);
         deque.addFirst(6);
         deque.addFirst(7);
         deque.addLast(8);
        // deque.ItoString();
         StdOut.println("Add Done");
         StdOut.println(deque.removeLast());
         StdOut.println(deque.removeLast());
         //Deque<Integer> deque = new Deque<Integer> ();
//       deque.addFirst("aa");
//       deque.addFirst("bb");
//       deque.addFirst("cc");
//       deque.addLast("dd");
         StdOut.println(deque.removeLast());
         StdOut.println(deque.removeFirst());
         StdOut.println(deque.removeFirst());
         StdOut.println(deque.removeLast());
        //StdOut.print("size:");
       StdOut.print("size:"+deque.size());
       //StdOut.println(deque.removeLast());
   }
}