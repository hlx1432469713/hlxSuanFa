package sort;

/**
 * 归并排序
 */
public class GuiBingSort {

    public static void main(String[] args) {
        int[] nums= new int[] { 1, 3, 7, 8, 2, 9, 6, 0, 5, 4 };
        sort(nums, 0, nums.length-1);
        for (int num : nums)
            System.out.print(num+" ");
    }
    private static void sort(int[] nums,int start,int end){
        //如果start == end 表明此时数组中只有一个元素，那这样也就用不着排序
        if(start < end){
            //进行分割，将数组分成两等份
            int mid = start + (end - start) / 2;
            sort(nums,start,mid);
            sort(nums,mid + 1,end);
            merge(nums,start,end);
        }
    }
    //辅助函数。进行两个分割数组的有序合并
    public static void merge(int[] nums,int left,int right){
        int[] tmp = new int[nums.length];
        int mid = left + (right - left) / 2;
        int p1 = left;
        int p2 = mid + 1;
        int k = left;
        while(p1 <= mid && p2 <= right){
            if(nums[p1] <= nums[p2])
                tmp[k++] = nums[p1++];
            else
                tmp[k++] = nums[p2++];
        }
        while(p1 <= mid)
            tmp[k++] = nums[p1++];
        while(p2 <= right)
            tmp[k++] = nums[p2++];
        for(int i = left;i <= right;i++)
            nums[i] = tmp[i];
    }
}
