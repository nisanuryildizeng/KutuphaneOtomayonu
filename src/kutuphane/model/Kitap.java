package kutuphane.model;
/**
 * Kutuphanedeki bir kitabı temsil eden model sinifidir.
 * Kitabin adi ,yazari,sayfa sayisi ve odunc durumunu tutar.
 * Encapsulation kullanilarak ,degiskenler private tanimlanmiş ve erisim getter/setter metodlari ile saglanmistir.
 */
public class Kitap{//Encapsulation
	private int id;
	private String ad;
	private String yazar;
	private int sayfaSayisi;
	private boolean oduncAlindiMi;
	
	
	private String oduncAlanKisi="";
	public String getOduncAlanKisi() {
		return oduncAlanKisi;
	}
	public void setOduncAlanKisi(String isim) {
		this.oduncAlanKisi=isim;
	}
	/**
	 * Yeni bir kitap olusturmak icin kullanilan yapici metot.
	 * @param id Kitabin numarasi
	 * @param ad Kitabin adi
	 * @param yazar Kitabin yazari
	 * @param sayfaSayisi Kitabin sayfa sayisi
	 */
	
	//Constructor
	public Kitap(int id,String ad,String yazar,int sayfaSayisi) {
		this.id=id;
		this.ad=ad;
		this.yazar=yazar;
		//this.sayfaSayisi=sayfaSayisi;
		setSayfaSayisi(sayfaSayisi);
		this.oduncAlindiMi=false;
	}
	/**
	 * Kitabin odunc durumunu kontrol eder.
	 * @return Eğer kitap baskasindaysa true,raftaysa false doner.
	 */
	
	//Veri okuma getter setter kullanimi
	public int getId() {
		return id;
	}
	public String getAd() {
		return ad;
	}
	public String getYazar() {
		return yazar;
	}
	public int getsayfaSayisi() {
		return sayfaSayisi;
	}
	/**
	 * Kitap bilgilerini CSV dosyasina yazilacak formata cevirir.
	 * @return Aralarinda noktali virgul olan String verisi
	 */
	public String toCSV() {
		return id+";"+ad+";"+yazar+";"+sayfaSayisi+";"+oduncAlindiMi+";"+oduncAlanKisi;//oduncleri sonradan ekledim.
	}
	
	//veri değiştirme
	public boolean isOduncAlindiMi() {
		return oduncAlindiMi;
	}
	public void setOduncAlindiMi(boolean durum) {
		this.oduncAlindiMi=durum;
	}
	@Override
	public String toString() {
		return "Kitap:"+ad+"("+yazar+")";
	}
	public void setSayfaSayisi(int sayfaSayisi) {
		if(sayfaSayisi<=0 || sayfaSayisi>10000) {
			System.out.println("UYARI: "+sayfaSayisi+"sayfa sayısı çok yüksek yanlış sayfa sayısı girmiş olabilirsiniz.");
			this.sayfaSayisi=-1;
		}
		else {
			this.sayfaSayisi=sayfaSayisi;
		}
	}
}