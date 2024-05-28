//2038. Remove Colored Pieces if Both Neighbors are the Same Color
public class RemoveColorPeice {
    public static void main(String args[]){
        //String colors = "AAABABB";
        //String colors = "AA";
        String colors = "ABBBBBBBAAA";

        RemoveColorPeice obj = new RemoveColorPeice();
        boolean result = obj.winnerOfGame(colors);
        System.out.println("result is :"+result);
    }

    boolean winnerOfGame(String colors) {
        int a=0,b=0;
        int n=colors.length();

        for(int i =1;i<n-1;i++){
            if(colors.charAt(i-1) == 'A' && colors.charAt(i) == 'A'  && colors.charAt(i+1) == 'A' ){
                a++;
            }else if(colors.charAt(i-1) == 'B' && colors.charAt(i) == 'B'  && colors.charAt(i+1) == 'B'){
                b++;
            }
        }
        return a>b;
    }
}
