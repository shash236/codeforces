package round926;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemD {
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

        Map<Integer,List<Integer>> edgeList = new HashMap<>();

        for(int i = 0; i < n-1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            addToEdgeList(u, v, edgeList);
            addToEdgeList(v, u, edgeList);   
        }

        int count = dfs(1, -1, edgeList, new HashMap<>(), 0);
    }

    private static void addToEdgeList(int u, int v, Map<Integer, List<Integer>> edgeList) {
        List<Integer> uList = edgeList.get(u);
        if (uList == null) {
            uList = new ArrayList<>();
            edgeList.put(u, uList);
        }
        uList.add(v);
    }


    private static int dfs(Integer current, Integer previous, 
        Map<Integer, List<Integer>> edgeList, Map<Integer, Integer> connectionsCountMap, int count) {
        count += calculateCount(current, previous, count, connectionsCountMap);
        List<Integer> connectedNodes = edgeList.get(current);
        for (Integer node : connectedNodes) {
            if(node == previous) continue;
            count = dfs(node, current, edgeList, connectionsCountMap, count);
        }
        return count;
    }

    private static int calculateCount(int u, int v, int count, Map<Integer, Integer> connectionsCountMap) {
        if(v == -1) return 0;
        int additions = 0;
        Integer uConnectionsCount = connectionsCountMap.get(u);
        Integer vConnectionsCount = connectionsCountMap.get(v);

        if (uConnectionsCount == null && vConnectionsCount == null) {
            connectionsCountMap.put(u, 1);
            connectionsCountMap.put(v, 1);
        } else if (uConnectionsCount == null) {
            additions = count + vConnectionsCount;
            connectionsCountMap.put(u, 1);
            connectionsCountMap.put(v, vConnectionsCount + 1);
        } else if (vConnectionsCount == null) {
            additions = count += count + uConnectionsCount;
            connectionsCountMap.put(v, 1);
            connectionsCountMap.put(u, uConnectionsCount + 1);
        }

        return additions;

    }


}
