package com.qlsp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QLSP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Sanpham sp = new Sanpham();
		sp.setFlag(1);
		
		HashMap<String, Sanpham> hashmapSP = new HashMap<>();
		int n;

		Thread threadNhap = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (hashmapSP) {
					
					for(int i = 0; i < 1; i++) {
							sp.NhapSP();
							hashmapSP.put(sp.getMaSP(), new Sanpham(sp.getMaSP(), sp.getTenSP(), sp.getSoLuong()));
						}
					hashmapSP.notifyAll();
				}	
			}
		});
		
		Thread threadXuat = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (hashmapSP) {
							
							System.out.println("<---------------------------->");
							Set<Map.Entry<String, Sanpham>> entrie = hashmapSP.entrySet();
							for(Map.Entry<String, Sanpham> sanpham : entrie) {
								Sanpham s = sanpham.getValue();
								s.Hienthi();						
							}
	     			}
			}
	});	
		
		int cs ;
		do {
			System.out.println("n : ");
			cs = Integer.parseInt(new Scanner(System.in).nextLine());
			switch (cs) {
			case 1:
					threadNhap.start();
					try {
						threadNhap.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			case 2:
				threadXuat.start();
				try {
					threadXuat.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		}
		while(cs!=3);
	}
}

//failed
