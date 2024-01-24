package DynamicProgramming;
//2266. Count Number of Texts
public class CountText {
    int mod=(int)Math.pow(10,9)+7;
    public static void main(String args[]){

        int mod=(int)Math.pow(10,9)+7;

        System.out.println(mod);


        // String[] keypad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        CountText obj = new CountText();
        int result = obj.countTexts("22233");
        System.out.println(result);
;    }

    public int countTexts(String pressedKeys){

        int len=pressedKeys.length();
        int[] dp=new int[len+1];

        dp[0]=1;
        System.out.print(dp[0]+" ");
        for(int i=1;i<len+1;i++){
            char ch=pressedKeys.charAt(i-1);

            dp[i]=(dp[i]%mod+dp[i-1]%mod)%mod;

            System.out.println(dp[i]);

            if(i-2>=0 && pressedKeys.charAt(i-2)==ch ){
                dp[i]=(dp[i]%mod+dp[i-2]%mod)%mod;


                if(i-3>=0 &&  pressedKeys.charAt(i-3)==ch ){


                    dp[i]=(dp[i]%mod+dp[i-3]%mod)%mod;

                    if((i-4>=0 && pressedKeys.charAt(i-4)==ch)&& (ch=='7' || ch=='9')  ){
                        dp[i]=(dp[i]%mod+dp[i-4]%mod)%mod;
                    }
                }
            }

            System.out.println("second"+dp[i]);


        }
        return dp[len];
    }
}
