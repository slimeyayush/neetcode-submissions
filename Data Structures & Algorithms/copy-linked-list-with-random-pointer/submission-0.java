/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> orgToCopy = new HashMap<>();
        Node temp = head;
        
       
        while(temp != null) {
            
            Node copy = new Node(temp.val);
            
            orgToCopy.put(temp,copy);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            Node copy = orgToCopy.get(temp);
            copy.next = orgToCopy.get(temp.next);
            copy.random = orgToCopy.get(temp.random);
            temp = temp.next;
        }

        return orgToCopy.get(head);
        
        

    }
}
