import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHero {

    public static void main(String[] args) throws IOException {
        Stream <String> lines = Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        List <Hero> list = new ArrayList <>();
        lines.forEach(s -> {
            String[] split = s.split("\t");
            int i = Integer.parseInt(split[0]);
            int i1 = Integer.parseInt(split[4]);
            int i2 = Integer.parseInt(split[5]);
            int i3 = Integer.parseInt(split[6]);
            list.add(new Hero(i, split[1], split[2], split[3], i1, i2, i3));
        });
        Stream <Hero> stream = list.stream();
        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
//        List <Hero> collect = list.stream().sorted((h, h2) -> {
//            int num = h.getPower() - h2.getPower();
//            return -num;
//        }).limit(3).collect(Collectors.toList());
//        System.out.println(collect);

        // 2. 按出生地分组
//
//        Map <String, List <Hero>> collect = stream.collect(Collectors.groupingBy((S) -> S.getLoc()));
//        System.out.println(collect);

        // 3. 找出寿命前三的武将
//        List <Hero> collect = stream.sorted((h1, h2) -> {
//            int num = (h1.getDeath() - h1.getBirth()) - (h2.getDeath() - h2.getBirth());
//            return -num;
//        }).limit(3).collect(Collectors.toList());
//        System.out.println(collect);

        // 4. 女性寿命最高的

//        Map <String, List <Hero>> 女 = stream.filter(hero -> hero.getSex().equals("女")).sorted((h1, h2) -> {
//            int num = (h1.getDeath() - h1.getBirth()) - (h2.getDeath() - h2.getBirth());
//            return -num;
//        }).limit(1).collect(Collectors.groupingBy((S) -> S.getSex()));
//        System.out.println(女);
        // 5. 找出武力排名前三  100, 99,  97 ==> 4个人 吕布", "张飞", "关羽", "马超

//        Set <Integer> collect = list.stream().map(hero -> hero.getPower()).sorted((p1, p2) -> p2 - p1).limit(3).collect(Collectors.toSet());
//        list.stream().filter((h)->collect.contains(h.getPower())).forEach(hero -> System.out.println(hero));

        //6.按各个年龄段分组：0-20,21-40,41-60,60以上
//        Map <Object, List <Hero>> collect = list.stream().collect(Collectors.groupingBy(h -> ageRangs(h.getDeath() - h.getBirth())));
//        collect.forEach((k,v)-> {
//            System.out.println(k+":"+v.stream().map(h->h.getName()).collect(Collectors.toList()));
//        });


        //7.按武力值分组：>=90,80~89,70~79,70>
//        Map <Object, List <Hero>> collect = list.stream().collect(Collectors.groupingBy(h -> powerRangs(h.getPower())));
//        collect.forEach((k,v)-> {
//            System.out.println(k+":"+v.stream().map(h->h.getName()).collect(Collectors.toList()));
//        });


        //8.按出生地划分，统计人数

        Map <String, Long> collect = list.stream().collect(Collectors.groupingBy(h -> h.getLoc(), Collectors.counting()));
        System.out.println(collect);

    }
    public static String ageRangs(int age){
        if (age>=0&&age<=20){
            return "0-20";
        }else if (age>=21&&age<=40){
            return "21-40";
        }else if (age>=41&&age<=60){
            return "41-60";
        }else return "60以上";
    }
    public static String powerRangs(int power){
        if (power>=90){
            return "90以上";
        }else if (power>=80&&power<=89){
            return "80-89";
        }else if (power>=70&&power<=79){
            return "70-79";
        }else return "0-69";
    }

}




