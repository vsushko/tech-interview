package common;

public class LinkedListNodeWithArbitraryPointer<T> {

    public LinkedListNodeWithArbitraryPointer<T> next;
    public LinkedListNodeWithArbitraryPointer arbitraryPointer;
    public T data;

    public LinkedListNodeWithArbitraryPointer(T data) {
        this.data = data;
    }

    public LinkedListNodeWithArbitraryPointer(T data, LinkedListNodeWithArbitraryPointer<T> next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNodeWithArbitraryPointer(T data, LinkedListNodeWithArbitraryPointer<T> next,
                                              LinkedListNodeWithArbitraryPointer arbitraryPointer) {
        this.data = data;
        this.next = next;
        this.arbitraryPointer = arbitraryPointer;
    }

    void appendToTail(T data) {
        LinkedListNodeWithArbitraryPointer<T> node = new LinkedListNodeWithArbitraryPointer<>(data);
        LinkedListNodeWithArbitraryPointer<T> current = this;

        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof LinkedListNodeWithArbitraryPointer
                && ((LinkedListNodeWithArbitraryPointer) obj).data == data;
    }


    @Override
    public int hashCode() {
        return data.hashCode();
    }


    public String toString() {
        LinkedListNodeWithArbitraryPointer node = this;

        StringBuilder sb = new StringBuilder();

        while (node.next != null) {
            sb.append(node.data)
                    .append('(').append(node.arbitraryPointer).append(')')
                    .append("->");
            node = node.next;
        }
        sb.append(node.data);

        return sb.toString();
    }

}
