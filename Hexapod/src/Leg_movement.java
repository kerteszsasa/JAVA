import java.io.Serializable;


public class Leg_movement implements Serializable{
	
	int[] LEG_A = { 0, 100, 100}; // leg number + leg position + leg speed
	int[] LEG_B = { 0, 100, 100};
	int[] LEG_C = { 0, 100, 100};
	
	boolean leg_A_valid = false;
	boolean leg_B_valid = false;
	boolean leg_C_valid = false;
	
	public Leg_movement(int A_leg, int A_pos, int A_speed, int B_leg, int B_pos, int B_speed, int C_leg, int C_pos, int C_speed){
		if(A_leg>=1 && A_leg<=18 && A_pos>=0 && A_pos<=200 && A_speed>=0 && A_speed<=100){
			leg_A_valid = true;
			LEG_A[0]=A_leg;
			LEG_A[1]=A_pos;
			LEG_A[2]=A_speed;	
		}
		if(B_leg>=1 && B_leg<=18 && B_pos>=0 && B_pos<=200 && B_speed>=0 && B_speed<=100){
			leg_B_valid = true;
			LEG_B[0]=B_leg;
			LEG_B[1]=B_pos;
			LEG_B[2]=B_speed;	
		}
		if(C_leg>=1 && C_leg<=18 && C_pos>=0 && C_pos<=200 && C_speed>=0 && C_speed<=100){
			leg_C_valid = true;
			LEG_C[0]=C_leg;
			LEG_C[1]=C_pos;
			LEG_C[2]=C_speed;	
		}
	}
	
	int[] Get_data(){
		int[] data = {  LEG_A[0], LEG_A[1], LEG_A[2], LEG_B[0], LEG_B[1], LEG_B[2], LEG_C[0], LEG_C[1], LEG_C[2]};
		return data;
	}
	

}// end of class
