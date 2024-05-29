public class FindVMIndex {
    public static void main(String args[]){
        int vm=7;
        int vmlist[] = new int[]{2,4,1,5,1,2,3,4};


        int node_count=1000;
        int start_index=-1;

        for(int i=0; i<vmlist.length; i++){
            int curr_node_count=1;
            int remaining_item = vm-vmlist[i];
            int curr_start_index = i;

            for(int j=i+1; j<vmlist.length && remaining_item>0 ;j++){
                curr_node_count++;
                remaining_item = remaining_item-vmlist[j];

            }

            if(remaining_item<=0){
                System.out.println("previous start index is:"+start_index);
                if(node_count>curr_node_count){
                    start_index = curr_start_index;
                }
                node_count = Math.min(node_count,curr_node_count);
                //if(node_count>curr_node_count){\\\\


                System.out.println("current curr_node_count:"+curr_node_count);









                System.out.println("current start index is:"+start_index);
                //}



            }



        }

        System.out.println("the node count is :"+node_count);
        System.out.println("the start_index  is :"+start_index);
        System.out.println("the end_index  is :"+(start_index+node_count-1));
    }
}
