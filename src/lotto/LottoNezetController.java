package lotto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class LottoNezetController implements Initializable {
    //<editor-fold defaultstate="collapsed" desc="Class variabbles">
    private final int MAX = 90;
    private final int MIN = 1;
    private int getNum1;
    private int getNum2;
    private int getNum3;
    private int getNum4;
    private int getNum5;
    private int selNum1;
    private int selNum2;
    private int selNum3;
    private int selNum4;
    private int selNum5;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="FXML item import">
    @FXML
    private Pane basePane;
    @FXML
    private Pane alertPane;
    @FXML
    private Label alertText;
    @FXML
    private Button alertButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
    @FXML
    private Label eredmeny;
//</editor-fold>

    @FXML
    private void handleAlertButton(ActionEvent event){
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);
        alertText.setText("");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        //We are generating numbers
        getNum1 = 0;
        getNum2 = 0;
        getNum3 = 0;
        getNum4 = 0;
        getNum5 = 0;
        getNum1 = getRandomNumber();
        getNum2 = getRandomNumber();
        getNum3 = getRandomNumber();
        getNum4 = getRandomNumber();
        getNum5 = getRandomNumber();
        
        
        //We are setting the generated numbers to the labels
        label1.setText("" + getNum1);
        label2.setText("" + getNum2);
        label3.setText("" + getNum3);
        label4.setText("" + getNum4);
        label5.setText("" + getNum5);
        
        calculate();
    }
    
    private String calculate(){
        try{
            selNum1 = Integer.parseInt(input1.getText());
            selNum2 = Integer.parseInt(input2.getText());
            selNum3 = Integer.parseInt(input3.getText());
            selNum4 = Integer.parseInt(input4.getText());
            selNum5 = Integer.parseInt(input5.getText());
        }catch(Exception e){
            basePane.setDisable(true);
            basePane.setOpacity(0.3);
            alertPane.setVisible(true);
            alertText.setText("Nem jó számot adtál meg!");
            System.out.println(e);
            return "";
        }
        return "";
    }
    
    private int getRandomNumber(){
        int random = (int) (Math.random() * MAX) + MIN;
        if(random == getNum1 || random == getNum2 || random == getNum3 || random == getNum4 || random == getNum5){
            return getRandomNumber();
        }
        return random;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
