import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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

        //Viết chương trình Java để đếm số lần xuất hiện của mỗi phần tử trong một mảng và lưu trữ kết quả trong HashMap.
        Random random = new Random();
        List<Integer> randomList =
                Stream.generate(() -> random.nextInt(50))
                        .limit(50)
                        .toList();// thuật toán random 100 số ngẫu nhiên từ 0- 1000

        System.out.println(randomList);
        // sử dụng hash map
        //  B1 duyệt qua từng phần tử của randomlist
        //  B2 Kiểm tra phần tử đang xét đã tồn tại trong map hay chưa
        // neeusu chưa tồn tại thì theem 1 cặp entry : number - count = 1
        // nếu đã tồn tại thì put cặp entry : number - count = count+1
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer element : randomList){
            if (map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }else {
                map.put(element,1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("Số : "+entry.getKey() + " | Xuất hiên " + entry.getValue() + " lần" );
        }
        // sắp xếp tăng dâ theo số lần xuất hiện
        List<Map.Entry<Integer,Integer>> sortList = new ArrayList<>(map.entrySet());
        Collections.sort(sortList,(o1, o2) -> o1.getValue()-o2.getValue());
//        sortList.sort((o1, o2) -> o1.getValue()-o2.getValue());
        System.out.println("Daanh sach da săp xep");
        for (Map.Entry<Integer, Integer> entry : sortList){
            System.out.println("Số : "+entry.getKey() + " | Xuất hiên " + entry.getValue() + " lần" );
        }
//        Sắp xếp phần tử có giá trị tăng dần trong TreeMap.
//                Tìm phần tử nhỏ nhất trong TreeMap
//        Tìm phần tử lớn thứ 2 trong TreeMap
//        Sắp xếp các phần tử theo giá trị giảm dần trong TreeMap

        TreeMap<Integer,Integer> tree = new TreeMap<>();
        for (Integer e : randomList){
            tree.put(e,0);
        }
        for (Integer key  : tree.keySet()){
            System.out.println("Key "+key );
        }

        System.out.println("Phần tử nhỏ nhất trong tree map : "+tree.firstKey());
        System.out.println("Phần tử lơn thứ 2 trong tree map : "+tree.lowerKey(tree.lastKey()));

        NavigableSet<Integer> integers =  tree.descendingKeySet();
        while (!integers.isEmpty()){
            System.out.println(integers.pollFirst());
        }



    }
}