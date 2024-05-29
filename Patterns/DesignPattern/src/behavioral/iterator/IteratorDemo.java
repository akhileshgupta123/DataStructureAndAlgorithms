import java.util.*;

class SomeClassWithData

{

    private TreeSet  m_data = new TreeSet(); 

	// Concrete Iterator
    public class MyIterator
    {

        private SomeClassWithData m_collection;
        private java.util.Iterator m_it;
        private int m_current;
        public MyIterator(SomeClassWithData in)
        {
            m_collection = in;
        }

        public void first()
        {
            m_it = m_collection.m_data.iterator();
            next();
        }

        public void next()
        {

            try
            {
                m_current =(Integer) m_it.next();
            }
            catch (NoSuchElementException ex)
            {
                m_current =  - 999;
            }
        }

        public boolean is_done()
        {
            return m_current ==  - 999;
        }

        public int current_item()
        {
            return m_current;
        }

    }

 

    public void add(int in)
    {
        m_data.add(in);
    }
	
	//Concrete Aaggregate
    public MyIterator create_iterator()
    {
        return new MyIterator(this);
    }

}

 

class IteratorDemo
{

    public static void main(String[] args)
    {

        SomeClassWithData some_object = new SomeClassWithData();

        for (int i = 9; i > 0; --i)
          some_object.add(i);

 
       
        // Client has to use Iterator.

        SomeClassWithData.MyIterator it1 = some_object.create_iterator();   
 

        for (it1.first(); !it1.is_done(); it1.next())
          System.out.print(it1.current_item() + "  ");     

    }

}

 