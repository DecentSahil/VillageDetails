public class test {
    public static void main(String[] args) {
        test a =new  b();
        a.greet();
    }
}
class b extends c{
    pblic static void greet(){
        System.out.println("child class");
    }
}
class c{
    public static void greet(){
        System.out.println("parent class");
    }

}