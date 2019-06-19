package cn.structure;

public class LinkedList {
    public class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }
    Node head = new Node(1);
    public void addNode(Node node){
        Node tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }
    int[] data = {3,6,2,8,12,5};
    public Node createLinkedList(){
        int[] array = data;
        if(array.length==0){
            System.out.println("链表创建失败");
            return null;
        }else{
            for(int i=0;i<array.length;i++){
                addNode(new Node(array[i]));
            }
            System.out.println("链表创建成功");
        }
        return head;
    }
    //链表翻转
    public Node LinkedListreverse(Node node){
        if(node==null||node.next==null)
        {
            return node;
        }
        Node pre = null;
        Node next;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
    //链表中检测是否存在环
    public Node CreateCycleLinkedList(int nodenum,int circlenum){
        if(nodenum<circlenum){
            return null;
        }
        Node head = createLinkedList();
        Node head1 = head;
        while(head1.next!=null)
        {
            head1 = head1.next;
        }
        Node temp = head;
        int step = nodenum-circlenum;
        while(step>0){
            temp = temp.next;
            step--;
        }
        head1.next = temp;
        return head;
    }
    public boolean CycleLinkedList(){
        Node head = CreateCycleLinkedList(10,8);
        if(head==null||head.next==null){
            return false;
        }

        Node fast = head;
        Node slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //两个有序链表合并
    public Node MergeLinkedList(Node n1,Node n2){

        Node newHead = null;
        while(n1!=null&&n2!=null){
            if(n1.data>n2.data){
                newHead.next = n1;
                n1 = n1.next;
                newHead = newHead.next;
            }else{
                newHead.next = n2;
                n2 = n2.next;
                newHead = newHead.next;
            }
        }
        if(n1!=null){
            newHead.next = n1;
            n1 = n1.next;
        }
        if(n2!=null){
            newHead.next = n2;
            n2 = n2.next;
        }
        return newHead;
    }
    //删除链表倒数第n个节点
    public Node KthNodeRemove(Node node,int k){
        Node node1 = node;
        Node node2 = node;
        while(k>0){
            node2 = node2.next;
            k--;
        }
        while(node2!=null&&node2.next!=null){
            node1 = node1.next;
            node2 = node2.next;
        }

        if(node1.next.next==null){
            node1.next = null;
        }else{
            node1.next = node1.next.next;
        }
        return node;
    }
    //找出链表中间节点
    public void FindMiddleNode(Node node){
        if(node==null||node.next==null){
            return ;
        }
        Node fast = node;
        Node slow = node;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
//        System.out.println(ll.CycleLinkedList());
        Node headNode = ll.createLinkedList();
        ll.FindMiddleNode(headNode);
//        Node headNode1 = ll.KthNodeRemove(headNode,3);

//        while(headNode!=null)
//        {
//            System.out.println(headNode.data);
//            headNode = headNode.next;
//        }
//        Node headNode1 = ll.LinkedListreverse(headNode);
//        while(headNode1!=null)
//        {
//            System.out.println(headNode1.data);
//            headNode1 = headNode1.next;
//        }

    }
}
