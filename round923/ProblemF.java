package round923;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemF {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) {
            solve(scanner);
        }
 
        scanner.close();
    }
 
    private static void solve(final Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer,Map<Integer,Integer>> graphMap = new HashMap<>();

        for(int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            putInGraphMap(graphMap, u, v, w);
            putInGraphMap(graphMap, v, u, w);
        }

        final Soln soln = new Soln();
        final Set<Integer> allVisited = new HashSet<>();
        final Deque<Integer> visitedStack = new LinkedList<>();
        final Set<Integer> visitedSet = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            dfs(i, -1, graphMap, soln, visitedStack, visitedSet, allVisited,n);
        }
        System.out.println(soln.minWeight + " " + soln.minWeightCycleNodes.size());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : soln.minWeightCycleNodes) {
            stringBuilder.append(integer).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static void dfs(int node, int parentNode, Map<Integer,Map<Integer,Integer>> graphMap, final Soln soln, final Deque<Integer> visitedStack,
        final Set<Integer> visitedSet, final Set<Integer> allVisited, int n) {
        if(visitedSet.contains(node)){
            final Deque<Integer> visitedStackCopy = new LinkedList<>(visitedStack);
            final List<Integer> cycleNodeList = new ArrayList<>();
            int minWeightOfCycle = Integer.MAX_VALUE;
            int currentNode = node;
            do{
                minWeightOfCycle = Math.min(minWeightOfCycle,getFromGraphMap(graphMap, currentNode, visitedStackCopy.peek()));
                cycleNodeList.add(currentNode);
                currentNode = visitedStackCopy.pop();
            } while(currentNode!=node);

            if(minWeightOfCycle < soln.minWeight){
                soln.minWeight = minWeightOfCycle;
                soln.minWeightCycleNodes = cycleNodeList;
            }
        }
        else if(allVisited.contains(node)) {
            return;
        }
        else {
            visitedStack.push(node);
            visitedSet.add(node);
            allVisited.add(node);
            for(int i = 1; i <= n; i++) {
                if(getFromGraphMap(graphMap, node, i) == 0) continue;
                if(i == parentNode) continue;
                dfs(i,node,graphMap,soln,visitedStack,visitedSet,allVisited,n);
            }
            visitedStack.pop();
            visitedSet.remove(node);
        }

    }

    private static class Soln {
        List<Integer> minWeightCycleNodes;
        Integer minWeight;

        Soln() {
            this.minWeightCycleNodes = new ArrayList<>();
            this.minWeight = Integer.MAX_VALUE;
        }
    }

    private static void putInGraphMap(Map<Integer, Map<Integer, Integer>> graphMap, int u, int v, int w) {
        Map<Integer, Integer> uMap = graphMap.get(u);
        if (uMap == null) {
            uMap = new HashMap<>();
            graphMap.put(u, uMap);
        }
        uMap.put(v, w);
    }

    private static int getFromGraphMap(Map<Integer, Map<Integer, Integer>> graphMap, int u, int v) {
        Map<Integer, Integer> uMap = graphMap.get(u);
        if(uMap == null) return 0;
        Integer wVal = uMap.get(v);
        if(wVal == null) return 0;
        return wVal;
    }
}