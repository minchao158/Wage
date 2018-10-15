package wage;
import java.util.Scanner;

public class Wage {
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		do{			//循环主程序
		System.out.println("请输入职工岗位或退出：\n1.员工    2.经理    3.股东    4.查询所有并退出");
		try{
			Scanner s=new Scanner(System.in);
			int t=s.nextInt();
			if(t==1)			//员工
			{
				System.out.println("查询或添加：1.添加    2.查询");
				Scanner sc=new Scanner(System.in);
				int d=sc.nextInt();
				Staff st=new Staff();
				if(d==1)
				{
					st.staffSalary();//添加
				}
				else if(d==2)
				{
					st.read();//查询
				}
			}
			else if(t==2)				//经理
			{
				System.out.println("查询或添加：1.添加    2.查询");
				Scanner e=new Scanner(System.in);
				int f=e.nextInt();
				Manager ma=new Manager();
				if(f==1)
				{
					ma.managerSalary();//添加
				}
				else if(f==2)
				{
					ma.read();	//查询
				}
			}
			else if(t==3)				//股东
			{
				Shareholder sh=new Shareholder();
				sh.dividend();	//股东信息
			}
			else if(t==4)				//查询所有信息
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
