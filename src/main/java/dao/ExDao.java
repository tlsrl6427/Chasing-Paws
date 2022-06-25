package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ExVo;

public class ExDao {
	
	SqlSessionFactory factory;
	
	// single-ton : 객체 1개만 생성해서 계속 사용하기
	static ExDao single = null;

	public static ExDao getInstance() {
		// 객체가 없으면 생성하기
		if (single == null)
			single = new ExDao();

		return single;
	}

	//외부에서 생성못하게 하기
	private ExDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<ExVo> selectList() {
		// TODO Auto-generated method stub
		List<ExVo> list = null;
		//1. SqlSession 생성
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행					namespace.mapper_id
		list = sqlSession.selectList("ex.ex_list");
		
		//3.sqlSession이 얻어온 Connection닫기
		sqlSession.close();
		
		return list;
	}
	
	
}
