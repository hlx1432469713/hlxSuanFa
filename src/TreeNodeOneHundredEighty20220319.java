import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *date：2022-03-19
 *
 * message : 606. 根据二叉树创建字符串
 *
 * work :
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 */
public class TreeNodeOneHundredEighty20220319 {
    public static void main(String args[]){

    }
    StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode root) {
        backIng(root);
        return String.valueOf(stringBuilder.substring(1,stringBuilder.length() - 1));
    }

    public void backIng(TreeNode root){
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        if(root.left != null)
            backIng(root.left);
        else if(root.right != null){
            stringBuilder.append("()");
        }
        if(root.right != null)
            backIng(root.right);
        stringBuilder.append(")");
    }

}
