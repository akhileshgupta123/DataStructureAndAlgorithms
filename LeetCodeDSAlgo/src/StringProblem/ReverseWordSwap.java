package StringProblem;

public class ReverseWordSwap {
    public static void main(String args[]){
        ReverseWordSwap obj = new ReverseWordSwap();
        String str = "Geeks for Geeks ";
        String result = obj.reverseWord(str);

        System.out.println("the result is :"+result);

    }

    private String reverseWord(String str){
        int i=0;
        int j=0;
        char ch[] = str.toCharArray();

        while(i<=ch.length && j<=ch.length){
            if(j==ch.length || ch[j]==' '){

                reverse(ch,i,j);
                i=j+1;
            }
            j++;

        }

        return String.valueOf(ch);
    }

    private void reverse(char ch[], int i, int j){
        j=j-1;
        while(i<j)
        {
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }

    }
}
