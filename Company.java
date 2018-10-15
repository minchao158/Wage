package wage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Company {
	static File file=new File("File.txt");
	String name;				//姓名
	int page;					//工资
	Calendar time;				//生日
//	int YEAR=0;
	int[] wage=new int[12];		//存储每月工资
	
	static List<Company> list=new ArrayList<>();	//存储Company子类对象

	void delete()
	{
		file.delete();
	}
	
	public int  wage() 				//工资总额
	{
		int wageSum=0;				//每一成员计算工资时初始化
		for(int i=0;i<wage.length;i++)
		{
			wageSum=wageSum+wage[i];
		}
		return wageSum;
	}
	void read()					//向文件读取所有数据
	{
		try {
			StringBuilder result=new StringBuilder();
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String s=null;
			while((s=br.readLine())!=null)
			{
				result.append(System.lineSeparator()+s);
			}
			String str=result.toString();				//获取文件数据用字符串存储
			String a="员工";
			String b="经理";
			String c="股东";
			while(str.contains(a))					//遇到员工输出其信息
			{
			String t=str.substring(str.indexOf(a), str.indexOf("#"));
			System.out.println(t.toString()+"\n");
			t=t+"#";
			str=str.replace(t, "");						//删除其信息
			}
			while(str.contains(b))						//遇到经理输出其信息
			{
				String t=str.substring(str.indexOf(b),str.indexOf("@"));
				System.out.println(t.toString()+"\n");
				t=t+"@";
				str=str.replace(t,"");						//删除其信息
			}
			while(str.contains(c))						//遇到股东输出其信息
			{
				String t=str.substring(str.indexOf(c),str.indexOf("￥"));
				System.out.println(t.toString()+"\n");
				t=t+"￥";
				str=str.replace(t, "");						//删除其信息
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}