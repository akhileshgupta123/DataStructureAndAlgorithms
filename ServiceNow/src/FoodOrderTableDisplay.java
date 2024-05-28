import java.util.*;
//1418. Display Table of Food Orders in a Restaurant
public class FoodOrderTableDisplay {
    public static void main(String args[]){
        List<List<String>> orders = new ArrayList<List<String>>();
        FoodOrderTableDisplay obj = new FoodOrderTableDisplay();
        orders.add(obj.addItem("David","3","Ceviche"));
        orders.add(obj.addItem("Corina","10","Beef Burrito"));
        orders.add(obj.addItem("David","3","Fried Chicken"));
        orders.add(obj.addItem("Carla","5","Water"));
        orders.add(obj.addItem("Carla","5","Ceviche"));
        orders.add(obj.addItem("Rous","3","Ceviche"));


        List<List<String>> result = obj.displayTable(orders);
        System.out.println(result);
    }

    public List<List<String>> displayTable(List<List<String>> orders){
        Set<Integer> tables = new HashSet<Integer>();
        Set<String> foods = new HashSet<String>();
        Map<String, Integer> mp = new HashMap<String, Integer>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            tables.add(table);
            foods.add(food);
            String key = table + "." + food;
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        List<Integer> t = new ArrayList<>(tables);
        List<String> f = new ArrayList<>(foods);
        Collections.sort(t);
        Collections.sort(f);
        List<List<String>> res = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(f);
        res.add(title);
        for (int table : t) {
            List<String> tmp = new ArrayList<>();
            tmp.add(String.valueOf(table));
            for (String food : f) {
                int foodItemCount = mp.getOrDefault(table + "." + food, 0);
                tmp.add(String.valueOf(foodItemCount));
            }
            res.add(tmp);
        }
        return res;
    }

    private List<String> addItem(String item1, String item2, String item3){
        List<String> item = new ArrayList<String>();
        item.add(item1);
        item.add(item2);
        item.add(item3);
        return item;
    }
}
