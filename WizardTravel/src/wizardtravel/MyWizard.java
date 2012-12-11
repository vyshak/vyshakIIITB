package wizardtravel;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class MyWizard extends Wizard implements INewWizard{

  protected page1 one;
  protected page2 two;
  protected page3 three;
  Statement queryToExecute;
  String query;
  Connection conn;
  public MyWizard() {
    super();
    setNeedsProgressMonitor(true);
  }

  @Override
  public void addPages() {
    one = new page1();
    two = new page2();
    three= new page3();
    addPage(one);
    addPage(two);
    addPage(three);
    
  }

  public boolean canFinish(){
	  
	  if(getContainer().getCurrentPage()== one)
		  return false;
	  else if(getContainer().getCurrentPage()== two)
		  if(two.checkPageComplete())
			  return true;
		  else 
			  return false;
	  return true;
  }
  @Override
  public boolean performFinish() {
	  //String TravelName= new String();
	  String TravelName= one.getText1();
	  String from= two.getText1();
	  String to= two.getText2();
	  String via=two.getVia();
	  StringBuffer travelDate= three.getDate();
	  String agent= three.getAgent();
    // Print the result to the console
    System.out.println(TravelName);
    System.out.println(from);
    System.out.println(to);
    System.out.println(via);
    System.out.println(travelDate);
    System.out.println(agent);
    //System.out.println(two.getText1());
    queryInsert(TravelName, from, to, via, travelDate, agent);
   
    
    return true;
  }
public void queryInsert(String TravelName,String from,String to,String via,StringBuffer travelDate,String agent ){
	try{
        Class.forName("com.mysql.jdbc.Driver");
          conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagency", "root", "password");
            queryToExecute = (Statement) conn.createStatement();
        }
        catch (Exception ex)
        {
            
        }
    
    query= "insert into traveldetails values('" + TravelName+ "','"+from+ "','"+
    		to+ "','"+via+ "','"+travelDate+ "','"+agent+ "')";
    System.out.println(query);
    try {
		queryToExecute.executeUpdate(query);
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Override
public void init(IWorkbench workbench, IStructuredSelection selection) {
	// TODO Auto-generated method stub
	
}
} 