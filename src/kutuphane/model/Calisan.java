package kutuphane.model;

public abstract class Calisan {
private int id;
private String ad;
private String soyad;

public Calisan(int id,String ad,String soyad) {
	this.id=id;
	this.ad=ad;
	this.soyad=soyad;
}

public abstract void calis();

public int getId() {
	return id;
}
public void setId(int id) {
	this.id=id;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad=ad;
}
public String getSoyad() {
	return soyad;
}
public void setSoyad(String soyad) {
	this.soyad=soyad;
}

public void bilgileriGoster() {
	System.out.println("ID:"+id+"|İsim:"+ad+""+soyad);
}

}
