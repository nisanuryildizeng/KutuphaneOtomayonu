package kutuphane.model;
/**
 * Kutuphane uyeleri (Ogrenci,Personel vb.) icin Interface belirler.
 * Polymorphism (Cok bicimlilik) yapisini destekler.
 */
public interface IMember {
	/**
	 * Uyenin bir kitabi odunc alma islemini tanimlar.
	 * @param book Odunc alinacak kitap nesnesi
	 */
void borrowBook(Kitap book );
/**
 * Uyenin elindeki kitabi iade etme islemini tanimlar.
 * @param book Iade edilecek kitap nesnesi
 */
void returnBook(Kitap book);
}
