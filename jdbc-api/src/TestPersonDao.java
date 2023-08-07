import java.util.List;

import com.tekheroes.bean.Person;
import com.tekheroes.dao.PersonDao;
import com.tekheroes.dao.PersonDaoImpl;

public class TestPersonDao {

	public static void main(String[] args) {
		
		PersonDao dao = new PersonDaoImpl();
		
//		Person p1 = new Person("Mike", 32, "Reston");
//		dao.save(p1);
//		
//		Person p2 = dao.fetch("Polo");
//		System.out.println(p2);
//		
//		List<Person> people = dao.list();
//		people.forEach(System.out::println);
		
		dao.remove("Mike");
		
	}
}
