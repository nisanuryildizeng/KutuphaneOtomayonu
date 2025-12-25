package kutuphane.model;

import java.util.ArrayList;
import java.util.List;


public class LibraryManager {
private List<Kitap>books;
public LibraryManager() {
	this.books=new ArrayList<>();
}

public void addBook(Kitap book) {
	books.add(book);
	System.out.println("System:'"+book.getAd()+"'Kütüphane envanterine eklendi.");
}
public void listBooks() {
	System.out.println("\n---Kütüphane Arşivi---");
	for(Kitap book:books) {
		System.out.println("ID:"+book.getId()+"|Kitap:"+book.getAd());
	}
}

public Kitap kitapBul(String kitapAdi) {
	for(Kitap k:books) {
		if(k.getAd().equalsIgnoreCase(kitapAdi)) {
			return k;
		}
		}
	return null;
	}

/*public void borrowBook(Kitap book,StudentMember student) {
	if(book.isOduncAlindiMi()) {
		System.out.println("Hata:'"+book.getAd()+"'kitabı şuan başkasında,verilemez.");
	}
	else {
		book.setOduncAlindiMi(true);
		System.out.println("BAŞARILI: '"+book.getAd()+"'kitabı,"+student.getName()+" adlı öğrenciye teslim edildi.");
	}
	
	
}*/

public void borrowBook(Kitap book,StudentMember student) {
	if(book.isOduncAlindiMi()) {
		System.out.println("HATA: '"+book.getAd()+"kitabı verilemez!");
		System.out.println("Çünkü bu kitap şu an şu kişide: "+book.getOduncAlanKisi());
	}
	else {
		book.setOduncAlanKisi(student.getName());
	
	System.out.println("BAŞARILI: '"+book.getAd()+"'kitabı,"+student.getName()+"kişisine verildi.");
}
}



public void returnBook(Kitap book,StudentMember student,int gunSayisi) {
	int izinSure=15;
	int gunlukCeza=5;
	
	if(gunSayisi>izinSure) {
		int gecikme=gunSayisi-izinSure;
		int ceza=gecikme*gunlukCeza;
		System.out.println("Geç İade:!"+gecikme+"gün gecikmişsiniz.");
		System.out.println("Sayın "+student.getName()+"ödemeniz gereken ceza: "+ceza+"TL");
	}
	else {
		System.out.println("Teşekkürler"+student.getName()+",kitabı zamanında getirdniz.Ceza yok.");
	}
	book.setOduncAlindiMi(false);
	System.out.println("BAŞARILI: '"+book.getAd()+"'kitabı envantere geri eklendi.");
	
	
	
}



}
