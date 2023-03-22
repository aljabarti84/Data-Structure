package BST_Tree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BST implements BST_Interface<customer> {

	/*Root of the BST*/
    customer root;
    static boolean isDeleted= false;
    static boolean isDuplicate=false;    
    static List<customer> nodesToArray =  new ArrayList<>();
 
    /*Constructor of the BST*/
    BST(){
         root = null;
    }
 
    /**********Member Methods************/
	@Override
	public void insert(customer obj) {
		root = insertRecursion(root, obj);
	}
	
    /* Helper Method for insert method */
    private customer insertRecursion(customer root, customer key)
    { 
        /*When node is empty*/
        if (root == null){
            root = key;
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key.getId() < root.getId()) {
        	if(key.getId()==root.getId())
            	isDuplicate = true;
        	else
        		isDuplicate = false;
        	root.left = insertRecursion(root.left, key);        	
        }            
        else if (key.getId() > root.getId()) {
        	if(key.getId()==root.getId())
            	isDuplicate = true;
        	else
        		isDuplicate = false;
        	root.right = insertRecursion(root.right, key);
        }            
        else if(key.getId()==root.getId())
        	isDuplicate = true;
 
        /* return the (unchanged) node pointer */
        return root;
    }

	@Override
	public customer search(int id) {
		customer temp = search(root, id);
		return temp;
	}
	/*Helper method for search*/
	private customer search(customer root, int key)
	{
	    //root is null or key is present at root
	    if (root==null || root.getId()==key)
	        return root;
	    // Key is greater than root's key
	    if (root.getId() < key)
	       return search(root.right, key);
	    // Key is smaller than root's key
	    return search(root.left, key);
	}
	
	@Override
	public void delete(int id) {		
		root = deleteRecursion(root, id);
		if(isDeleted == true) {
			System.out.println("Record Deleted !");
		}else {
			System.out.println("Record not present");
		}
	}
		 
    /*Helper method for delete method*/
    private customer deleteRecursion(customer root, int key)
    {
        /*If the tree is empty */
        if (root == null) {
        	return root;
        }            
 
        /* Otherwise, recur down the tree */
        if (key < root.getId())
            root.left = deleteRecursion(root.left, key);
        else if (key > root.getId())
            root.right = deleteRecursion(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null) {
            	isDeleted = true;
            	return root.right;
            }
            else if (root.right == null) {
            	isDeleted = true;
            	return root.left;
            }
            // node with two children: Get the in-order
            // successor (smallest in the right subtree)
            root.setId(min(root.right));
            
            // Delete the in-order successor
            root.right = deleteRecursion(root.right, root.getId());             
        }        
        
        return root;
    }
    /*Helper method for deleteRecursion method*/
    private int min(customer root){
        int min = root.getId();
        while (root.left != null){
        	min = root.left.getId();
            root = root.left;
        }
        return min;
    }
	
    /*Method to retrieve all the records in in-order*/
    void inorder(){
         inorderRecursion(root);
    }
 
    /*Helper method for in-order method*/
    private void inorderRecursion(customer root){
        if (root != null) {        	
        	inorderRecursion(root.left);
            System.out.println("ID: "+root.getId()+"\nName: "+root.getName()
            +"\nPhone No: "+ root.getPhone()+"\nEmail: "+root.getEmail()+"\n");            
            inorderRecursion(root.right);           
        }
    }
    
    /*BST node to array*/
    void nToA(customer root){
        if (root != null) {
        	nToA(root.left);
        	nodesToArray.add(root);
            nToA(root.right);
        }		
    }
    
    /*Count total records in bst*/
    int size(customer node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }    
    
	/*******************************************************************************
	 *********** Main method (Driver of the Code) 
	 * @throws IOException **********************************
	 *******************************************************************************/
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BST bst = new BST();	
		String fileName = "";
		
		/*From file to BST*/		
		try {
    		File f = new File("customerData.txt");    	
        	fileName = f.getName();
    		FileReader fr = new FileReader(f);
        	BufferedReader br  = new BufferedReader(fr);
        	
        	String s = (br.readLine());        	
        	while (s!=null) {
        		String[] tokens = s.split(",");        		
        		if(tokens.length==1) {
        			customer cs = new customer(Integer.parseInt(tokens[0]),null,null,null);
        			bst.insert(cs);
        		}
        		if(tokens.length==2) {
        			customer cs = new customer(Integer.parseInt(tokens[0]),tokens[1],null,null);
        			bst.insert(cs);
        		}
        		if(tokens.length==3) {
        			customer cs = new customer(Integer.parseInt(tokens[0]),tokens[1],tokens[2],null);
        			bst.insert(cs);
        		}
        		if(tokens.length==4) {
        			customer cs = new customer(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3]);
            		bst.insert(cs);
        		}        		        		
        		s = br.readLine();
        	}
        	fr.close();
        	br.close();
    	}
    	catch(Exception i) {
    		System.out.println(i.getMessage());	
    	}		
		
		/******************* User Menu********************/		
		
		int again;
		do {			
			Scanner in = new Scanner(System.in);		
			System.out.println("======================================");
			System.out.println("  Welcome to Hotel Management System");
			System.out.println("======================================");
			System.out.println("\t1. Insert new Record.");
			System.out.println("\t2. Delete Record.");
			System.out.println("\t3. Search Record.");
			System.out.println("\t4. See all Records.");
			System.out.println("\t5. Save & Exit.");
			System.out.println("======================================");
			System.out.print("Enter your choice >> ");
		     int a = in.nextInt();
			 switch(a) {
				
				case 1:					
					Scanner scr = new Scanner(System.in);
					System.out.println("_____________________________________");						
					System.out.print("Enter ID for Customer >>");
					int id = in.nextInt();
					System.out.print("Enter Name of Customer >> ");
					String name = scr.nextLine();
					System.out.print("Enter Phone No of Customer >>");
					String phone = scr.nextLine();
					System.out.print("Enter Email of Customer >> ");
					String email = scr.nextLine();
					
					customer cs = new customer(id,name,phone,email);					
					bst.insert(cs);
					if(isDuplicate==false) {
						System.out.println("\n------Inserted Successfully-------");
					}						
					else {
						System.out.println("\n``````````````````````````````````````");
						System.out.println("ID already registered, Try another.");
					}
					break;
					
				/*To delete record by id*/						
				case 2:
					Scanner inp = new Scanner(System.in);									
					System.out.println("``````````````````````````````````````");
					System.out.print("Enter ID to Delete >> ");
					int idDel = inp.nextInt();
					
					/*Firstly to search*/
					customer temp = bst.search(idDel);
					if(temp!=null) {
						System.out.println("ID: "+temp.getId()+"\nName: "+temp.getName()+"\nPhone No: "+temp.getPhone()+"\nEmail: "+temp.getEmail());
						System.out.print("\nConfirm to delete [yes(1)]");
						int conf = inp.nextInt();
						if(conf==1) {
							bst.delete(idDel);							
						}
					}						
					else {
						System.out.println("Item not present");
					}					
					break;
				
				/*To search record by id*/	
				case 3:					
					inp = new Scanner(System.in);
					System.out.println("_____________________________________");					
					System.out.print("Enter ID to Search >> ");
					int idSrch = inp.nextInt();
										
					temp = bst.search(idSrch);
					if(temp!=null) {
						System.out.println("ID: "+temp.getId()+"\nName: "+temp.getName()+"\nPhone No: "+temp.getPhone()+"\nEmail: "+temp.getEmail());						
					}						
					else {
						System.out.println("Item not present");
					}
					break;
					
				/*to retrieve all the records*/	
				case 4:					
					System.out.println("_____________________________________");
					int total = bst.size(bst.root);
					System.out.println("\tTotal Records: "+total);
					System.out.println("``````````````````````````````````````");
					bst.inorder();
					
					break;
					
				/*to save records in file and exit*/	
				case 5:
					/*First to retrieve records from bst*/
					bst.nToA(bst.root);
					
					/*Secondly, to shuffle and store in file*/
					try {
			        	File f = new File("customerData.txt");
			        	FileWriter fw = new FileWriter(f);
			        	BufferedWriter br  = new BufferedWriter(fw);
			        	
			        	Collections.shuffle(nodesToArray);			        	
			        	for(int i=0 ; i<nodesToArray.size() ; i++) {
			        		temp = nodesToArray.get(i);
			        		br.write(temp.getId()+","+temp.getName()+","+temp.getPhone()+","+temp.getEmail()+"\n");
			        	}			      
			        	br.close();
			        	fw.close();
			    	}
			    	catch(Exception i) {
			    		System.out.println(i.getMessage());
			    	}
					/*close the application*/
					System.out.print("__________________________________________________");
					int tot = bst.size(bst.root);
					System.out.println("\n["+tot+"] Customer Records Saved in "+fileName+" File");
					System.out.println("```````````````````````````````````````````````````");
					System.exit(0);					
					break;				
			}			 
			System.out.println("_____________________________________");
			System.out.println("\nDo you want to continue ? [yes(1)]");
			again = in.nextInt();
			for (int i = 0; i < 50; ++i) System.out.println(); /*to clear screen*/
		}while(again==1);
		
	}	
}















