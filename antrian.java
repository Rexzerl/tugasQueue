package tugasQueue;

public class antrian {
    orang front, rear;
    int jumlah, maks;
    
    public antrian(int j) {
        maks = j;
        System.out.println("Antrian dibuat dengan kapasitas " + j);
    }
    
    void enqueue(String n, int p) {
        if(jumlah >= maks) {
            System.out.println("Antrian sudah penuh!");
            return;
        }
        
        orang baru = new orang(n, p);
        
        if(front == null) {
            // Antrian kosong
            front = rear = baru;
        } else {
            // Cari posisi yang tepat berdasarkan prioritas
            orang current = front;
            orang prev = null;
            
            while(current != null && current.prioritas >= baru.prioritas) {
                prev = current;
                current = current.next;
            }
            
            if(prev == null) {
                // Masuk di depan
                baru.next = front;
                front.prev = baru;
                front = baru;
            } else if(current == null) {
                // Masuk di belakang
                rear.next = baru;
                baru.prev = rear;
                rear = baru;
            } else {
                // Masuk di tengah
                prev.next = baru;
                baru.prev = prev;
                baru.next = current;
                current.prev = baru;
            }
        }
        jumlah++;
        System.out.println(n + " dengan prioritas " + p + " telah ditambahkan");
    }
    
    String dequeue() {
        if(jumlah == 0) {
            System.out.println("Antrian kosong!");
            return "";
        }
        
        String nama = front.nama;
        if(front.next == null) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        jumlah--;
        return nama;
    }
    
    void tampil() {
        System.out.println("\nDaftar Antrian Pasien:");
        System.out.println("-----------------------");
        System.out.println("Nama\t| Prioritas");
        System.out.println("-----------------------");
        
        orang current = front;
        while(current != null) {
            System.out.println(current.nama + "\t| " + current.prioritas);
            current = current.next;
        }
        
        System.out.println("-----------------------");
        System.out.println("Jumlah pasien: " + jumlah + "/" + maks);
    }
}