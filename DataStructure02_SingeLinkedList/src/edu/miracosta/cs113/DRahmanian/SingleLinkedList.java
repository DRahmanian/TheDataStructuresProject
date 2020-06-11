package edu.miracosta.cs113.DRahmanian;

public class SingleLinkedList<E> {
   /** Reference to List head */
   private Node<E> head=null;
    /** Reference to size of the list */
    private int size;

    /**
     * This method adds an item to the front of the list
     * @param item
     */
    private void addFirst(E item){
    head= new Node<E>(item, head);
    size++;
    }

    /**
     * Add a node after a give node
     * @param node
     * @param item
     */
    private void addAfter(Node<E> node, E item){
        node.next= new Node<E>( item, node.next);
        size++;

    }

    /**
     * This method removes the node after a given node
     * This method works on all nodes except the first
     * @param node
     * @return
     */
    private E removeAfter(Node<E> node){
        Node<E> temp= node.next;
        if(temp!=null) {
            node.next = temp.next;
            size--;
            return temp.data;
        }else{
            return null;
        }
    }

    /**
     * this method removes the node at the top of the list
     * @return
     */
    private E removeFirst(){
        Node<E> temp= head;
        if(head!= null){
            head= head.next;
        }
        if(temp!=null){
            size--;
            return  temp.data;
        }else
            return null;
    }

    //The Traversal of the Single Linked List
    // 1. Set nodeRef to reference the first node
    // 2. while nodeRef is not null
    // 3.     Do something with node referenced by nodeRef
    // 4.     set nodeRef to nodeRef.next

    /**
     * The toString methods traverses the SingleLinkedList starting from the head
     * @return
     */
    public String toString(){
        //1
        Node<String> nodeRef= (Node<String>) head;
        StringBuilder result = new StringBuilder();
       //2
        while(nodeRef!= null){
            result.append(nodeRef.data);
          //3
            if(nodeRef.next!=null){
                result.append("==>");
            }
       //4
        nodeRef= nodeRef.next;
        }
// final result
        return result.toString();
    }
    //find node at specified position
private Node<E> getNode(int index){
        Node<E> node= head;
        for(int i=0; i<index && node!=null; i++){
            node=node.next;
        }
        return node;
}


    //Set of extra methods required by the List interface

    /**
     * the get method retrieves the Node data at the specified index
     * @param index
     * @return
     */
    public E get(int index){
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node <E> node = getNode(index);
        return node.data;
    }

    public E set(int index, E newValue){
        if(index<0 || index>= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }
public void add(int index, E item){
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException(Integer.toString(index));
        if(index == 0){
            addFirst( item);
        }else{
            Node<E> node = getNode(index=1);
            addAfter(node,item);
        }
}

public boolean add( E item){
        add(size, item);
        return true;
}

    /**
     * Method removes item at specified index
     * interior loops to check if it is at the head or arbitrary position
     * @param index
     */
    public void remove( int index){
        if(head==null)
            return;
        Node<E> temp= head;

        if(index== 0){
            head=temp.next;
        }

// Find previous node of the node to be deleted
    for (int i=0; temp!=null && i<index-1; i++)
        temp = temp.next;

    // If position is more than number of ndoes
    if (temp == null || temp.next == null)
        return;

    // Node temp->next is the node to be deleted
    // Store pointer to the next of node to be deleted
    Node next = temp.next.next;

    temp.next = next;  // Unlink the deleted node from list
    }




    /**
     * A node is the building block for a Single Linked List
     * @param <E>
     */
    private static class Node<E>{
        //Data fields
        /** reference to data being stored */
        private E data;
        /** reference to the next node in the list */
        private Node<E> next;
        //Constructors

        /**
         * creates a new node with a null next field
         * @param dataitem
         */
        private Node( E dataitem){
            data= dataitem;
            next=null;
        }

        /**
         * Creates a new node that references another node
         * @param dataitem
         * @param nodeRef
         */
        private Node(E dataitem, Node<E> nodeRef){
            data=dataitem;

            next=nodeRef;
        }
    }



}
