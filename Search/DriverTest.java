import javax.swing.JOptionPane;

public class DriverTest {
    public static void main(String[] args) {
        
        String choice;
        int ch = 0;
        int e;
        Object obj;

        DriverTest test = new DriverTest();
        ArrayList list = new ArrayList();
        while(ch != 8){
            try{
                choice = JOptionPane.showInputDialog(null,
                    "        1. Insert\n"+
                    "        2. Retrieve\n"+
                    "        3. Delete \n"+
                    "        4. Update \n"+
                    "        5. Sort \n"+
                    "        6. Find Key \n"+
                    "        7. PrintAll\n"+
                    "        8. Exit \n"+
                    " ----------------------------------\n");

                ch = Integer.parseInt(choice);
                switch(ch){
                    case 1:
                        //insert
                        list.insert(67);
                        list.insert(32);
                        list.insert(75);
                        list.insert(68);
                        list.insert(58);
                        list.insert(55);
                        list.insert(90);
                        list.insert(35);
                        list.insert(40);
                        list.insert(83);
                        break;
                    case 2:
                        //retrieve
                        obj = list.retrieve();
                        e = (int)obj;
                        JOptionPane.showMessageDialog(null, "Retrieve: "+e);
                        break;

                    case 3:
                        //delete
                        list.delete();
                        break;

                    case 4:
                        //update
                        e = test.getElement();
                        obj = e;
                        list.update(e);
                        break;

                    case 5:
                        //sort
                        list.findFirst();
                        list.printAll();
                        System.out.println("--------------------------------------------------------");
                        list.Sort();
                        System.out.println("--------------------------------------------------------");
                        break;

                    case 6:
                        //findkey
                        e = test.getElement();
						obj=e;
						if (list.findkey(e))
								System.out.println("Found your key:"+list.retrieve());
						else
								JOptionPane.showMessageDialog(null,"Not Found");
                        break;

                    case 7:
                        //show research
                        list.findFirst();
						for(int i = 0;i<list.getSize();i++)
						{
								System.out.print(list.retrieve()+" " );
								list.findNext();
						}
						break;

                    case 8:
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice");
                }
            }catch(Exception err){
                JOptionPane.showMessageDialog(null, "Invalid Input");
                // continue;
            }
        }

        }

        public int getElement()
        {
            int temp = Integer.parseInt(JOptionPane.showInputDialog(null,"Please input number :"));
            return temp;
        }

        public void printElement(int e)
	{
			JOptionPane.showMessageDialog(null,e	);	
	}
    
}