package jingsai;

/**
 *date：2022-03-20
 *
 * message :2211. 统计道路上的碰撞次数
 *
 * work : 在一条无限长的公路上有 n 辆汽车正在行驶。汽车按从左到右的顺序按从 0 到 n - 1 编号，每辆车都在一个 独特的 位置。
 *
 * 给你一个下标从 0 开始的字符串 directions ，长度为 n 。directions[i] 可以是 'L'、'R' 或 'S'
 * 分别表示第 i 辆车是向 左 、向 右 或者 停留 在当前位置。每辆车移动时 速度相同 。
 *
 * 碰撞次数可以按下述方式计算：
 *
 * 当两辆移动方向  相反   的车相撞时，碰撞次数加 2 。
 * 当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1 。
 * 碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置。除此之外，汽车不能改变它们的状态或移动方向。
 *
 * 返回在这条道路上发生的 碰撞总次数 。
 */
public class ten20220320 {
    public static void main(String[] args) {
    }

    static public int countCollisions(String directions) {
        if(directions.length() == 1)
            return 0;
        int sum = 0;
        char[] list = directions.toCharArray();
        boolean flag = false;
        int count = 0;
        for(int i = 0;i < list.length - 1;){
            if(list[i] == 'R')
                count++;
            if(list[i] == 'R' && list[i + 1] == 'L' ){
                sum += 2;
                sum += count - 1;
                count = 0;
                flag = true;
                i += 2;
            }else if(list[i] == 'R' && list[i + 1] == 'S'){
                sum += 1;
                sum += count - 1;
                count = 0;
                flag = true;
                i += 2;
            }else if(list[i] == 'L' && flag) {
                sum += 1;
                i += 1;

            }else if(list[i] == 'S'){
                flag = true;
                i += 1;
            }else{
                i += 1;
            }
            if(i == list.length - 1){
                if(list[i] == 'L' && flag)
                    sum++;
            }
        }
        return sum;
    }
}
