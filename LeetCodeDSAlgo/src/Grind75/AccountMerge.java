package Grind75;
//721. Accounts Merge
import java.util.*;
public class AccountMerge {
    public static void main(String args[]){
        AccountMerge obj = new AccountMerge();
        List<String> l1 = new ArrayList<String>();
        l1.add("John");
        l1.add("johnsmith@mail.com");
        l1.add("john_newyork@mail.com");

        List<String> l2 = new ArrayList<String>();
        l2.add("John");
        l2.add("johnsmith@mail.com");
        l2.add("john00@mail.com");


        List<String> l3 = new ArrayList<String>();
        l3.add("Mary");
        l3.add("mary@mail.com");

        List<String> l4 = new ArrayList<String>();
        l4.add("John");
        l4.add("johnnybravo@mail.com");




        List<List<String>> l = new ArrayList<List<String>>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);

        List<List<String>> result = obj.accountsMerge(l);
        System.out.println(result);

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<String,String>();
        Map<String, String> parents = new HashMap<String,String>();
        Map<String, TreeSet<String>> unions = new HashMap<String,TreeSet<String>>();

        // Owner: email -> email
        // Parent: email -> name
        for (List<String> a: accounts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }

/*
        for(Map.Entry<String,String> obj : parents.entrySet()){
            System.out.println("key is:"+obj.getKey());
            System.out.println("val is:"+obj.getValue());
        }
*/


        System.out.println("####################");

        //System.out.println("parent size"+parents.size());
        //System.out.println("owner size"+owner.size());

        // Update parent
        for (List<String> a: accounts) {
            String p = find(a.get(1), parents);
            //System.out.println("####################parent is:"+p);
            //System.out.println(p);
            for (int i = 2; i < a.size(); i++) {
                //String temp = find(a.get(i), parents);
                //System.out.println("####################temp is:"+temp);
                parents.put(find(a.get(i), parents), p);
            }
        }
/*

        for(Map.Entry<String,String> obj : parents.entrySet()){
            System.out.println("key is:"+obj.getKey());
            System.out.println("val is:"+obj.getValue());
        }*/

        //System.out.println("parent size"+parents.size());

        //System.out.println("adding name");
        // Add to name
        for (List<String> a: accounts) {
            String p = find(a.get(1), parents);
            //System.out.println("parent is"+p);
            //System.out.println("child is"+a.get(1));
            if (!unions.containsKey(p)) { unions.put(p, new TreeSet<>()); }
            for (int i = 1; i < a.size(); i++) {
                unions.get(p).add(a.get(i));
               // System.out.println("inner is"+a.get(i));
            }

            //System.out.println(unions.get(p));
        }

        //System.out.println("final name");

        // return
        List<List<String>> res = new ArrayList<>();
        for (String p: unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            //System.out.println("key is:"+p);
           // System.out.println(emails);

            emails.add(0, owner.get(p));
            //System.out.println(emails);
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}
