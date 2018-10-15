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

	 public int profit()				//��˾����
	{
		 int pay=0;
		for(int i=0;i<list.size();i++)
		{
			pay=pay+list.get(i).wage();
		}
		profit=allMoney-pay;				//����=��Ӫҵ��-����֧��
		return profit;
	}
	 int p=profit();
	public void setNameStock(String name,double stock)		//���ùɶ������͹ɷ�
	{
		this.name=name;
		this.stock=stock;
	}
	
	void print()							//������ɶ���Ϣ
	{
		System.out.println(this.name+"     "+this.stock+"     "+String.format("%.2f", this.stock*p*0.1));	
	}
	
	
	void read()			//���ļ���ȡ�ɶ���Ϣ
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
			
			System.out.println("������Ҫ��ѯ�Ĺɶ�������");
			Scanner sc=new Scanner(System.in);
			String c=sc.nextLine();
			
			String d=c+"#";
			if(str.contains(str))
			{
				System.out.println("�ɶ�����        �ɷ�       �ֺ�");
			String t=str.substring(str.indexOf(str), str.indexOf(d));
			System.out.println(t.toString()+"\n");
			}
			else
				System.out.println("�����ֲ����ڣ�");
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void dividend()						//���ùɶ���Ϣ�����ļ�д��
	{try {
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bf=new BufferedWriter(fw);
		
		Shareholder sh1=new Shareholder();
		Shareholder sh2=new Shareholder();
		Shareholder sh3=new Shareholder();
		Shareholder sh4=new Shareholder();
		sh1.setNameStock("�ɶ�1",0.1);
		
		sh2.setNameStock("�ɶ�2",0.2);
		sh3.setNameStock("�ɶ�3",0.3);
		sh4.setNameStock("�ɶ�4",0.4);
		System.out.println("���ɶ����շֺ�������\n"+"�ɶ�       �ɷ�       �ֺ�");
		bf.write("���ɶ����շֺ�������");
		bf.newLine();
		bf.write("�ɶ�       �ɷ�       �ֺ�");
		bf.newLine();
		
		sh1.print();					//�������10%���ɷݷ��䲢������λС��
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
		bf.write("��");					//���ļ����ùɶ���Ϣ��־
		bf.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
