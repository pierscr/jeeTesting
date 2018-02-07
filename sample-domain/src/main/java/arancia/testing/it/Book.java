package arancia.testing.it;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
@NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b"),
@NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title ='H2G2'")
})
public class Book {

	@Id @GeneratedValue
	private Long id;
	
	private String title;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String string) {
		this.title=string;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
	
}
