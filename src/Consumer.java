public class Consumer extends Thread {
    private Holder holder;
    private boolean state = true;

    public Consumer(Holder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        while(state) {
            holder.getData();
        }
    }

    public void finish() {
        state = false;
    }
}
