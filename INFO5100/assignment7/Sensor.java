package assignment7;

class Sensor extends Thread {
    private final Device device;
    private double value;
    
    public Sensor(Device device) {
        this.device = device;
        this.value=60*Math.random();
    }
    
    public double getValue() {
        return value;
    }
    
    public void updateValue() { 
        this.value += 0.1*Math.random(); 
    }
    
    public void run() {
        System.out.println("Sensor started");        
        while (!this.isInterrupted()) { 
            updateValue();
            synchronized (device) {
                device.notify();
            }
        }        
    }

        
}