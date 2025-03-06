import matplotlib.pyplot as plt
import networkx as nx

# Node class for BST
class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

# Binary Search Tree class
class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, key):
        if self.root is None:
            self.root = Node(key)
        else:
            self._insert_recursive(self.root, key)

    def _insert_recursive(self, node, key):
        if key < node.key:
            if node.left is None:
                node.left = Node(key)
            else:
                self._insert_recursive(node.left, key)
        else:
            if node.right is None:
                node.right = Node(key)
            else:
                self._insert_recursive(node.right, key)

    def delete(self, key):
        self.root = self._delete_recursive(self.root, key)

    def _delete_recursive(self, node, key):
        if node is None:
            return node
        if key < node.key:
            node.left = self._delete_recursive(node.left, key)
        elif key > node.key:
            node.right = self._delete_recursive(node.right, key)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            temp_val = self._min_value_node(node.right).key
            node.key = temp_val
            node.right = self._delete_recursive(node.right, temp_val)
        return node

    def _min_value_node(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current

# Function to add nodes and edges to the graph for visualization
def add_edges(graph, node, pos, parent=None, x=0, y=0, level=1):
    if node:
        graph.add_node(node.key, pos=(x, y))
        pos[node.key] = (x, y)
        if parent:
            graph.add_edge(parent, node.key)
        spacing = 1.0 / (2 ** level)
        add_edges(graph, node.left, pos, node.key, x - spacing, y - 1, level + 1)
        add_edges(graph, node.right, pos, node.key, x + spacing, y - 1, level + 1)

# Function to visualize and save BST
def save_bst_image(bst, filename, title):
    graph = nx.DiGraph()
    pos = {}
    add_edges(graph, bst.root, pos)
    plt.figure(figsize=(8, 5))
    nx.draw(graph, pos, with_labels=True, node_size=2000, node_color="lightblue", font_size=12, font_weight="bold", edge_color="gray")
    plt.title(title)
    plt.savefig(filename)  # Save the image
    plt.close()  # Close plot to avoid overlap

# Step 1: Insert elements into BST and save initial visualization
bst = BinarySearchTree()
elements = [15, 23, 20, 10, 13, 6, 18, 35, 9, 24]

for elem in elements:
    bst.insert(elem)

save_bst_image(bst, "BST_Before_Deletion.png", "BST Before Deletion")

# Step 2: Perform deletions and save images
deletions = [6, 15, 20]
for key in deletions:
    bst.delete(key)
    save_bst_image(bst, f"BST_After_Deleting_{key}.png", f"BST After Deleting {key}")

print("BST graphs generated and saved successfully.")
