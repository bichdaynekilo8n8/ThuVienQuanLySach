package quanlythuviensach;
import java.util.Scanner;

public class QuanLyThuVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bài 1: Nhập thông tin sách
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

        // Bài 2: Tính thành tiền
        double thanhTien = donGia * soLuong;

        // Bài 3: Tính phí vận chuyển 5%
        double phiVanChuyen = thanhTien * 0.05;

        // Bài 4: Tính tổng tiền nhập
        double tongTien = thanhTien + phiVanChuyen;

        // Hiển thị kết quả
        System.out.println("\n===== THONG TIN SACH =====");

        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
       

        System.out.printf("Don gia: %.2f VND\n", donGia);
        System.out.println("So luong: " + soLuong);

        System.out.println("\n===== GIA TRI NHAP KHO =====");

        System.out.printf("Thanh tien: %.2f VND\n", thanhTien);
        System.out.printf("Phi van chuyen (5%%): %.2f VND\n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %.2f VND\n", tongTien);
    }
}