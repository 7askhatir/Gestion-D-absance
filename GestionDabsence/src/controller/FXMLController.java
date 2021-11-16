/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Absences;
import domain.Apprenant;
import domain.Promotion;
import domain.Retar;
import domain.Staf;
import domain.TableAbsent;
import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.dao.inmplement.AbsencesDao;
import model.dao.inmplement.ApprenantDao;
import model.dao.inmplement.PromotionDao;
import model.dao.inmplement.RetarDao;
import model.dao.inmplement.StafDao;
import model.dao.inmplement.TableAbsentDao;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class FXMLController implements Initializable {

 @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Pane page1;

    @FXML
    private Pane page2;

    @FXML
    private Pane page3;

    @FXML
    private ImageView arrow1;

    @FXML
    private ImageView arrow2;

    @FXML
    private ImageView arrow3;
       @FXML
    private Label email;

    @FXML
    private Label nom;

    @FXML
    private Label role;
    
       @FXML
   
    private TableView<TableAbsent> absence_table;

    @FXML
    private TableColumn<TableAbsent,Integer> id;

    @FXML
    private TableColumn<TableAbsent, String> nStaf;

    @FXML
    private TableColumn<TableAbsent, String> apprenent;

    @FXML
    private TableColumn<TableAbsent, String> date;

    @FXML
    private TableColumn<TableAbsent,Button> yes;

    @FXML
    private TableColumn<TableAbsent,Button> non;
    
         @FXML
    private TableView<TableAbsent> table_re;

    @FXML
    private TableColumn<TableAbsent, Integer> IDr;

    @FXML
    private TableColumn<TableAbsent, String> NAp;

    @FXML
    private TableColumn<TableAbsent, String> NSt;

    @FXML
    private TableColumn<TableAbsent,Integer > duee;

    @FXML
    private TableColumn<TableAbsent,Button> yseR;

    @FXML
    private TableColumn<TableAbsent,Button> noR;
     @FXML
    private Button deconnecter;
     @FXML
    private HBox hbox1;
     @FXML
    private HBox hbox11;

    public  ObservableList<TableAbsent> data= FXCollections.observableArrayList();
    public  ObservableList<TableAbsent> data2= FXCollections.observableArrayList();
    
    /*public ObservableList<TableAbsent> obsRetard(int idPromotion){
        
        
        
    }*/
    @FXML
    void click(ActionEvent event) throws SQLException {
        
        if(event.getTarget()==btn1){
            page1.setVisible(true);
            arrow1.setVisible(true);
            page2.setVisible(false);
            arrow2.setVisible(false);
            page3.setVisible(false);
            arrow3.setVisible(false);
            
        }
        else if(event.getTarget()==btn2){
            hbox1.getChildren().clear();
            page1.setVisible(false);
            arrow1.setVisible(false);
            page2.setVisible(true);
            arrow2.setVisible(true);
            page3.setVisible(false);
            arrow3.setVisible(false);
            table_re.getItems().clear();
            RetarDao ab=new RetarDao();
            List<Retar> list= new ArrayList<Retar>();
            list=ab.getAll();
            for(int i=0;i<list.size();i++){
                TableAbsent u= new TableAbsent();
                u.setId(list.get(i).getIdretar());
                Staf vv=new Staf();
                StafDao vvv=new StafDao();
                vv=vvv.getById(list.get(i).getIdformateur());
                u.setNS(vv.getNomuser());
                Apprenant xx=new Apprenant();
                ApprenantDao xxx=new ApprenantDao();
                xx=xxx.getById(list.get(i).getIdapprenant());
                u.setNA(xx.getNomuser());
                u.setDate(String.valueOf(list.get(i).getDuréretar()));
                int num=list.get(i).getIdretar();
                RetarDao cccc=new RetarDao();
                Button b1= new Button("justife");
                b1.setOnAction(e -> {
                cccc.update(num,"justife");
               });
                Button b2 = new Button("NO Justifie");
                b2.setOnAction(e -> {
                cccc.update(num,"No justife");
               });
                u.setYes(b1);
                u.setNon(b2);

                data.add(u);    
            }
            IDr.setCellValueFactory(new PropertyValueFactory<TableAbsent,Integer>("id"));
            NAp.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NA"));
            NSt.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NS"));
            duee.setCellValueFactory(new PropertyValueFactory<TableAbsent,Integer>("date"));
            yseR.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("yes"));
            noR.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("non"));
            table_re.setItems(data);
            
            
            double h=hbox1.getWidth();
            PromotionDao promo=new PromotionDao();
            List<Promotion> P1=new ArrayList<Promotion>();
            
                P1=promo.getAll();
            for(int i=0;i<P1.size();i++){
                int a=P1.get(i).getIdpromotion();
                Button b1=new Button(P1.get(i).getNompromotion());
                b1.setMinWidth(h/P1.size());
                b1.setOnAction(e ->{
                  table_re.getItems().clear();
                  List<Apprenant> P=new ArrayList<Apprenant>();
                  ApprenantDao Ap=new ApprenantDao();
                  P=Ap.getAll(a);
                  int newarr[] = new int[P.size()];
                  for(int j=0;j<P.size();j++){
                     newarr[j]=P.get(j).getIduser(); 
                  } 
                  String Table="(";
                  for(int j=0;j<newarr.length;j++){
                      if(j<newarr.length-1)Table+=newarr[j]+",";
                      else Table+=newarr[j]+"";
                     
                  }
                  Table+=")";
                 
                 
                 List<Retar> list2= new ArrayList<Retar>();
                  RetarDao ab2=new RetarDao();
                  list2=ab2.getAll(Table);
                  System.out.print(list2.size());
                   
                   for(int j=0;j<list2.size();j++){
                        int p=list2.get(j).getIdretar();
                       
                     TableAbsent u1= new TableAbsent();
                       u1.setId(list2.get(j).getIdretar());
                       Staf vv=new Staf();
                       StafDao vvv=new StafDao();
                       vv=vvv.getById(list2.get(j).getIdformateur());
                       u1.setNS(vv.getNomuser());
                        Apprenant xx=new Apprenant();
                        ApprenantDao xxx=new ApprenantDao();
                        xx=xxx.getById(list2.get(j).getIdapprenant());
                        u1.setNA(xx.getNomuser());
                        u1.setDate(String.valueOf(list2.get(j).getDuréretar()));
                        int num=list2.get(j).getIdretar();
                        RetarDao cccc=new RetarDao();
                        Button but= new Button("justife");
                        but.setOnAction(ev->{
                            cccc.update(num,"justife");
                        });
                        Button but2 = new Button("NO Justifie");
                        but2.setOnAction(ev -> {
                        cccc.update(num,"No justife");
                        });
                        u1.setYes(but);
                        u1.setNon(but2);
                        data.add(u1);       
                   }
            IDr.setCellValueFactory(new PropertyValueFactory<TableAbsent,Integer>("id"));
            NAp.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NA"));
            NSt.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NS"));
            duee.setCellValueFactory(new PropertyValueFactory<TableAbsent,Integer>("date"));
            yseR.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("yes"));
            noR.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("non"));
            table_re.setItems(data);
                   
                   
                  
                  
                  
                 
                  
                });
               
            
                
               
                 
                hbox1.getChildren().add(b1);
                
                
            }
            
            
            
            
        }
        else if(event.getTarget()==btn3){
            hbox11.getChildren().clear();
            page1.setVisible(false);
            arrow1.setVisible(false);
            page2.setVisible(false);
            arrow2.setVisible(false);
            page3.setVisible(true);
            arrow3.setVisible(true);
            absence_table.getItems().clear();
            AbsencesDao ab=new AbsencesDao();
            List<Absences> list= new ArrayList<Absences>();list=ab.getAll();
            for(int i=0;i<list.size();i++){
                TableAbsent u= new TableAbsent();
                u.setId(list.get(i).getIdabsence());
                Staf vv=new Staf();StafDao vvv=new StafDao();vv=vvv.getById(list.get(i).getIdformateur());
                u.setNS(vv.getNomuser());
                Apprenant xx=new Apprenant();ApprenantDao xxx=new ApprenantDao();xx=xxx.getById(list.get(i).getIdapprenant());
                u.setNA(xx.getNomuser());u.setDate(list.get(i).getDateabs());  
                Button b3 = new Button("Justifie");
                int num=list.get(i).getIdabsence();
                AbsencesDao cccc=new AbsencesDao();
                b3.setOnAction(e -> {
                cccc.update(num,"justife");
               });
                u.setYes(b3);
                Button b4 = new Button("NO Justifie");
                b4.setOnAction(e -> {
                cccc.update(num,"No justife");
               });
                
                u.setNon(b4);
                
                data2.add(u);    
            }
            id.setCellValueFactory(new PropertyValueFactory<TableAbsent,Integer>("id"));
            nStaf.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NA"));
            apprenent.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NS"));
            date.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("date"));
            yes.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("yes"));
            non.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("non"));
            absence_table.setItems(data2);
            double h=hbox11.getWidth();
            PromotionDao promo=new PromotionDao();
            List<Promotion> P1=new ArrayList<Promotion>();
            
                P1=promo.getAll();
            for(int i=0;i<P1.size();i++){
                int a=P1.get(i).getIdpromotion();
                Button b1=new Button(P1.get(i).getNompromotion());
                b1.setMinWidth(h/P1.size());
                 b1.setOnAction(e ->{
                  absence_table.getItems().clear();
                  List<Apprenant> P=new ArrayList<Apprenant>();
                  ApprenantDao Ap=new ApprenantDao();
                  P=Ap.getAll(a);
                  int newarr[] = new int[P.size()];
                  for(int j=0;j<P.size();j++){
                     newarr[j]=P.get(j).getIduser(); 
                  } 
                  String Table="(";
                  for(int j=0;j<newarr.length;j++){
                      if(j<newarr.length-1)Table+=newarr[j]+",";
                      else Table+=newarr[j]+"";
                     
                  }
                  Table+=")";
                 
                 
                 AbsencesDao ab2=new AbsencesDao();
                  List<Absences> list3= new ArrayList<Absences>();
                  list3=ab2.getAll(Table);
                  
                  for(int j=0;j<list3.size();j++){
                TableAbsent u= new TableAbsent();
                u.setId(list3.get(j).getIdabsence());
                Staf vv=new Staf();StafDao vvv=new StafDao();vv=vvv.getById(list3.get(j).getIdformateur());
                u.setNS(vv.getNomuser());
                Apprenant xx=new Apprenant();ApprenantDao xxx=new ApprenantDao();xx=xxx.getById(list3.get(j).getIdapprenant());
                u.setNA(xx.getNomuser());u.setDate(list3.get(j).getDateabs());  
                Button b31 = new Button("Justifie");
                int num=list3.get(j).getIdabsence();
                AbsencesDao cccc=new AbsencesDao();
                b31.setOnAction(e1 -> {
                cccc.update(num,"justife");
               });
                u.setYes(b31);
                Button b41 = new Button("NO Justifie");
                b41.setOnAction(e1 -> {
                cccc.update(num,"No justife");
               });
                
                u.setNon(b41);
                
                data2.add(u);    
            }
            id.setCellValueFactory(new PropertyValueFactory<TableAbsent,Integer>("id"));
            nStaf.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NA"));
            apprenent.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("NS"));
            date.setCellValueFactory(new PropertyValueFactory<TableAbsent,String>("date"));
            yes.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("yes"));
            non.setCellValueFactory(new PropertyValueFactory<TableAbsent,Button>("non"));
                   
                   
                   
                   
                  
                  
                  
                 
                  
                });
                hbox11.getChildren().add(b1);
            }
        }
        
    }
     @FXML
    void dec(ActionEvent event) {
        if(event.getTarget()==deconnecter){
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }

    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            page1.setVisible(true);
            arrow1.setVisible(true);
            page2.setVisible(false);
            arrow2.setVisible(false);
            page3.setVisible(false);
            arrow3.setVisible(false);
     try {
         if(!StafDao.getCon().isClosed()){
             System.out.print("Db Connected");
             StafDao sec =new StafDao();
             Staf vv=sec.getById(1);
             email.setText(vv.getEmailuser());
             nom.setText(vv.getNomuser());
             role.setText(vv.getTypeuser());
             
             
         }
     } catch (SQLException ex) {
         Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
     }
        
                 
             
            
                    
            
    }  

    private EventHandler<ActionEvent> onclick(Absences get, Button btn11) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
