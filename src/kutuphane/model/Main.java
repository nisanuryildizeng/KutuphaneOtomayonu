package kutuphane.model;
import java.util.Scanner;
public class Main {
public static void main(String[]args) {
	LibraryManager manager=new LibraryManager();
	Scanner scanner=new Scanner(System.in);
	System.out.println("===SİSTEM BAŞLATILIYOR===");
	Robot asimo=new Robot(1,"Asimo","Honda");
	asimo.calis();
	
	boolean devamEdelimMi=true;
	
	while(devamEdelimMi) {
		System.out.println("\n=============KÜTÜPHANE YÖNETİM PANELİ=============");
		System.out.println("1.Kitapları Listele(CSV DAhil)");
		System.out.println("2.Yeni kitap ekle");
		System.out.println("3.Öğrenci kitap ödünç alsın(Demo)");
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
	    	System.out.println("\n---Hızlı Ödünç Alma Testi---");
	    	StudentMember ogr=new StudentMember("Nisanur",228);
	    	System.out.println("Sayın "+ogr.getName()+",hangi kitabı ödünç almak istersiniz? ");
	    	System.out.println("Kitap Adı: ");
	    	String istenenKitapAdı=scanner.nextLine();
	    	Kitap bulunanKitap=manager.kitapBul(istenenKitapAdı);
	    	if(bulunanKitap != null) {
	    		manager.borrowBook(bulunanKitap, ogr);
	    	}
	    	else {
	    		System.out.println("Hata: Kütüphanede '"+istenenKitapAdı+"'isminde bir kitap bulunamadı.");
	    	}
		//StudentMember ogr=new StudentMember("Nisanur",228);
		//Kitap ornek=new Kitap(99,"Nutuk","Atatürk",600);
		//ogr.borrowBook(ornek);
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
	memur1.calis();
	
	
	scanner.close();
}
}
