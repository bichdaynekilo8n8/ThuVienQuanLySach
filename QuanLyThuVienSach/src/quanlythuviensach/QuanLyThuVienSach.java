package quanlythuviensach;
import java.util.Scanner;

public class QuanLyThuVienSach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập thông tin sách
        System.out.println("===== NHAP THONG TIN SACH =====");

        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        int soLuong = sc.nextInt();

        // Bai 1: Kiem tra thong tin hop le
        System.out.println("\n===== KIEM TRA THONG TIN =====");

        boolean hopLe = true;
        int namHienTai = java.time.Year.now().getValue();

        if (donGia <= 0) {
            System.out.println("Don gia phai lon hon 0!");
            hopLe = false;
        }

        if (soLuong < 0) {
            System.out.println("So luong khong duoc am!");
            hopLe = false;
        }

        if (namXuatBan < 1 || namXuatBan > namHienTai) {
            System.out.println("Nam xuat ban khong hop le!");
            hopLe = false;
        }

        if (!hopLe) {
            System.out.println("Thong tin sach khong hop le!");
            sc.close();
            return;
        }

        System.out.println("Thong tin sach hop le!");

        // Bai 2: Phan loai gia sach
        String mucGia;

        if (donGia < 50000) {
            mucGia = "Sach gia thap";
        } else if (donGia <= 100000) {
            mucGia = "Sach gia trung binh";
        } else if (donGia <= 200000) {
            mucGia = "Sach gia cao";
        } else {
            mucGia = "Sach gia dac biet";
        }

        // Bai 3: Phan loai ton kho
        String tinhTrang;

        if (soLuong == 0) {
            tinhTrang = "Het sach";
        } else if (soLuong <= 5) {
            tinhTrang = "Sap het";
        } else if (soLuong <= 20) {
            tinhTrang = "Con it";
        } else {
            tinhTrang = "Con nhieu";
        }

        // Bai 4: Chon loai sach bang switch
        System.out.println("\n===== CHON LOAI SACH =====");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");

        System.out.print("Nhap lua chon: ");
        int luaChon = sc.nextInt();

        String loaiSach;

        switch (luaChon) {
            case 1:
                loaiSach = "Sach giao khoa";
                break;
            case 2:
                loaiSach = "Sach tham khao";
                break;
            case 3:
                loaiSach = "Sach chuyen nganh";
                break;
            case 4:
                loaiSach = "Sach khac";
                break;
            default:
                loaiSach = "Lua chon khong hop le";
                break;
        }

        // Tinh tien ke thua tu tuan 3
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTien = thanhTien + phiVanChuyen;

        // Hien thi ket qua
        System.out.println("\n===== THONG TIN SACH =====");

        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);

        System.out.printf("Don gia: %.2f VND\n", donGia);
        System.out.println("So luong: " + soLuong);

        System.out.println("Loai sach: " + loaiSach);
        System.out.println("Muc gia: " + mucGia);
        System.out.println("Tinh trang: " + tinhTrang);

        System.out.println("\n===== GIA TRI NHAP KHO =====");

        System.out.printf("Thanh tien: %.2f VND\n", thanhTien);
        System.out.printf("Phi van chuyen: %.2f VND\n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %.2f VND\n", tongTien);
    }
}