package packag; 

  

import java.util.ArrayList; 

import java.util.Collections; 

  

  

public class FCFS implements Algorithm { 

 

ArrayList<Task> queue; 

  

public FCFS () {} 

public FCFS (ArrayList<Task> q) 

{ 

queue  = new ArrayList<Task>(q); 

} 

 

@Override 

public void schedule() { 

 

int sumturnaround = 0; 

for (int i = queue.size(), j = 0; i>0 && j < queue.size(); i--, j++) 

{ 

sumturnaround += i*(queue.get(j).getBurst()); 

} 

int avgturnaround = sumturnaround/queue.size(); 

 

int sumwaiting = 0; 

for (int i = queue.size() - 1,j = 0; i > 0 && j < queue.size(); i--, j++) 

{ 

sumwaiting += i*(queue.get(j).getBurst()); 

} 

int avgwaiting = sumwaiting/queue.size(); 

 

while (queue.isEmpty() != true) 

{ 

Task result = pickNextTask(); 

CPU.run(result, result.getBurst()); 

queue.remove(0); 

} 

System.out.println("Average Turnaround Time: "+ avgturnaround); 

System.out.println("Average Waiting Time: "+ avgwaiting); 

System.out.println("Average Response Time: "+ avgwaiting); 

} 

  

@Override 

public Task pickNextTask() { 

Task choice = queue.get(0); 

return choice; 

} 

  

} 
