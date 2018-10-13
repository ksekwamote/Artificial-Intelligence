/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author user
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public String path="1348627b5";
    
    public String dpath ="1238b4765";
  
    private boolean in;
   public ArrayList<String> ex= new ArrayList<String>();
    public ArrayList<String> closed= new ArrayList<String>();
    public ArrayList<String> opened= new ArrayList<String>();
    private ArrayList<String> inside= new ArrayList<String>();
    private boolean success=false;
    private String x;
    private String goal="1238b4765";
    public  boolean bool = true;
    public  int count;
    //private String[] paths;
    
    public ArrayList<String> list = new ArrayList<String>();
    
    
    
    public NewJFrame() {
        initComponents();
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("BREADTH FIRST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("DEPTH FIRST");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(0, 204, 0));
        jButton3.setText("A STAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("START");

        jLabel2.setText("GOAL");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addGap(46, 46, 46)
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Normalise(){
        opened.clear();
        closed.clear();
        list.clear();
        success= false;
        bool= true;
        jTextArea1.setText("");
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Normalise();
        path=jTextField2.getText();    
        goal=jTextField3.getText();
        jTextArea1.setForeground(Color.red);
        breadthFirst();
        jTextArea1.append( "\n");
        jTextArea1.append(closed.size()+ "  Moves");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Normalise();
        path=jTextField2.getText();    
        goal=jTextField3.getText();
        jTextArea1.setForeground(Color.blue);
        DepthFirst();   
        jTextArea1.append( "\n");
        jTextArea1.append(closed.size()+ "  Moves");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Normalise();
        path=jTextField2.getText();    
        goal=jTextField3.getText();
        jTextArea1.setForeground(Color.green);
        astar();
        jTextArea1.append( "\n");
        jTextArea1.append(closed.size()+ "  Moves");
          // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
     
    
    public String swapp(String s, int a, int b){
        char ac[] = s.toCharArray();
        char aa =s.charAt(a);
        for(int i = 0; i < s.length(); i++)
        {
            if(ac[i] == s.charAt(a))
                ac[i]=s.charAt(b);
            else if(ac[i] == s.charAt(b))
                ac[i] = aa; 
        }
        s = new String(ac);
        return s;
    }
      
    public int permutation(String str) { 
         count=0;
         bool= true;
         permutation("", str ); 
     return count;
    }
      
    public void permutation(String prefix, String str ) {
    
     
    int n = str.length();
    if (n == 0 && bool){
        //System.out.println(prefix);
        if(prefix.equals("1238b4765")){
            bool= false;
        }
        else count++;
        
            }
    else if (n!=0 && bool){
        for (int i = 0; i < n; i++)
          
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }
}
     
    
    public int misplaced(String original , String test){
        int counts=-1;
        for(int i=0; i<original.length(); i++){
            if(original.charAt(i)!=test.charAt(i) )
                counts++;
        }    
        return counts;
    } 
      public void reorder(ArrayList<String> arr) {
         ArrayList<String> array = new ArrayList<String>();
       ArrayList<Integer> arrays = new ArrayList<Integer>();
        int max=0;
        
       for(int i=0; i<arr.size(); i++){
           
             arrays.add(permutation(arr.get(i))+ (misplaced(arr.get(i), goal)*100 ));  
                  
       }
        Collections.sort(arrays);
        for(int j=0; j<arrays.size(); j++){
           
            for (int k=0; k<arrays.size(); k++){
              if  (arrays.get(j)==permutation(arr.get(k))+ (misplaced(arr.get(k), goal)*100 ))
                    array.add(arr.get(k));
                
            }
             
                  
       }
       
       arr.clear();
       arr.addAll(array);
    
   
   }
      public void child(String path){
    
        if(path.indexOf('b')==0){
             list.add(swapp(path, 0,1));
            list.add(swapp(path,0,3));
            
        }
        
        else if (path.indexOf('b')==1){
            list.add(swapp(path, 0,1));
            list.add(swapp(path,1,2));
             list.add(swapp(path, 1,4));
           
        }
        
        else if(path.indexOf('b')==2){
             list.add(swapp(path, 2,1));
            list.add(swapp(path,2,5));
         
         
        }
         else if(path.indexOf('b')==3){
            list.add(swapp(path, 3,1));
            list.add(swapp(path,4,3));
            list.add(swapp(path, 3,6));
             
        }
         else if(path.indexOf('b')==4){
            list.add(swapp(path, 1,4));
            list.add(swapp(path,7,4));
            list.add(swapp(path, 3,4));
            list.add(swapp(path,4,5));
        }
        
         else if(path.indexOf('b')==5){
            list.add(swapp(path, 5,2));
            list.add(swapp(path,5,8));
            list.add(swapp(path, 5,4));

         }
         else if(path.indexOf('b')==6){
            list.add(swapp(path,7,6));
            list.add(swapp(path, 6,3));
           
            
           
         }
         else if(path.indexOf('b')==7){
            list.add(swapp(path, 7,6));
            list.add(swapp(path,7,4));
            list.add(swapp(path, 7,8));
           
         }
         else if(path.indexOf('b')==8){
            list.add(swapp(path, 8,5));
            list.add(swapp(path,7,8));
            
         }   
    }
      
      public void breadthFirst(){
        opened.add(path);
        
        while(opened.isEmpty()==false &&  success==false){
             x=opened.get(0);
        
             opened.remove(0);
             jTextArea1.append("\n");
            jTextArea1.append(x); 
            
             if(x.equals(goal))
             {
                 success=true;
                
             }
             else
             {
                 child(x);
   
                 closed.add(x);
                 list.removeAll(opened);
                 list.removeAll(closed);
                 opened.addAll(list);
                 list.clear();
             }
        }
        
    }
      public void DepthFirst(){
       
        opened.add(path);
        
        while(opened.isEmpty()==false &&  success==false){
            ex.add(x);
            x=opened.get(0);
        
             opened.remove(0);
           jTextArea1.append("\n");
            jTextArea1.append(x); 
             if(x.equals(goal))
             {
                 success=true;
                
             }
             else
             {
                 child(x);
   
                 closed.add(x);
                 list.removeAll(opened);
                 list.removeAll(closed);
                 opened.addAll(0,list);
                 list.clear();
             }
        }
        
    }
      public void astar(){
          opened.add(path);
          
          while(opened.isEmpty()==false && success== false){
              //jTextArea1.append("here here here");
              x=opened.get(0);
              opened.remove(0);
              jTextArea1.append("\n");
              jTextArea1.append(x);
       
       if(x.equals(goal))
             {
                 success=true;
                
             }
       else { 
           child(x);
           for(int i=0; i<list.size(); i++){
               if( opened.contains(list.get(i))==false && closed.contains(list.get(i))==false){
                   opened.add(list.get(i));
                   
               }
               if(opened.contains(list.get(i))){
                    //opened.remove(list.get(i));
               }
               if (closed.contains(list.get(i))){
                    //closed.remove(list.get(i));
                    
               }
           
           }
          closed.add(x);
          
       }
       reorder(opened);
    }
     
     
   
   
   
   }
      
      /**
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
