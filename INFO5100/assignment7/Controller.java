package assignment7;

public class Controller extends Thread {    
    private Device device;
    private Sensor heat;
    private Sensor pressure;
    
    public Controller(Device d, Sensor h, Sensor p) {
        this.device=d;
        this.heat=h;
        this.pressure=p;
    }
    
    public void run() {
        device.startup();
        double t,p;
        while (true) { 
            synchronized (device) {
                t=heat.getValue();
                p=pressure.getValue();
                System.out.printf("Heat -> %.2f",t);            
                System.out.printf(" Pressure -> %.2f\n",p);  
                try {
                    device.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                            
            }
            if (t>70 || p>100) {
                device.shutdown();
                heat.stop();
                pressure.stop();
                return;
            }
            
        }
    }

}
