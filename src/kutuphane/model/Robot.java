package kutuphane.model;

public class Robot extends Calisan{
public Robot(int id,String ad,String soyad) {
	super(id,ad,soyad);
}

@Override
public void calis() {
	System.out.println(getAd()+" isimli robot kütüphane raflarini düzenliyor.");
}



}
