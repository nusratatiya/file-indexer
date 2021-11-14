

	// Basic node stored in unbalanced binary search trees
    public class BinaryNode<Object>
    {
    	
            // Constructors
        BinaryNode( Object theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( Object theElement, BinaryNode<Object> lt, BinaryNode<Object> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        Object element;            // The data in the node
        BinaryNode<Object> left;   // Left child
        BinaryNode<Object> right;  // Right child
        
        int data;
     
        // Function to create a new binary tree node having a given key
        BinaryNode(int key)
        {
            data = key;
            left = right = null;
        }
        
    }


