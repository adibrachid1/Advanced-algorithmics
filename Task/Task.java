import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Task {
	int start;
	int end;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tasks.add(new Task(0, 4));
		tasks.add(new Task(2, 3));
		tasks.add(new Task(3, 6));
		tasks.add(new Task(6, 9));
		tasks.add(new Task(7, 8));
		tasks.add(new Task(1, 2));
		tasks.add(new Task(0, 5));
		tasks.add(new Task(4, 8));
		tasks.add(new Task(1, 4));
		tasks.add(new Task(1, 3));
		tasks.add(new Task(2, 5));
		tasks.add(new Task(3, 7));
		tasks.add(new Task(4, 7));
		tasks.add(new Task(6, 9));
		tasks.add(new Task(7, 8));
		tasks.add(new Task(1, 9));
		tasks.add(new Task(2, 3));
		start();
		System.out.print(machines.size());
	}

	public Task(int s, int e) {
		start = s;
		end = e;
	}

	public static void start() {
		while (!tasks.isEmpty()) {
			Task current = tasks.poll();
			Machine availabl = search_machines(current.start);
			availabl.end_at = current.end;
		}
	}

	public static Machine search_machines(int start) {
		Machine a = null;
		Iterator it = machines.iterator();
		while (it.hasNext()) {
			Machine b = (Machine) it.next();
			if (b.end_at <= start)
				a = b;
		}
		if (a == null || machines.isEmpty()) {
			a = new Machine();
			machines.add(a);
		}
		return a;
	}

	static PriorityQueue<Task> tasks = new PriorityQueue<Task>(20, new Comparator<Task>() {
		public int compare(Task i, Task j) {
			if ((i.start > j.start)) {
				return 1;
			}

			else if (i.start < j.start) {
				return -1;
			}

			else {
				return 0;
			}

		}
	});

	static PriorityQueue<Machine> machines = new PriorityQueue<Machine>(20, new Comparator<Machine>() {
		public int compare(Machine i, Machine j) {
			if ((i.end_at > j.end_at)) {
				return 1;
			}

			else if (i.end_at < j.end_at) {
				return -1;
			}

			else {
				return 0;
			}

		}
	});

}