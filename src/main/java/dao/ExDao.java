package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ExVo;

public class ExDao {
	
	SqlSessionFactory factory;
	
	// single-ton : ��ü 1���� �����ؼ� ��� ����ϱ�
	static ExDao single = null;

	public static ExDao getInstance() {
		// ��ü�� ������ �����ϱ�
		if (single == null)
			single = new ExDao();

		return single;
	}

	//�ܺο��� �������ϰ� �ϱ�
	private ExDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<ExVo> selectList() {
		// TODO Auto-generated method stub
		List<ExVo> list = null;
		//1. SqlSession ����
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾�����					namespace.mapper_id
		list = sqlSession.selectList("ex.ex_list");
		
		//3.sqlSession�� ���� Connection�ݱ�
		sqlSession.close();
		
		return list;
	}
	
	
}
