import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.nm.mapper.DepartmentMapper;
import com.nm.mapper.DepartmentMapper02;
import com.nm.model.Department;

public class Test2 {
	public static void main(String[] args) throws IOException {
		//��ȡ����Դ�ļ�
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		//SqlSessionFactory����
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//SqlSession����
		SqlSession session=factory.openSession();
		//���ýӿ�
		DepartmentMapper02 dMapper=session.getMapper(DepartmentMapper02.class);
		
		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("dname", "sss");
//		map.put("remark", "sss");
		//List<Map<String,Object>> list=dMapper.find1(map);
		//System.out.println(list.get(0).get("dname"));
//		System.out.println(list.size());
//		System.out.println(list.get(0).get("dname"));
		
	    List<Integer> l=new ArrayList<Integer>();
	    l.add(1);
	    l.add(21);
	    
	    map.put("d_id",l);//HashMap<String,Object>()
	    
	    map.put("dname", "������");
		List<Map<String,Object>> list=dMapper.find3(map);
		
		for(Map<String,Object> m:list){
			//System.out.println(list.size());
			System.out.println(m.get("dname"));
		}
		
		//�ύ����
		session.commit();
		//�ͷ���Դ
		session.close();
		
		
	}
}
