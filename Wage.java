package wage;
import java.util.Scanner;

public class Wage {
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		do{			//ѭ��������
		System.out.println("������ְ����λ���˳���\n1.Ա��    2.����    3.�ɶ�    4.��ѯ���в��˳�");
		try{
			Scanner s=new Scanner(System.in);
			int t=s.nextInt();
			if(t==1)			//Ա��
			{
				System.out.println("��ѯ����ӣ�1.���    2.��ѯ");
				Scanner sc=new Scanner(System.in);
				int d=sc.nextInt();
				Staff st=new Staff();
				if(d==1)
				{
					st.staffSalary();//���
				}
				else if(d==2)
				{
					st.read();//��ѯ
				}
			}
			else if(t==2)				//����
			{
				System.out.println("��ѯ����ӣ�1.���    2.��ѯ");
				Scanner e=new Scanner(System.in);
				int f=e.nextInt();
				Manager ma=new Manager();
				if(f==1)
				{
					ma.managerSalary();//���
				}
				else if(f==2)
				{
					ma.read();	//��ѯ
				}
			}
			else if(t==3)				//�ɶ�
			{
				Shareholder sh=new Shareholder();
				sh.dividend();	//�ɶ���Ϣ
			}
			else if(t==4)				//��ѯ������Ϣ
			{
				Company cp=new Company();
				cp.read();
				cp.delete();
				break;
			}
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		}while(true);
	}
}
