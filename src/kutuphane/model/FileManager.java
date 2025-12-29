package kutuphane.model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Dosye okuma ve yazma islemlerini yoneten yardimci siniftir.
 * Verilerin program kapansa bile kaybolmamasini saglar.
 * Verileri "kütüphane_verileri.csv" dosyasinda tutar.
 */
public class FileManager {
private static final String DOSYA_ADI="kütüphane_verileri.csv";
/**
 * Guncel kitap listesini CSV dosyasina kaydeder.
 * Her kitabi satir satir dosyaya yazar.
 * @param kitaplar Kaydedilecek kitap listesi
 */
public static void dosyaYaz(List<Kitap>kitaplar) {
	try(BufferedWriter yazar=new BufferedWriter(new FileWriter(DOSYA_ADI))){
		for(Kitap k:kitaplar) {
			yazar.write(k.toCSV());
			yazar.newLine();
		}
	}
	catch (IOException e) {
		System.out.println("Dosya yazma hatası: "+e.getMessage());
	}
}
/**
 * Program acildiginda CSV dosyasini okuyarak kitaplari geri yukler.
 * @return Dosyadan okunan kitaplarin listesi (ArayList)
 */
public static ArrayList<Kitap>dosyadanOku(){
	ArrayList<Kitap> liste=new ArrayList<>();
	File dosya=new File(DOSYA_ADI);
	if(!dosya.exists()) {
		return liste;
	}
	try (BufferedReader okuyucu=new BufferedReader(new FileReader(DOSYA_ADI))){
		String satir;
		
		while((satir=okuyucu.readLine()) != null) {
			String[] veri=satir.split(";");
			if(veri.length>=4) {
				int id=Integer.parseInt(veri[0]);
				String ad=veri[1];
				String yazar=veri[2];
				int sayfa=Integer.parseInt(veri[3]);
				Kitap k=new Kitap(id,ad,yazar,sayfa);
				if(veri.length>=6) {
					boolean oduncDurumu=Boolean.parseBoolean(veri[4]);
					String alanKisi=veri[5];
					k.setOduncAlindiMi(oduncDurumu);
					if(! alanKisi.equals("null") && !(alanKisi.length()>0)){
						k.setOduncAlanKisi(alanKisi);
					}
				}
				liste.add(k);
			}
		}
	}
	catch (IOException e) {
		System.out.println("Dosya okuma hatası: "+e.getMessage());
	}
	return liste;
}
}
