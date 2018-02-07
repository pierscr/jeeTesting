package arancia.testing.it;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.AssertTrue;

import org.eclipse.persistence.internal.jpa.parsing.GreaterThanEqualToNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

			private static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("chapter04TestPU");
			private EntityManager em;
			private EntityTransaction tx;
			
			@Before
			public void initEntityManager() throws Exception {
				System.out.println("test------------->");				
				em = emf.createEntityManager();
				tx = em.getTransaction();
			}
			@After
			public void closeEntityManager() throws Exception {
				if (em != null) em.close();
			}

//			@Test
//			public void shouldFindJavaEE7Book() throws Exception {
//				System.out.println("test------------->2");
//				Book book = em.find(Book.class, 1001L);
//				assertEquals("Beginning Java EE 7", book.getTitle());
//			}
			 
			@Test
			public void shouldCreateH2G2Book() throws Exception {
				
				System.out.println("test------------->3");
			 
				// Creates an instance of book
				Book book = new Book("H2G2");
				
				System.out.println(book.getTitle());
				// Persists the book to the database
				tx.begin();
				em.persist(book);
				tx.commit();
				assertNotNull("ID should not be null", book.getId());
				 
				// Retrieves all the books from the database
				book = em.createNamedQuery("findAllBooks", Book.class).getSingleResult();
				List<Book> books=em.createNamedQuery("findAllBooks", Book.class).getResultList();				
				assertEquals("H2G2", book.getTitle());
				System.out.println(books.size());
				assertTrue(books.size()>1);
				}
				 
//			@Test(expected = ConstraintViolationException.class)
//				public void shouldRaiseConstraintViolationCauseNullTitle() {
////				 
////				Book book = new Book(null);
////				em.persist(book);
//			}
//	
}
