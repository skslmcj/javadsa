package graph;

public class DoublyLinkedList<T> {
    
    class Node {
        T data;
        Node nextNode;
        Node prevNode;
    }

    Node headNode;
    Node tailNode;
    int size;

    public DoublyLinkedList(){
        this.headNode = null;
        this.tailNode = null;
    }

    public boolean isEmpty(){
        if(headNode == null && tailNode == null)
            return true;
        return false;
    }
    
    public Node getHeadNode(){
        return headNode;
    }

    public Node getTailNode(){
        return tailNode;
    }

    public int getSize(){
        return size;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode;
        newNode.prevNode = null;

        if(headNode != null){
            headNode.prevNode = newNode;
        } else {
            tailNode = newNode;
        }
        this.headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data){
        if(isEmpty()){
            insertAtHead(data);
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        tailNode.nextNode = newNode;
        newNode.prevNode = tailNode;
        tailNode = newNode;
        size++;
    }

    public void printList(){
        if(isEmpty()){
            System.out.println("List is Empty!");
        }

        Node temp = this.headNode;

        System.out.print("List : null <-- ");

        while(temp.nextNode != null){
            System.out.print(temp.data.toString() + " <--> ");
            temp = temp.nextNode;
        }

        System.out.print(temp.data.toString()+ " --> null");
    }

        public void printListReverse() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = tailNode;
        System.out.print("List : null <- ");

        while (temp.prevNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.prevNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    public void deleteByValue(T data) {
        if(isEmpty()){
            return;
        }

        Node currentNode = this.headNode;
        if(data.equals(currentNode.data)){
            deleteAtHead();
            return;
        }

        while(currentNode != null){
            if(data.equals(currentNode.data)){
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if(currentNode.nextNode != null){
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                }
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void deleteAtHead(){
        if(isEmpty()){
            return;
        }

        if(headNode == null){
            tailNode = null;
        } else {
            headNode = headNode.nextNode;
            headNode.prevNode = null;
        }
        size--;
    }

    public void deleteAtTail(){
        if(isEmpty()){
            return;
        }

        if(tailNode == null){
            headNode = null;
        } else {
            tailNode = tailNode.prevNode;
            tailNode.nextNode = null;
        }
        size--;
    }
}
