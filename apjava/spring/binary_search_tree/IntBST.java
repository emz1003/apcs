public class IntBST {

	// instance variables
	private TreeNode<Integer> root;
	private int size;

	private static class TreeNode<Integer> {
		private Integer value;
		private TreeNode<Integer> left, right;

		public TreeNode(Integer value, TreeNode<Integer> left, TreeNode<Integer> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		// accessors
		public Integer getValue() {
			return value;
		}

		public TreeNode<Integer> getLeft() {
			return left;
		}

		public TreeNode<Integer> getRight() {
			return right;
		}

		// mutators

		public void setValue(Integer i) {
			value = i;
		}

		public void setLeft(TreeNode<Integer> n) {
			left = n;
		}

		public void setRight(TreeNode<Integer> n) {
			right = n;
		}

	}

	public IntBST() {
		root = null;
		size = 0;
	}
	public int height() {
		return height(root);
	}

	private int height(TreeNode<Integer> r) {
		if (r == null) return 0;
		if (r.isLeaf()) return 0;
		return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
		// if (r.isLeaf()) return 1;
		
		// int left = getHeight(r.getLeft());
		// int right = getHeight(r.getRight());

		// return left > right ? left + 1 : right + 1;
		
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(TreeNode<Integer> r) {
		if (r == null) return true;
		if (r.isLeaf()) return true;
		if (Math.abs(height(r.getLeft()) - height(r.getRight())) > 1) return false;
		return isBalanced(r.getLeft()) && isBalanced(r.getRight());
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(TreeNode<Integer> r) {
		if (r == null) return 0;
		if (r.isLeaf()) return 1;
		return countLeaves(r.getLeft()) + countLeaves(r.getRight());
	}

	private TreeNode<Integer> find(Integer x) {
		return find(root, x);
	}

	private TreeNode<Integer> find(TreeNode<Integer> r, Integer x) {
		if (r != null){
			if (r.getValue() == x) return r;
			TreeNode<Integer> left = find(r.getLeft(), x);
			TreeNode<Integer> right = find(r.getRight(), x);
			if (left != null) return left;
			if (right != null) return right;
		}
		return null;
	}

	private TreeNode<Integer> findI(Integer x) {
		TreeNode<Integer> node = root;
		while (node != null) {
			if (node.getValue() == x) break;
			if (node.getValue() < x)
				node = node.getRight();
			else
				node = node.getLeft();
		}
		return node;
		
	}

	// Adds x into the IntBST as a leaf.
	public void add(Integer x) {
		root = add(x, root);
		size++;
	}

	private TreeNode<Integer> add(Integer x, TreeNode<Integer> rt) {
		if (rt == null)
			rt = new TreeNode<Integer>(x, null, null);
		else if (x <= rt.getValue())
			rt.setLeft(add(x, rt.getLeft()));
		else
			rt.setRight(add(x, rt.getRight()));
		return rt;
	}

	public void addI(Integer x) {
		if (root == null) {
			root = new TreeNode<Integer>(x, null, null);
			size++;
			return;
		}
		TreeNode<Integer> ref, trailRef = root;
		
		if (x > root.getValue()) ref = trailRef.getRight();
		else ref = trailRef.getLeft();
		while (ref != null) {
			trailRef = ref;
			if (x > ref.getValue()) {
				ref = ref.getRight();
			} else {
				ref = ref.getLeft();
			}
		}
		if (x > trailRef.getValue()) trailRef.setRight(new TreeNode<Integer>(x, null, null));
		else trailRef.setLeft(new TreeNode<Integer>(x, null, null));
		size++;
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	private void inorder(TreeNode<Integer> rt) {
		if (rt != null) {
			inorder(rt.getLeft());
			System.out.print(rt.getValue() + " ");
			inorder(rt.getRight());

		}
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(TreeNode<Integer> rt) {
		if (rt != null) {
			System.out.print(rt.getValue() + " ");
			preorder(rt.getLeft());
			preorder(rt.getRight());
		}
	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(TreeNode<Integer> rt) {
		if (rt != null) {
			postorder(rt.getLeft());
			postorder(rt.getRight());
			System.out.print(rt.getValue() + " ");
		}
	}

	public void printSideways() {
		printSideways(root, 0);
	}
	
	private void printSideways(TreeNode<Integer> rt, int h) {
		if (rt != null) {
			String blanks = "";
			for (int i = 0; i < h; i++) {
				blanks += "   ";
			}
			printSideways(rt.getRight(), ++h);
			System.out.println(blanks + rt.getValue());
			printSideways(rt.getLeft(), h);

		}
	}

	public TreeNode<Integer> maxNode() {
		return maxNode(root);
	}

	public TreeNode<Integer> minNode() {
		return minNode(root);
	}

	// Post: returns null if rt is null.
	private TreeNode<Integer> maxNode(TreeNode<Integer> rt) {
		if (rt == null) return null;
		if (rt.getRight() == null) return rt;
		return maxNode(rt.getRight());
	}

	// Post: returns null if rt is null.
	private TreeNode<Integer> minNode(TreeNode<Integer> rt) {
		if (rt == null) return null;
		if (rt.getLeft() == null) return rt;
		return minNode(rt.getLeft());
	}

	private TreeNode<Integer> getPrevious(TreeNode<Integer> node) {
		TreeNode<Integer> prevNode = null;
		while (node != null) {
			prevNode = node;
			if (node.getValue() == node.getValue())
				break;
			if (node.getValue() < node.getValue())
				node = node.getRight();
			else
				node = node.getLeft();
		}
		return prevNode;
	}

	public boolean remove(Integer x) {
		if (root == null) return false;
		TreeNode<Integer> node = find(x);
		if (node == null) return false;
		if (node.isLeaf()) {
			if (node.getValue() > getPrevious(node).getValue()) 
				getPrevious(node).setRight(null);
			else
				getPrevious(node).setLeft(null);
			node = null;
		} else if (node.getRight() == null) {
			TreeNode<Integer> max = maxNode(root.getLeft());
			node.setValue(max.getValue());
			max.setValue(null);
			getPrevious(max).setRight(null);
			remove(max.getValue());
		} else {
			TreeNode<Integer> min = minNode(root.getRight());
			node.setValue(min.getValue());
			min.setValue(null);
			getPrevious(min).setLeft(null);
			remove(min.getValue());
		}

		size--;
		return true;
	}

	public boolean remove(Integer x) {

	}

	public TreeNode<Integer> remove(Integer x, TreeNode<Integer> rt) {
		if (rt.isLeaf() && rt.getValue() == x) {
			rt = null;
			size--;
		}
		else if (rt.getValue()== x) {
			if(rt == null) return rt;
			if(rt.isLeaf && rt.getValue() == x)
			if(rt.getRight() == null) {
				Integer max = maxNode(rt.getLeft()).getValue();
				rt.setValue(max);
				rt.setLeft(remove(max, rt.getLeft()));
			}
			else {
				Integer min = minNode(rt.getRight()).getValue())
			}
		}
	}

	public static void main(String[] args) {
		IntBST bst = new IntBST();
		// bst.addI(5);
		// bst.addI(7);
		// bst.addI(4);
		// bst.addI(2);
		// bst.addI(6);
		// bst.addI(3);
		// bst.addI(8);
		// bst.addI(1);
		// bst.addI(9);
		// bst.preorder();
		// bst.inorder();
		// bst.postorder();
		// bst.printSideways();

		int[] arr = { 10, 25, 5, 4, 13, 11, 7, 12 };
		for (int i: arr) {
			bst.addI(i);
		}
		bst.printSideways();
		System.out.println(bst.height());
		bst.preorder();
		bst.inorder();
		bst.postorder();
		System.out.println(bst.isBalanced());
		System.out.println(bst.countLeaves());
		System.out.println(bst.find(13).getValue());
		System.out.println(bst.find(0));
		System.out.println(bst.maxNode().getValue());
		System.out.println(bst.minNode().getValue());
		bst.remove(25);
		bst.printSideways();

	}

}
