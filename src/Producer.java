public class Producer extends Thread {
    private Holder holder;
    private boolean state = true;

    public Producer(Holder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        int i = 1;
        while (state) {
            holder.setData(i++);
        }
    }

    public void finish() {
        state = false;
    }
}
