class Solution {
    Trie root = new Trie();
    int res = 0;

    class Trie {
        Trie[] memo = new Trie[10];
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie cur = root;
        for (int a : arr1) {
            add(a);
        }
        for (int a : arr2) {
            int sum = search(a);
            res = Math.max(res, sum);
        }
        return res;
    }

    private void add(int i) {
        Trie cur = root;
        String str = String.valueOf(i);
        char[] ch = str.toCharArray();
        for (int j = 0; j < ch.length; j++) {
            if (cur.memo[ch[j] - '0'] == null) {
                cur.memo[ch[j] - '0'] = new Trie();
            }
            cur = cur.memo[ch[j] - '0'];
        }
    } 

    private int search(int i) {
        int sum = 0;
        Trie cur = root;
        String str = String.valueOf(i);
        char[] ch = str.toCharArray();
        for (int j = 0; j < ch.length; j++) {
            int digit = ch[j] - '0';
            if (cur.memo[digit] == null) {
                break;
            }
            cur = cur.memo[digit];
            sum++;
        }
        return sum;
    }


}