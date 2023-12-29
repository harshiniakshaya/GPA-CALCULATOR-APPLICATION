// COMMAND PROMPT
import java.sql.*;  
import java.util.*;

public class gpacse{
    public static int grade(String g){
        if ("o".equalsIgnoreCase(g))
            return 10;
        if ("a+".equalsIgnoreCase(g))
            return 9;
        if ("a".equalsIgnoreCase(g))
            return 8;
        if ("b+".equalsIgnoreCase(g))
            return 7;
        if ("b".equalsIgnoreCase(g))
            return 6;
        if ("c".equalsIgnoreCase(g))
            return 5;
        return 0;
    }
    public static void main(String[] args){
        try{
            Scanner s = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa","root","");
            Statement st = con.createStatement();
            ResultSet rs1= st.executeQuery("show tables");
            while(rs1.next()){
                String tc=rs1.getString("Tables_in_gpa");
                System.out.println(tc);
            }
            //st.close();
            //rs.close();
            //con.close();
            char c;
            do{
            System.out.print("Enter your Semester:");
            int sem=s.nextInt();
            //System.out.println("semester : "+sem);
            int sum=0; String gr; 
            s.nextLine();
           /* String q1="select * from semester"+sem;
            //preparedStatement - ps
            PreparedStatement ps1 = con.prepareStatement(q1);*/
            String q1="select * from semester?";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ps1.setInt(1,sem);
            ResultSet rs=ps1.executeQuery();
            
            String q2="select sum(credits) from semester"+sem;
            PreparedStatement ps2 = con.prepareStatement(q2);
            ResultSet rs2=ps2.executeQuery();
            rs2.next();
            int cr=rs2.getInt("sum(credits)");
        
            while(rs.next()){
                String sub=rs.getString("name");
                System.out.print(sub+" :");
                gr=s.nextLine();
                int grpt=grade(gr);
                int subcr=rs.getInt("credits");
                //System.out.println(gpt);
                sum+=(grpt*subcr);
            }
            //System.out.println(gpt);
            //System.out.println(sum);
            double gpa = (double)sum/(double)cr;
            System.out.println("Your grade is :" + gpa);
            System.out.println("Do you want to continue(y/n)");
            c=s.nextLine().charAt(0);
            }
            while(c=='y');
            

        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    
}
	
