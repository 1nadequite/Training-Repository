import executors.AbstractMapExecutor;
import executors.SimpleMapExecutor;
import executors.SortedMapExecutor;
import executors.NavigableMapExecutor;

class MapRunner {
	public static void main(String[] args) {
		AbstractMapExecutor mapExecutor = new SimpleMapExecutor(); //HashMap and TreeMap versions, see constructor
//		AbstractMapExecutor mapExecutor = new SortedMapExecutor();
//		AbstractMapExecutor mapExecutor = new NavigableMapExecutor();
		mapExecutor.execute();
	}
}
