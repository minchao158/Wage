package wage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Staff extends Company  {
	static int giftSum=0;
	int [] gift=new int[10];

	public int gift()
	{
		for(int i:gift)
		{
			giftSum=giftSum+i;
		}
		return giftSum;
	}
	
	void read()					//���ļ���ȡԱ����Ϣ
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
			String str=result.toString();			//���ļ����ַ�����ʽ�洢
			
			System.out.println("������Ҫ��ѯ��Ա��������");
			Scanner sc=new Scanner(System.in);
			String c=sc.nextLine();
			
			String d="#"+c;
			if(str.contains(c))			//�ж��Ƿ����
			{
			String t=str.substring(str.indexOf(c), str.indexOf(d));
			System.out.println(t.toString()+"\n");
			}
			else
				System.out.println("�����ֲ����ڣ�");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void staffSalary()								//����Ա����Ϣ��д���ļ�
	{
		int GIFT=0;
		try {
			FileWriter fw=new FileWriter(file,true);
			BufferedWriter bf=new BufferedWriter(fw);

		System.out.println("���������Ա�����֣�");
		Scanner a=new Scanner(System.in);
		String str=a.nextLine();
		bf.write("Ա��������"+str);
		bf.newLine();					//д������

		System.out.println("���������գ�YYYYMMDD");
		Scanner c=new Scanner(System.in);
		String s=c.nextLine();
		bf.write("����Ϊ��"+s);				//д������
		bf.newLine();
		
		String s1=s.substring(0, 4);
		String s2=s.substring(4, 6);
		String s3=s.substring(6, 8);
		int year=Integer.parseInt(s1);
		int month=Integer.parseInt(s2);
		int day=Integer.parseInt(s3);
	
		System.out.println("������Ҫ�����ʵ���ݣ�YYYY");
		Scanner e=new Scanner(System.in);
		String f=e.nextLine();
		final int year2=Integer.parseInt(f);		
		for(int i=year2;i<2020;i++)
		{
			System.out.println(i+"��Ĺ������£�");
			bf.write(i+"��Ĺ���Ϊ��");
			bf.newLine();
			
			for(int j=0;j<12;j++)
			{
				this.wage[j]=(int)(2000+Math.random()*2000);
			}
			for(int j=0;j<12;j++)
			{
				if((j+1)==month)
				{
					gift[GIFT]=(int)(Math.random()*200);
				
				}
				System.out.println((j+1)+"�µĹ���Ϊ��"+this.wage[j]);
				bf.write((j+1)+"�µĹ���Ϊ��"+this.wage[j]);					//д�빤����Ϣ
				bf.newLine();
			}
			System.out.println(i+"�����������Ϊ��"+gift[GIFT]);
			bf.write(i+"�����������Ϊ��"+gift[GIFT]);						//д�����ս���
			bf.newLine();
			GIFT++;
			int t=this.wage();
			int t2=this.gift();
			System.out.println(i+"����ܹ���Ϊ��"+(t+t2));
			bf.write(i+"����ܹ���Ϊ��"+(t+t2));
			bf.newLine();
			
			list.add(this);									//�����ݴ���list
			
			try{System.out.println("�Ƿ�̲鿴��һ�깤�ʣ�");
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
		bf.write("#"+str+"        ");						//���ļ�����Ա�����
		bf.newLine();
		bf.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}