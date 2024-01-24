package BinarySearch;
//1618. Maximum Font to Fit a Sentence in a Screen
public class MaximumFontFitSentence {
    public static void main(String args[]){

        MaximumFontFitSentence obj = new MaximumFontFitSentence();
        int w=80;
        int h = 20;
        String text="helloworld";
        int fonts[] = new int[]{6,8,10,12,14,16,18,24,36};
        FontInfo fontObj;
        //int result = obj.maxFont(text,w,h,fonts,fontObj);
    }

    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0, right = fonts.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            int fontSize = fonts[mid];
            if (check(text, fontSize, w, h, fontInfo)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return check(text, fonts[left], w, h, fontInfo) ? fonts[left] : -1;
    }

    private boolean check(String s, int fontSize, int w, int h, FontInfo fontInfo) {
        if (fontInfo.getHeight(fontSize) > h) {
            return false;
        }
        int width = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            width += fontInfo.getWidth(fontSize, ch);
            if (width > w) {
                return false;
            }
        }
        return true;
    }
}

interface FontInfo {

           public int getWidth(int fontSize, char ch);
           public int getHeight(int fontSize);
 }
