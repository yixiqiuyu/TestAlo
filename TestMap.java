import java.util.*;

public class TestMap {
    public static void main(String[] args){
        Map<String,Integer> map=new HashMap<>();
        map.put("gejian",18);
        map.put("wangwu",20);
        map.put("zhangsan",12);
        Map<String,Integer> map1=new HashMap<>();
        map1.putAll(map);

        //键值对遍历
        Set set=map1.keySet();
        for(Object o:set){
            Object value=map1.get(o);
            System.out.println(o+" "+value);
        }

        //值遍历
       /* Collection<Integer> values = map1.values();
        Iterator iterator=values.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        //Enter遍历
        Set set1=map1.entrySet();
        Iterator it=set1.iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
