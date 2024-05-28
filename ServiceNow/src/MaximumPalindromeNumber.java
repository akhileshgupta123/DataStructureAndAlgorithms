public class MaximumPalindromeNumber {
    public static void main(String args[]){
        //String number = "39878";
        String number = "123123789";
        char test[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };
        String res = new String(test);
        System.out.println(res);
        MaximumPalindromeNumber obj = new MaximumPalindromeNumber();
        String result = obj.maxPalindromeNumber(number);

        System.out.println(result);
    }

    public String maxPalindromeNumber(String number) {
        int isAllZeros = 0;
        int[] freq = new int[10];
        for(int i=0; i< number.length(); i++){
            int index = Character.getNumericValue(number.charAt(i));
            freq[index] = freq[index] + 1;
        }



        int lengthOfPalindrom = 0;
        for(int k=9 ; k >=0; k--){
            if(freq[k] != 1){
                if(freq[k] % 2 == 0){
                    lengthOfPalindrom+=freq[k];
                }else{
                    lengthOfPalindrom+=(freq[k]-1);
                }
            }

        }

        char[] charArray = new char[lengthOfPalindrom+1];
        int left = 0;
        int right = lengthOfPalindrom;

        System.out.println("array length :"+charArray.length);

        System.out.println("length"+ right);

        for(int l=9; l >=0; l--){
            int fr = freq[l];
            if(fr != 1){
                if(fr % 2 ==0){
                    fr = fr;
                }else{
                    fr = fr-1;
                }

                while(left < right && fr >1 && left >=0 && left < charArray.length && right >=0 && right < charArray.length){
                    charArray[left] = (char)(l+'0');
                    charArray[right] = (char)(l + '0');

                    freq[l]-=2;
                    left++;
                    right--;
                    fr = fr-2;
                }
            }
        }

        for(int i=0; i<charArray.length; i++){
            System.out.println("final"+charArray[i]);
        }

        System.out.println("here:"+charArray[left]);
        System.out.println(charArray);
        for(int p=9; p >=0; p--){
            if(freq[p] == 1){
                charArray[left] = (char)(p+ '0');
                break;
            }
        }

        String res = new String(charArray);
        return res;
    }
}
