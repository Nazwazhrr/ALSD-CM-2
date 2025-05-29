public class QueueTransaksi {
     TransaksiPengisian[] data;
     int front, rear, size, capacity;

    public QueueTransaksi(int capacity) {
        this.capacity = capacity;
        data = new TransaksiPengisian[capacity];
        front = rear = size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(TransaksiPengisian datatransaksi) {
        if (isFull()) {
            System.out.println("Queue transaksi penuh!");
            return;
        }
        data[rear] = datatransaksi;
        rear = (rear + 1) % capacity;
        size++;
    }

    public void tampilkanTransaksi() {
        if (isEmpty()) {
            System.out.println("Tidak ada transaksi.");
            return;
        }
        System.out.println("-- Riwayat Transaksi --");
        int idx = front;
        for (int i = 0; i < size; i++) {
            TransaksiPengisian datatransaksi = data[idx];
            System.out.println("Plat: " + datatransaksi.kendaraan.platNomor + ", Tipe: " + datatransaksi.kendaraan.tipe + ", Merk: " + datatransaksi.kendaraan.merk);
            System.out.println("BBM: " + datatransaksi.bbm.namBBM + ", Liter: " + datatransaksi.liter + ", Total: Rp" + datatransaksi.totalBayar);
            idx = (idx + 1) % capacity;
        }
    }
}
