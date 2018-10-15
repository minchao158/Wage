package wage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Shareholder extends Company{
	static int allMoney=(int)(200000+Math.random()*list.size()*200000);
	int profit=0;
	double stock;

	 public int profit()				//公司利润
	{
		 int pay=0;
		for(int i=0;i<list.size();i++)
		{
			pay=pay+list.get(i).wage();
		}
		profit=allMoney-pay;				//利润=总营业额-工资支出
		return profit;
	}
	 int p=profit();
	public void setNameStock(String name,double stock)		//设置股东姓名和股份
	{
		this.name=name;
		this.stock=stock;
	}
	
	void print()							//输出各股东信息
	{
		System.out.println(this.name+"     "+this.stock+"     "+String.format("%.2f", this.stock*p*0.1));	
	}
	
	
	void read()			//向文件读取股东信息
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
			String str=result.toString();
			
			System.out.println("请输入要查询的股东姓名：");
			Scanner sc=new Scanner(System.in);
			String c=sc.nextLine();
			
			String d=c+"#";
			if(str.contains(str))
			{
				System.out.println("股东姓名        股份       分红");
			String t=str.substring(str.indexOf(str), str.indexOf(d));
			System.out.println(t.toString()+"\n");
			}
			else
				System.out.println("该名字不存在！");
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void dividend()						//设置股东信息并向文件写入
	{try {
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bf=new BufferedWriter(fw);
		
		Shareholder sh1=new Shareholder();
		Shareholder sh2=new Shareholder();
		Shareholder sh3=new Shareholder();
		Shareholder sh4=new Shareholder();
		sh1.setNameStock("股东1",0.1);
		
		sh2.setNameStock("股东2",0.2);
		sh3.setNameStock("股东3",0.3);
		sh4.setNameStock("股东4",0.4);
		System.out.println("各股东年终分红的情况：\n"+"股东       股份       分红");
		bf.write("各股东年终分红的情况：");
		bf.newLine();
		bf.write("股东       股份       分红");
		bf.newLine();
		
		sh1.print();					//讲利润的10%按股份分配并保留两位小数
		bf.write(sh1.name+"     "+sh1.stock+"     "+String.format("%.2f", sh1.stock*p*0.1));
		bf.newLine();
		
		sh2.print();
		bf.write(sh2.name+"     "+sh2.stock+"     "+String.format("%.2f", sh2.stock*p*0.1));
		bf.newLine();
		
		sh3.print();
		bf.write(sh3.name+"     "+sh3.stock+"     "+String.format("%.2f", sh3.stock*p*0.1));
		bf.newLine();
		
		sh4.print();
		bf.write(sh4.name+"     "+sh4.stock+"     "+String.format("%.2f", sh4.stock*p*0.1));
		bf.newLine();
		bf.write("￥");					//向文件设置股东信息标志
		bf.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
