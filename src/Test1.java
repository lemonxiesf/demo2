import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.nm.mapper.DepartmentMapper;
import com.nm.model.Department;

public class Test1 {
	public static void main(String[] args) throws IOException {
		//��ȡ����Դ�ļ�
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		//SqlSessionFactory����
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//SqlSession����
		SqlSession session=factory.openSession();
		//���ýӿ�
		DepartmentMapper dMapper=session.getMapper(DepartmentMapper.class);
		//����������Ϣ
		Department d=new Department();
		d.setDname("������");
		d.setRemark("��");
		dMapper.insert(d);
		
		//�ύ����
		session.commit();
		//�ͷ���Դ
		session.close();
		
		
	}
}
