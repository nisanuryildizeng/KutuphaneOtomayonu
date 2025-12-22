package kutuphane.model;
public class Kitap{//Encapsulation
	private int id;
	private String ad;
	private String yazar;
	private int sayfaSayisi;
	private boolean oduncAlindiMi;
	
	
	//Constructor
	public Kitap(int id,String ad,String yazar,int sayfaSayisi) {
		this.id=id;
		this.ad=ad;
		this.yazar=yazar;
		this.sayfaSayisi=sayfaSayisi;
		this.oduncAlindiMi=false;
	}
	
	//Veri okuma
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
}