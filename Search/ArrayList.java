import javax.swing.JOptionPane;

class  ArrayList implements ListADT
{
	private int total;
	private Object list[];
	int current,size;
	private int ss;

	public ArrayList()
	{
		List();
	}

	public void List()
	{
		current= -1;
		total = 100;
		size=0;
		list = new Object[total];

	}

	public void insert(Object e) throws Exception 
	{
		if (full())
		{			
			throw new Exception("List is full");
		}else
			{
				size++;
				if (size==1)
				{
					current++;
					list[current]=e;
				}
				else{
				for(int i=size-1;i>current+1;i--)
					list[i]=list[i-1];
					current++;
					list[current] = e;
				}
				
			}
	}

	public Object retrieve() throws Exception 
	{
		if (empty()){
				throw new Exception("List is empty");
		}
		else{
			return list[current];
		}
	}

	public void delete() throws Exception 
	{
		if (empty())
		{			
			throw new Exception("List is empty");
		}else{
				if (size == 1)
					current = -1;
				else if (current==size-1)
					current = 0;
				else
					{
					for(int i=current;i<size-1;i++)
					list[i]=list[i+1];		
					current = 0;
					}
				size--;
				throw new Exception("List Deleted");
			}
	}

	public boolean empty() 
	{
		if(size==0)
			return true;
		else
			return false;
	}

	public boolean full()
	{
		if (size == total)
			return true;
		else
			return false;
	}
	public void update(Object e) throws Exception
	{
		if (empty())
		{			
			throw new Exception("List is empty");
		}else
			{
				list[current] = e;
			}
	}

	public void findFirst() throws Exception
	{
		if (empty())
		{			
			throw new Exception("List is empty");
		}else
			{
				current=0;
			}
	}

	public void findNext() throws Exception
	{
		if (empty())
		{			
			throw new Exception("List is empty");
		}else
			{
				if (current != size-1)
					current = current+1;
			}
	}

	public boolean findkey(Object tKey)
	{
		//printAll();
		//quickSort(0,size-1);
		heapSort();

		return binSearch(tKey,0,size-1);  //Concurrency
		//return binSearch(tKey);             //Normal
	}

	public void Sort()throws Exception{
		if(empty()){
			throw new Exception("List is empty");
		}else{
			String ss = JOptionPane.showInputDialog("Enter the sorting method:\n"+
							"1. Quick Sort \n"+
							"2. Header Sort");
			int s = Integer.parseInt(ss);
			switch(s){
				case 1: quickSort(0,size-1);
						break;
				case 2: heapSort();
						break;
			}
			//headerSort();
			//quickSort(0,size-1);
		}
	}


	
	public boolean binSearch( Object key, int low, int high) {
		int mid = (low + high)/2;

		if (low>high){
			return false;
		}else if(list[mid]==key){
			current = mid;
			return true;
		}else if((Integer)list[mid] < (Integer)key){
			return binSearch(key,mid+1,high);
		}
		else{
			return binSearch(key,low,mid-1);
		}
	}

	public void quickSort(int left,int right)
	{
		Object tmp,mid; 
		int i,j;
		i = left; 
		j = right;
		mid = list[(left + right)/2];
		do{
			while((Integer)list[i] < (Integer)mid)
				i++;
			while((Integer)mid < (Integer)list[j])
				j--;
			if (i <= j) {
				tmp = list[i];
				list[i] = list[j];
				list[j] = tmp;
				i++;
				j--;
			}
		}while(i <= j);
			printAll();
			if (left < j) quickSort(left,j);
			if (i < right) quickSort(i,right);
	}


	public void heapSort() {
		makeHeap();
		System.out.print("The data in sequence are: ");
		printAll();
		System.out.println("The data after in each loop are: ");
		for (int nodeIndex = size; nodeIndex > 0; nodeIndex--) {
			swap(0, nodeIndex - 1);
			reHeapDown(0, nodeIndex - 2);
			printAll();
		}
	}

	public void makeHeap() {
		for (int i = size; i >= 0; i--) {
			reHeapDown(i, size);
		}
	}

	public void reHeapDown(int root, int bottom) {
		boolean heapOK = false;
		int maxChild, leftChild = 2 * root + 1, rightChild = 2 * root + 2;
		while ((leftChild <= bottom) && (!heapOK)) {
			if (leftChild == bottom) {
				maxChild = leftChild;

			} else if (list[rightChild] == null) {
				maxChild = leftChild;

			} else if ((int) list[leftChild] > (int) list[rightChild]) {
				maxChild = leftChild;

			} else {
				maxChild = rightChild;

			}

			if (((int) list[root]) < ((int) list[maxChild])) {
				swap(root, maxChild);
				root = maxChild;
				leftChild = 2 * root + 1;
				rightChild = 2 * root + 2;
			} else
				heapOK = true;
		}
	}

	public void swap(int i, int j) {
		Object temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}


	public int getSize(){
		return size;
	}

	
	public void printAll(){
		for (int i=0;i<size ;i++ )
		{
			System.out.print(list[i]+ " ");
		}
		System.out.println("");
	}
}