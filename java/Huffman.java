
import java.util.*;

public class Huffman {

    // Node of Huffman Tree
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    // Store Huffman codes of characters
    static Map<Character, String> codes = new HashMap<>();

    // Generate Huffman codes by traversing the tree
    static void generateCodes(Node root, String code) {

        if (root == null)
            return;

        // If leaf node, store its character and code
        if (root.left == null && root.right == null) {

            // For a single character, assign code 0
            if (code.isEmpty())
                code = "0";

            codes.put(root.ch, code);

            System.out.println(root.ch + " : " + code);
            return;
        }

        // Left branch represents 0
        generateCodes(root.left, code + "0");

        // Right branch represents 1
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Check if input is empty
        if (str.isEmpty()) {
            System.out.println("Please enter a valid string.");
            sc.close();
            return;
        }

        // Step 1: Count frequency of each character
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create Priority Queue
        // Lowest frequency is given highest priority
        // For equal frequencies, higher character comes first
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {

            if (a.freq != b.freq)
                return Integer.compare(a.freq, b.freq);

            return Character.compare(b.ch, a.ch);
        });

        // Step 3: Insert characters into Priority Queue
        for (char ch : freq.keySet()) {
            pq.add(new Node(ch, freq.get(ch)));
        }

        // Step 4: Build Huffman Tree
        while (pq.size() > 1) {

            // Remove two nodes with minimum frequency
            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new parent node
            Node parent = new Node('\0',
                    left.freq + right.freq);

            parent.left = left;
            parent.right = right;

            // Insert parent node back into queue
            pq.add(parent);
        }

        // Step 5: Generate Huffman Codes
        Node root = pq.poll();

        System.out.println("\nHuffman Codes:");
        generateCodes(root, "");

        // Step 6: Generate Encoded String
        StringBuilder encoded = new StringBuilder();

        for (char ch : str.toCharArray()) {
            encoded.append(codes.get(ch));
        }

        // Display final encoded string
        System.out.println("\nEncoded String: " + encoded);

        sc.close();
    }
}
