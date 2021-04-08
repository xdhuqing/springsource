import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lu shun zhi
 * @version 1.0.0
 * @date 2019/11/9 23:54
 */
public class TestApplication {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//		String name = applicationContext.getApplicationName();
//		System.out.println("name = " + name);


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		PojoClass pojo = context.getBean(PojoClass.class);
		pojo.sayHello();
		CommentsInValue comment = context.getBean(CommentsInValue.class);
		comment.myName();



	}
}
