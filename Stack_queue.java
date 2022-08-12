/*
 *  Java Program to Create a Stack using Two Queues
 */
 
import java.util.*;
 
class Test
{
    Queue<Integer> q1 ;
    Queue<Integer> q2 ; //temporary Queue
 
    /* Constructor */
    public Test()
    {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }    
    /*  Function to push an element to the stack */
    public void push(int data)
    {
        /* if no element is present in queue q1 then
         * enqueue the new element into q1  */         
        if (q1.size() == 0) 
        {
            q1.add(data);
        }
        else
        {
            /* if elements are present in q1 then
             * dequeue all the elements to 
             * temporary queue q2 */             
            int n = q1.size();
            for (int i = 0; i < n; i++)
            {
                q2.add(q1.remove());
            }                
            /* enqueue the new element into q1 */
            q1.add(data);        
            /* dequeue all the elements from
             * temporary queue q2 to q1 */                 
            for (int i = 0; i < n; i++)
            {
                q1.add(q2.remove());
            }
        }
    }    
    /*  Function to remove top element from the stack */
    public int pop()
    {
        if (q1.size() == 0)
        {
            throw new NoSuchElementException("stack is Underflow");
        }        
        return q1.remove();
    }    
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if (q1.size() == 0)
        {
            throw new NoSuchElementException("stack is Underflow");
        }              
        return q1.peek();
    }        
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return q1.size() == 0 ;
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return q1.size();
    }    
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nElements in Stack = ");
        int n = getSize();
        if (n == 0)
        {
            System.out.print("Stack is Empty\n");
        }
        else
        {
            Iterator it = q1.iterator();
            while (it.hasNext())
            {
                System.out.print(it.next()+" ");
            }
            System.out.println();
        }
    }
}
/*  Class Stack_queue  */
public class Stack_queue
{    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);      
        Test t = new Test();                  
        /* Perform Stack Operations */          
        System.out.println("Stack Using Two Queues\n");  
        char ch;     
        do 
        {
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");            
            int choice = scan.nextInt();
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter integer element to push");
                t.push( scan.nextInt() );                 
                break;                          
            case 2 : 
                try
                {
                    System.out.println("Popped Element is  = "+ t.pop() );
                }
                catch (Exception e)
                {
                    System.out.println("Found Error : " + e.getMessage());
                }        
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peeked Element is = "+ t.peek() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ t.isEmpty() );
                break;                
            case 5 : 
                System.out.println("Size = "+ t.getSize() ); 
                break;            
            default :  
                System.out.println("Wrong Entry \n ");
                break;
            }                 
            /* Display Stack */        
            t.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');                 
    }
}

/*

    -- OUTPUT--
Stack Using Two Queues


Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
30

Elements in Stack = 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
40

Elements in Stack = 40 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
3
Peeked Element is = 40

Elements in Stack = 40 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
4
Empty status = false

Elements in Stack = 40 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
Stack Using Two Queues


Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
30

Elements in Stack = 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
40

Elements in Stack = 40 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
3
Peeked Element is = 40

Elements in Stack = 40 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
4
Empty status = false

Elements in Stack = 40 30

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
*/
