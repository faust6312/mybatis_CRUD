import com.pzhu.dao.TeacherMapper;
import com.pzhu.domain.Teacher;
import com.pzhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;



public class MyTest {
	@Test
	public void testGetTeacher() {
		SqlSession session = MybatisUtils.getSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher(1);
		System.out.println(teacher.getName());
		System.out.println(teacher.getStudents());
	}
}


