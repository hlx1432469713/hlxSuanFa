package hash;


/**
 *date：2022-04-02
 *
 * message : 2156. 查找给定哈希值的子串
 *
 * work :给定整数 p和 m，一个长度为 k且下标从 0开始的字符串s的哈希值按照如下函数计算：
 *
 * hash(s, p, m) = (val(s[0]) * p0 + val(s[1]) * p1 + ... + val(s[k-1]) * pk-1) mod m.
 * 其中val(s[i])表示s[i]在字母表中的下标，从val('a') = 1 到val('z') = 26。
 *
 * 给你一个字符串s和整数power，modulo，k和hashValue。请你返回 s中 第一个 长度为 k的 子串sub，
 * 满足hash(sub, power, modulo) == hashValue。
 *
 * 测试数据保证一定 存在至少一个这样的子串。
 *
 * 子串 定义为一个字符串中连续非空字符组成的序列。
 *
 */
public class hashTwoHundredFifteen20220402 {
    public static void main(String args[]){}

    //公式 1： (a * b) % m = ((a % m) * (b % m)) % m
    //公式 2： (a + b) % m = (a % m + b % m) % m
    static    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        for(int i = 0;i <= s.length() - k;i++){
            if(getHashValue(s,power,modulo,k,i) == hashValue){
                return s.substring(i,i + k);
            }
        }
        return null;

    }
    static public long getHashValue(String s,int p,int m,int k,int start){
        long sum = 0;
        long e = 1;
        for (int i = start;i<start + k;i++){
            int x =(s.charAt(i) - 'a' + 1) % m;
            sum += (x * e) % m;
            e = e * p % m;
        }
        return sum % m;
    }
}
