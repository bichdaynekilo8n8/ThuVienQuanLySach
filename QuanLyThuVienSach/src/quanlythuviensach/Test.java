
package quanlythuviensach;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tao danh sach sach
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        // Tao doi tuong sach ban dau
        Sach sach1 = new Sach("001", "Doraemon", "Fujiko F. Fujio", 2020, 50);
        Sach sach2 = new Sach("002", "Conan", "Gosho Aoyama", 2021, 30);
        Sach sach3 = new Sach("003", "Dragon Ball", "Akira Toriyama", 2019, 40);

        // Them sach vao ArrayList
        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);

        int luaChon;

        do {
            System.out.println("\n===== QUAN LY THU VIEN SACH =====");
            System.out.println("1. Hien thi danh sach sach");
            System.out.println("2. Them sach moi");
            System.out.println("3. Tim kiem sach theo ma");
            System.out.println("4. Cap nhat thong tin sach");
            System.out.println("5. Xoa sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    // Hien thi danh sach sach
                    System.out.println("\n--- DANH SACH SACH ---");

                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sach rong!");
                    } else {
                        for (Sach sach : danhSachSach) {
                            sach.hienThiThongTin();
                        }
                    }
                    break;

                case 2:
                    // Them sach moi
                    System.out.print("Nhap ma sach: ");
                    String maMoi = sc.nextLine();

                    boolean trungMa = false;

                    for (Sach sach : danhSachSach) {
                        if (sach.getMaSach().equals(maMoi)) {
                            trungMa = true;
                            break;
                        }
                    }

                    if (trungMa) {
                        System.out.println("Ma sach da ton tai!");
                        break;
                    }

                    System.out.print("Nhap tieu de: ");
                    String tieuDe = sc.nextLine();

                    System.out.print("Nhap tac gia: ");
                    String tacGia = sc.nextLine();

                    System.out.print("Nhap nam xuat ban: ");
                    int namXuatBan = sc.nextInt();

                    System.out.print("Nhap so luong: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();

                    Sach sachMoi = new Sach(maMoi, tieuDe,
                                           tacGia, namXuatBan, soLuong);

                    danhSachSach.add(sachMoi);

                    System.out.println("Them sach thanh cong!");
                    break;

                case 3:
                    // Tim kiem sach theo ma
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();

                    boolean timThay = false;

                    for (Sach sach : danhSachSach) {
                        if (sach.getMaSach().equals(maTim)) {
                            sach.hienThiThongTin();
                            timThay = true;
                            break;
                        }
                    }

                    if (!timThay) {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 4:
                    // Cap nhat thong tin sach
                    System.out.print("Nhap ma sach can sua: ");
                    String maSua = sc.nextLine();

                    boolean daSua = false;

                    for (Sach sach : danhSachSach) {
                        if (sach.getMaSach().equals(maSua)) {
                            System.out.print("Nhap tieu de moi: ");
                            sach.setTieuDe(sc.nextLine());

                            System.out.print("Nhap tac gia moi: ");
                            sach.setTacGia(sc.nextLine());

                            System.out.print("Nhap nam xuat ban moi: ");
                            sach.setNamXuatBan(sc.nextInt());

                            System.out.print("Nhap so luong moi: ");
                            sach.setSoLuong(sc.nextInt());
                            sc.nextLine();

                            System.out.println("Cap nhat thanh cong!");
                            daSua = true;
                            break;
                        }
                    }

                    if (!daSua) {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 5:
                    // Xoa sach theo ma
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();

                    Sach sachCanXoa = null;

                    for (Sach sach : danhSachSach) {
                        if (sach.getMaSach().equals(maXoa)) {
                            sachCanXoa = sach;
                            break;
                        }
                    }

                    if (sachCanXoa != null) {
                        danhSachSach.remove(sachCanXoa);
                        System.out.println("Xoa sach thanh cong!");
                    } else {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (luaChon != 0);
    }
}
