package kutuphane.model;

import java.util.ArrayList;
import java.util.List;


public class LibraryManager {
private List<Kitap>books;
public LibraryManager() {
	this.books=new ArrayList<>();
}

public void addBook(Kitap book) {
	books.add(book);
	System.out.println("System:'"+book.getAd()+"'Kütüphane envanterine eklendi.");
}
public void listBooks() {
	System.out.println("\n---Kütüphane Arşivi---");
	for(Kitap book:books) {
		System.out.println("ID:"+book.getId()+"|Kitap:"+book.getAd());
	}
}


}
