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
        int index = 0, result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                if (result == -1) {
                    result = i;
                }
                if (index == needle.length() - 1) {
                    return result;
                }
                index++;
            } else {
                result = -1;
            }
        }
        return index == needle.length() ? result : -1;
    }

    public static void main(String[] args) {
        String hayStack = "mississippi";
        String needle = "issip";
        ImplementStr implementStr = new ImplementStr();
        System.out.println(implementStr.strStr(hayStack, needle));
    }
}
