package myxm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map; 

public class Password {
public boolean Pa(String content,String content2) {
    Map<String,String> map=new HashMap<String,String>();
    map.put("root", "123");
    String i=content.replace(" ","");
    String j=content2.replace(" ","");
    return j.equals(map.get(i));        
}

}
class FileSave{
       public static void save() throws IOException {
        File f=new File("Staff.txt");
        if(f.exists()) {
            f.delete();
        }
        f.createNewFile();
        FileWriter fw=null;
        fw=new FileWriter("Staff.txt");
        int i;
        for(i=0;i<chief.data.size();i++) {
            String tmp=new String(chief.data.get(i).getId()+"\t"+chief.data.get(i).getName()+"\t"+chief.data.get(i).getSex()+"\t"+chief.data.get(i).getAge()+"\t"+chief.data.get(i).getBasic()+"\t"+chief.data.get(i).getAllowances()+"\t"+chief.data.get(i).getInterated());
            fw.write(tmp+"\r\n");
        } 
        fw.close();
}

}

class FileRead {
public static void read() throws IOException {   
        FileReader fr=null;
        int i,j;
        fr=new FileReader("Staff.txt");
        BufferedReader br=new BufferedReader(fr); 
        String line=br.readLine();  
        while(line!=null) {
            if(line.equals("")) {
                line=br.readLine();
                continue;
            }
            Staff s=new Staff();
            String tmp[]=line.split("\\s");                
                for(j=0;j<tmp.length;j++) {
                switch(j) {
                    case 0:
                        s.setId(tmp[j]);
                        break;
                    case 1:
                        s.setName(tmp[j]);
                        break;
                    case 2:
                        s.setSex(tmp[j]);
                        break;
                    case 3:
                        s.setAge(tmp[j]);
                        break;
                    case 4:
                        s.setBasic(tmp[j]);
                        break;
                    case 5:
                        s.setAllowances(tmp[j]);
                        break;
                    case 6:
                        s.setInterated(tmp[j]);
                        break;
                    }
                }
                boolean flag=true;
                for(i=0;i<chief.data.size();i++) {
                if(s.getId().equals(chief.data.get(i).getId())) {
                    flag=false;
                }
            }
                if(flag) {
                    chief.data.add(s);
                }
                line=br.readLine();
        }
        fr.close();

}

}
class Staff {
private String id;
private String name;
private String sex;
private String age;
private String basic;
private String allowances;
private String interated;

public Staff() {
}

public Staff(String id,String name,String sex,String age,String basic,String allowances,String interated) {
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.basic = basic;
    this.allowances = allowances;
    this.interated = interated;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getSex() {
    return sex;
}
public void setSex(String sex) {
    this.sex = sex;
} 
public String getAge() {
    return age;
}
public void setAge(String age) {
    this.age = age;
} 
public String getBasic() {
    return basic;
}
public void setBasic(String basic) {
    this.basic = basic;
}

public String getAllowances() {
    return allowances;
}
public void setAllowances(String allowances) {
    this.allowances = allowances;
}

public String getInterated() {
    return interated;
}

public void setInterated(String interated) {
    this.interated = interated;
}
}