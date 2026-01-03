package kutuphane.model;
/**
 * Kutuphane calisanlari icin hazirlanmis SOYUT (Abstract) temel siniftir.
 * Bu siniftan dogrudan nesne uretilemez,sadece miras alinabilir.
 * Calisanlarin ortak ozelliklerini (ID,Ad,Soyad) yonetir.
 * Memur gibi alt siniflara miras verir.
 */
public abstract class Calisan {
private int id;
private String ad;
private String soyad;
/**
 * Ortak ozellikleri baslatan yapici metot.
 * @param id Calisanin ID numarasi
 * @param ad Calisanin Adi
 * @param soyad Calisanin Soyadi
 */
public Calisan(int id,String ad,String soyad) {
	this.id=id;
	this.ad=ad;
	this.soyad=soyad;
}


/**
 * Calisanin ID numarasini dondurur.
 * @return ID
 */ 
public int getId() {
	return id;
}
/**
 * Calisanin ID numarasini ayarlar.
 * @param id Yeni ID
 */
public void setId(int id) {
	this.id=id;
}
/**
 * Calisanin adini dondurur.
 * @return Isim
 */
public String getAd() {
	return ad;
}
/**
 * Calisanin adini gunceller.
 * @param ad Yeni Isim
 */
public void setAd(String ad) {
	this.ad=ad;
}
/**
 * Calisanin soyadini dondurur.
 * @return Soyisim
 */
public String getSoyad() {
	return soyad;
}
/**
 * Calisanin soyadini gunceller.
 * @param soyad Yeni Soyisim
 */
public void setSoyad(String soyad) {
	this.soyad=soyad;
}
/**
 * Calisanin kimlik bilgilerini ekrana yazdiran somut metot.
 * Alt siniflar bu metodu oldugu gibi kullanilabilir veya @Override edebilir.
 */
public void bilgileriGoster() {
	System.out.println("ID:"+id+"|İsim:"+ad+""+soyad);
}

}
