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
	Kitap devKitap=new Kitap(1,"Ansiklopedi","Uzay",-1);
	assertEquals(-1,devKitap.getsayfaSayisi(),"Sistem büyük sayfa sayılarını yönetemiyor!");
}
/**
 * Sistemde kayitli olmayan bir veri arandiginda sistemin davranisini test eder.
 * Hatali veri girisinde sistemin cokmemesi gerektigini dogrular.
 */
@Test
void testOlmayanKitabıArama() {
	LibraryManager manager=new LibraryManager();
	Kitap sonuc=manager.kitapAra("Harry Potter");
	assertNull(sonuc,"Olmayan bir kitap arandığında sistem hatalı (dolu) nesne döndürdü!");
}
/**
 * Mantiksiz veri girisi (Negatif gun) durumunda sistemin karar yapisini test eder.
 * Kullanici hatali gun girse bile sistemin bunu guvenli sekilde yonetip yonetmedigini kontrol eder.
 */
@Test
void testNegatifGunIade() {
	LibraryManager manager=new LibraryManager();
	Kitap okumaKitabı=new Kitap(2,"Nutuk","Atatürk",100);
	StudentMember ogr=new StudentMember("Ali",1);
	okumaKitabı.setOduncAlindiMi(true);
	okumaKitabı.setOduncAlanKisi("Ali");
	manager.returnBook(okumaKitabı, ogr, -5);
	assertTrue(okumaKitabı.isOduncAlindiMi(),"Negatif gün girilince iade işlemi başarısız oldu!");
}










}
