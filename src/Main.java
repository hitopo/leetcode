import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 一个饼干，且只有饼干的大小不小于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩子
 * 可以吃饱
 */
public class Main {
    public static void main(String[] args) {
        int[] children = {1, 2, 3};
        int[] cookie = {4, 5, 1};
        Arrays.sort(children);
        Arrays.sort(cookie);
        Set<Integer> eatCookieIdxSet = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < children.length; i++) {
            for (int j = 0; j < cookie.length; j++) {
                if (!eatCookieIdxSet.contains(j) && children[i] <= cookie[j]) {
                    cnt++;
                    eatCookieIdxSet.add(j);
                }
            }
        }
        System.out.println(cnt);
    }
}

