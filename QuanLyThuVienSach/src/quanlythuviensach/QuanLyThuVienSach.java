package quanlythuviensach;

import java.util.Scanner;

public class QuanLyThuVienSach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== QUAN LY THU VIEN SACH =====");
        int n = nhapSoNguyen(sc, "Nhap so luong dau sach: ", 1, Integer.MAX_VALUE);

        // Bai 1: Dung mang va vong lap for de nhap n cuon sach.
        String[] maSach = new String[n];
        String[] tenSach = new String[n];
        String[] tacGia = new String[n];
        int[] namXuatBan = new int[n];
        double[] donGia = new double[n];
        int[] soLuong = new int[n];
        String[] loaiSach = new String[n];

        int namHienTai = java.time.Year.now().getValue();

        for (int i = 0; i < n; i++) {
            System.out.println("\n===== NHAP SACH THU " + (i + 1) + " =====");

            // Khong de trong hoac trung ma sach.
            boolean trungMa;
            do {
                maSach[i] = nhapChuoi(sc, "Nhap ma sach: ");
                trungMa = false;

                for (int j = 0; j < i; j++) {
                    if (maSach[i].equalsIgnoreCase(maSach[j])) {
                        trungMa = true;
                        System.out.println("Ma sach da ton tai, vui long nhap lai!");
                        break;
                    }
                }
            } while (trungMa);

            tenSach[i] = nhapChuoi(sc, "Nhap ten sach: ");
            tacGia[i] = nhapChuoi(sc, "Nhap tac gia: ");
            namXuatBan[i] = nhapSoNguyen(sc, "Nhap nam xuat ban: ", 1, namHienTai);
            donGia[i] = nhapDonGia(sc);
            soLuong[i] = nhapSoNguyen(sc, "Nhap so luong: ", 0, Integer.MAX_VALUE);

            System.out.println("\n===== CHON LOAI SACH =====");
            System.out.println("1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.println("3. Sach chuyen nganh");
            System.out.println("4. Sach khac");

            int chonLoai = nhapSoNguyen(sc, "Nhap lua chon: ", 1, 4);
            switch (chonLoai) {
                case 1:
                    loaiSach[i] = "Sach giao khoa";
                    break;
                case 2:
                    loaiSach[i] = "Sach tham khao";
                    break;
                case 3:
                    loaiSach[i] = "Sach chuyen nganh";
                    break;
                default:
                    loaiSach[i] = "Sach khac";
                    break;
            }

            System.out.println("Thong tin sach hop le. Da them sach thanh cong!");
        }

        // Bai 3: Menu luon lap cho den khi nguoi dung chon 0.
        int chon;
        do {
            System.out.println("\n========== MENU QUAN LY THU VIEN ==========");
            System.out.println("1. Hien thi danh sach sach");
            System.out.println("2. Thong ke tong so luong va gia tri sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.println("===========================================");

            chon = nhapSoNguyen(sc, "Nhap lua chon: ", 0, 3);

            switch (chon) {
                case 1:
                    System.out.println("\n===== DANH SACH SACH =====");
                    for (int i = 0; i < n; i++) {
                        inThongTinSach(i, maSach, tenSach, tacGia,
                                namXuatBan, donGia, soLuong, loaiSach);
                    }
                    break;

                case 2:
                    // Bai 2: Cong don so luong va gia tri tat ca sach.
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;
                    for (int i = 0; i < n; i++) {
                        tongSoLuong += soLuong[i];
                        tongGiaTri += donGia[i] * soLuong[i];
                    }

                    double tongPhiVanChuyen = tongGiaTri * 0.05;
                    System.out.println("\n===== THONG KE THU VIEN =====");
                    System.out.println("Tong so dau sach: " + n);
                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    System.out.printf("Tong gia tri sach: %.2f VND%n", tongGiaTri);
                    System.out.printf("Tong phi van chuyen: %.2f VND%n", tongPhiVanChuyen);
                    System.out.printf("Tong tien nhap: %.2f VND%n", tongGiaTri + tongPhiVanChuyen);
                    break;

                case 3:
                    // Bai 4: Tim sach theo ma bang vong lap for.
                    String maCanTim = nhapChuoi(sc, "Nhap ma sach can tim: ");
                    boolean timThay = false;

                    for (int i = 0; i < n; i++) {
                        if (maSach[i].equalsIgnoreCase(maCanTim)) {
                            System.out.println("\n===== SACH TIM THAY =====");
                            inThongTinSach(i, maSach, tenSach, tacGia,
                                    namXuatBan, donGia, soLuong, loaiSach);
                            timThay = true;
                            break;
                        }
                    }

                    if (!timThay) {
                        System.out.println("Khong tim thay sach co ma: " + maCanTim);
                    }
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh. Tam biet!");
                    break;

                default:
                    // Da kiem tra gioi han 0..3 o ham nhapSoNguyen.
                    break;
            }
        } while (chon != 0);

        sc.close();
    }

    // Nhap so nguyen, yeu cau dung kieu va nam trong khoang [min, max].
    private static int nhapSoNguyen(Scanner sc, String thongBao, int min, int max) {
        while (true) {
            System.out.print(thongBao);
            String duLieu = sc.nextLine().trim();
            try {
                int giaTri = Integer.parseInt(duLieu);
                if (giaTri >= min && giaTri <= max) {
                    return giaTri;
                }
            } catch (NumberFormatException e) {
                // Nhap sai kieu, yeu cau nguoi dung nhap lai.
            }
            System.out.println("Gia tri khong hop le, vui long nhap lai!");
        }
    }

    // Nhap chuoi khong rong.
    private static String nhapChuoi(Scanner sc, String thongBao) {
        String ketQua;
        do {
            System.out.print(thongBao);
            ketQua = sc.nextLine().trim();
            if (ketQua.isEmpty()) {
                System.out.println("Thong tin khong duoc de trong!");
            }
        } while (ketQua.isEmpty());
        return ketQua;
    }

    // Nhap don gia > 0 va phai la so huu han.
    private static double nhapDonGia(Scanner sc) {
        while (true) {
            System.out.print("Nhap don gia: ");
            String duLieu = sc.nextLine().trim();
            try {
                double gia = Double.parseDouble(duLieu);
                if (Double.isFinite(gia) && gia > 0) {
                    return gia;
                }
            } catch (NumberFormatException e) {
                // Nhap sai kieu, yeu cau nguoi dung nhap lai.
            }
            System.out.println("Don gia phai la so lon hon 0!");
        }
    }

    // Giu lai logic phan loai gia sach cua chuong trinh cu.
    private static String phanLoaiGia(double gia) {
        if (gia < 50000) {
            return "Sach gia thap";
        } else if (gia <= 100000) {
            return "Sach gia trung binh";
        } else if (gia <= 200000) {
            return "Sach gia cao";
        }
        return "Sach gia dac biet";
    }

    // Giu lai logic phan loai ton kho cua chuong trinh cu.
    private static String phanLoaiTonKho(int sl) {
        if (sl == 0) {
            return "Het sach";
        } else if (sl <= 5) {
            return "Sap het";
        } else if (sl <= 20) {
            return "Con it";
        }
        return "Con nhieu";
    }

    // Hien thi thong tin va gia tri nhap kho cua mot cuon sach.
    private static void inThongTinSach(int i,
            String[] maSach, String[] tenSach, String[] tacGia,
            int[] namXuatBan, double[] donGia, int[] soLuong,
            String[] loaiSach) {

        double thanhTien = donGia[i] * soLuong[i];
        double phiVanChuyen = thanhTien * 0.05;

        System.out.println("\n----- SACH THU " + (i + 1) + " -----");
        System.out.println("Ma sach: " + maSach[i]);
        System.out.println("Ten sach: " + tenSach[i]);
        System.out.println("Tac gia: " + tacGia[i]);
        System.out.println("Nam xuat ban: " + namXuatBan[i]);
        System.out.printf("Don gia: %.2f VND%n", donGia[i]);
        System.out.println("So luong: " + soLuong[i]);
        System.out.println("Loai sach: " + loaiSach[i]);
        System.out.println("Muc gia: " + phanLoaiGia(donGia[i]));
        System.out.println("Tinh trang: " + phanLoaiTonKho(soLuong[i]));

        System.out.println("===== GIA TRI NHAP KHO =====");
        System.out.printf("Thanh tien: %.2f VND%n", thanhTien);
        System.out.printf("Phi van chuyen: %.2f VND%n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %.2f VND%n", thanhTien + phiVanChuyen);
    }
}
