package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class HedgehogExample {

    private static List<String> readFile() throws IOException {
        final String fileName="/input-file.txt";
        String dataset = System.getProperty("user.dir") + "/src/main/java/com/example" + fileName;
        System.out.println(dataset);
        List<String> allLines = Files.readAllLines(Paths.get(dataset));
        return allLines;
    }

    public static void main(String[] args) {
        try {
            List<String> allLines = readFile();
            int m = 0, n = 0;
            int[][] arr = null;
            String line = null;
            String[] strArr;
            int index = 0;
            for (int z = 0; z < allLines.size(); z++) {
                line = allLines.get(z);
                // if there is/are an extra line with space or whatever then do not process and ignore further reading
                if ("".equalsIgnoreCase(line.trim())) {
                    continue;
                }
                System.out.println(line);
                strArr = line.split(" ");
                if (z == 0) { // reading first line and storing in M and N variables as row and column respectively
                    m = Integer.parseInt(strArr[0]);
                    n = Integer.parseInt(strArr[1]);
                    arr = new int[m][n];
                } else {
                    // reading rest of lines one by one and storing in arr of M x N
                    for (int j = 0; j < n; j++) {
                        arr[index][j] = Integer.parseInt(strArr[j]);
                    }
                    index++;
                }
            }
            System.out.println("=========================================");
            Arrays.stream(arr).forEach(x -> System.out.println(Arrays.toString(x)));

            // creating a tree with specified requirement as lower and right
            Node<Integer> node = helper(arr, 0, 0, m, n);

            System.out.println("===============================================");

            // calculating max eat or picked apple
            System.out.println("Maximum no. of Apples collected by Hedgehog " + calculateMaxApples(node));
            System.out.println("===============================================");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static Node<Integer> helper(int[][] num, int a, int b, int M, int N) {
        if (a >= M || b >= N) { // Done
            return null;
        }
        Node<Integer> node = new Node<>(num[a][b]);
        node.lower = helper(num, a + 1, b, M, N);
        node.right = helper(num, a, b + 1, M, N);
        return node;
    }

    private static int calculateMaxApples(final Node<Integer> root) {
        int r = 0;
        if (root == null) return 0;
        else {
            r += root.getValue();
            root.setVisited(true);
            if (root.lower != null && root.right != null) {
                if (root.lower.getValue() >= root.right.getValue()) {
                    root.lower.setVisited(true);
                    root.right.setVisited(true);
                    r += calculateMaxApples(root.lower);
                } else {
                    root.lower.setVisited(true);
                    root.right.setVisited(true);
                    r += calculateMaxApples(root.right);
                }
            } else if (root.lower != null) {
                root.lower.setVisited(true);
                r += calculateMaxApples(root.lower);
            } else if (root.right != null) {
                root.right.setVisited(true);
                r += calculateMaxApples(root.right);
            }
        }
        return r;
    }
}
