import java.util.*;

/**
 * Created by pmg on 2015/11/9.
 * Find the number connected component in the undirected graph. Each node in
 * the graph contains a label and a list of its neighbors. (a connected
 * component (or just component) of an undirected graph is a subgraph in which
 * any two vertices are connected to each other by paths, and which is connected
 * to no additional vertices in the supergraph.)
 * 答案要求从小到大排序!!
 * 使用DFS也可
 */

public class GraphConnectedComponent {
    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    private static HashMap<Integer, Boolean> marked;
    public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        marked = new HashMap<Integer, Boolean>();
        int cnt = 0;
        List<List<Integer>> CC =  new ArrayList<List<Integer>>();

        // constructing the Hash table, it maps the label to a boolean variable
        // indicates whether it has been visited.
        for (UndirectedGraphNode node : nodes) {
            marked.put(node.label, false);
        }

        for (UndirectedGraphNode node : nodes) {
            if (!marked.get(node.label)) {
                CC.add(cnt, new ArrayList<Integer>());
                bfs(node, CC.get(cnt++));
            }
        }
        return CC;
    }

    private static void bfs(UndirectedGraphNode node, List<Integer> components) {
        LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node); marked.put(node.label, true);
        while (!q.isEmpty()) {
            UndirectedGraphNode x = q.remove();
            components.add(x.label);
            for (UndirectedGraphNode neighbor : x.neighbors)
                if (!marked.get(neighbor.label)) {
                    q.add(neighbor); marked.put(neighbor.label, true);
                }
        }
        Collections.sort(components);    // lintcode 答案要求从小到大排序!!
    }

    public static void main(String[] args) {
        // constructing a graph
        // 1 ----- 2  3
        //  \      |  |
        //   \     |  |
        //    \    |  |
        //     \   |  |
        //        4   5

        UndirectedGraphNode x1 = new UndirectedGraphNode(1);
        UndirectedGraphNode x2 = new UndirectedGraphNode(2);
        UndirectedGraphNode x3 = new UndirectedGraphNode(3);
        UndirectedGraphNode x4 = new UndirectedGraphNode(4);
        UndirectedGraphNode x5 = new UndirectedGraphNode(5);

        x1.neighbors = new ArrayList<UndirectedGraphNode>();
        x2.neighbors = new ArrayList<UndirectedGraphNode>();
        x3.neighbors = new ArrayList<UndirectedGraphNode>();
        x4.neighbors = new ArrayList<UndirectedGraphNode>();
        x5.neighbors = new ArrayList<UndirectedGraphNode>();

        x1.neighbors.add(x2); x1.neighbors.add(x4);
        x2.neighbors.add(x1); x2.neighbors.add(x4);
        x3.neighbors.add(x5);
        x4.neighbors.add(x1); x4.neighbors.add(x2);
        x5.neighbors.add(x3);

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        nodes.add(x1); nodes.add(x2); nodes.add(x3); nodes.add(x4); nodes.add(x5);
        List<List<Integer>> out = connectedSet(nodes);

        for (int i = 0; i < out.size(); i++) {
            List<Integer> set = out.get(i);
            for (int j = 0; j < set.size(); j++)
                System.out.print(set.get(j) + ", ");
            System.out.println();
        }
    }
}
