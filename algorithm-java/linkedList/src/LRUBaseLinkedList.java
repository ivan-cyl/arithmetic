import javax.swing.*;
import javax.xml.transform.Source;
import java.util.Scanner;

public class LRUBaseLinkedList<T> {
    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }


    private SNode<T> headNode;
    private Integer length;
    private Integer capacity;
    private final static Integer DEFAULT_CAPACITY = 10;

    public LRUBaseLinkedList(Integer capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new SNode<>();
    }

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    private void deleteElementOption(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length++;
    }

    private void insertElementAtBegin(T data){
        SNode next=headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }

    private void deleteElementAtEnd(){
        SNode ptr=headNode;
        if(ptr.getNext()==null){
            return;
        }
        while (ptr.getNext().getNext()==null){
            ptr=ptr.getNext();
        }
        SNode tmp=ptr.getNext();
        ptr.setNext(null);
        tmp=null;
        length--;
    }

    private SNode findPreNode(T date){
        SNode node=headNode;
        while (node.getNext()!=null){
            if(date.equals(node.getNext().getElement())){
                return node;
            }
        }
        return null;
    }

    public void add(T date) {
        SNode preNode=findPreNode(date);
        if(preNode!=null){
            deleteElementOption(preNode);
            insertElementAtBegin(date);
        }else {
            if (length >= this.capacity) {
                deleteElementAtEnd();
            }
            insertElementAtBegin(date);
        }
    }

    private void printAll(){
        SNode node=headNode.getNext();
        while (node!=null){
            System.out.print(node.getElement());
            node=node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list=new LRUBaseLinkedList();
        Scanner scanner=new Scanner(System.in);
        while (true){
            list.add(scanner.nextInt());
            list.printAll();
        }
    }
}
