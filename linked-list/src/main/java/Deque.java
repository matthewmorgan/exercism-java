public class Deque<T> {

    private Element head;

    public void push(T input){
        if (head != null){
            Element nextNode = new Element(input);
            Element lastNode = findLastNode();
            lastNode.next = nextNode;
        } else {
            head = new Element(input);
        }
    }

    public T pop(){
        Element tail = findLastNode();
        tail.prev.next = null;
        T value = tail.data;
        return value;
    }

    public void unshift(T input) {
        if (head !=null ){
            Element newHead = new Element(input);
            newHead.next = head;
            head = newHead;
        } else {
            head = new Element(input);
        }
    }

    public T shift(){
        T value = head.data;
        head = head.next;
        return value;
    }

    private Element findLastNode(){
        Element tail = head;
        Element runner = head;
        while (tail.next != null){
            runner = tail;
            tail = tail.next;
        }
        tail.prev = runner;
        return tail;
    }

    private class Element {
        T data;
        Element next, prev;
        public Element(T input){
            this.data = input;
        }
    }
}
