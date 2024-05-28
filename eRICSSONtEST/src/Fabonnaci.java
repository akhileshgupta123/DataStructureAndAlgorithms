public class Fabonnaci {
    //0,1,1,2,3

    //n*n
    public static void main(String args[]){
        int num =10;
        Fabonnaci obj = new Fabonnaci();

        for(int i=0; i<num; i++){
            int result = obj.fabonnaci(i);
            System.out.print(result+" ,");
        }
    }


    public int fabonnaci(int num){
        if(num==0 || num ==1){
            return num;
        }
        return fabonnaci(num-1) + fabonnaci(num-2);
    }
}
