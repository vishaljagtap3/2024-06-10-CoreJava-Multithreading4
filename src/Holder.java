public class Holder {
    private int data;
    private boolean isDataSet = false;

    public synchronized void getData() {
        if(isDataSet) {
            System.out.println("Got: " + data);
            isDataSet = false;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void setData(int data) {
        if(!isDataSet) {
            this.data = data;
            isDataSet = true;
            System.out.println("Put: " + data);
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
