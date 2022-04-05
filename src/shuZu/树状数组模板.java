package shuZu;

public class 树状数组模板 {
    int[] tree;
    int n ;
    //2^k = i&(-i);
    int lowbit(int x){
        return x & -x;
    }
    //查询前缀和的方法
    int query(int x){
        int ans = 0;
        for(int i = x;i > 0;i -= lowbit(i))
            ans += tree[i];
        return ans;
    }
    //在树状数组x位置增加值u
    void add(int x,int u){
        for(int i = x;i <= n ;i+= lowbit(i)){
            tree[i] += u;
        }
    }
}
