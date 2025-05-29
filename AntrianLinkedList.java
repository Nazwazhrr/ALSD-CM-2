public class AntrianLinkedList{
    public NodeKendaraan head, tail;
    public int size;

    public void tambahAntrian(Kendaraan k) {
        NodeKendaraan baru = new NodeKendaraan(k);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
        System.out.println(">> Kendaraan masuk ke dalam antrian.");
    }

    public Kendaraan layaniKendaraan() {
        if (head == null) {
            System.out.println("Antrian kosong tidak ada kendaraan yang bisa dilayani.");
            return null;
        }
        Kendaraan dilayani = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return dilayani;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int jumlahAntrian(){
        return size;
    }
    
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println(">> Tidak ada kendaraan dalam antrian.");
            return;
        }

        System.out.println("--- Daftar Kendaraan dalam Antrian ---");
        NodeKendaraan current = head;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". Plat Nomor: " + current.data.platNomor);
            System.out.println("Tipe      : " + current.data.tipe);
            System.out.println("Merk      : " + current.data.merk);
            current = current.next;
            no++;
        }
    }
}