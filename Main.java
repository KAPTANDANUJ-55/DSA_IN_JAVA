import LL.Making_LL;
import LL.DLL;
public class Main {
 public static void main(String[] args){
    Making_LL list = new Making_LL();
     list.addFirst(0);
     list.addFirst(2);
     list.addFirst(5);
     list.addFirst(6);
     list.deleteParticular(2);
     list.display();

     DLL dll = new DLL();

     dll.insert(0);
     dll.insert(8);
     dll.insert(3);
     dll.insert(5);
     dll.deleteFirst();
     dll.display();
 }
    
}