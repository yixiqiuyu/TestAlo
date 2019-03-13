

public class SingleLinkedList {
    //单链表的插入、删除、查找操作
    //链表中存储的是int类型的值
    private Node head=null;
    public Node findByValue(int value){
        Node p=head;
        while(p!=null&&p.data!=value){
            p=p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        Node p=head;
        int pos=0;
        while(p!=null&&pos!=index){
            p=p.next;
            pos++;
        }
        return p;
    }

    //无头结点，表头部插入，这种操作将与输入的顺序相反，逆序
    public void insertToHead(int value){
        Node newNode=new Node(value,null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode){
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
    }

    //顺序插入，链表尾部插入
    public void insertTrail(int value){
        Node newNode=new Node(value,null);
        if(head==null){
            head=newNode;
        }else{
            Node q=head;
            while(q!=null){
                q=q.next;
            }
            newNode.next=q.next;
            q.next=newNode;
        }
    }

    public void insertAfter(Node p,int value){
        Node newNode=new Node(value,null);
        insertAfter(p,newNode);
    }
    public void insertAfter(Node p,Node newNode){
        if(p == null)
            return;
        else{
            newNode.next=p.next;
            p.next=newNode;
        }
    }

    public void insertBefore(Node p,int value){
        Node newNode=new Node(value,null);
        insertBefore(p,newNode);
    }
    public void insertBefore(Node p,Node newNode){
        if (p==null)
            return;
        if(p==head)
            insertToHead(newNode);
        Node q=head;
        while(q!=null&&q.next!=p){
            q=q.next;
        }
        newNode=q.next;
        newNode.next=p;
    }

    public void deleteByNode(Node p){
        if (p==null||head==null)return;
        if(p==head){
            head=head.next;
            return;
        }

        Node q=head;
        while(q!=head&&q.next!=p){
            q=q.next;
        }
        q.next=q.next.next;
        //q.next=p.next;
    }

    public void deleteByValue(int value){
        if(head==null){
            return;
        }
        Node p=head;
        Node q=null;
        while(p!=null&&p.data!=value){
            q=p;
            p=p.next;
        }
        if (p==null)
            return;
        if (q==null)
            head=head.next;
        else
            q.next=q.next.next;
    }

    //打印链表
    public void printAll(){
        Node p=head;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    //判断true or false
    public boolean TFResult(Node left,Node right){
        Node l=left;
        Node r=right;

        System.out.println("left_"+l.data);
        System.out.println("right_"+r.data);
        while (l!=null&&r!=null){
            if (l.data==r.data){
                l=l.next;
                r=r.next;
                continue;
            }else{
                break;
            }
        }
        System.out.println("什么结果");
        if(l==null&&r==null){
            System.out.println("什么结果");
            return true;
        }else{
            return false;
        }
    }

    //判断是否为回文
    public boolean palindrome(){
        if (head==null)
            return false;
        else{
            System.out.println("开始执行找到中间节点");
            Node p=head;
            Node q=head;
            if(p.next==null){
                System.out.println("只有一个元素");
                return true;
            }
            while (q.next!=null&&q.next.next!=null){
                p=p.next;
                q=q.next.next;
            }
            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if(q.next == null){
                //　p 一定为整个链表的中点，且节点数目为奇数
                leftLink = inverseLinkList(p);
                System.out.println("左边第一个节点"+leftLink.data);
                System.out.println("右边第一个节点"+p.next.data);
                rightLink = p;

            }else{
                //p q　均为中点
                leftLink = inverseLinkList(p);
                rightLink = q;
            }
            return TFResult(leftLink, rightLink);
        }
    }

    //带节点的链表翻转
    public Node inverseLinkList_head(Node p){
        //head为新建的一个头结点
        Node Head=new Node(9999,null);
        //p为原来整个链表的头结点，现在让head指向整个头结点
        Head.next=p;
        //带头结点的链表翻转等价于从第二个元素开始重新头插法建立链表
        Node cur=p.next;
        p.next=null;
        Node next=null;

        while (cur!=null){
            next=cur.next;
            cur.next=Head.next;
            Head.next=cur;
            cur=next;
        }
        //返回左半部分的中点之前的那个节点
        //从此开始同步向两边比较
        return Head;

    }

    //无头结点的链表翻转
    public Node inverseLinkList(Node p){

        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next= null;
        while(r !=p){
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;

    }


    public static  class Node{
        private int data;
        private Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

        public int getData(){
            return data;
        }
    }

}

