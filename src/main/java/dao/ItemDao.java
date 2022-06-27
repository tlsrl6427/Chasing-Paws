package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CharacterVo;
import vo.ItemVo;

public class ItemDao {

	SqlSessionFactory factory;

	// single-ton : 객체 1개만 생성해서 사용하자!
	// 여러군데에서 호출을 받기 때문에, single-ton 형식으로 생성함
	// 스태틱객체는 무조건 하나만 만들어진다.
	static ItemDao single = null;

	// 스태틱은 무조건 스태틱으로만
	public static ItemDao getInstance() {

		// 객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new ItemDao();

		return single;
	}

	// 외부에서 객체를 생성하지 못하게 막음
	private ItemDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<ItemVo> selectList(int i_idx) {
		// TODO Auto-generated method stub

		List<ItemVo> list = null;

		// 1. SqlSession 얻어오기
		SqlSession sqlSession = factory.openSession();

		// 2. 실행
		list = sqlSession.selectList("item.item_list", i_idx);

		// 3. session close
		sqlSession.close();

		return list;
	}

}
