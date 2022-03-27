package taxXin;

/**
 *date：2022-03-14
 *
 * message ：968. 监控二叉树
 *
 * work :给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class tanXinOneHundredSixtySix20220315 {
    public static void main(String[] args){}


    static int sum = 0;
    //贪心思路：局部贪心主要是 在叶子节点的父节点上 放监控器，这样就可以覆盖<子节点 本身节点 父节点>三层，
    //        整体贪心主要是 遍历全部节点
    //节点有三种状态 0 --该节点不可观察
    //             1 --该节点安装了监控器
    //              2 --该节点可以观察，但是没有安装监控器(空节点 也算2状态，这样可以保证我们的贪心思路)
    static public int minCameraCover(TreeNode root) {
        if(root.left == null && root.right == null)
            return 1;
        int reuslt = backIng(root);
        //情况4：最后返回的是根节点的状态，如果为0--代表根节点没有被监控到，需要在根节点上在放置一个监控器
        if (reuslt == 0)
            sum++;
        return sum;

    }

    static public int backIng(TreeNode root){
        //空节点---可以观察，但是没有安装监控器
        if (root == null)
            return 2;
        int left = backIng(root.left);
        int right = backIng(root.right);
        //情况1：当左右子节点  当中至少有一个节点状态是0（不可观测）--就需要在该节点放置一个监控器，同时返回自身节点状态为1（已经放置监控）
        if (left == 0 || right == 0){
            sum++;
            return 1;
        }
        //情况2：当左右子节点  当中至少有一个节点状态为1（已经放置监控），代表该节点已经能被观察到，返回自身节点状态为2（能观察，但没有监控）
        else if (left == 1 || right == 1) {
            return 2;
        }
        //情况3：当左右子节点  状态全部为2（能观察，但没有监控），表明该节点没有监控能观察到，返回自身节点状态为0（不可观察）
        else if (left == 2 && right == 2) {
           return 0;
        }else{
            return 0;
        }

    }
}
