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
		//读取数据源文件
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		//SqlSessionFactory对象
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//SqlSession对象
		SqlSession session=factory.openSession();
		//引用接口
		DepartmentMapper dMapper=session.getMapper(DepartmentMapper.class);
		//创建部门信息
		Department d=new Department();
		d.setDname("技术部");
		d.setRemark("无");
		dMapper.insert(d);
		
		//提交操作
		session.commit();
		//释放资源
		session.close();
		
		
	}
}
