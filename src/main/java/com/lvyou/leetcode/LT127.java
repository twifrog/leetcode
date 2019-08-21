package com.lvyou.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: VernLv
 * @Data: Create in 18:54 2019/8/21
 */
public class LT127 {
    //递归
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dic = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord)) {
            return 0;
        }

        return bfs(start,end,dic,2);
    }

    private int bfs(Set<String> start, Set<String> end, Set<String> dic, int l){
        if (start.size() == 0) {
            return 0;
        }
        if (start.size() > end.size()){
            return bfs(end, start, dic, l);
        }
        dic.remove(start);
        Set<String> nextLevel = new HashSet<>();
        for (String s: start) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++){
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++){
                    if (temp == c) {
                        continue;
                    }
                    chars[i] = c;
                    String tempstr = new String(chars);
                    if (dic.contains(tempstr)) {
                        if (end.contains(tempstr)){
                            return l;
                        }
                        nextLevel.add(tempstr);
                    }
                }
                chars[i] = temp;
            }
        }
        return bfs(nextLevel,end,dic,l+1);
    }






//    public int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
//        //双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
//        if (st.size() == 0) return 0;
//        if (st.size() > ed.size()) {//双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
//            return bfs(ed, st, dic, l);
//        }
//        //BFS的标记行为，即使用过的不重复使用
//        dic.removeAll(st);
//        //收集下一层临近点
//        HashSet<String> next = new HashSet<>();
//        for (String s : st) {
//            char[] arr = s.toCharArray();
//            for (int i = 0; i < arr.length; i++) {
//                char tmp = arr[i];
//                //变化
//                for (char c = 'a'; c <= 'z'; c++) {
//                    if (tmp == c) continue;
//                    arr[i] = c;
//                    String nstr = new String(arr);
//                    if (dic.contains(nstr)) {
//                        if (ed.contains(nstr)) return l;
//                        else next.add(nstr);
//                    }
//                }
//                //复原
//                arr[i] = tmp;
//            }
//        }
//        return bfs(next, ed, dic, l + 1);
//    }
}
