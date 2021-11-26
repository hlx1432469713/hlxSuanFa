import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *date：2021-11-23
 *
 * message ： N 叉树的层序遍历
 *
 * work:给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 *树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 */
public class TreeNodeThirtyFour2021123 {
    public static void main(String[] args){


    }
    //借助辅助队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> item = new ArrayList<>();
            while(length > 0){
                TreeNode treeNode = queue.poll();
                item.add(treeNode.val);
                if(treeNode.children!=null && treeNode.children .size() > 0){
                    List<TreeNode> list1 = treeNode.children;
                    for(TreeNode node:list1)
                        queue.offer(node);
                }
                length--;
            }
            list.add(item);
        }
        return list;
    }

    //递归
    List<List<Integer>> list1 = new ArrayList<>();
    public void levelOrder2(TreeNode root,int deep) {
      if(root == null)
          return;
      deep++;
      if(list1.size() < deep){
          List<Integer> item = new ArrayList<>();
          list1.add(item);
      }
      list1.get(deep-1).add(root.val);
      for(TreeNode node : root.children)
          levelOrder2(node,deep);
    }

}
