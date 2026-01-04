package kutuphane.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Kitap ekleme,listeleme,odunc verme ,iade alma ve arama islemlerini yonetir.
 * Verleri bir liste icinde tutar ve yonetir.
 * Kutuphane otomasyonunun ana beyni gibidir.
 */
public class LibraryManager {
private List<Kitap>books;
public LibraryManager() {
	this.books=FileManager.dosyadanOku();//üst satır yerine bunu ekledim.
	if(this.books==null) {
		this.books=new ArrayList<>();
	}
}
/**
 * Kutuphaneye yeni bir kitap ekler.
 * Eklenen kitabı listeye kaydeder ve kalici olmasi icin dosyaya yazar.
 * @param book Eklenecek olan Kitap nesnesi
 */
public void addBook(Kitap book) {
	if(book.getsayfaSayisi()== -1) {
		System.out.println("HATA: Kitap envantere eklenemedi.Çünkü sayfa sayısı kurallara uymuyor.");
	}
	books.add(book);
	System.out.println("System:'"+book.getAd()+"'Kütüphane envanterine eklendi.");
	FileManager.dosyaYaz(books);
}
/**
 * Kutuphanedeki tum kitaplari (odunc verilenler dahil) ekrana listeler.
 * Kitaplarin ID,isim,yazar ve durum bilgilerini gosterir.
 */
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
/**
 * Bir ogrencinin kitap odunc almasini saglar.
 * Eger kitap raftaysa ogrenciye verir,baskasindaysa uyari gosterir.
 * @param book Istenen kitap nesnesi
 * @param student student Kitabi almak isteyen ogrenci
 */
public void borrowBook(Kitap book,StudentMember student) {
	if(book.isOduncAlindiMi()) {
		System.out.println("HATA: '"+book.getAd()+"kitabı verilemez!");
		System.out.println("Çünkü bu kitap şu an şu kişide: "+book.getOduncAlanKisi());
	}
	else {
		book.setOduncAlindiMi(true);
		book.setOduncAlanKisi(student.getName());
	System.out.println("BAŞARILI: '"+book.getAd()+"'kitabı,"+student.getName()+" kişisine verildi.");
	FileManager.dosyaYaz(books);
}
}
/**
 * Kitap iade islemlerini gerceklestirir.
 * Kitabin kac gun sonra getirildigine bakarak gecikme cezasi hesaplar.
 * Kitabin durumunu tekrar 'Rafta' olarak gunceller.
 * @param book Iade edilen kitap
 * @param student Iade eden ogrenci
 * @param gunSayisi Kitabin kac gun sureyle kaldigi
 */
public void returnBook(Kitap book,StudentMember student,int gunSayisi) {
	int izinSure=15;
	int gunlukCeza=5;
	//78 ile 82 arası yeni eklendi.
	if(gunSayisi<0) {
		System.out.println("HATA: Geçersiz gün sayısı! Gün eksi (-) olmamalı.");
		System.out.println("İşlem iptal edildi.");
		return;
	}
	
	if(gunSayisi>izinSure) {
		int gecikme=gunSayisi-izinSure;
		int ceza=gecikme*gunlukCeza;
		System.out.println("Geç İade:!"+gecikme+" gün gecikmişsiniz.");
		System.out.println("Sayın "+student.getName()+" ödemeniz gereken ceza: "+ceza+"TL");
	}
	else {
		System.out.println("Teşekkürler "+student.getName()+",kitabı zamanında getirdiniz.Ceza yok.");
	}
	book.setOduncAlindiMi(false);
	System.out.println("BAŞARILI: '"+book.getAd()+"' kitabı envantere geri eklendi.");
	FileManager.dosyaYaz(books);	
}
/**
 * Kullanicin girdigi kelimeye gore kitap aramasi yapar.
 * Kitap isminin icinde aranan kelime geciyorsa sonuclari listeler.
 * @param arananKelime Aranacak kelime veya kitap adi parcasi
 */
public void kitapAra(String arananKelime) {
	boolean bulundu=false;
	System.out.println("\n---Arama Sonuçları: '"+arananKelime+"'---");
	
	for(Kitap k:books) {
		if(k.getAd().toLowerCase().contains(arananKelime.toLowerCase())){
			System.out.println("BULUNDU ID: "+k.getId()+"|"+k.getAd()+"("+k.getYazar()+")");
			bulundu=true;
		}
	}
	if(!bulundu) {
		System.out.println("Maalesef bu isimde bir kitap bulunamadı.");
	}
}
/**
 * Sadece kutuphanede mevcut olan (baskasinda olmayan) kitaplari listeler.
 * Odunc alinmaya musait kitaplari gormek icin kullanilir.
 */
public void raftakileriListele() {
	System.out.println("\n---ŞU An Kiralanabilir Kitaplar---");
	boolean kitapVar=false;
	for(Kitap k:books) {
		if(!k.isOduncAlindiMi()) {
			System.out.println("MÜSAİT ID: "+k.getId()+"|"+k.getAd()+"("+k.getYazar()+")");
			kitapVar=true;
		}
	}
	if(!kitapVar) {
		System.out.println("(!) Tüm kitaplar ödünç verilmiş,rafta kitap kalmadı.!");
	}
}
}