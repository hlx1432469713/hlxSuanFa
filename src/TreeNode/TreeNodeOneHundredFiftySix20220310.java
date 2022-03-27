package TreeNode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-10
 *
 * message : 589. N 叉树的前序遍历
 *
 * work : 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 *

 */
public class TreeNodeOneHundredFiftySix20220310 {
    public static void main(String args[]){

    }
    static List<Integer> list = new ArrayList<>();
    static public List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        //preorderList(root);
        return list;

    }

    //由于没有Node节点 、先注释（已100%通过）
//    static public void preorderList(Node root){
//        if (root == null)
//            return;
//        list.add(root.val);
//        if (root.children == null)
//            return;
//        for (int i = 0;i < root.children.size();i++){
//            preorder(root.children.get(i));
//        }
   // }


}
