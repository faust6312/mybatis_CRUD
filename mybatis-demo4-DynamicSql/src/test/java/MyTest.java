import com.pzhu.dao.BlogMapper;
import com.pzhu.pojo.Blog;
import com.pzhu.utils.IDutils;
import com.pzhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
 @Test
 public void addInitBlog(){
 SqlSession session = MybatisUtils.getSession();
 BlogMapper mapper = session.getMapper(BlogMapper.class);

  Blog blog = new Blog();

 blog.setTitle("NOIDTEST");
 blog.setAuthor("faust");
 blog.setCreateTime(new Date());
 blog.setViews(9999);
  mapper.addBlog(blog);
 session.commit();
 session.close();
 }

 @Test
 public void testQueryBlogIf() {
  SqlSession session = MybatisUtils.getSession();
  BlogMapper mapper = session.getMapper(BlogMapper.class);
  HashMap<String, String> map = new HashMap<String, String>();
map.put("title","动态SQL");

 //map.put("author", "JOE");//if语句可以有多个条件，如查找都有“Java如此简单”和“JOE”这两个字段的数据
  List<Blog> blogs = mapper.queryBlogIf(map);
  System.out.println(blogs);
  session.close();
 }


 @Test
 public void testUpdateBlog(){
 SqlSession session = MybatisUtils.getSession();
 BlogMapper mapper = session.getMapper(BlogMapper.class);
 HashMap<String, String> map = new HashMap<String, String>();
 map.put("title","动态SQL");//update更新数据，此处根据id更新
 map.put("author","faust");
 map.put("views","8888");
 map.put("id","1");

 mapper.updateBlog(map);
 session.commit();
 session.close();
 }
// @Test
//// public void testdeleteBlog(){
////  SqlSession session = MybatisUtils.getSession();
////  BlogMapper mapper = session.getMapper(BlogMapper.class);
////  List<Integer> list = new ArrayList<>();
////  list.add(1);
////  list.add(2);
////
////  session.close();
//// }

 @Test
 public void testQueryBlogChoose(){
 SqlSession session = MybatisUtils.getSession();
 BlogMapper mapper = session.getMapper(BlogMapper.class);
 HashMap<String, Object> map = new HashMap<String, Object>();
 map.put("title","动态SQL");//choose只能查其中一个条件，只执行一条查询SQL语句
 map.put("author","JOE");
 map.put("views",9999);
 List<Blog> blogs = mapper.queryBlogChoose(map);
 System.out.println(blogs);
 session.close();
 }


 @Test
 public void testQueryBlogForeach(){
 SqlSession session = MybatisUtils.getSession();
 BlogMapper mapper = session.getMapper(BlogMapper.class);
 HashMap map = new HashMap();
 List<Integer> ids = new ArrayList<Integer>();
 ids.add(1);
 ids.add(2);
 ids.add(3);
 map.put("ids",ids);
 List<Blog> blogs = mapper.queryBlogForeach(map);
 System.out.println(blogs);
 session.close();
 }



}
