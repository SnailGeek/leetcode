package easy.q_28_implement_strStr;

/**
 * @program: ImplementStr
 * @description:
 * @author: wangf-q
 * @date: 2020-06-20 14:07
 **/
public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            result = i;
            for (int j = i; j < haystack.length(); j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    break;
                }
                if (j - i == needle.length() - 1) {
                    return result;
                }
            }

        }
        return result == haystack.length() - 1 ? -1 : result;
    }

    public static void main(String[] args) {
//        String hayStack = "mississippi";
//        String needle = "issip";

        String hayStack = "baaaa";
        String needle = "aaa";
        ImplementStr implementStr = new ImplementStr();
        System.out.println(implementStr.strStr(hayStack, needle));
    }
}
