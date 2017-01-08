public class Heap 
{
	int [] value;
	int last = -1;
	final int root = 0;
	
	public int[] sort(int[] x)
	{
		value = x;
		
		for(int i = 0; i < value.length; i++)
		{
			insert(value[i]);
		}
		for(int i = 0; i < value.length; i++)
		{
			remove();
		}
		return x;
	}
	
	public void insert(int x)
	{
		last ++;
		heapIfyUpward(last);
	}
	
	public int parent(int n)
	{
		return (n-1) / 2;
	}
	
	public int right(int n)
	{
		return 2 * n + 2;
	}
	
	public int left(int n)
	{
		return 2 * n + 1;
	}
	
	public void swap(int A, int B)
	{
		int temp = value[A];
		value[A] = value[B];
		value[B] = temp;
	}
	
	public void heapIfyUpward(int node)
	{
		if((node != root) && (value[node] > value[parent(node)]))
		{
			swap(node, parent(node));
			heapIfyUpward(parent(node));
		}
	}
	
	
	public void remove()
	{
		swap(root, last);
		last--;
		heapIfyDownward(root);
	}
	
	public void heapIfyDownward(int node)
	{
		if(right(node) <= last)              //if two children
		{
			if((value[left(node)] > value[right(node)]) && //if left child is bigger
			   (value[node] < value[left(node)]))          //if node is smaller
			{
				swap(node, left(node));
				heapIfyDownward(left(node));
			}
			if((value[right(node)] > value[left(node)]) && //if right child is bigger
			   (value[node] < value[right(node)]))         //if node is smaller
			{
				swap(node, right(node));
				heapIfyDownward(right(node));
			}
		}
		else if(left(node) == last)          //if one child only
		{
			if(value[node] < value[left(node)])
			{
				swap(node, left(node));
			}
		}
	}
	
}
