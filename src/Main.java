import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Map- Tree
        // lưu trữ dưới dạng key - value (Entry)
        // key là ko trung lặp

        // Interface Map ; class implement : HashMap , LinkedHashMap, TreeMap
        Map<String, String> dictionary = new HashMap<>();
        // thêm phan tu vào
        dictionary.put("hello","xin chào");
        dictionary.put("thank you","cảm ơn");
        dictionary.put("good bye","tạm biệt");
        System.out.println(dictionary);

        // thay dổi giá trị
        dictionary.put("hello","chào");
        System.out.println(dictionary);
        // xóa entry ra khỏi map
        dictionary.remove("hello");
        System.out.println(dictionary);
        // lấy giá tri theo key
        System.out.println(dictionary.get("thank you"));

        // chuyển map thành 1 Set<Key>
        Set<String> keySet = dictionary.keySet();
        System.out.println(keySet);

        for (String key : dictionary.keySet()){
            System.out.println("Key : "+key);
            System.out.println("Value : "+dictionary.get(key));
        }
        // chuyển map thành mảng các value
        Collection<String> values = dictionary.values();
        System.out.println(values);

        // chuyen map thành mảng các entry
        Set<Map.Entry<String, String>> entrySet = dictionary.entrySet();
        System.out.println(entrySet);

        for (Map.Entry<String ,String> entry : dictionary.entrySet()){
            System.out.println("Key : "+entry.getKey());
            System.out.println("Value : "+entry.getValue());
        }

        // kiểm tra tồn tại theo key, value
        System.out.println(" key hello có tồn tại ko : "+dictionary.containsKey("hello"));
        System.out.println(" key hello có tồn tại ko : "+dictionary.containsKey("thank you"));
        System.out.println(" key hello có tồn tại ko : "+dictionary.containsValue("chào"));

        // Cấu trúc dạng tree - cây
        // Các phần tử trong cấu trúc tree sẽ được sắp xếp theo thứ tự tự nhiên (Comparable/ Comparator)

        // So sánh 2 đối tượng trong Java
        // Cách thức sắp xếp 1 danh sách đôi tượng

        // Comparable : pttt compareTo(T o)
//        sắp xếp số tăng dần


        Double[] arr = {2.6,6.0,-1.2,5.0,0.1,9.0,7.2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

//        Student[] students = {
//                new Student(1,"Nguyen Van A",19,70.5),
//                new Student(2,"Nguyen Van D",18,70.4),
//                new Student(3,"Nguyen Van E",21,70.6),
//                new Student(4,"Nguyen Van B",20,70.55)
//        };
//        // sắp xếp theo tên tăng dần
//        Arrays.sort(students);
//        System.out.println(Arrays.toString(students));
        // Collections
        List<Student> list = Arrays.asList( new Student(1,"Nguyen Van A",19,70.5),
                new Student(2,"Nguyen Van D",18,70.4),
                new Student(3,"Nguyen Van E",21,70.6),
                new Student(4,"Nguyen Van B",20,70.55));
//        Collections.sort(list); // list<T> : T phải triển khai COmparable
        Collections.sort(list, (o1,o2)->o1.getAge()-o2.getAge()); // list<T> : T phải triển khai COmparable
        System.out.println(list);
        Collections.sort(list, (o1,o2)->Double.compare(o2.getWeight(),o1.getWeight())); // list<T> : T phải triển khai COmparable
        System.out.println(list);
        Collections.sort(list, (o1,o2)->o2.getName().compareTo(o1.getName())); // list<T> : T phải triển khai COmparable
        System.out.println(list);
    }
}