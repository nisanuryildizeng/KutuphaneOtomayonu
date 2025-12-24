package kutuphane.model;

public class Memur extends Calisan{
public Memur(int id,String ad,String soyad) {
	super(id,ad,soyad);
}

@Override
public void calis() {
	System.out.println(getAd()+"isimli memur evrakları düzenliyor.");
	
}
}
