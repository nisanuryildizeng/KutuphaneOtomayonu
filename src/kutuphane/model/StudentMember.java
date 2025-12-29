package kutuphane.model;
/**
 * Ogrenci uyeleri temsil eden siniftir.
 * IMember arayuzunu uygular(Implementation).
 */
public class StudentMember implements IMember{
private String name;
private int studentId;
/**
 * Yeni bir ogrenci uyesi olusturur.
 * @param name Ogrencinin adi
 * @param studentId Ogrenci numarasi
 */
public StudentMember(String name,int studentId) {
	this.name=name;
	this.studentId=studentId;
}
@Override
public void borrowBook(Kitap book) {
	System.out.println("Öğrenci"+name+"("+studentId+"),'"+book.getAd()+"'kitabını ödünç aldı.");
}
@Override
public void returnBook(Kitap book) {
	System.out.println("Öğrenci"+name+"("+studentId+"),'"+book.getAd()+"'kitabını iade etti.");
}
public String getName() {
	return name;
}
public int getOgrenciNo() {
	return studentId;
}


}
