import java.util.*;

/**
 *date：2022-03-11
 *
 * message : 590. N 叉树的后序遍历
 *
 * work :给定一个 n叉树的根节点root，返回 其节点值的 后序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 *
 *

 */
public class TreeNodeOneHundredSixtyTwo20220312 {
    public static void main(String args[]){}

    //先将数组转换成二叉树，然后通过后序遍历  遍历整棵树
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        postOrderList(root);
        return list;
    }
    public void postOrderList(Node root){
        if (root == null)
            return;
        List<Node> children = root.children;

        for (Node child : children) {
            postOrderList(child);
        }
        list.add(root.val);

    }
}
