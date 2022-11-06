
interface ListADT
{
	
	public void List();

	public void insert(Object e) throws Exception;

	public Object retrieve() throws Exception;

	public boolean empty();

	public void delete() throws Exception;

	public void update(Object e) throws Exception;

	public void findFirst() throws Exception;

	public void findNext() throws Exception;

	public boolean full();

	public boolean findkey(Object tKey);
}