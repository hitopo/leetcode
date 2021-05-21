import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // 待匹配的字符串
        StringBuilder line = new StringBuilder("12ada12mm31ni55eee912iiii");
        // 模式字符串
        String pattern = "(\\w)\\1{2,}";
        Pattern p = Pattern.compile(pattern);
        // 获取字符串中所有符合模式的匹配
        Matcher matcher = p.matcher(line);
        while (matcher.find()) {
            line.delete(matcher.start(), matcher.end());
            // System.out.println(matcher.group(0));
            // System.out.println("matcher.start() = " + matcher.start());
            // System.out.println("matcher.end() = " + matcher.end());
            matcher = p.matcher(line);
        }
        System.out.println(line);
    }
}

