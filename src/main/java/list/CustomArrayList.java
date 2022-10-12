package list;

public class CustomArrayList<T> {
    private Node<T> firstNode = null;
    private Node<T> lastNode = null;

    public Integer length = 0;

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(value);
            lastNode = firstNode;
            length = 1;
        } else {
            lastNode.setNext(new Node<>(lastNode, value));
            lastNode = lastNode.getNext();
            length++;
        }
    }

    public Boolean contains(T value){
        if (firstNode != null){
            Node<T> tmp = firstNode;
            while(tmp != null){
                if (value.equals(tmp.getValue())) return true;
                tmp = tmp.getNext();
            }
        }
        return false;
    }

    public T get(Integer index){
        if (index > length){
            return null;
        } else {
            Node<T> tmp = firstNode;
            if (index.equals(0)) return firstNode.getValue();
            if (index.equals(length-1)) return lastNode.getValue();
            Integer cnt = 0;
            while (tmp != null) {
                if (cnt.equals(index)){
                    break;
                }
                tmp = tmp.getNext();
                cnt++;
            }
            if (tmp != null){
                return tmp.getValue();
            } else {
                return null;
            }
        }
    }

    public T remove(Integer index) {
        if (firstNode != null) {
            Node<T> tmp = firstNode;
            if (!index.equals(0)) {
                Integer cnt = 0;
                while (tmp != null) {
                    if (cnt.equals(index)) {
                        tmp.getPrev().setNext(tmp.getNext());
                        if (tmp.getNext() == null){
                            lastNode = tmp.getPrev();
                        }
                        length--;
                        return tmp.getValue();
                    } else {
                        cnt++;
                        tmp = tmp.getNext();
                    }
                }
                return null;
            } else {
                T value = tmp.getValue();
                firstNode = tmp.getNext();
                length--;
                return value;
            }

        } else {
            return null;
        }
    }

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node<T> lastNode) {
        this.lastNode = lastNode;
    }

    @Override
    public String toString() {
        if (firstNode == null) {
            return "list.CustomArrayList{[]}";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            Node<T> tmp = firstNode;
            stringBuilder.append("list.CustomArrayList{[").append(tmp.getValue());
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
                stringBuilder.append(", ").append(tmp.getValue());
            }
            stringBuilder.append("]}");
            return stringBuilder.toString();
        }
    }
}
