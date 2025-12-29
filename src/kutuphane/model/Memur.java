package kutuphane.model;
/**
 * Kutuphane personelini temsil eden siniftir.
 * IMember arayuzunu uygular.
 */
public class Memur extends Calisan{
	/**
	 * Yeni bir memur olusturur.
	 * 'super' anahtar kelimesi ile Abstract olan Calisan yapicisini cagirir.
	 * @param id Personel Sicil No
	 * @param ad Personel Adi
	 * @param soyad Personel Soyadi
	 */
public Memur(int id,String ad,String soyad) {
	super(id,ad,soyad);
}

@Override
public void calis() {
	System.out.println(getAd()+"isimli memur evrakları düzenliyor.");
	
}
}
