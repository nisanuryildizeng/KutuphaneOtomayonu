package kutuphane.model;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Programin giris noktasidir.
 * Kullanici menusunu gosterir ve kullanicidan secim alarak sistemi yonetir.
 */
public class Main {
	/**
	 * Uygulamanin ana metodudur.Program buradan baslar.
	 * Bir dongu icinde surekli kullaniciya secenekler sunar.
	 * @param args Komut satiri argumanlari (Kullanilmiyor)
	 */
public static void main(String[]args) {
	LibraryManager manager=new LibraryManager();
	Scanner scanner=new Scanner(System.in);
	ArrayList<StudentMember>ogrenciListesi=new ArrayList<>();
	ogrenciListesi.add(new StudentMember("Nisa nur",228));
	ogrenciListesi.add(new StudentMember("Ahmet",101));
	ogrenciListesi.add(new StudentMember("Ayşe",102));
	ogrenciListesi.add(new StudentMember("Ecrin",146));
	ogrenciListesi.add(new StudentMember("Sema",442));
	StudentMember aktifOgrenci=null;
	System.out.println("===SİSTEM BAŞLATILIYOR===");
	boolean devamEdelimMi=true;
	
	while(devamEdelimMi) {
		System.out.println("\n=============KÜTÜPHANE YÖNETİM PANELİ=============");
		System.out.println("1.Kitapları Listele(CSV DAhil)");
		System.out.println("2.Yeni kitap ekle");
		System.out.println("3.Öğrenci kitap ödünç alsın(Demo)");
		System.out.println("4.Kitap iade et(Ceza Hesapla)");
		System.out.println("5.Öğrenci Girişi/Kullancı Değiştir");
		System.out.println("6.Kitap Ara(İsimle)");
		System.out.println("7.Sadece Raftakileri Listele");
		System.out.println("0.Çıkış");
		System.out.println("Seçiminiz: ");
		int secim=scanner.nextInt();
		scanner.nextLine();
		
		switch(secim) {
		case 1:
		manager.listBooks();
			break;
	    case 2:
		  System.out.println("Kitap Adı: ");
		 String ad=scanner.nextLine();
		 System.out.println("Yazar Adı: ");
		 String yazar=scanner.nextLine();
		 System.out.println("Sayfa sayısı: ");
		 int sayfa=scanner.nextInt();
		 int id=(int) (Math.random()*10000);
		 Kitap yeniKitap=new Kitap(id,ad,yazar,sayfa);
		 
		 manager.addBook(yeniKitap);
		 break;
	    case 3:
	    	if(aktifOgrenci==null) {
	    		System.out.println("İŞLEM BAŞARISIZ:Lütfen önce 5'e basarak Giriş Ypaınız!");
	    		break;
	    	}
	    	System.out.println("\n---Hızlı Ödünç Alma Testi---");
	    	System.out.println("Sayın "+aktifOgrenci.getName()+",hangi kitabı ödünç almak istersiniz? ");
	    	System.out.println("Kitap Adı Giriniz: ");
	    	String istenenKitapAdı=scanner.nextLine();
	    	Kitap bulunanKitap=manager.kitapBul(istenenKitapAdı);
	    	if(bulunanKitap != null) {
	    		manager.borrowBook(bulunanKitap, aktifOgrenci);
	    	}
	    	else {
	    		System.out.println("Hata: Kütüphanede '"+istenenKitapAdı+"'isminde bir kitap bulunamadı.");
	    	}
	    	
		break;
		
	    case 4:
	    	if(aktifOgrenci==null) {
	    		System.out.println("İŞLEM BAŞARISIZ:Lütfen önce 5'e basarak Giriş Yapınız!");
	    		break;
	    	}
	    	System.out.println("\n---Kitap İade Ve Ceza Sorgulama---");
	    	System.out.println("İade edilecek kitabın adı: ");
	    	String iadeAd=scanner.nextLine();
	    	Kitap iadeKitap=manager.kitapBul(iadeAd);
	    	if(iadeKitap != null) {
	    		System.out.println("Bu kitabı kaç gündür kullanıyorsunuz?(Gün sayısı): ");
	    		int gun=scanner.nextInt();
	    		scanner.nextLine();
	    		manager.returnBook(iadeKitap, aktifOgrenci, gun);
	    	}
	    	else {
	    		System.out.println("HATA: '"+iadeAd+"'diye bir kitap sistemde yok.");
	    	}
		break;
	    case 5:
	    	System.out.println("\n---Öğrenci Giriş Paneli---");
	    	System.out.println("Giriş yapılacak öğrenci no: ");
	    	int girilenNo=scanner.nextInt();
	    	scanner.nextLine();
	    	boolean bulundu=false;
	    	for(StudentMember ogr:ogrenciListesi) {
	    		if(ogr.getOgrenciNo()==girilenNo) {
	    			aktifOgrenci=ogr;
	    			System.out.println("GİRİŞ BAŞARILI.HOŞGELDİN"+aktifOgrenci.getName());
	    			bulundu=true;
	    			break;
	    		}
	    	}
	    	if(!bulundu) {
	    		System.out.println("HATA:Böyle bir öğrenci numarası yok.");
	    	}
	    	break;
	    case 6:
	    	System.out.print("Aranacak kitap adını(veya bir kısmını) girin: ");
	    	String aranacak=scanner.nextLine();
	    	manager.kitapAra(aranacak);
	    	break;
	    case 7:
	    	manager.raftakileriListele();
	    	break;
		case 0:
			System.out.println("Sistem kapatılıyor.Veriler CSV dosyasında güvende!");
		devamEdelimMi=false;
		break;
		default:
			System.out.println("Hatalı seçim yaptınız,tekrar deneyin.");
		}
	}
	
	Memur memur1=new Memur(2,"Ahmet","Yılmaz");
	
	scanner.close();
}
}
