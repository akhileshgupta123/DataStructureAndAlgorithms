package StringProblem;
//Given an encrypted string s and an integer k, decrypt each character of the string by finding the kth character behind it. Eg: str=kumar & k=3 then ans=hrjxo
public class DecryptString {
    public static void main(String args[]){
        String encryptedString = "kumar";
        int k = 3;

        String decryptedString = decrypt(encryptedString, k);
        System.out.println("Decrypted String: " + decryptedString);
    }

    private static String decrypt(String s, int k){
        StringBuilder decrypted = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            char decryptedChar = decryptChar(currentChar, k);
            decrypted.append(decryptedChar);
        }
        return decrypted.toString();
    }

    private static char decryptChar(char c, int k){
        int base = 'a';
        int charIndex = c-base;

        //int charIndex = c;
        charIndex = (charIndex - k + 26) % 26;

        //return (char) (charIndex + base);

        System.out.println("here:"+charIndex);

        return (char) (charIndex + base);

    }
}
