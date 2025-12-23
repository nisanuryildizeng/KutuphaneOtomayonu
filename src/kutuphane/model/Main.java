package kutuphane.model;
import java.util.Scanner;
public class Main {
public static void main(String[]args) {
	System.out.println("===Kütüphane Sistemi Başlatılıyor===");
	LibraryManager manager=new LibraryManager();
	Robot asimo=new Robot(1,"Asimo","Honda");
	asimo.calis();
	Kitap k1=new Kitap(101,"java ile programlama","Ali Veli",350);
	Kitap k2=new Kitap(102,"Sefiller","Victor Hugo",1200);
	manager.addBook(k1);
	manager.addBook(k2);
	manager.listBooks();
	StudentMember ogrenci=new StudentMember("Nisanur",228);
	System.out.println("\n---Ödünç Alma İşlemi---");
	ogrenci.borrowBook(k1);
	
	System.out.println("\n---Sistem Kapatılıyor.---");
	
	
	
	
}
}
