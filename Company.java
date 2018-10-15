package wage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Company {
	static File file=new File("File.txt");
	String name;				//����
	int page;					//����
	Calendar time;				//����
//	int YEAR=0;
	int[] wage=new int[12];		//�洢ÿ�¹���
	
	static List<Company> list=new ArrayList<>();	//�洢Company�������

	void delete()
	{
		file.delete();
	}
	
	public int  wage() 				//�����ܶ�
	{
		int wageSum=0;				//ÿһ��Ա���㹤��ʱ��ʼ��
		for(int i=0;i<wage.length;i++)
		{
			wageSum=wageSum+wage[i];
		}
		return wageSum;
	}
	void read()					//���ļ���ȡ��������
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
			String str=result.toString();				//��ȡ�ļ��������ַ����洢
			String a="Ա��";
			String b="����";
			String c="�ɶ�";
			while(str.contains(a))					//����Ա���������Ϣ
			{
			String t=str.substring(str.indexOf(a), str.indexOf("#"));
			System.out.println(t.toString()+"\n");
			t=t+"#";
			str=str.replace(t, "");						//ɾ������Ϣ
			}
			while(str.contains(b))						//���������������Ϣ
			{
				String t=str.substring(str.indexOf(b),str.indexOf("@"));
				System.out.println(t.toString()+"\n");
				t=t+"@";
				str=str.replace(t,"");						//ɾ������Ϣ
			}
			while(str.contains(c))						//�����ɶ��������Ϣ
			{
				String t=str.substring(str.indexOf(c),str.indexOf("��"));
				System.out.println(t.toString()+"\n");
				t=t+"��";
				str=str.replace(t, "");						//ɾ������Ϣ
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}