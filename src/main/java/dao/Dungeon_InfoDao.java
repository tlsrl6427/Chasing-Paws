package dao;

import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;

public class Dungeon_InfoDao {
	
	SqlSessionFactory factory;
	
	// single-ton : 객체 1개만 생성해서 사용하자!
	// 여러군데에서 호출을 받기 때문에, single-ton 형식으로 생성함
	// 스태틱객체는 무조건 하나만 만들어진다.
	static Dungeon_InfoDao single = null;

	// 스태틱은 무조건 스태틱으로만
	public static Dungeon_InfoDao getInstance() {

		// 객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new Dungeon_InfoDao();

		return single;
	}

	// 외부에서 객체를 생성하지 못하게 막음
	private Dungeon_InfoDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	
}
