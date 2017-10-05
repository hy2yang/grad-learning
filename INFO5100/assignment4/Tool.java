package assignment4;

public class Tool {
    
    public static void main(String[] args) {
        Rock r2=new Rock(2);
        Rock r5=new Rock(5);
        Scissors s2=new Scissors(2);
        Scissors s5=new Scissors(5);
        Paper p2=new Paper(2);
        Paper p5=new Paper(5);
        System.out.println("    r2    r5    s2    s5    p2    p5");
        System.out.println("r2 "+r2.fight(r2)+" "+r2.fight(r5)+" "+r2.fight(s2)+" "+r2.fight(s5)+" "+r2.fight(p2)+" "+r2.fight(p5)+" ");
        System.out.println("r5 "+r5.fight(r2)+" "+r5.fight(r5)+" "+r5.fight(s2)+" "+r5.fight(s5)+" "+r5.fight(p2)+" "+r5.fight(p5)+" ");
        System.out.println("s2 "+s2.fight(r2)+" "+s2.fight(r5)+" "+s2.fight(s2)+" "+s2.fight(s5)+" "+s2.fight(p2)+" "+s2.fight(p5)+" ");
        System.out.println("s5 "+s5.fight(r2)+" "+s5.fight(r5)+" "+s5.fight(s2)+" "+s5.fight(s5)+" "+s5.fight(p2)+" "+s5.fight(p5)+" ");
        System.out.println("p2 "+p2.fight(r2)+" "+p2.fight(r5)+" "+p2.fight(s2)+" "+p2.fight(s5)+" "+p2.fight(p2)+" "+p2.fight(p5)+" ");
        System.out.println("p5 "+p5.fight(r2)+" "+p5.fight(r5)+" "+p5.fight(s2)+" "+p5.fight(s5)+" "+p5.fight(p2)+" "+p5.fight(p5)+" ");
    }
    
    private int strength;
    private char type;
    
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public char getType() {
        return type;
    }
    public void setType(char type) {
        this.type = type;
    }
    
    
    public static class Rock extends Tool{
        public Rock(int s) {
            this.setStrength(s);
            this.setType('r');            
        }
        
        public boolean fight (Tool that) {
            if (that.getType()=='s') return ((2*this.getStrength())>that.getStrength());
            if (that.getType()=='p') return (this.getStrength()>(2*that.getStrength()));
            else return (this.getStrength()>that.getStrength());
        }
    }

    public static class Scissors extends Tool{
        public Scissors(int s) {
            this.setStrength(s);
            this.setType('s');            
        }
        
        public boolean fight (Tool that) {
            if (that.getType()=='p') return ((2*this.getStrength())>that.getStrength());
            if (that.getType()=='r') return (this.getStrength()>(2*that.getStrength()));
            else return (this.getStrength()>that.getStrength());
        }
    }
    
    public static class Paper extends Tool{
        public Paper(int s) {
            this.setStrength(s);
            this.setType('p');            
        }
        
        public boolean fight (Tool that) {
            if (that.getType()=='r') return ((2*this.getStrength())>that.getStrength());
            if (that.getType()=='s') return (this.getStrength()>(2*that.getStrength()));
            else return (this.getStrength()>that.getStrength());
        }
    }

}



