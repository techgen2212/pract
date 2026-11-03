
import heapq

# Class to create nodes of Huffman Tree
class Node:
    def __init__(self, char, freq):
        self.char = char       # Store character
        self.freq = freq       # Store frequency of character
        self.left = None       # Left child of node
        self.right = None      # Right child of node

    # Compare two nodes according to their frequency
    def __lt__(self, other):
        return self.freq < other.freq


# Function to generate Huffman Codes
def huffman(text):

    # Step 1: Count frequency of each character
    freq = {}
    for ch in text:
        freq[ch] = freq.get(ch, 0) + 1

    # Step 2: Create a Min Heap using characters and frequencies
    heap = [Node(ch, f) for ch, f in freq.items()]
    heapq.heapify(heap)  # Arrange nodes in minimum frequency order

    # If input contains only one unique character
    if len(heap) == 1:
        return {heap[0].char: "0"}

    # Step 3: Build the Huffman Tree
    while len(heap) > 1:

        # Remove two nodes having the lowest frequency
        left = heapq.heappop(heap)
        right = heapq.heappop(heap)

        # Create a new parent node by adding their frequencies
        new = Node(None, left.freq + right.freq)

        # Connect both nodes to the new parent node
        new.left = left
        new.right = right

        # Insert the new node back into the Min Heap
        heapq.heappush(heap, new)

    # Step 4: Generate binary codes for each character
    codes = {}

    def generate(node, code):

        # If the node is a leaf node, store its binary code
        if node.char is not None:
            codes[node.char] = code
            return

        # Add 0 when moving to the left child
        generate(node.left, code + "0")

        # Add 1 when moving to the right child
        generate(node.right, code + "1")

    # Start generating codes from the root node
    generate(heap[0], "")

    # Return the dictionary containing Huffman Codes
    return codes


# Main Program

# Accept a string from the user
text = input("Enter a string: ")

# Call Huffman function to generate codes
codes = huffman(text)

# Display Huffman Codes
print("\nHuffman Codes:")
for ch, code in codes.items():
    print(ch, ":", code)

# Replace each character with its Huffman binary code
encoded = "".join(codes[ch] for ch in text)

# Display the final encoded string
print("\nEncoded String:", encoded)
