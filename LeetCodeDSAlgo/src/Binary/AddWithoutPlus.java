package Binary;

public class AddWithoutPlus {
    public static void main(String args[]){
        System.out.println(Add(15, 32));
    }
    static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;
            System.out.println(carry);

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            System.out.println(x);
            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
            System.out.println(y);
        }
        return x;
    }
}
