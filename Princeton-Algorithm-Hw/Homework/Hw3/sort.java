public class sort
{
    public static void main(String arg[])
    {
        int[] num=new int[12];
        for(int i=0;i<12;i++)
        {
            num[i]=12-i;
        }
        for(int i=0;i<12;i++)
       {
           System.out.print(num[i]+"  ");
       }
         System.out.print("\r\n");
        for(int i=0;i<12;i++)
      {
          for(int j=i;j<12;j++)
          {
              if(num[j]<num[i])
              {
                  int temp=num[j];
                  num[j]=num[i];
                  num[i]=temp;
              }
          }
      }
       for(int i=0;i<12;i++)
       {
           System.out.print(num[i]+"  ");
       }
    }
}