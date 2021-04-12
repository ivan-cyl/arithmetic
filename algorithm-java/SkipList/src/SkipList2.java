import org.w3c.dom.Node;

import java.util.Random;

public class SkipList2 {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    public class Node {
        private int data = -1;
        private Node forwards[];
        private int maxLevel = 0;

        public Node(int level) {
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }

        private Node head = new Node(MAX_LEVEL);
        private Random r = new Random();

        public Node find(int value) {
            Node p = head;
            for (int i = levelCount - 1; i >= 0; i--) {
                while (p.forwards[i] != null && p.forwards[i].data < value) {
                    p = p.forwards[i];
                }
            }
            if (p.forwards[0] != null && p.forwards[0].data == value) {
                return p.forwards[0];
            } else {
                return null;
            }
        }

        private int randomLevel(){
            int level=1;
            for (int i = 1; i < MAX_LEVEL; i++) {
                if(r.nextInt()%2==1){
                    level++;
                }
            }
            return level;
        }

        public void insert(int value){
            int level=head.forwards[0]==null?1:
        }
    }

    public static void main(String[] args) {

    }
}
