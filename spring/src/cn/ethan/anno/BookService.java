package cn.ethan.anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service(value="bookService")
public class BookService {
	
	//使用注解方式不需要set方法
	//在dao属性上面使用注解完成对象注入
//	@Autowired
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	public void add() {
		System.out.println("service.......");
		bookDao.add();
	}
}
