# Kutuphane Otomasyon Sistemi

Bu proje,Nesne Tabanlı Programlama dersi kapsamında JAVA dili kullanılarak geliştirilmiştir.

##Projenin Amacı
Kütüphanedeki kitap envanterinin yönetilmesi,üyelerin (öğrenci) kitap ödünç alma/iade etme süreçlerinin takibi ve gecikme durumunda ceza puanı hesaplanması işlemlerini simüle eden bir otomasyon sistemidir.

##Temel Özellikler
Kitap Yönetimi:Sisteme yeni kitap ekleme,kitap arama ve mevcut kitapları listeleme.
Üye Takibi:Öğrenci (StudentMember) üyelerin sisteme kaydı ve yönetimi.
Ödünç/İade Döngüsü:Kitapların ödünç alınması ve iade edilmesi.
Ceza Sistemi:İade tarihi geciken kitaplar için otomatik ceza puanı hesaplama.
Veri Kalıcılığı:Kitap ve üye verilerinin program kapansa bile kaybolmaması için dosya sistemine kaydedilmesi.
Abstraction(Soyutlama):Calisan soyut sınıfı (abstract class) oluşturularak,tüm çalışanların ortak özellikleri (Ad,Soyad) tek bir çatıda toplandı.
IMember arayüzü (interface) ile üyelerin sahip olması gereken zorunlu yetenekler (kitap al/iade et) belirlenmiştir.
İnheritance(Kalıtım):Memur sınıfı,Calisan sınıfından türetilmiştir.Kod tekrarı önlenmiştir.
Encapsulation(Kapsülleme):Kitap ve StudentMember sınıflarınadki hassa veriler (örneğin ID,ceza puanı) 'private' yapılarak dış erişime kapatılmış,erişim kontrollü getter/setter metodları ile sağlanmıştır.
Polymorphism(Çok biçimlilik):Sistemde üyeler 'IMember' referansı üzerinden yönetilerek,ileride eklenebilecek yeni üye tiplerine (Örn Akademisyen) açık,esnek bir yapı kurulmuştur.

##Sınıf Yapısı
Main.java:Uygulamanın giriş noktası ve menü yönetimi.
LibraryManager.java:Sistemin beyni.Tüm iş mantığı burada döner.
FileManager.java:Dosya okuma/yazma işlemlerini yöneten yardımcı sınıf.
Kitap.java:Kitap nesnesi modeli.
StudentMember.java:Öğrenci üye modeli (IMember implementasyonu).
Memur.java:Sistem yetkilisi (Calisan alt sınıfı).





