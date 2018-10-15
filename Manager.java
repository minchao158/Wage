package wage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Manager extends Company{
	int[] bonus=new int[12];
	int bonusAll=0;
	public int bonus()
	{
		for(int i:bonus)
		{
			bonusAll=bonusAll+i;
		}
		return bonusAll;
	}
	
void read()											//向文件读取数据 
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
		String str=result.toString();				//讲文件数据以字符串形式存储
		
		System.out.println("请输入要查询的经理姓名：");
		Scanner sc=new Scanner(System.in);
		String c=sc.nextLine();
		
		String d="@"+c;
		if(str.contains(str))				//判断是否存在
		{
		String t=str.substring(str.indexOf(c), str.indexOf(d));
		System.out.println(t.toString()+"\n");
		}
		else
			System.out.println("该名字不存在！");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

	@SuppressWarnings({ "resource", "unused" })
	void managerSalary()					//写入经理信息并写入文件
	{

		try {
			FileWriter fw=new FileWriter(file,true);		//设置为true可多次向文件添加数据
			BufferedWriter bf=new BufferedWriter(fw);

		System.out.println("请输入添加经理名字：");
		Scanner a=new Scanner(System.in);
		String str=a.nextLine();
		bf.write("经理姓名："+str);
		bf.newLine();							//写入姓名

		System.out.println("请输入生日：YYYYMMDD");
		Scanner c=new Scanner(System.in);
		String s=c.nextLine();
		bf.write("生日为："+s);						//写入生日
		bf.newLine();
		
		String s1=s.substring(0, 4);
		String s2=s.substring(4, 6);
		String s3=s.substring(6, 8);
		int year=Integer.parseInt(s1);
		int month=Integer.parseInt(s2);
		int day=Integer.parseInt(s3);
		
		System.out.println("请输入要发工资的年份：YYYY");
		Scanner e=new Scanner(System.in);
		String f=e.nextLine();
		int year2=Integer.parseInt(f);		
	
		for(int i=year2;i<2020;i++)
		{
			System.out.println(i+"年的工资如下：");
			bf.write(i+"年的工资为：");
			bf.newLine();
			
			for(int j=0;j<12;j++)
			{
				this.wage[j]=(int)(6000+Math.random()*3000);
			}
			for(int j=0;j<12;j++)
			{
				bonus[j]=(int)(Math.random()*200);
				System.out.println((j+1)+"月的工资为："+this.wage[j]+"    奖金为："+bonus[j]);
				bf.write((j+1)+"月的工资为："+this.wage[j]+"    "+"奖金为："+bonus[j]);						//写入工资信息
				bf.newLine();
			}
			int t=bonus();
			int t2=wage();
			int t3=(int)(100+Math.random()*200);
			System.out.println(i+"年的总奖金为："+t);
			bf.write(i+"年的总奖金为："+t);
			bf.newLine();
			System.out.println(i+"年的生日奖励为："+t3);
			bf.write(i+"年的生日奖励为："+t3);				//写入生日奖励
			System.out.println(i+"年的总工资为："+(t+t2+t3));
			bf.newLine();
			bf.write(i+"年的总工资为："+(t+t2+t3));
			bf.newLine();
			
			list.add(this);
			try{System.out.println("是否继查看下一年工资？");
			Scanner d=new Scanner(System.in);
			String q=d.nextLine();
			if(q.equals("yes"))
			{
				
			}
			else if(q.equals("no"))
				{
					break;
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
			bf.write("@"+str+"          ");					//向文件设置经理标记
			bf.newLine();
			bf.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
