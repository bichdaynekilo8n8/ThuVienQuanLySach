package quanlythuviensach;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class QuanLyThuVienSach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // BAI 1: Mang co dinh 5 phan tu.
        bai1MangSoLuong(sc);

        // BAI 2: ArrayList<String> chi chua ma sach.
        ArrayList<String> danhSachMaSach = new ArrayList<>();

        // BAI 3: Moi String la thong tin day du cua mot sach.
        // Dinh dang: ma|ten|tacGia|namXuatBan|donGia|soLuong|loaiSach
        ArrayList<String> danhSachSach = new ArrayList<>();

        // BAI 4: Menu xu ly lien tuc den khi chon 8.
        int chon;
        do {
            System.out.println("\n========== QUAN LY THU VIEN - TUAN 6 ==========");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.println("===============================================");

            chon = nhapSoNguyen(sc, "Chon chuc nang (1-8): ", 1, 8);

            switch (chon) {
                case 1: {
                    // add() - them ma sach va thong tin sach.
                    String ma;
                    do {
                        ma = nhapMaSach(sc, "Nhap ma sach moi: ");
                        if (danhSachMaSach.contains(ma)) {
                            System.out.println("Ma sach da ton tai. Vui long nhap ma khac!");
                        }
                    } while (danhSachMaSach.contains(ma));

                    String thongTin = nhapThongTinSach(sc, ma);
                    danhSachMaSach.add(ma);
                    danhSachSach.add(thongTin);
                    System.out.println("Them sach thanh cong!");
                    break;
                }

                case 2: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sach sach dang rong!");
                        break;
                    }
                    System.out.println("\n===== DANH SACH SACH =====");
                    System.out.println("Danh sach ma: " + danhSachMaSach);

                    // size() va get() - duyet tat ca phan tu cua ArrayList.
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        System.out.println("\n--- Sach thu " + (i + 1) + " ---");
                        inThongTinSach(danhSachSach.get(i));
                    }
                    break;
                }

                case 3: {
                    String maTim = nhapMaSach(sc, "Nhap ma sach can tim: ");

                    // contains() - kiem tra ma co ton tai trong danh sach.
                    if (danhSachMaSach.contains(maTim)) {
                        int viTri = danhSachMaSach.indexOf(maTim);
                        System.out.println("Tim thay sach:");
                        inThongTinSach(danhSachSach.get(viTri));
                    } else {
                        System.out.println("Khong tim thay sach co ma: " + maTim);
                    }
                    break;
                }

                case 4: {
                    String maXoa = nhapMaSach(sc, "Nhap ma sach can xoa: ");
                    int viTri = danhSachMaSach.indexOf(maXoa);

                    if (viTri == -1) {
                        System.out.println("Khong tim thay sach co ma: " + maXoa);
                    } else {
                        // remove() cung vi tri o hai list de du lieu dong bo.
                        danhSachMaSach.remove(viTri);
                        danhSachSach.remove(viTri);
                        System.out.println("Xoa sach thanh cong!");
                    }
                    break;
                }

                case 5: {
                    String maCu = nhapMaSach(sc, "Nhap ma sach can sua: ");
                    int viTri = danhSachMaSach.indexOf(maCu);

                    if (viTri == -1) {
                        System.out.println("Khong tim thay sach co ma: " + maCu);
                        break;
                    }

                    System.out.println("Thong tin truoc khi sua:");
                    inThongTinSach(danhSachSach.get(viTri));

                    String maMoi;
                    do {
                        maMoi = nhapMaSach(sc, "Nhap ma moi (co the giu ma cu): ");
                        if (!maMoi.equals(maCu) && danhSachMaSach.contains(maMoi)) {
                            System.out.println("Ma moi da duoc sach khac su dung!");
                        } else {
                            break;
                        }
                    } while (true);

                    String thongTinMoi = nhapThongTinSach(sc, maMoi);

                    // set() - thay the du lieu tai dung vi tri.
                    danhSachMaSach.set(viTri, maMoi);
                    danhSachSach.set(viTri, thongTinMoi);
                    System.out.println("Cap nhat sach thanh cong!");
                    break;
                }

                case 6: {
                    int tongSoLuong = 0;
                    for (String sach : danhSachSach) {
                        String[] truong = tachSach(sach);
                        tongSoLuong += Integer.parseInt(truong[5]);
                    }
                    System.out.println("Tong so dau sach: " + danhSachSach.size());
                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    break;
                }

                case 7: {
                    double tongGiaTri = 0;
                    for (String sach : danhSachSach) {
                        String[] truong = tachSach(sach);
                        double gia = Double.parseDouble(truong[4]);
                        int soLuong = Integer.parseInt(truong[5]);
                        tongGiaTri += gia * soLuong;
                    }
                    double phiVanChuyen = tongGiaTri * 0.05;
                    System.out.printf("Tong gia tri sach: %.2f VND%n", tongGiaTri);
                    System.out.printf("Phi van chuyen (5%%): %.2f VND%n", phiVanChuyen);
                    System.out.printf("Tong tien nhap kho: %.2f VND%n",
                            tongGiaTri + phiVanChuyen);
                    break;
                }

                case 8:
                    System.out.println("Da thoat chuong trinh!");
                    break;

                default:
                    // Lua chon da duoc kiem tra trong nhapSoNguyen().
                    break;
            }
        } while (chon != 8);

        sc.close();
    }

    // BAI 1: Nhap so luong cua 5 cuon sach, hien thi, tinh tong, tim MAX.
    private static void bai1MangSoLuong(Scanner sc) {
        System.out.println("===== BAI 1: MANG SO LUONG 5 CUON SACH =====");

        int[] soLuong;
        soLuong = new int[5];

        for (int i = 0; i < soLuong.length; i++) {
            soLuong[i] = nhapSoNguyen(sc,
                    "Nhap so luong cuon sach thu " + (i + 1) + ": ",
                    0, Integer.MAX_VALUE);
        }

        int tong = 0;
        int lonNhat = soLuong[0];

        System.out.println("\nSo luong cua tung cuon sach:");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);
            tong += soLuong[i];
            if (soLuong[i] > lonNhat) {
                lonNhat = soLuong[i];
            }
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + lonNhat);
    }

    // Moi phan tu ArrayList<String> la mot ban ghi co 7 truong, cach nhau boi '|'.
    private static String nhapThongTinSach(Scanner sc, String ma) {
        String ten = nhapChuoi(sc, "Nhap ten sach: ");
        String tacGia = nhapChuoi(sc, "Nhap tac gia: ");
        int namHienTai = java.time.Year.now().getValue();
        int nam = nhapSoNguyen(sc, "Nhap nam xuat ban: ", 1, namHienTai);
        double gia = nhapDonGia(sc);
        int soLuong = nhapSoNguyen(sc, "Nhap so luong: ", 0, Integer.MAX_VALUE);

        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        int chonLoai = nhapSoNguyen(sc, "Chon loai sach (1-4): ", 1, 4);

        String loai;
        switch (chonLoai) {
            case 1:
                loai = "Sach giao khoa";
                break;
            case 2:
                loai = "Sach tham khao";
                break;
            case 3:
                loai = "Sach chuyen nganh";
                break;
            default:
                loai = "Sach khac";
                break;
        }

        return ma + "|" + ten + "|" + tacGia + "|" + nam + "|"
                + gia + "|" + soLuong + "|" + loai;
    }

    private static String[] tachSach(String sach) {
        return sach.split("\\|", -1);
    }

    private static void inThongTinSach(String sach) {
        String[] truong = tachSach(sach);
        double gia = Double.parseDouble(truong[4]);
        int sl = Integer.parseInt(truong[5]);
        double thanhTien = gia * sl;
        double phiVanChuyen = thanhTien * 0.05;

        System.out.println("Ma sach: " + truong[0]);
        System.out.println("Ten sach: " + truong[1]);
        System.out.println("Tac gia: " + truong[2]);
        System.out.println("Nam xuat ban: " + truong[3]);
        System.out.printf("Don gia: %.2f VND%n", gia);
        System.out.println("So luong: " + sl);
        System.out.println("Loai sach: " + truong[6]);
        System.out.println("Muc gia: " + phanLoaiGia(gia));
        System.out.println("Tinh trang: " + phanLoaiTonKho(sl));
        System.out.printf("Thanh tien: %.2f VND%n", thanhTien);
        System.out.printf("Phi van chuyen: %.2f VND%n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %.2f VND%n", thanhTien + phiVanChuyen);
    }

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

    private static String nhapMaSach(Scanner sc, String thongBao) {
        return nhapChuoi(sc, thongBao).toUpperCase(Locale.ROOT);
    }

    private static String nhapChuoi(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String giaTri = sc.nextLine().trim();
            if (!giaTri.isEmpty() && !giaTri.contains("|")) {
                return giaTri;
            }
            System.out.println("Khong duoc de trong hoac chua ky tu '|'. Nhap lai!");
        }
    }

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
                // Nhap sai kieu du lieu, yeu cau nhap lai.
            }
            System.out.println("So nguyen khong hop le, vui long nhap lai!");
        }
    }

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
                // Nhap sai kieu du lieu, yeu cau nhap lai.
            }
            System.out.println("Don gia phai la so lon hon 0!");
        }
    }
}
