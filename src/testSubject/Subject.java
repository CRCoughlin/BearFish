/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testSubject;

/**
 *
 * @author Christian Coughlin
 */

import java.util.Random;

abstract class Subject{
	final int strength;
	final boolean gender;	// false: female, true: male
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
                
        @Override
	public String toString() {
		return "Subject{'Strength': " + strength + ", 'Gender': " + gender + "}\n";
	}

}
