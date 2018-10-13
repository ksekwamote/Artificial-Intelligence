
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;



/**
 *
 * @author user
 */
public class Assignment {

    /**
     * @param args the command line arguments
     */

  
    public ArrayList<String>    allBoxes = new ArrayList<String>();
    public ArrayList< ArrayList<Integer>> used= new ArrayList<ArrayList<Integer>>();  
    public ArrayList< ArrayList<Integer>> p= new ArrayList<ArrayList<Integer>>();  
    public ArrayList<Integer>    tester;
    public ArrayList<Integer>    offspring ;
    public ArrayList<Integer> offspring1;
    public ArrayList<Integer> offspring2;
    public ArrayList<Integer> offspring3;
    public ArrayList<Integer> parent1;
    public ArrayList<Integer> parent2;
    public int gen=4;
    public int generation=0;
    public int capacity;
    public int quota;
    public int numOfObjects;
    public int totals=0;
    
    
    public Assignment(){
    
    }
    
    public void print(ArrayList obj ){  //Prints out any ArrayList
    
    for(int i=0; i<obj.size(); i++){
        
        System.out.print(" "+obj.get(i));
    
    }
    System.out.println("");
    }
      
    public void printin(ArrayList<ArrayList<Integer>> population){
        for(int i=0;i<population.size();i++){             //Prints Out the ArrayLists 
            for(int j=0;j<population.get(i).size();j++){ //inside an ArrayList
                  System.out.print("     ");
                  System.out.print(population.get(i).get(j));
            
            }
           System.out.print("        Fitness is: "+ fit(population.get(i) ));
            System.out.println(" ");
        
        }
    }
    
  public void init(){     
        String line=" ";
        
        try                  //Initialization, reads, capacity, quota and number of Objects from TEXTFILE
                         
        {
        Scanner inputs = new Scanner(new File("input.txt"));
         
        int counter =0;
       
        while(inputs.hasNextLine() && counter<numOfObjects +4){
            
            line=inputs.nextLine();
            if(line.equals("***") || line.equals(" ") ){
         
                 counter=0;
                 
            }
            
            if (counter==0){
            
            }
            else if(counter==1){
               capacity= Integer.parseInt(line.trim());
               
            }
            else if(counter==2){
                 quota =Integer.parseInt(line.trim());
            }
            else if(counter==3){
               numOfObjects = Integer.parseInt(line.trim());
            }
            else if(counter>=4 && counter<= numOfObjects+3) {
                  allBoxes.add(line);  //Enters ALL Ojects inside an ArrayList: allBoxes, used as a Reference
            }
               counter++;
        }
        }
        catch(FileNotFoundException ex){
            System.err.println(ex.toString());
        } 
        
        //done.add(allBoxes);
    }
    
    public int getWeight(String str){
        int we=0;
        String[] state= str.split(" "); //Gets the weight of an individual object
        if(state[1].equals("")){
            
           we=Integer.parseInt(state[2]);
        }
        else{
           
            we=Integer.parseInt(state[1]);}
       return we; 
    }
    
    public int getValue(String str){
        int va=0;
        String[] state = str.split(" ");
        if(state[1].equals("")){     //Gets Value of Individual Object
           va=Integer.parseInt(state[3]);
        }
        else{va=Integer.parseInt(state[2]);}
     
        return va; 
    
    }
    public String getAlpha(String str){
        String[] state = str.split(" ");
        return state[0];       //Gets the Alphabet representing that particular objects
        
    }
    
  
    
    
   public ArrayList<Integer> bitFlip(){
       Random rand = new Random();
       ArrayList<ArrayList<Integer>> pop= new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> offspring1= new ArrayList<Integer>();
       pop.addAll(p);
       offspring1.addAll(pop.get(rand.nextInt(pop.size())));
       int bit = rand.nextInt(offspring1.size()-1);
       int bits = bit+1 % (offspring1.size()-1);
                                                //bit flips selected parent
       if(offspring1.get(bits)==1){
          offspring1.set(bits, 0);     
      }
      else{offspring1.set(bits, 1);}
       
       if(offspring1.get(bit)==1){
          offspring1.set(bit, 0);
       }
       else{offspring1.set(bit, 1);}
       return offspring1;
   } 
   
    public ArrayList<Integer> bitFlip2(){
       Random rand = new Random();
       ArrayList<ArrayList<Integer>> pop= new ArrayList<ArrayList<Integer>>();
       pop.addAll(p);
       ArrayList<Integer> offspring2= new ArrayList<Integer>();
       offspring2.addAll( pop.get(rand.nextInt(pop.size())));
       int bit = rand.nextInt(offspring2.size()-1);
       int bits = bit+1 % (offspring2.size()-1);
               
       if(offspring2.get(bits)==1){
           offspring2.set(bits, 0);     
      }
       else{offspring2.set(bits, 1);}
       
       if(offspring2.get(bit)==1){
         offspring2.set(bit, 0);
       }
       else{offspring2.set(bit, 1);}
       return offspring2;
   } 
   
   
   public ArrayList<Integer> crossOver1(){
                                              //CROSS-OVER1
      ArrayList<Integer> news = new ArrayList<Integer>();
      news.addAll(parent1);
      int mid=(int)(news.size()/2);
      for(int i=mid; i<news.size();i++){
          news.set(i, parent2.get(i));
      }
      offspring= news;
      used.add(news);  
      return news;
    }
   
   
   public ArrayList<Integer> crossOver2(){
                                                //CROSS-OVER2
       ArrayList<Integer> news = new ArrayList<Integer>();
      news.addAll(parent2);
      int mid=(int)(news.size()/2);
      for(int i=mid; i<news.size();i++){
          news.set(i, parent1.get(i));
      }
      offspring3= news;
      used.add(news);
      return news; 
   }
   
