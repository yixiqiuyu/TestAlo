class List{
    int data;
    List next;
    List head=null;

    public List(){}
    public List(int data){
        this.data=data;
    }
    public void add(List list){
        if(head==null){
            head=list;
            return;
        }
        List temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=list;
    }
    public void print(){
        while(head.next!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.print(head.data);
    }
}
public class TestList {
    public static void main(String[] args){
        List l=new List();
        List node=new List(4);
        List node1=new List(5);
        l.add(node);
        l.add(node1);
        l.print();
    }
}
