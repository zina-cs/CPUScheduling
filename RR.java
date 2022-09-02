package packag; 

import java.util.ArrayList; 

  

  

public class RR implements Algorithm{ 

 

ArrayList<Task> queue; 

static int sumwaitingt; 

 

public RR () {} 

public RR (ArrayList<Task> q) 

{ 

queue  = new ArrayList<Task>(q); 

} 

  

@Override 

public void schedule()  

{ 

int quantum = 10; 

avgwaitingt(queue, quantum); 

avgturnaroundt(queue); 

while (queue.isEmpty() != true) 

{ 

Task result = pickNextTask(); 

if (result.getBurst() > quantum) 

{ 

CPU.run(result, quantum); 

result.setBurst(result.getBurst() - quantum);  

queue.add(result); 

} 

else 

{ 

CPU.run(result, result.getBurst()); 

} 

queue.remove(0); 

} 

 

} 

  

@Override 

public Task pickNextTask()  

{ 

Task x = queue.get(0); 

return x; 

} 

public void avgwaitingt( ArrayList<Task>q, int quantum) 

{ 

   int Burstime[] = new int[q.size()]; 

   for (int i = 0 ; i < q.size() ; i++) 

       Burstime[i] =  q.get(i).getBurst(); 

   int time = 0;  

   int sumwaiting = 0; 

   boolean repeat = true; 

   while(repeat) 

   { 

       boolean done = true; 

       for (int i = 0 ; i < queue.size(); i++) 

       { 

           if (Burstime[i] > 0) 

           { 

               done = false;  

               if (Burstime[i] > quantum) 

               { 

                   time += quantum; 

                   Burstime[i] -= quantum; 

               } 

               else 

               { 

                   time += Burstime[i]; 

                   sumwaiting += (time - Burstime[i]); 

                   Burstime[i] = 0; 

               } 

           } 

       } 

       if (done == true) 

       { 

    	   repeat = false;  

       } 

   } 

   sumwaitingt = sumwaiting; 

   int avgwaiting = sumwaiting/queue.size(); 

   System.out.println("Average Waiting Time: "+ avgwaiting); 

} 

static void avgturnaroundt (ArrayList<Task>q) 

{ 

int sumburstime = 0; 

   for (int i = 0; i < q.size() ; i++) 

       sumburstime += q.get(i).getBurst(); 

   int sumturnaround = sumburstime + sumwaitingt; 

   int avgturnaround = sumturnaround/q.size(); 

   System.out.println("Average Turnaround Time: "+ avgturnaround); 

} 

  

} 
