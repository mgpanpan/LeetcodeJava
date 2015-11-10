import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pmg on 2015/11/10.
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 *
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 *
 * Note
 * You can assume that there is at least one topological order in the graph.
 *
 * Challenge
 * Can you do it in both BFS and DFS?   (BFS???)
 *
 */

public class TopologicalSorting
{
    static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    }

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */

    // toplogical order is the post reversed order
    private static ArrayList<DirectedGraphNode> postReversed;
    private static HashMap<Integer, Boolean> marked;
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        postReversed = new ArrayList<DirectedGraphNode>();
        marked = new HashMap<Integer, Boolean>();
        for (DirectedGraphNode v : graph)
            marked.put(v.label, false);
        for (DirectedGraphNode v : graph)
            if (!marked.get(v.label))
                dfs(v);
        return postReversed;
    }

    private static void dfs(DirectedGraphNode v) {
        marked.put(v.label, true);
        for (DirectedGraphNode w : v.neighbors)
            if (!marked.get(w.label))
                dfs(w);
        postReversed.add(0, v);
    }
}