  public void uniformCrossover(ArrayList<Integer> a, ArrayList<Integer> b){
    for (int i = 0; i <a.size(); i++) {
        if(Math.random() < 0.5){
            int tmp = a.get(i);
            a.set(i, b.get(i));
            b.set(i, tmp);
        } 
    }
  
    
}
   
   public int fitness(ArrayList<String> objects){
       int total=0;
       
       for(int i=0; i<objects.size();i++){  
           total+=((getWeight(objects.get(i))+ getValue(objects.get(i))));  
       } 
     
       
       return total;
   }
   
   public void rouletteWheel(ArrayList<ArrayList<Integer>>  obj){
     double totality=0;
     double degree=0;
     Random rand = new Random();
     ArrayList<ArrayList<Integer>> wheel= new ArrayList<ArrayList<Integer>>(); 
     
     for(int i=0; i<obj.size();i++){
         totality+= fit(obj.get(i));
     }
     for(int j=0; j<obj.size();j++){  //Making a Circle and Filling it;
         degree=(int)((fit(obj.get(j))/totality)*360);
         //System.out.println(degree);
         for(int k=0; k<degree; k++){
             wheel.add(obj.get(j));
         }
     }
     
    parent1= wheel.get(rand.nextInt(wheel.size()));  //spin the wheel
     while(wheel.remove(parent1)){};
     parent2 =wheel.get(rand.nextInt(wheel.size()));  // remove element selected
      
   }   
  
   
   public void newPopulation(ArrayList<Integer> offspring){
      if( p.contains(offspring)){}
                                                //after mutation and crossOver operators, a new population is formed
      else
      {
          for(int i=0; i<p.size(); i++){
              if(fit(offspring)< fit(p.get(i)) || fit(p.get(i))==0 ){
                  p.set(i, offspring); 
                  break;
              }
          }
       }
   }
     
      public ArrayList<Integer> rand(){
        Random rand = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i =0; i<numOfObjects; i++){    //input 1 and 0' randomly in the string
            arr.add(rand.nextInt(2));
        }
        if(used.contains(arr)){
            rand();
        }else{used.add(arr);}
        
        tester=arr;
        return arr;
    }
    
      public void inita(){
          for(int i=0; i<40; i++){
               p.add(rand());         
          }   
      }
      
      public int fit(ArrayList<Integer> arr){
       int total=0;
       int weight=0;                           //Fitness Test
       int value=0;
       for(int i=0; i<allBoxes.size();i++){
           weight+=(getWeight(allBoxes.get(i)))*arr.get(i);
           value+= (getValue(allBoxes.get(i)))*arr.get(i);
           total+=((getWeight(allBoxes.get(i))+ getValue(allBoxes.get(i)))*arr.get(i));  
       }
       if(weight<=capacity && value>=quota){
            
           total=total-1000;
       
       }
      
      
       return total;
       
      }
      public int totalWeight(ArrayList<Integer> arr){
         int wgt =0;
         for(int i=0; i<allBoxes.size();i++){  
           wgt+=((getWeight(allBoxes.get(i)))*arr.get(i));  
         }   
      
         return wgt;
      }
      public int totalValue(ArrayList<Integer> arr){
          int val =0;
         for(int i=0; i<allBoxes.size();i++){  
           val+=((getValue(allBoxes.get(i)))*arr.get(i));  
         }   
      
         return val;
      
      
      
      }
      public boolean crit(ArrayList<ArrayList<Integer>> arr){
          boolean win = false;
          for(int i=0; i<arr.size(); i++){               //Criteria
              if(totalWeight(arr.get(i))<=capacity && totalValue(arr.get(i))>= quota ){
                  System.out.println("THE WINNER IS..."+"\n");
                  print(arr.get(i));
                  System.out.println("GENERATION:  "+ generation);
            
                  object(arr.get(i));
                  
                  System.out.println();
                  win=true;
                  break;
              }
          }
          return win;
      }
      public void object(ArrayList<Integer> arr){
          System.out.print("{ ");
          for(int i=0; i<arr.size(); i++){    //gets the winning set
             if(arr.get(i)==1){
                 System.out.print(getAlpha(allBoxes.get(i))+" ");
             } 
          }
         System.out.print("}");
      }
      
      
    public static void main(String[] args) {
        Assignment ass  = new Assignment();
        ass.init();
        ass.inita();
        int count=0;
       while(!ass.crit(ass.p)){  
           ass.generation++;
       ass.rouletteWheel(ass.p);
       ass.crossOver1();
       ass.crossOver2();
       ass.newPopulation(ass.bitFlip());
       ass.newPopulation(ass.bitFlip2());
       ass.newPopulation(ass.offspring);
       ass.newPopulation(ass.offspring3);   
    }
    }    
    }
