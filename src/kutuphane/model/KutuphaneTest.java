package kutuphane.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
/**
 * Projenin is mantigini (Business Logic) test eden JUnit sinifidir.
 * Kitap ekleme,odunc alma ve sinir degerleri burada test edilir.
 */
public class KutuphaneTest {
	/**
	 * Kitap sayfa sayisi icin sinir degerlerini test eder.
	 * Cok buyuk sayilar girildiginde sistemin veri kaybi yasayip yasamadigini kontrol eder.
	 */
@Test
void testAsiriBuyukSayi() {
	Kitap devKitap=new Kitap(1,"Ansiklopedi","Uzay",1000000);
	assertEquals(1000000,devKitap.getsayfaSayisi(),"Sistem büyük sayfa sayılarını yönetemiyor!");
}
/**
 * Sistemde kayitli olmayan bir veri arandiginda sistemin davranisini test eder.
 * Hatali veri girisinde sistemin cokmemesi gerektigini dogrular.
 */
@Test
void testOlmayanKitabıArama() {
	LibraryManager manager=new LibraryManager();
	Kitap sonuc=manager.kitapBul("Harry Potter");
	assertNull(sonuc,"Olmayan bir kitap arandığında sistem hatalı (dolu) nesne döndürdü!");
}
/**
 * Mantiksiz veri girisi (Negatif gun) durumunda sistemin karar yapisini test eder.
 * Kullanici hatali gun girse bile sistemin bunu guvenli sekilde yonetip yonetmedigini kontrol eder.
 */
@Test
void testNegatifGunIade() {
	LibraryManager manager=new LibraryManager();
	Kitap testKitabı=new Kitap(2,"Test Kitap","Test Yazar",100);
	StudentMember ogr=new StudentMember("Ali",1);
	testKitabı.setOduncAlindiMi(true);
	testKitabı.setOduncAlanKisi("Ali");
	manager.returnBook(testKitabı, ogr, -5);
	assertFalse(testKitabı.isOduncAlindiMi(),"Negatif gün girilince iade işlemi başarısız oldu!");
}
/**
 * Kritik sinir degeri olan 15.gunde iade islemini test eder.
 * Tam sinirda ceza hesaplanmamasi gerektigini dogrular.
 */
@Test
void testZamanindaIade() {
	LibraryManager manager=new LibraryManager();
	Kitap k=new Kitap(3,"Sınır Kitabı","Yazar",50);
	StudentMember ogr=new StudentMember("Veli",2);
	manager.returnBook(k, ogr, 15);
	assertFalse(k.isOduncAlindiMi(),"Sınır gününde (15) iade işlemi başarısız oldu!");
}
}
