package paypal;

public class TinyURL {
    public static void main(String args[]){
        int n = 12345;
        String shorturl = idToShortURL(n);
        System.out.println("Generated short url is " + shorturl);
        System.out.println("Id from url is " +
                shortURLtoID(shorturl));

    }

    // Function to generate a short url from integer ID
    static String idToShortURL(int n) {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer();

        // Convert given integer id to a base 62 number
        while (n > 0){
            // use above map to store actual character
            // in short url
            shorturl.append(map[n % 62]);
            n = n / 62;
            System.out.println("n:"+n);

        }


            // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();

    }

    // Function to get integer ID back from a short url
    static int shortURLtoID(String shortURL){
        int id = 0; // initialize result

        // A simple base conversion logic
        for (int i = 0; i < shortURL.length(); i++)
        {
            System.out.println(shortURL.charAt(i));
            if ('a' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'z'){
                id = id * 62 + shortURL.charAt(i) - 'a';
                System.out.println("inside first" + id);
            }
            if ('A' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'Z'){
                id = id * 62 + shortURL.charAt(i) - 'A' + 26;
                System.out.println("inside second"+id);
            }

            if ('0' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= '9'){
                id = id * 62 + shortURL.charAt(i) - '0' + 52;
                System.out.println("inside third"+id);
            }

        }
        return id;

    }

}
