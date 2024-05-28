// find the number of times a given small string appears in an another big string
public class StringAppearanceCount {
    public static void main(String args[]){
        String bigString = "qabcaccxcxabcadfgdfgfdabca";
        String smallString = "abc";
        StringAppearanceCount obj = new StringAppearanceCount();
        int appearanceCount = obj.countStringAppearances(bigString, smallString);
        System.out.println("The small string appears " + appearanceCount + " times in the big string.");

    }
    private int countStringAppearances(String bigString, String smallString){
        int count = 0;
        int index = bigString.indexOf(smallString);

        System.out.println(index);
        while (index != -1) {
            count++;
            index = bigString.indexOf(smallString, index + 1);

            System.out.println("inner index is:"+index);
        }

        return count;
    }
}
