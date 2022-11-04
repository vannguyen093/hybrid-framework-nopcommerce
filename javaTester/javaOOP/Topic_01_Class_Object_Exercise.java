package javaOOP;

public class Topic_01_Class_Object_Exercise {
    public static void main(String[] args) {
        Topic_01_Class_Object_Exercise firstStudent = new Topic_01_Class_Object_Exercise();
        firstStudent.setMaSinhVien(1);
        firstStudent.setHoTen("Nguyen Van A");
        firstStudent.setDiemLyThuyet(6.4f);
        firstStudent.setDiemThucHanh(8.4f);
        firstStudent.showThongTinSinhVien();
    }
    private int maSinhVien;
    private String hoTen;
    private float diemLyThuyet;
    private float diemThucHanh;

    private float diemTrungBinh;

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiemLyThuyet() {
        return diemLyThuyet;
    }

    public void setDiemLyThuyet(float diemLyThuyet) {
        this.diemLyThuyet = diemLyThuyet;
    }

    public float getDiemThucHanh() {
        return diemThucHanh;
    }

    public void setDiemThucHanh(float diemThucHanh) {
        this.diemThucHanh = diemThucHanh;
    }

    public Float getdiemTrungBinh(){
        return (this.diemLyThuyet + this.diemThucHanh * 2) / 3;
    }

    public void showThongTinSinhVien(){
        System.out.println("Mã Sinh Viên: " + this.maSinhVien);
        System.out.println("Họ tên: " + this.hoTen);
        System.out.println("Điểm lý thuyết: " + this.diemLyThuyet);
        System.out.println("Điểm thực hành: " + this.diemThucHanh);
        System.out.println("Điểm trung bình: " + getdiemTrungBinh());
    }
}
