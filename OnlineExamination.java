package java_project1;
import java.io.*;
import java.util.*;
class OnlineExamination{
    HashMap<String,Integer> data=new HashMap <String,Integer>();
    Scanner sc=new Scanner(System.in);
    public void login(){
        data.put("bhavitha",1121);
        data.put("madhu",1122);
        data.put("vyshnavi",1123);
        data.put("Sita",1124);
        System.out.println("---welcome to online examintaion---");
        System.out.println("Enter your details...");
        System.out.println("Enter USER NAME :");
        String userID=sc.nextLine();
        System.out.println("Enter PASSWORD :");
        int password=sc.nextInt();
        if (data.containsKey(userID) && data.get(userID)==password){
            System.out.println("login successfull!!!");
            menu();
        }
        else{
            System.out.println("enter valid credentials!!...");
            login();
        }
    }
    public void menu(){
        System.out.println("\nSelect any one option:");
        System.out.println("1.EDIT PROFILE AND PASSWORD\n2.START THE EXAM\n3.LOGOUT");
        int op=sc.nextInt();
        switch(op){
            case 1 : data=update();
                     menu();
                     break;
            case 2 : writeExam();
                     menu();
                     break;
            case 3 : System.exit(0);
                     break;
            default: System.out.println("select a valid option!!!");
        }
    }
    public HashMap<String,Integer> update(){
        System.out.println("EDIT YOUR PROFILE HERE");
        System.out.println("Enter username : ");
        Scanner in=new Scanner(System.in);
        String uid=in.nextLine();
        if (data.containsKey(uid)){
            System.out.println("Enter new password : ");
            int newpwd=sc.nextInt();
            data.replace(uid,newpwd);
        }
        else{
            System.out.println("User name doesn't exists");
        }
        System.out.println(" Your Profile updated successfully!!");
        return data;
    }
    public void writeExam(){
        long start=System.currentTimeMillis();
        long end1=start+15*1000;
        long end2=start+30*1000;
        int score1=0,score2=0;
        int cnt1=0,cnt2=0;
        char ans;
        System.out.println("Start the exam!");
        System.out.println("You have 15 seconds to answer the questions in section 1");
        System.out.println("You have  30 seconds to answer the questions in section 2");
        System.out.println(" For Each question in section 1 ,5 marks will be awarded for correct answer");
        System.out.println("1 mark will be deducted for each wrong answer in section 1");
        System.out.println(" For Each question in section 2 ,10 marks will be awarded for correct answer");
        System.out.println("2 marks will be deducted for each wrong answer in section 2");
        System.out.println("start your exam...");
        while(System.currentTimeMillis()<end1){
            System.out.println("***Section 1***");
            System.out.println("1.Number of primitive data types in Java?");
            System.out.println("a.6\nb.7\nc.8\nd.9");
            System.out.println("select your option:");
            ans=sc.next().charAt(0);
            if(ans=='c'){
                cnt1+=1;
            }
            System.out.println("2.Identify the return type of a methd that does not return any value?");
            System.out.println("a.int\nb.void\nc.double\nd.None");
            System.out.println("select your option:");
            ans=sc.next().charAt(0);
            if(ans=='b'){
                cnt1+=1;
            }
            System.out.println("3.Total constructer string class have?");
            System.out.println("a.3\nb.7\nc.13\nd.20");
            System.out.println("select your option:");
            ans=sc.next().charAt(0);
            if(ans=='b'){
                cnt1+=1;
            }
    
            break;
        }
         while(System.currentTimeMillis()<end2){
            System.out.println("***Section 2***");
            System.out.println("1.to which of the following does the class string belong to");
            System.out.println("a.java.lang\nb.java.awt\nc.java.applet\nd.java.string");
            System.out.println("slect  your option:");
            ans=sc.next().charAt(0);
            if(ans=='c') {
                score2+=10;
                cnt2+=1;
            }
            else
                score2-=2;
            System.out.println("2.what is size of float and double in java");
            System.out.println("a.32 and 64\nb.32 and 32\nc.64 and 64\nd.64 and 32");
            System.out.println("slect  your option:");
            ans=sc.next().charAt(0);
            if(ans=='c') {
                score2+=10;
                cnt2+=1;
            }
            else
                score2-=2;
            break;
        }
        System.out.println("exam completed!!");
        score1=cnt1*5-((4-cnt1)*1);
        System.out.println("correct answers in section1 :"+cnt1);
        System.out.println("bhavithacorrect answers in section2 :"+cnt2);
        System.out.println("Your score in section1 :"+score1);
        System.out.println("Your score in section2 :"+score2);
        System.out.println("Your total score is :"+(score1+score2));
    }
    public static void main(String[] args){
        OnlineExamination can=new OnlineExamination();
        can.login();
    }
}

