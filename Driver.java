public class Driver 

{ 

    public static void main(String[] args) throws IOException { 

        BufferedReader inFile = new BufferedReader(new FileReader("C:\\Users\\Z\\eclipse-workspace\\ANLP\\bin\\a\\OS\\classes\\packag\\cod.txt")); 

  

        String schedule; 

  

        // create the queue of tasks 

        ArrayList<Task> queue = new ArrayList<Task>(); 

  

        // read in the tasks and populate the ready queue         

        while ( (schedule = inFile.readLine()) != null) { 

            String[] params = schedule.split(",\\s*"); 

            queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]))); 

        } 

         

        inFile.close(); 

        Scanner s = new Scanner(System. in); 

        System.out.println("Please enter the CPU scheduling algorithm you would like to use."); 

        Algorithm scheduler = null; 

         

        String choice = s.nextLine().toUpperCase(); 

  

        switch(choice) { 

        case "FCFS": 

            scheduler = new FCFS(queue); 

            break; 

        case "SJF": 

            scheduler = new SJF(queue); 

            break; 

            case "PRI": 

                scheduler = new Priority(queue); 

                break; 

            case "RR": 

                scheduler = new RR(queue); 

                break; 

            default: 

                System.err.println("Invalid algorithm"); 

                System.exit(0); 

        } 

  

        // start the scheduler 

        scheduler.schedule(); 

    } 

} 
