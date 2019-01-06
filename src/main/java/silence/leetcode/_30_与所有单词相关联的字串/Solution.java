package silence.leetcode._30_与所有单词相关联的字串;


import java.util.*;

/**
 * @author zhouqi
 * @date 2018/11/28
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.equals("") || words.length == 0) {
            return res;
        }
        SortedMap<Integer, Set<String>> map = new TreeMap<Integer, Set<String>>();
        for (String word : new HashSet<String>(Arrays.asList(words))) {
            int x = 0;
            while (true) {
                int i = s.indexOf(word, x);
                if (i >= 0) {
                    Set<String> wordSet = map.get(i);
                    if (wordSet == null) {
                        wordSet = new HashSet<String>();
                        wordSet.add(word);
                        map.put(i, wordSet);
                    } else {
                        wordSet.add(word);
                    }
                    x = i + 1;
                } else {
                    break;
                }
            }
            if (x == 0) {
                return res;
            }
        }
        int size = map.size();
        for (int i = 0; i <= size - words.length; i++) {
            Boolean check = check(map, Arrays.asList(words));
            Integer firstKey = map.firstKey();
            if (check) {
                res.add(firstKey);
            }
            map = map.tailMap(firstKey + 1);
        }
        return res;
    }

    public Boolean check(SortedMap<Integer, Set<String>> map, List<String> words) {
        if (map.size() < words.size()) {
            return false;
        }
        Integer firstKey = map.firstKey();
        Set<String> strings = map.get(firstKey);
        for (String string : strings) {
            if(words.contains(string)){
                List<String> list = new ArrayList<String>(words);
                list.remove(string);
                if(list.size()==0){
                    return true;
                }
                if(map.containsKey(firstKey + string.length())){
                    return check(map.tailMap(firstKey + string.length()), list);
                }
            }
        }
        return false;
    }

 public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        //String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String s ="aaaaa";
        List<Integer> barfoothefoobarman = new Solution().findSubstring(s, new String[]{"aa","aa","aa"});
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}