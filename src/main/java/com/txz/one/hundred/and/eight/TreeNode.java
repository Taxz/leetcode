package com.txz.one.hundred.and.eight;

/**
 * Created by Taxz on 2019/1/26/026.
 * GitHub:https://github.com/Taxz
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode tree = createTree(nums, 0, nums.length - 1);

    }

    private static TreeNode createTree(int[] nums, int start, int end) {
        if (nums == null || start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);
        return root;
    }

}
