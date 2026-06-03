public class Interface {
    interface Playable {
        void play();
    }
    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Playing the guitar");
        }
    }
    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Playing the piano");
        }
    }
    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play();
        p.play();
    }
}
