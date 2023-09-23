public class Main {
    public static void main(String args[]) {
        MyGenericList <Pair<String, Integer>> db = new MyGenericList <Pair<String, Integer>>();
        db.add(new Pair <String, Integer> ("John", 2343));
        db.add(new Pair <String, Integer> ("Susane", 8908));
    }
}