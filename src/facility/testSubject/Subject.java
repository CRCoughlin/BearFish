/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facility.testSubject;

/**
 *
 * @author Christian Coughlin
 */

import java.util.Random;

public abstract class Subject{
	final int strength;
	final boolean gender;	// false: female, true: male
        boolean alive = true;
        int speed;
        int x = 0;
        int y = 0;
        

	public Subject(int maxS, int minS){
		Random rand = new Random();
		strength = rand.nextInt(maxS) + minS;
		gender = (rand.nextInt() > 0);
	}

	public Subject(){
		Random rand = new Random();
		strength = rand.nextInt(100) + 0;
		gender = (rand.nextInt() > 0);
	}
        
        public boolean isAlive(){
            return alive;
        }
        
        public void dead(){
            alive = false;
        }
        
        public void alive(){
            alive = true;
        }
        
        public int getSpeed() {return speed; }
	
	public int getStrength() { return strength; }

	public boolean getGender() { return gender; }
	
        public int getX() { return x; }
        
        public int getY() { return y; }
        
        public void setX(int x){ this.x = x;}
        
        public void setY(int y){ this.y = y;}
        
        public void setCord(int x, int y) {
            setX(x);
            setY(y);
        }
        
        public int[] getCord(){
            return new int[] {x, y};
        }
                

        
        @Override
	public String toString() {
		return "Subject{'Strength': " + strength + ", 'Gender': " + gender + "}\n";
	}

}
