package com.qlsp;

import java.util.Scanner;

public class Sanpham {
	
	private String MaSP;
	private String TenSP;
	private int SoLuong;
	private int flag;
	
	public Sanpham() {};
	
	public Sanpham(String MaSP, String TenSP, int SoLuong) {
		this.MaSP = MaSP;
		this.TenSP = TenSP;
		this.SoLuong = SoLuong;
	}
	
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int i) {
		this.flag = i;
	}

	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		this.MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		this.TenSP = tenSP;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(Integer soLuong) {
		this.SoLuong = soLuong;
	}
	
	public void NhapSP() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.print("Nhap Ma SP: ");
		MaSP = sc.nextLine();
		@SuppressWarnings("resource")
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Nhap Ten SP: ");
		TenSP = sc2.nextLine();
		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(System.in);
		System.out.print("Nhap so luong SP: ");
		SoLuong = Integer.parseInt(sc3.nextLine());
	}
	public void Hienthi() {
		System.out.printf("\nMã SP: %-5s Tên SP: %-7s SL: %-5d",  getMaSP(), getTenSP(), getSoLuong());
		System.out.println();
	}
}
