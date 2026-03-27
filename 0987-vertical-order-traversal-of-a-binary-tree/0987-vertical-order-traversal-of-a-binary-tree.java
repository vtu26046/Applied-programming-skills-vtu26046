import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> row -> min heap (for sorting values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        traverse(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }

            result.add(colList);
        }

        return result;
    }

    private void traverse(TreeNode node, int row, int col,
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {

        if (node == null) return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);


        // left: col - 1, right: col + 1
        traverse(node.left, row + 1, col - 1, map);
        traverse(node.right, row + 1, col + 1, map);
    }
}