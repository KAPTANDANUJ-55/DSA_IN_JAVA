import LL.Making_LL;

public class Main {
 public static void main(String[] args){
    Making_LL list = new Making_LL();
     list.addFirst(0);
     list.addFirst(2);
     list.addFirst(5);
     list.addFirst(6);
     list.deleteParticular(2);
     list.display();
 }
    
}